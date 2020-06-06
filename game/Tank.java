package game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.Rectangle;

public class Tank {
	
	protected double dx;
	protected double dy;
	protected double da;
	protected double x;
	protected double y;
	protected int w;
	protected int h;
	protected double angle;
	protected List<Shell> tankshell;
	protected Image image;
	protected List<wall> wallist;
	protected List<kit> kitlist;
	protected List<Integer> keybuffer;
	
	//*****
	protected int health;
	protected int damage;
	public void takedamage(int a) {health-=a;} //health-a
	public void heal(int a) {health+=a;}
	
	//******
	protected int ammo;
	protected int cdammo;
	final protected double ROTATION_RAD = 0.5;
	final protected int MAX_AMMO = 4;
	final protected int CD_AMMO = 6;
	
	public Tank(int startx, int starty,double startangle, List<wall> wl, List<kit> k1) {
		x = startx;
		y = starty;
		angle = startangle;
		this.wallist = wl;
		this.kitlist = k1;
		loadImage();
		tankshell = new ArrayList<Shell>();
		keybuffer = new ArrayList<Integer>();
		ammo = MAX_AMMO;
		cdammo = CD_AMMO;
	}

	protected void loadImage() {
		
		ImageIcon ii = new ImageIcon("src/resources/tanker.png");
		image = ii.getImage();
		
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	
	public void move() {
		angle += da;
		if(angle>2*Math.PI)
			angle -= 2*Math.PI;
		else if(angle<-2*Math.PI)
			angle += 2*Math.PI;
		x += dx;
		y -= dy;
	}
	
	public double getX() {
		
		return x;	
	}
	
	public double getY() {
		return y;		
	}
	
	public double getangle() {
		return angle;
	}
	
	public int getWidth() {
		
		return w;
	}
	public int getHeight() {
		
		return h;
	}
	public Image getImage() {
		
		return image;
	}
	
	public List<Shell> getShell() {
		return tankshell;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) 
			keybuffer.add(KeyEvent.VK_LEFT);
		if(key == KeyEvent.VK_RIGHT)
			keybuffer.add(KeyEvent.VK_RIGHT);
		if(key == KeyEvent.VK_UP)
			keybuffer.add(KeyEvent.VK_UP);
		if(key == KeyEvent.VK_DOWN)
			keybuffer.add(KeyEvent.VK_DOWN);
		
		
		if(keybuffer.contains(KeyEvent.VK_RIGHT))
			da = Math.toRadians(this.ROTATION_RAD);
		if(keybuffer.contains(KeyEvent.VK_LEFT))
			da = Math.toRadians(-this.ROTATION_RAD);
		if(keybuffer.contains(KeyEvent.VK_UP)) {
			if(keybuffer.contains(KeyEvent.VK_RIGHT)) {
				dx = Math.sin(this.angle+da);
				dy = Math.cos(this.angle+da);
				da = Math.toRadians(this.ROTATION_RAD);

			}
			else if(keybuffer.contains(KeyEvent.VK_LEFT)) {
				dx = Math.sin(this.angle+da);
				dy = Math.cos(this.angle+da);
				da = Math.toRadians(-this.ROTATION_RAD);
			}
			else {
				dx = Math.sin(this.angle+da);
				dy = Math.cos(this.angle+da);
				da = 0;
			}
			if(detectCollision(wallist))
			{
				System.out.println("BOOM");
			}
			
			//kit collision
			if(detectKitCollision(kitlist))
			{
				System.out.println("Get kit!");
				if(health <50) {
					this.health +=5;
				}
				
				System.out.println(this.health);
			}
		}
		if(keybuffer.contains(KeyEvent.VK_DOWN)) {
			if(keybuffer.contains(KeyEvent.VK_RIGHT)) {
				dx = -Math.sin(this.angle+da);
				dy = -Math.cos(this.angle+da);
				da = Math.toRadians(this.ROTATION_RAD);
			}
			else if(keybuffer.contains(KeyEvent.VK_LEFT)) {
				dx = -Math.sin(this.angle+da);
				dy = -Math.cos(this.angle+da);
				da = Math.toRadians(-this.ROTATION_RAD);
			}
			else {
				dx = -Math.sin(this.angle+da);
				dy = -Math.cos(this.angle+da);
				da = 0;
			}
			if(detectCollision(wallist))
			{
				System.out.println("BOOM");
			}
			
			if(detectKitCollision(kitlist))
			{
				System.out.println("Get kit!");
				if(health <50) {
					this.health +=5;
				}
				
				System.out.println(this.health);
			}
		}

	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_LEFT));
			da = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			System.out.println("release r");
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_RIGHT));
			da = 0;
		}
		if(key == KeyEvent.VK_UP) {
			System.out.println("release up");
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_UP));
			dy = 0;
			dx = 0;
			da = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_DOWN));
			dx = 0;
			dy = 0;
			da = 0;
		}
		if(key == KeyEvent.VK_SPACE) {
			fire();
		}
	}
	
	public void fire() {
		if(this.ammo >= 1)
		{
			this.ammo--;
			Shell temp = new Shell(x+(w/2)+((h+4)*Math.sin(angle))/2, y+(h/2)-((h+4)*Math.cos(angle)/2), angle);
			tankshell.add(temp);
			System.out.println("Roger");
	
		}
		else // reload
		{
			System.out.println("Reloading");
			this.cdammo--;
			if(this.cdammo <= 0)
			{
				this.cdammo = this.CD_AMMO;
				this.ammo = this.MAX_AMMO;
			}
		}

	}
	
	public int right()
	{
		return (int)(x + w);
	}
	public int bottom()
	{
		return (int)(y+h);
	}
	public boolean detectCollision(List<wall> w)
	{
		Rectangle rr;
		Rectangle target ;
		for(wall obj: w)
		{
			rr = new Rectangle((int)this.x, (int)this.y, this.w, this.h);
			target = new Rectangle((int)obj.getX(), (int)obj.getY(), (int)obj.getW(),(int)obj.getH());
			if(rr.intersects(target))
			{
				return true;
			}
			
		} // end for
		rr = null; target = null;
		return false;
	}
	
	//detect kit
	public boolean detectKitCollision(List<kit> k)
	{
		Rectangle rr;
		Rectangle target ;
		
		//Iterator<kit> itr = k.iterator();
		List<kit> found = new ArrayList<kit>();
		kit toDelete = null;
		int index = 0;
		for(kit obj: k)
		{
			rr = new Rectangle((int)this.x, (int)this.y, this.w, this.h);
			target = new Rectangle((int)obj.getX(), (int)obj.getY(), (int)obj.getW(),(int)obj.getH());
			if(rr.intersects(target))
			{
				toDelete = obj; 
				k.remove(index);
				toDelete.finalize();
				return true;
				//obj.remove();
			}
			index++;
		} // end for
		rr = null; target = null;
		return false;
	}
	
	
	

}

