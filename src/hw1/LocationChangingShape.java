package hw1;

import java.awt.*;
import java.util.Random;



/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationChangingShape extends Shape implements Animatable {//it is abstract only because the father is abstract?
	private int velocityX;
	private int velocityY;
	private boolean velocityChanged;


    // TODO (BOM): Write Abstraction Function

    // TODO (BOM): Write Representation Invariant


    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */

	 LocationChangingShape(Point _location, Color _color) {
	    	super(_location, _color);
		 //	setLocation(_location);
		 	//setColor(_color);
	    	Random rand = new Random();
	    	this.velocityX = rand.nextInt(10)-5;
	    	this.velocityY = rand.nextInt(10)-5;

	    }
	

    /**
     * @return the horizontal velocity of this.
     */
	 

    public int getVelocityX() {
        // TODO (BOM): Implement this method

    	return this.velocityX;
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
        // TODO (BOM): Implement this method

    	return this.velocityY;
    }


    /**
	 * @requires -5 <= velocityX <= 5 && -5 <= velocityY <= 5 && velocityX != 0 && velocityY != 0
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     *          vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
        // TODO (BOM): Implement this method

    	if ( velocityX > 5 || velocityX < -5 || velocityY > 5 || velocityY < -5 || velocityX == 0 || velocityY == 0) {
    		assert false: "velocityX or velocityY are either above 5,under-5 or 0";
    	}		
    	this.velocityX = velocityX;
    	this.velocityY = velocityY;

    }


    /**
     * @modifies this
     * @effects Let p = location
     *              v = (vx, vy) = velocity
     *              r = the bounding rectangle of this
     *          If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     *              If adding v to p would move r horizontally outside of bound,
     *                  vx = -vx
     *              If adding v to p would move r vertically outside of bound,
     *                  vy = -vy
     *          }
     *          p = p + v
     */
    public void step(Rectangle bound) {
        // TODO (BOM): Implement this method
    	Rectangle boundingRec = getBounds();
    	int width = (int) boundingRec.getWidth();
    	int height = (int) boundingRec.getHeight();
    	Point _location = getLocation();
    	double x = _location.getX();
    	double y = _location.getY();
    	//double newX;
    	//double newY;
    	double sizeX = bound.getWidth();
    	double sizeY = bound.getHeight();
    	//private double y = location.getY();
    	double boundX = bound.getX();
    	double boundY = bound.getY();
    	boolean velocityChangedX;
    	boolean velocityChangedY;
    	//System.out.println();
    	if (x + width + velocityX  > boundX + sizeX || x + velocityX  < boundX) { 
    	//	System.out.println("new location is: " + x + velocityX );
    		//System.out.println("bound is:"+boundX + sizeX);
    		velocityX = -velocityX;
    		velocityChangedX = true;
    	}
    	else {
    		velocityChangedX = false;
    	}
    	//if (y + velocityY  > boundY  || y - height + velocityY  < boundY - sizeY) {
    	if (y + height + velocityY  > boundY + sizeY || y +  velocityY  < boundY ) {
    		velocityChangedY = true;
    		velocityY = -velocityY;
    	}
    	else {
    		velocityChangedY = false;
    	}
    	velocityChanged=velocityChangedX || velocityChangedY;
    	System.out.println("velcoity changed:" + velocityChanged);
    	double newX = x+velocityX;
    	double newY = y+velocityY;
    	
    	Point newPoint= new Point((int)newX,(int)newY);// is the casting here ok? yes
    //	System.out.println("new point is:" + newPoint);
    	setLocation(newPoint);			

    }
    public boolean velocityChanged() {
    	return velocityChanged;
    }
}
