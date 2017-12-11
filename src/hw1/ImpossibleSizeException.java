package hw1;

import java.awt.*;

/**
 * Thrown to indicate that the setSize method in class Shape has been called to resize a shape, but it cannot be resized to the specified dimension. 
Applications that override the clone method can also throw this exception to indicate that an object could not or should not be cloned.
 *
 *
 */
@SuppressWarnings("serial")
public class ImpossibleSizeException extends Exception{
	public Dimension newDimension;

	public ImpossibleSizeException() {

		this.newDimension = new Dimension(1,1);

	}


}
	
	
	

