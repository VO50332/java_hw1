package hw1;


import java.awt.*;


/**
 * A Shape is an abstraction of a shape object. A typical Shape consists of
 * a set of properties: {location, color, shape, size}.
 * Shapes are mutable and cloneable.
 */
public abstract class Shape implements Cloneable {

    private Point location;
    private Color color;


    // TODO (BOM): Write Abstraction Function
    	// represents a shape, which its bounding rectangle's upper left corner is this.location, and its color is this.color.
    // TODO (BOM): Write Representation Invariant
    	// this.location != null, color != null
    /**
     * @effects Initializes this with a a given location and color.
     */
    
    public Shape(Point location, Color color) {
		 // TODO (BOM): Implement this method
    	this.location = location;
    	this.color = color; 
    	checkRep();
    }
    
    /**
     * @effects throws AssertionError if representation invariant is violated
     */
    private void checkRep() {
    	//System.out.println(this.location.getX());
    	assert this.location != null  : "location cannot be null";
    	assert this.color != null : "color cannot be null";
    }
    /**
     * @return the top left corner of the bounding rectangle of this.
     */
    public Point getLocation() {
        // TODO (BOM): Implement this method
    	checkRep();
    	return (Point) this.location.clone();//because location is immutable point, return location will deliver the user the real reference

    }


    /**
     * @modifies this
     * @effects Moves this to the given location, i.e. this.getLocation()
     *          returns location after call has completed.
     */
    public void setLocation(Point location) {
    	checkRep();
        this.location = (Point)location.clone();
        checkRep();
    }


    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     *          dimension.
     *          If this cannot be resized to the specified dimension =>
     *          this is not modified, throws ImpossibleSizeException
     *          (the exception suggests an alternative dimension that is
     *           supported by this).
     */
    public abstract void setSize(Dimension dimension)
        throws ImpossibleSizeException;


    /**
     * @return the bounding rectangle of this.
     */
    public abstract Rectangle getBounds();


    /**
     * @return true if the given point lies inside the bounding rectangle of
     *         this and false otherwise.
     */
    public boolean contains(Point point) {
    	checkRep();
        return getBounds().contains(point);
    }
    
	//public abstract String getShape();

    /**
     * @return color of this.
     */
    public Color getColor() {
    	checkRep();
        return color;
    }


    /**
     * @modifies this
     * @effects Sets color of this.
     */
    public void setColor(Color color) {
    	checkRep();
        this.color = color;
        checkRep();
    }


    /**
     * @modifies g
     * @effects Draws this onto g.
     */
    public abstract void draw(Graphics g);


    /**
     * @effects Creates and returns a copy of this.
     * 
     */
    @Override
    public Object clone() {
        // TODO (BOM): Implement this method
    	checkRep();
    	Shape newShape = null;
    	try {
    		newShape = (Shape)super.clone();
    	}
    	catch (CloneNotSupportedException e) {
    		assert false: "Got inside the CloneNotSupportedException exception of Shape.clone()";
    	}
    	newShape.location = (Point)this.location.clone();// point is immutable and thus won't copy the value when cloning
    	checkRep();
    	return newShape;
    	
    }

	public void step(Rectangle windowBound) {
		checkRep();
		// TODO Auto-generated method stub
		
	}
}
