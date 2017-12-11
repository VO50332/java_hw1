package hw1;

import java.awt.*;

 class LocationChangingOval extends LocationChangingShape{

	
	//private Point relocation;
	private int width;
	private int height;
	private Dimension dimension;

	
	LocationChangingOval(Point _location, Color _color,int _width,int _height) {
		super(_location, _color);
<<<<<<< HEAD
		this.width = _width;
		this.height = _height;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
=======
		//this.width = _width;
		//this.height = _height;
		Dimension _dimension  = new Dimension(_width,_height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		} catch (ImpossibleSizeException e) {
			// TODO Auto-generated catch block
			System.out.println("no problem is possible");
		}
>>>>>>> 5088258c797dcb0102d8cc00a087612d9075b67d
		
		

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
	public void draw(Graphics g) {
		Point location = getLocation();
		int x = (int)location.getX();
		int y = (int)location.getY();
		g.setColor(getColor());
		g.fillOval(x, y, width, height);
		
	}
	
	
	@Override
	public Rectangle getBounds() {
		
		Rectangle rec = new Rectangle(getLocation(),this.dimension); // do I have to create another object?
		return rec;
	}

}
