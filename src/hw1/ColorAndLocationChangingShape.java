package hw1;

import java.awt.*;
import java.util.Random;
//import java.util.Random;


/**
 * A ColorAndLocationChaningShape is a Shape that can change its location and color using its step()
 * method.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class ColorAndLocationChangingShape extends LocationChangingShape{
	private int red;
	private int blue;
	private int green;
	Color newColor = new Color(red,green,blue);
	
    // TODO (BOM): Write Abstraction Function

    // TODO (BOM): Write Representation Invariant
	

    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    ColorAndLocationChangingShape(Point location, Color color) {
        // TODO (BOM): Implement this constructor
    	super(location, color);

    }

    /**
     * @modifies this
     * @effects Changes the location of this as described in the specification
     *          of LocationChangingShape.step(Rectangle bound) &&
	 *			if the velocity of this needs to be changed (as described in LocationChangingShape.step(Rectangle bound)),
	 *			changes the color of this to a new random color;
	 *			else, does not change the color of this.
     */
    public void step(Rectangle bound) {
        // TODO (BOM): Implement this method
    	super.step(bound);
    	boolean change = velocityChanged();
    	//System.out.println("right here.velocity changed is " + change);
    	if (change) {
    		Random rand = new Random();
    		red = (int) rand.nextInt(256);
    		green = (int) rand.nextInt(256);
    		blue = (int) rand.nextInt(256);
    		Color newColor = new Color(red,green,blue);
    		System.out.println("color test is:" + newColor);
    		setColor(newColor);
    	}

    }
}
