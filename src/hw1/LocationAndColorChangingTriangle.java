package hw1;

import java.awt.*;

public class LocationAndColorChangingTriangle extends ColorAndLocationChangingShape {
	private int width;
	private int height;
	private Dimension dimension;
	
	LocationAndColorChangingTriangle(Point location, Color color,int _width,int _height)  {
		super(location, color);
<<<<<<< HEAD
		this.height = _height;
		this.width = _width;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		
=======
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
>>>>>>> 5088258c797dcb0102d8cc00a087612d9075b67d
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
		int[] xList = {x,x,x+this.width};
		int[] yList = {y,y+this.height,y};
		System.out.println("(" + x + "," + y+ ") height="+ this.height + "width =" + this.width);
	//	g.drawPolygon(xList, yList, 3);
		g.fillPolygon(xList, yList, 3);
		
	}

}
