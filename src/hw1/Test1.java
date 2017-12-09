package hw1;

import java.awt.*;

public class Test1 {
	public static void main(String[] args) {
		Point loc = new Point(0,1); 
		LocationChangingOval oval = new LocationChangingOval(loc,Color.blue,1,1);
		Rectangle bound = new Rectangle(0,1,10,10);
		//Rectangle rec = new Rectangle(0,1,1);
		int x =5;
		x = 4;
		if (x == 4) {
			System.out.println("Every thing is good!");
		}
		System.out.println(oval.getColor());
		
		Rectangle rec =oval.getBounds();
		System.out.println(loc);
		System.out.println(rec);
		oval.step(bound);
		
		loc = oval.getLocation();
		System.out.println(loc);
		rec = oval.getBounds();
		System.out.println(rec);
		oval.step(bound);
		
		loc = oval.getLocation();
		System.out.println(loc);
		rec = oval.getBounds();
		System.out.println(rec);
		oval.step(bound);
		loc = oval.getLocation();
		System.out.println(loc);
		rec = oval.getBounds();
		System.out.println(rec);
		oval.step(bound);
		loc = oval.getLocation();
		System.out.println(loc);
		rec = oval.getBounds();
		System.out.println(rec);
		oval.step(bound);
	//	System.out.println(oval.getColor());
		
		
	}
}
