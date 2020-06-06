package game;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.*;

public class Map {
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected List<kit> kitlist;
 	protected List<wall> wallist;
	protected Image image;
	
	//******
	public void makekit() {}
	//******
	
	public Map() {
		loadImage();
		x = 400;
		y = 300;
		
		kitlist = new ArrayList<kit>();
		kitlist.add(new kit(250, 250));
		kitlist.add(new kit(50,50));
		kitlist.add(new kit(50,250));
		
				
		wallist = new ArrayList<wall>();
		wall ww = new wall(325,275);
		wallist.add(ww);
	}
	
	protected void loadImage() {
		
		ImageIcon ii = new ImageIcon("src/resources/Xi.png");
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
	
	public List<wall> getwall(){
		return wallist;
	}
	
	public List<kit> getkit(){
		return kitlist;
	}
}
