package hw1;

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

	}
	
	public void draw(Graphics g) {
		super.draw(g);
		Point location = getLocation();
		x = (int)location.getX();
		y = (int)location.getY();
		String myNumber = Integer.toString(number);
		Rectangle rec = this.getBounds();
		int boundX = (int) rec.getWidth();
		int boundY = (int) rec.getHeight();

		Color shapeColor = g.getColor();
		int blue = shapeColor.getBlue();
		int red = shapeColor.getRed();
		int green = shapeColor.getGreen();
		g.setColor(Color.black);
		if (0.3*red + 0.59*green +0.11*blue < 110) {
			g.setColor(Color.white);
		}
		g.drawString(myNumber,x +boundX/2,y+boundY/2);
	}

}
