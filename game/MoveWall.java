package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MoveWall extends Wall{
	
	private Image image;
	private double w;
	private double h;
	private double dx,ddx;
	private double dy;
	
	private boolean IgnoreShell;
	public MoveWall(double wallx, double wally, String filepath) {
		super(wallx,wally,filepath);
		ImageIcon ii = new ImageIcon(filepath);
		image = ii.getImage();
	
		w = image.getWidth(null);
		h = image.getHeight(null);
		IgnoreShell = false;
		dx = 0.2;
		dy = 0;
		ddx=100;
	}
	
	
	
	public void Move() {
		if(getX()<500) {
			setX(getX()+dx);
			setY(getY()+dy);
		}
		else if(getX()>=500) {
			setX(100);
			setY(getY());
		
		}
		
	}
}
