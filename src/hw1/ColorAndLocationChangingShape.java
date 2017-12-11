package hw1;

import java.awt.*;
import java.util.Random;
//import java.util.Random;


/**
 * A ColorAndLocationChaningShape is a LocationChaningShape that can change its location and color using its step()
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
	// represents a color and location changing shape, which has a certain RGB color that composes out of red,green and blue colors:
	// this.blue is the blue influence, this.green is the green one and this.red is the red one.
    // TODO (BOM): Write Representation Invariant
	 //this.red, this.blue and this.green have to be an int of the range 0 to 255
	// again I don't think that this Rep Invariant has to be checked because I make them here and there is no chance that they are not legit.

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
    	//	System.out.println("color test is:" + newColor);
    		setColor(newColor);
    	}

    }
}
