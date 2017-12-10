package hw1;

import java.awt.*;

 class LocationChangingOval extends LocationChangingShape{

	
	//private Point relocation;
	//private int width;
	//private int height;
	private Dimension dimension;

	
	LocationChangingOval(Point _location, Color _color,int _width,int _height) {
		super(_location, _color);
		//this.width = _width;
		//this.height = _height;
		Dimension _dimension  = new Dimension(_width,_height);// bounding rectangle dimensions 
		try {
			this.setSize(_dimension);
		} catch (ImpossibleSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	@Override
	public void setSize(Dimension _dimension) throws ImpossibleSizeException {
		//try - catch
		this.dimension = _dimension;
		
	}

	@Override
	public void draw(Graphics g) {
		Point location = getLocation();
		int x = (int)location.getX();
		int y = (int)location.getY();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		g.setColor(getColor());
		g.fillOval(x, y, width, height);
		
	}
	
	
	@Override
	public Rectangle getBounds() {
		
		Rectangle rec = new Rectangle(getLocation(),this.dimension); // do I have to create another object?
		return rec;
	}

}
