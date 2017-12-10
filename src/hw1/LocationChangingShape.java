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
	    	int vX = rand.nextInt(10)-5;
	    	int vY = rand.nextInt(10)-5;
	    	setVelocity(vX,vY);
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
	    	Random rand = new Random();
	    	int vX = rand.nextInt(10)-5;
	    	int vY = rand.nextInt(10)-5;
	    	setVelocity(vX,vY);
    	}	
    	else {
        	this.velocityX = velocityX ;
        	this.velocityY = velocityY;
    	}

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
    	double sizeX = bound.getWidth();
    	double sizeY = bound.getHeight();
    	double boundX = bound.getX();
    	double boundY = bound.getY();
    	boolean velocityChangedX;
    	boolean velocityChangedY;
    	if (x + width + this.velocityX  > boundX + sizeX || x + this.velocityX  < boundX) { 
    		this.velocityX = -this.velocityX;
    		velocityChangedX = true;
    	}
    	else {
    		velocityChangedX = false;
    	}
    	if (y + height + this.velocityY  > boundY + sizeY || y +  this.velocityY  < boundY ) {
    		velocityChangedY = true;
    		this.velocityY = -this.velocityY;
    	}
    	else {
    		velocityChangedY = false;
    	}
    	velocityChanged=velocityChangedX || velocityChangedY;
    	double newX = x+this.velocityX;
    	double newY = y+this.velocityY;
    	
    	Point newPoint= new Point((int)newX,(int)newY);// is the casting here ok? yes
    	setLocation(newPoint);			

    }
    public boolean velocityChanged() {
    	return velocityChanged;
    }
}
