package hw1_3;

import java.awt.*;

public class LocationAndColorChangingTriangle extends ColorAndLocationChangingShape {
	private int width;
	private int height;
	private Dimension dimension;
	
	LocationAndColorChangingTriangle(Point location, Color color,int _width,int _height) {
		super(location, color);
		this.height = _height;
		this.width = _width;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		
	}

	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		//try - catch
		this.dimension = dimension;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle rec = new Rectangle(getLocation(),dimension); // do I have to create another object?
		return rec;
	}

	@Override
	public void draw(Graphics g) {
		setColor(getColor());
		Point location=getLocation();
		int x = (int) location.getX();
		int y = (int) location.getY();
		int[] xList = {x,x,x+width};
		int[] yList = {y,y-height,y};
		g.drawPolygon(xList, yList, 3);
		g.fillPolygon(xList, yList, 3);
		
	}

}
