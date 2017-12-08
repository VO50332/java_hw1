package hw1_3;

import java.awt.*;


public class AngleChangingSector extends Shape implements Animatable{
	private int width;
	private int height;
	private Dimension dimension;
	private int startAngle;
	private int arcAngle;
	boolean up = true;
	//private int velocityX;
	//private int velocityY;
//	private boolean velocityChanged;
	
	public AngleChangingSector(Point location, Color color,int width, int height,int startAngle,int arcAngle) {
		super(location, color);
		this.width = width;
		this.height = height;
		dimension  = new Dimension(width,height);// bounding rectangle dimensions 
		this.startAngle = startAngle;
		this.arcAngle = arcAngle;
    	//Random rand = new Random();
    	//this.velocityX = rand.nextInt(10)-5;
    //	this.velocityY = rand.nextInt(10)-5;
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
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		this.dimension = dimension;
		// TODO Auto-generated method stub
		
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
