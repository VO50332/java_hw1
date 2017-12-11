package hw1;

import java.awt.*;

/**
 * A LocationAndColorChangingTriangle is a kind of a shape object. A typical Location And Color Changing Triangle consists of
 * a set of properties: {location, color, shape, size}.
 * LocationAndColorChangingTriangle are mutable and cloneable.
 */
public class LocationAndColorChangingTriangle extends ColorAndLocationChangingShape {
	private int windowWidth;
	private int windowHeight;
	private Dimension dimension;
    //  Abstraction Function:
	// represents a right angle triangle such that its right angle is located at the top left point of its bounding rectangle.
	// this.windowWidth and this.windowHeight contain the window size information. this.dimension contains the shape's bounding rectangle dimensions
	
    // Representation Invariant:
	//this.windowWidth , this.windowHeight and this.dimension cannot be zero, negative or null

    
    /**
     * @effects Initializes this with a a given location , color and size.
     * also initializes the window dimensions 
     */
	LocationAndColorChangingTriangle(Point location, Color color,int _width,int _height,int windowWidth,int windowHeight)  {
		super(location, color);
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		checkRep();
		Dimension _dimension  = new Dimension(_width,_height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		} catch (ImpossibleSizeException ex) {
			this.dimension = ex.newDimension;
			System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
		}
		checkRep();
	}
	
    /**
     * throws AssertionError if representation invariant is violated
     */
    private void checkRep() {
    	assert (this.windowWidth > 0 && this.windowHeight > 0)  : "window size cannot be null, negative or zero";
    }
		
	
    /**
     * @effects changes the size of the shape. 
     * @modifies this.dimension. In case the the size input is not consistent with the rep invariant - new size is used from ImpossibleSizeException
     */
	@Override
	public void setSize(Dimension _dimension) throws ImpossibleSizeException  {
		checkRep();
		if (_dimension.getWidth() > 0 && _dimension.getHeight() > 0 ) {
			this.dimension = _dimension;
		}
		else {
			throw new ImpossibleSizeException(this.windowWidth,this.windowHeight);			
		}
		checkRep();
	}

    /**
     * 
     * @return new Rectangle object such that its upper left corner is in the specified location, and its dimension is this.dimension
     */
	@Override
	public Rectangle getBounds() {
		checkRep();
		Rectangle rec = new Rectangle(getLocation(),this.dimension); // do I have to create another object?
		return rec;
	}
/**
 * @effects draws the triangle at specified location with this.dimension
 */
	@Override
	public void draw(Graphics g) {
		checkRep();
		g.setColor(getColor());
		Point location=getLocation();
		int x = (int) location.getX();
		int y = (int) location.getY();
		int width = (int) this.dimension.getWidth();
		int height = (int) this.dimension.getHeight();
		int[] xList = {x,x,x+width};
		int[] yList = {y,y+height,y};
		g.fillPolygon(xList, yList, 3);
		checkRep();
		
	}

}
