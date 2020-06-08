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
 	protected List<BoostPlatform> bplist;
	protected Image image;
	protected String name;

	//******
	public void makekit() {}
	//******
	
	public Map() {
		loadImage();
		x = 400;
		y = 300;
		kitlist = new ArrayList<kit>();
		wallist = new ArrayList<wall>();
		bplist = new ArrayList<BoostPlatform>();
		setMap("default");
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
	public List<BoostPlatform> getBoostPlatformList()
	{
		return this.bplist;
	}
	public String getName() {
		return name;
	}
	
	public void setMap(String mapname) {
		this.name = mapname;
		wallist.clear();
		kitlist.clear();
		bplist.clear();
		final String path = "src/resources/";
		int[] Xs = {0,117, 45,117, 113,512, 133,205, 133,300, 133,345,
		239,296, 307,481, 349,436, 351,258,
		404,447, 406,625, 472,455, 322, 55, 628,219,
		};
		
				
		if(mapname.equals("default")) {
			wall w1 = new wall(325,275,"src/resources/bedrock.png");
			wall w2 = new wall(375, 275, "src/resources/bedrock.png");
			wall w3 = new wall(400, 400, "src/resources/bedrock.png");
			wallist.add(w1);
			wallist.add(w2);
			wallist.add(w3);
		}
		if(mapname.equals("test1")) {
			wall w1 = new wall(300, 300, "src/resources/xx.png");
			wallist.add(w1);
			
			for(int i = 0; i < Xs.length-1; i+=2)
			{
				wallist.add(new wall(Xs[i],Xs[i+1],path+"k_brick.png"));
			}
			this.DrawBoostArea("test1", null, "src/resources/cloud.png");
		}
		if(mapname.equals("test2")) {
			wall w1 = new wall(400, 388, "src/resources/xx.png");
			wall w2 = new wall(444,333, "src/resources/bedrock.png");
			wallist.add(w1);
			wallist.add(w2);
		}
		
	}
	
	//katsmin
	public void drawWalls(List<wall> wallist, String mapName, int[] xys, String resourcePath)
	{
		int[] position = xys;
		int[] pos = {0,117, 45,117, 113,512, 133,205, 133,300, 133,345,
				239,296, 307,481, 349,436, 351,258,
				404,447, 406,625, 472,455, 322, 55, 628,219,
				};
		if(xys == null || xys.length == 0)
		{
			position = pos;
		}
		if(wallist == null)
		{
			throw new NullPointerException();
		}
		for(int i = 0; i < position.length-1; i+=2)
		{
			wallist.add(new wall(position[i],position[i+1],resourcePath+"k_brick.png"));
		}
	}
	public void DrawBoostArea(String mapName, int[] xys, String resourcePath)
	{
		int[] position = xys;
		int[] pos = {65,345};
		if(xys == null || xys.length == 0)
		{
			position = pos;
		}

		for(int i = 0; i < position.length-1; i+=2)
		{
			bplist.add(new BoostPlatform(position[i],position[i+1],resourcePath));
		}
		
	}
}
