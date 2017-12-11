package hw1;

import java.awt.*;

public class LocationAndColorChangingTriangle extends ColorAndLocationChangingShape {
	//private int width;
//	private int height;
	private Dimension dimension;
	
	LocationAndColorChangingTriangle(Point location, Color color,int _width,int _height)  {
		super(location, color);
	//	this.height = _height;
		//this.width = _width;
		//dimension  = new Dimension(width,height);// bounding rectangle dimensions
		Dimension _dimension  = new Dimension(_width,_height);// bounding rectangle dimensions 
		//try {
			//System.out.println(_dimension);
		try {
			this.setSize(_dimension);
		}
		catch (ImpossibleSizeException e){
			System.out.println("no problem is possible");
		}
	}
	

		
	

	@Override
	public void setSize(Dimension _dimension) throws ImpossibleSizeException {
		if (_dimension.getWidth() > 0 && _dimension.getHeight() > 0 ) {
			this.dimension = _dimension;
		}
		else {
			ImpossibleSizeException ex=  new ImpossibleSizeException("width or height cannot be negative or zero");
			this.dimension = ex.newDimension;
			System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
			
		}
	}

	@Override
	public Rectangle getBounds() {
		Rectangle rec = new Rectangle(getLocation(),dimension); // do I have to create another object?
		return rec;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		Point location=getLocation();
		int x = (int) location.getX();
		int y = (int) location.getY();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		int[] xList = {x,x,x+width};
		int[] yList = {y,y+height,y};
		g.fillPolygon(xList, yList, 3);
		
	}

}
