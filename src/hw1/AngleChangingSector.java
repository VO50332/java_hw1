package hw1;

import java.awt.*;


public class AngleChangingSector extends Shape implements Animatable{
	private int width;
	private int height;
	private Dimension dimension;
	private int startAngle;
	private int arcAngle;
	boolean up = true;
	
	public AngleChangingSector(Point location, Color color,int width, int height,int startAngle,int arcAngle) {
		super(location, color);
<<<<<<< HEAD
		this.width = width;
		this.height = height;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
=======
	//	this.width = width;
		//this.height = height;
	//	dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		Dimension _dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		}
		catch (ImpossibleSizeException e){
			System.out.println("no problem is possible");
		}
		
>>>>>>> 5088258c797dcb0102d8cc00a087612d9075b67d
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;

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
			ImpossibleSizeException ex=  new ImpossibleSizeException("width or height cannot be negative or zero");
			this.dimension = ex.newDimension;
			System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
			
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
		g.setColor(getColor());
		g.fillArc(x, y, this.width, this.height, this.startAngle, this.arcAngle);
		
	}

}
