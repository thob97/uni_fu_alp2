package u6;

import java.util.Random;

public class TestCircle {
	
	public static void initWindow() {				
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);		
	}
	
	public static void testCompareTo() {
		
		double x1 = -50, y1 = 90,  r1 = 10;
		double x2 = -10, y2 = 90,  r2 = 15;
		
		Circle c1 = new Circle(x1, y1, r1);
		Circle c2 = new Circle(x2, y2, r2);
		
		StdDraw.text(x2-r2-60, y2, "compareTo");		
		StdDraw.circle(x1, y1, r1);
		StdDraw.circle(x2, y2, r2);
		StdDraw.text(x2+r2+20, y2, Integer.toString(c1.compareTo(c2)));
	}
	
	public static void testContains() {
		
		StdDraw.setPenColor(StdDraw.BLUE);
		
		double x1 = -50, y1 = 55,  r1 = 8;
		double x2 = -45, y2 = 55,  r2 = 10;
		
		Circle c1 = new Circle(x1, y1, r1);
		Circle c2 = new Circle(x2, y2, r2);
		
		StdDraw.text(x2-r2-35, y2, "contains");		
		StdDraw.circle(x1, y1, r1);
		StdDraw.circle(x2, y2, r2);
		StdDraw.text(x2+r2+10, y2, Boolean.toString(c2.contains(c1)));
		
		x1 = 23; y1 = 52; r1 = 5;
		x2 = 20; y2 = 54; r2 = 10;
		
		Circle c3 = new Circle(x1, y1, r1);
		Circle c4 = new Circle(x2, y2, r2);
		
		StdDraw.circle(x1, y1, r1);
		StdDraw.circle(x2, y2, r2);
		StdDraw.text(x2+r2+10, y2, Boolean.toString(c4.contains(c3)));
	}
	
	public static void testOverlaps() {
		
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		
		double x1 = -50, y1 = 20,  r1 = 8;
		double x2 = -35, y2 = 20,  r2 = 10;
		
		Circle c1 = new Circle(x1, y1, r1);
		Circle c2 = new Circle(x2, y2, r2);
		
		StdDraw.text(x2-r2-45, y2, "overlaps");		
		StdDraw.circle(x1, y1, r1);
		StdDraw.circle(x2, y2, r2);
		StdDraw.text(x2+r2+10, y2, Boolean.toString(c2.overlaps(c1)));
		
		x1 = 23; y1 = 22; r1 = 5;
		x2 = 37; y2 = 23; r2 = 8;
		
		Circle c3 = new Circle(x1, y1, r1);
		Circle c4 = new Circle(x2, y2, r2);
		
		StdDraw.circle(x1, y1, r1);
		StdDraw.circle(x2, y2, r2);
		StdDraw.text(x2+r2+10, y2, Boolean.toString(c4.overlaps(c3)));
	}
	
	public static void testSmallestBoundingRectangle() {
		
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		Random rand = new Random();
		int n = 10;
		Circle[] circles = new Circle[n]; 
		
		double x1 = -60, y1 = -20,  r1 = 0;
		StdDraw.text(x1, y1, "smallestBoundingRectangle");
		
		for (int i=0; i<n; i++) {
			x1 = rand.nextInt(60); y1 = -rand.nextInt(70); r1 = (rand.nextInt(10)+1)*2;
			circles[i] = new Circle(x1, y1, r1);
			StdDraw.circle(x1, y1, r1);
		}

		Rectangle rect = Circle.smallestBoundingRectangle(circles);
		double xc = rect.x + rect.width/2;
		double yc = rect.y + rect.height/2;
		StdDraw.rectangle(xc, yc, rect.width/2, rect.height/2);
	}
	
	public static void main( String[] args) {		
		initWindow();
		testCompareTo();
		testContains();
		testOverlaps();
		testSmallestBoundingRectangle();
	}

} // end of TestCircle
