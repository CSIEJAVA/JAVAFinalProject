package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MoveWall extends Wall{
	
	private Image image;
	private double w;
	private double h;
	private double dx,ddy;
	private double dy;
	private int change=0,turnx=0,turny=0;
	private boolean IgnoreShell;
	public MoveWall(double wallx, double wally, String filepath) {
		super(wallx,wally,filepath);
		ImageIcon ii = new ImageIcon(filepath);
		image = ii.getImage();
	
		w = image.getWidth(null);
		h = image.getHeight(null);
		IgnoreShell = false;
		dx = 0.5;
		dy = 0.45;
		ddy=250;
	}
	
	
	
	public void Move() {
		if(getX()<500 && getX()>250 && turnx==0) {
			setX(getX()+dx);
			
		}else if( getX()>250 && turnx==1) {
			setX(getX()-dx);
			
		}
		if(getX()>=500) {
			turnx=1;
			if(getY()>=350 || getY()<=180) {
				//setX(300);
				//setY(getY());
				
				++change;
				if (change==2) {
					//setX(getX());
					//setY(getY()-350);
					
				}
			
			}	 
		}else if(getX()<=260) {
			turnx=0;
			if(getY()>=350 || getY()<=180) {
				//setX(300);
				//setY(getY());
				
				++change;
				if (change==2) {
					//setX(getX());
					//setY(getY()-350);
					
				}
			
			}	 
		}
			
		if(getX()<250 && getX()>=100 && turny==0) {
			setY(getY()+dy);
			
		}else if( getX()<250 && getX()>=100 && turny==1) {
			setY(getY()-dy);
			
		}
		if(getY()>=350) {
			turny=1;
		}else if(getY()<=190){
			turny=0;
		}
	}
}