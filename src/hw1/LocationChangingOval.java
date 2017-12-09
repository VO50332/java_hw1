package hw1;

import java.awt.*;

 class LocationChangingOval extends LocationChangingShape{

	
	//private Point relocation;
	private int width;
	private int height;
	private Dimension dimension;

	
	LocationChangingOval(Point _location, Color _color,int _width,int _height) {
		super(_location, _color);
		this.width = _width;
		this.height = _height;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		
		

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
		g.setColor(getColor());
		g.fillOval(x, y, width, height);
		
	}
	
	
	@Override
	public Rectangle getBounds() {
		
		Rectangle rec = new Rectangle(getLocation(),this.dimension); // do I have to create another object?
		return rec;
	}

}
