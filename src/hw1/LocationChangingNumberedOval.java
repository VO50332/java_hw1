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

		
		// TODO Auto-generated constructor stub
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
		//Color color = getColor();
		//int blue = color.getBlue();
		//int red = color.getRed();
		//int green = color.getGreen();
		
		//Color numColor = new Color(1,2,3);
		Color shapeColor = g.getColor();
		int blue = shapeColor.getBlue();
		int red = shapeColor.getRed();
		int green = shapeColor.getGreen();
		//int rgb = shapeColor.getRGB();
		//System.out.println("rgb is" + rgb);
		System.out.println(shapeColor + myNumber);
		g.setColor(Color.black);
		System.out.println(0.3*red + 0.59*green +0.11*blue);
		System.out.println(red*red+blue*blue+green*green);
		if (0.3*red + 0.59*green +0.11*blue < 110) {
			g.setColor(Color.white);
		}
		g.drawString(myNumber,x +boundX/2,y+boundY/2);
	}

}
