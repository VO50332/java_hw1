package hw1;

import java.awt.*;

/**
 * A AngleChangingSector is a kind of a shape object. A typical angle changing sector consists of
 * a set of properties: {location, color, shape, size}.
 * AngleChangingSector are mutable and cloneable.
 */
public class AngleChangingSector extends Shape implements Animatable{
	//private int width;
//	private int height;
	private Dimension dimension;
	private int startAngle;
	private int arcAngle;
	boolean up = true;
	private int windowWidth;
	private int windowHeight;
	
	public AngleChangingSector(Point location, Color color,int width, int height,int startAngle,int arcAngle,int windowWidth,int windowHeight) {
		super(location, color);
		//this.width = width;
	//	this.height = height;
		//dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;		
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
		Dimension _dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		} catch (ImpossibleSizeException ex) {
			// TODO Auto-generated catch block
			this.dimension = ex.newDimension;
			System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
		}


	}

    
	@Override
	public void step(Rectangle bound) {// why do I care about bound?
		
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
	}

	@Override
	public void setSize(Dimension _dimension) throws ImpossibleSizeException {
		if (_dimension.getWidth() > 0 && _dimension.getHeight() > 0 ) {
			this.dimension = _dimension;
		}
		else {
			throw new ImpossibleSizeException(this.windowWidth,this.windowHeight);			
		}
	}


	@Override
	public Rectangle getBounds() {
		
		Rectangle rec = new Rectangle(getLocation(),this.dimension);
		return rec;
	}

	@Override
	public void draw(Graphics g) {
		int x = (int)getLocation().getX();
		int y = (int)getLocation().getY();
		int width = (int) this.dimension.getWidth();
		int height = (int) this.dimension.getHeight();
		g.setColor(getColor());
		g.fillArc(x, y, width, height, this.startAngle, this.arcAngle);
		
	}

}
