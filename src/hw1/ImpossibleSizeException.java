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

	public ImpossibleSizeException(int windowWidth,int windowHeight) {
		//super(message);
		int width = (int) (Math.random()*windowWidth*2/10+windowWidth/10);
        int height = (int) (Math.random()*windowHeight*2/10+windowHeight/10);
		this.newDimension = new Dimension(width,height);

	}


}
	
	
	

