package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Kit {

	private double x;
	private double y;
	private double w;
	private double h;
	private int inc_health;
	private Image image;

	public Kit(int init_x, int init_y) {


		ImageIcon kk = new ImageIcon("src/resources/kit38.png");
		image = kk.getImage();

		x = init_x;
		y = init_y;
		w = image.getWidth(null);
		h = image.getHeight(null);
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getW() {
		return w;
	}
	public double getH() {
		return h;
	}


	public Image getImage() {
		return image;
	}

	public int get_inc_health() {
		return inc_health;
	}
	public int right()
	{
		return (int)(x + w);
	}
	@Override
	public void finalize()  
	{
		try
		{
			super.finalize();
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
