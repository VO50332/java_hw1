package hw1;

import java.awt.*;

/**
 * A LocationChangingNumberedOval is a kind of a LocationChangingOval. A location changing oval consists of
 * a set of properties: {location, color, shape, size, number}.
 * AngleChangingSector are mutable and cloneable.
 */
public class LocationChangingNumberedOval extends LocationChangingOval{
	
	private int number;
	private static int counter;

    //  Abstraction Function:
	// represents a numbered oval such that at the center of the shape - its number is shown. every oval
	// has an ordinal number such that the number of total ovals (till this point) is drawn on every new oval.
	// this.dimension contains the shape's bounding rectangle dimensions
	
    // Representation Invariant:
	//this.dimension cannot be zero, negative or null
	//this.location != null, color != null

    
    /**
     * @effects Initializes this with a a given location , color , size and number.
     * 
     */
	LocationChangingNumberedOval(Point _location, Color _color, int _width, int _height) {
		super(_location, _color, _width, _height);
		counter++;
		number = counter;

	}
	
	/**
	 * @effects draws the numbered oval at specified location with this.dimension
	 */

	public void draw(Graphics g) {
		super.draw(g);
		Point location = getLocation();
		int x = (int)location.getX();
		int y = (int)location.getY();
		String myNumber = Integer.toString(number);
		Rectangle rec = this.getBounds();
		int boundX = (int) rec.getWidth();
		int boundY = (int) rec.getHeight();

		Color shapeColor = g.getColor();
		int blue = shapeColor.getBlue();
		int red = shapeColor.getRed();
		int green = shapeColor.getGreen();
		g.setColor(Color.black);

		if (0.3*red + 0.59*green +0.11*blue < 110) {
			g.setColor(Color.white);
		}
		g.drawString(myNumber,x +boundX/2,y+boundY/2);
	}

	/**
	 * @modifies this.counter
	 */
	public static void setZero(){
		counter=0;
	}
}


