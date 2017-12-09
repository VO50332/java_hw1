package hw1_3;
/**
 * Thrown to indicate that the setSize method in class Shape has been called to resize a shape, but it cannot be resized to the specified dimension. 
Applications that override the clone method can also throw this exception to indicate that an object could not or should not be cloned.
 *
 *
 */
public class ImpossibleSizeException extends Exception{
	final private int defaultValue = 1;
	public ImpossibleSizeException (String impossiblesize) {
		super(impossiblesize);
	}
	//return this.defaultValue;
	public int getDefaultValue() {
		return this.defaultValue;
	}
	
}	
	

