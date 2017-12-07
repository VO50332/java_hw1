package hw1_3;

import java.awt.*;

public class LocationChangingNumberedOval extends LocationChangingOval{
	
	private int number;
	private static int counter;
	private int x;
	private int y;
	LocationChangingNumberedOval(Point _location, Color _color, int _width, int _height) {
		super(_location, _color, _width, _height);
		counter++;
		number = counter;

		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		Point location = getLocation();
		x = (int)location.getX();
		y = (int)location.getY();
		String myNumber = Integer.toString(number);
		g.drawString(myNumber,x,y);
	}

}
