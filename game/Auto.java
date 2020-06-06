package game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

public class Auto extends Tank{
	
	public Auto(int startx, int starty, double startangle, List<wall> wl, List<kit> k1) {
		super(startx, starty, startangle, wl, k1);
		this.wallist = wl;
		loadImage();
		tankshell = new ArrayList<Shell>();
		keybuffer = new ArrayList<Integer>();
		ammo = MAX_AMMO;
		cdammo = CD_AMMO;
	}
	
	@Override
	protected void loadImage() {
		
		ImageIcon ii = new ImageIcon("src/resources/tanker2.png");
		image = ii.getImage();
		
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A) 
			keybuffer.add(KeyEvent.VK_A);
		if(key == KeyEvent.VK_D)
			keybuffer.add(KeyEvent.VK_D);
		if(key == KeyEvent.VK_W)
			keybuffer.add(KeyEvent.VK_W);
		if(key == KeyEvent.VK_S)
			keybuffer.add(KeyEvent.VK_S);
		
		
		if(keybuffer.contains(KeyEvent.VK_D))
			da = Math.toRadians(this.ROTATION_RAD);
		if(keybuffer.contains(KeyEvent.VK_A))
			da = Math.toRadians(-this.ROTATION_RAD);
		if(keybuffer.contains(KeyEvent.VK_W)) {
			if(keybuffer.contains(KeyEvent.VK_D)) {
				dx = Math.sin(this.angle+da);
				dy = Math.cos(this.angle+da);
				da = Math.toRadians(this.ROTATION_RAD);

			}
			else if(keybuffer.contains(KeyEvent.VK_A)) {
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
		}
		if(keybuffer.contains(KeyEvent.VK_S)) {
			if(keybuffer.contains(KeyEvent.VK_D)) {
				dx = -Math.sin(this.angle+da);
				dy = -Math.cos(this.angle+da);
				da = Math.toRadians(this.ROTATION_RAD);
			}
			else if(keybuffer.contains(KeyEvent.VK_A)) {
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
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_A));
			da = 0;
		}
		if(key == KeyEvent.VK_D) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_D));
			da = 0;
		}
		if(key == KeyEvent.VK_W) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_W));
			dy = 0;
			dx = 0;
			da = 0;
		}
		if(key == KeyEvent.VK_S) {
			keybuffer.removeAll(Arrays.asList(KeyEvent.VK_S));
			dx = 0;
			dy = 0;
			da = 0;
		}
		if(key == KeyEvent.VK_F) {
			fire();
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
