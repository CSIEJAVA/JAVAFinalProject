package game;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.*;

public class Map {
	
	private int x;
	private int y;
	private int w;
	private int h;
	private List<kit> kitlist;
 	private List<Wall> wallist;
 	private Image image;
	private String name;
	private double p1startx;
	private double p1starty;
	private double p2startx;
	private double p2starty;
	private double p1stangle;
	private double p2stangle;
	
	//******
	public void makekit() {}
	//******
	
	public Map() {
		this.p1startx = 100;
		this.p1starty = 100;
		this.p2startx = 600;
		this.p2starty = 500;
		this.p1stangle = 3*Math.PI/4;
		this.p2stangle = -Math.PI/4;
		loadImage();
		x = 400;
		y = 300;
		kitlist = new ArrayList<kit>();
		wallist = new ArrayList<Wall>();
		setMap("default");
	}
	
	protected void loadImage() {
		
		ImageIcon ii = new ImageIcon("src/resources/grass.png");
		image = ii.getImage();
		
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public List<Wall> getwall(){
		return wallist;
	}
	
	public String getName() {
		return name;
	}
	
	public double getp1StartX() {
		return p1startx;
	}
	public double getp1StartY() {
		return p1starty;
	}
	public double getp2StartX() {
		return p2startx;
	}
	public double getp2StartY() {
		return p2starty;
	}
	public double getp1StartA() {
		return p1stangle;
	}
	public double getp2StartA() {
		return p2stangle;
	}
	private void setP1start(double x1, double y1, double a1) {
		this.p1startx = x1;
		this.p1starty = y1;
		this.p1stangle = a1;
	}
	private void setP2start(double x2, double y2, double a2) {
		this.p2startx = x2;
		this.p2starty = y2;
		this.p2stangle = a2;
	}
	
	public void setMap(String mapname) {
		this.name = mapname;
		wallist.clear();
		kitlist.clear();
		if(mapname.equals("default")) {
			setP1start(100,100, 3*Math.PI/4);
			setP2start(600,500, -Math.PI/4);
			Wall w1 = new Wall(375, 195,"src/resources/bedrock.png");
			Wall w2 = new Wall(375, 275, "src/resources/bedrock.png");
			Wall w3 = new Wall(375, 355, "src/resources/bedrock.png");
			wallist.add(w1);
			wallist.add(w2);
			wallist.add(w3);
		}
		if(mapname.equals("Monster")) {
			setP1start(100,100, 3*Math.PI/4);
			setP2start(600,500, -Math.PI/4);
			MoveWall w1 = new MoveWall(100, 180,"src/resources/bedrock.png");
			//MoveWall w2 = new MoveWall(400, 275, "src/resources/bedrock.png");
			MoveWall w3 = new MoveWall(450, 360, "src/resources/bedrock.png");
			MoveWall w4 = new MoveWall(200, 180,"src/resources/bedrock.png");
			//MoveWall w5 = new MoveWall(400, 400, "src/resources/bedrock.png");
			MoveWall w6 = new MoveWall(350, 360, "src/resources/bedrock.png");
			Wall wt7 = new Wall(200,450,"src/resources/semiwater.jpg");
			Wall wt8 = new Wall(300,450, "src/resources/semiwater.jpg");
			Wall wt9 = new Wall( 400,450, "src/resources/semiwater.jpg");
			Wall wt10 = new Wall( 500,450,"src/resources/semiwater.jpg");
			Wall wt11 = new Wall(100,450, "src/resources/semiwater.jpg");
			Wall wt12 = new Wall(200,150,"src/resources/semiwater.jpg");
			Wall wt13 = new Wall(200,250, "src/resources/semiwater.jpg");
			Wall wt14 = new Wall( 300,250, "src/resources/semiwater.jpg");
			Wall wt15 = new Wall( 400,250,"src/resources/semiwater.jpg");
			Wall wt16 = new Wall(100,150, "src/resources/semiwater.jpg");
			Wall wt17 = new Wall( 570,250,"src/resources/semiwater2.jpg");
			Wall wt18 = new Wall(65,150, "src/resources/semiwater2.jpg");
			
			wt7.setIgnoreShell();
			wt8.setIgnoreShell();
			wt9.setIgnoreShell();
			wt10.setIgnoreShell();
			wt11.setIgnoreShell();
			wt12.setIgnoreShell();
			wt13.setIgnoreShell();
			wt14.setIgnoreShell();
			wt15.setIgnoreShell();
			wt16.setIgnoreShell();
			wt17.setIgnoreShell();
			wt18.setIgnoreShell();
			wallist.add(w1);
			//wallist.add(w2);
			wallist.add(w3);
			wallist.add(w4);
			//wallist.add(w5);
			wallist.add(w6);
			wallist.add(wt7);
			wallist.add(wt8);
			wallist.add(wt9);
			wallist.add(wt10);
			wallist.add(wt11);
			wallist.add(wt12);
			wallist.add(wt13);
			wallist.add(wt14);
			wallist.add(wt15);
			wallist.add(wt16);
			wallist.add(wt17);
			wallist.add(wt18);
		}
		if(mapname.equals("test1")) {
			setP1start(100,280, 2*Math.PI/4);
			setP2start(560,280, -2*Math.PI/4);
			Wall w1 = new Wall(150, 250, "src/resources/bedrock.png");
			Wall w2 = new Wall(450, 250, "src/resources/bedrock.png");
			Wall wt1 = new Wall(300,400, "src/resources/water.jpg");
			Wall wt2 = new Wall(300,300, "src/resources/water.jpg");
			Wall wt3 = new Wall(300,200, "src/resources/water.jpg");
			Wall wt4 = new Wall(300,100, "src/resources/water.jpg");
			Wall wt5 = new Wall(300,0, "src/resources/water.jpg");
			Wall wt6 = new Wall(300,500, "src/resources/water.jpg");
			wt1.setIgnoreShell();
			wt2.setIgnoreShell();
			wt3.setIgnoreShell();
			wt4.setIgnoreShell();
			wt5.setIgnoreShell();
			wt6.setIgnoreShell();
			wallist.add(w1);
			wallist.add(w2);
			wallist.add(wt1);
			wallist.add(wt2);
			wallist.add(wt3);
			wallist.add(wt4);
			wallist.add(wt5);
			wallist.add(wt6);
		}
		if(mapname.equals("test2")) {
			setP1start(100,100, 3*Math.PI/4);
			setP2start(600,500, -Math.PI/4);
			Wall w1 = new Wall(400, 388, "src/resources/xx.png");
			Wall w2 = new Wall(444,333, "src/resources/bedrock.png");
			wallist.add(w1);
			wallist.add(w2);
		}
		
	}
}
