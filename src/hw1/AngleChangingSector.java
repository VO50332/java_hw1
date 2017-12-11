package hw1;

import java.awt.*;

/**
 * A AngleChangingSector is a kind of a shape object. A typical angle changing sector consists of
 * a set of properties: {location, color, shape, size, start angle, arc angle}.
 * AngleChangingSector are mutable and cloneable.
 */
public class AngleChangingSector extends Shape implements Animatable{
	private Dimension dimension;
	private int startAngle;
	private int arcAngle;
	boolean up = true;
    //  Abstraction Function:
	// represents a sector of a oval such that its bounding rectangle's this.location.
	// this.windowWidth and this.windowHeight contain the window size information. this.dimension contains the shape's bounding rectangle dimensions
	
    // Representation Invariant:
	// 0<=arcAngle,startAngle <= 359
	//this.dimension cannot be zero, negative or null
	//this.location != null, color != null

	   /**
     * @effects Initializes this with a a given location , color , size , start angle and arc angle.
     * 
     */
	public AngleChangingSector(Point location, Color color,int width, int height,int startAngle,int arcAngle) {
		super(location, color);		
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
		Dimension _dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		} catch (ImpossibleSizeException ex) {
			this.dimension = ex.newDimension;
			System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
		}
		checkRep();


	}
	
    /**
     * @effects throws AssertionError if representation invariant is violated
     */
    private void checkRep() {
    	assert (this.startAngle >= -359 && this.startAngle <= 359) : "start angle should be -359-359";
    	assert (this.arcAngle >= 0 && this.arcAngle <= 359) : "Arc angle should be 0-359";
    	
    }
		
    /**
     * @modifies this.arcAngle
     * @effects if up is true:
	 *  each step arc angle increases by 1
	 * 	else:
	 * each step arc angle decreases by 1
	 * at the beginning up is true -> arc angle increases by 1
	 * when arcAngle == 359 -> up is false and decreasing starts to take place
     */
    
	@Override
	public void step(Rectangle bound) {// why do I care about bound?
		checkRep();
		if (up) {
			this.arcAngle++;
			if (arcAngle == 359) {
				up = false;
			}
				
		}
		else {
			this.arcAngle--;
			if(arcAngle == 0) {
				up = true;
			}
		}
		checkRep();
	}

    /**
     * @effects changes the size of the shape. 
     * @modifies this.dimension. In case the the size input is not consistent with the rep invariant - new size is used from ImpossibleSizeException
     * @requires _dimension.getWidth > 0 , _dimension.getHeight > 0 ,   
     */
	@Override
	public void setSize(Dimension _dimension) throws ImpossibleSizeException {
		checkRep();
		if (_dimension.getWidth() > 0 && _dimension.getHeight() > 0 ) {
			this.dimension = _dimension;
		}
		else {
			throw new ImpossibleSizeException();			
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
		Rectangle rec = new Rectangle(getLocation(),this.dimension);
		return rec;
	}
	
	/**
	 * @effects draws the sector at specified location with this.dimension
	 */
	@Override
	public void draw(Graphics g) {
		checkRep();
		int x = (int)getLocation().getX();
		int y = (int)getLocation().getY();
		int width = (int) this.dimension.getWidth();
		int height = (int) this.dimension.getHeight();
		g.setColor(getColor());
		g.fillArc(x, y, width, height, this.startAngle, this.arcAngle);
		checkRep();
	}

}
