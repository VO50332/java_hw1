package hw1;

import java.awt.*;

 class LocationChangingOval extends LocationChangingShape{


	private Dimension dimension;
	private int windowWidth;
	private int windowHeight;
	
	LocationChangingOval(Point _location, Color _color,int _width,int _height,int windowWidth,int windowHeight)  {
		super(_location, _color);

		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;

		Dimension _dimension  = new Dimension(_width,_height);// bounding rectangle dimensions 
			try {
				this.setSize(_dimension);
			} catch (ImpossibleSizeException ex) {
				this.dimension = ex.newDimension;
				System.out.println("Impossible size. New size is:" + "(" + (int)ex.newDimension.getWidth() +"," + (int)ex.newDimension.getHeight() +")");
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
	public void draw(Graphics g) {
		Point location = getLocation();
		int x = (int)location.getX();
		int y = (int)location.getY();
		int width = (int) this.dimension.getWidth();
		int height = (int) this.dimension.getHeight();
		g.setColor(getColor());
		g.fillOval(x, y, width, height);
		
	}
	
	
	@Override
	public Rectangle getBounds() {
		
		Rectangle rec = new Rectangle(getLocation(),this.dimension); // do I have to create another object?
		return rec;
	}

}
