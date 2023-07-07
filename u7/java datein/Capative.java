package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Capative implements Shape, Animation {

	double radius;
	int step;
	Point center;
	ShapesWorld theWorld;	   
	Color color;
	
	public Capative () {
		super();
		this.radius = 15;
		this.step = 1;
		this.center = new Point(x,y);
		this.color = Color.YELLOW;		
	}
	
	// Random
	Random zahl = new Random();
	int upDown = zahl.nextInt(2)-1;
	int leftRight = zahl.nextInt(2)-1;
	int x = zahl.nextInt(481)-240;
	int y = zahl.nextInt(381)-190;
	
	public void play() {

		if (upDown==0 || leftRight==0) {
			upDown = zahl.nextInt(3)-1;
			leftRight = zahl.nextInt(3)-1;
		}
		
		else if ( center.x + radius == theWorld.getMax_X() ) {leftRight *= -1;}
		else if ( center.x - radius == theWorld.getMin_X() ) {leftRight *= -1;}
		else if ( center.y + radius == theWorld.getMax_Y() ) {upDown *= -1; }
		else if ( center.y	- radius == theWorld.getMin_Y() ) {upDown *= -1; }
		
		this.moveTo(center.x+leftRight, center.y+upDown);		 
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
	    fillCapative(g,x,y,radius);
}
	
	//Polygon Shape
	public void fillCapative(Graphics g, double x, double y, double radius) {
		int[] x_coords = {
				
				(int) (center.x), 
				
				(int) (center.x + radius), 
				
				(int) center.x, //Mund
				
				(int) (center.x + radius), 
				
				(int) (center.x), 
				
				(int) (center.x - radius), 
				
				(int) (center.x - radius), 
					
		};
		int[] y_coords = {
				
				(int) (center.y + radius), 
				
				(int) (center.y + radius/2), 
				
				(int) center.y, //Mund
				
				(int) (center.y - radius/2), 
				
				(int) (center.y - radius), 
				
				(int) (center.y - radius/2), 
				
				(int) (center.y + radius/2), 
							
		};
		Polygon p = new Polygon(x_coords,y_coords,7);
		g.fillPolygon(p);
	}
	
	public boolean contains(double x, double y) {
		return false;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}
	
	public Point getCenter() {
		return center;
	}

	public void setShapesWorld(ShapesWorld theWorld) {
		this.theWorld = theWorld;
	}
	
	public void userClicked(double at_X, double at_Y) {
			
	}
	
	public void userTyped(char key) {
		
	}
	
	public void moveTo(double x, double y) {
		center.x = (int)x;
		center.y = (int)y;
	}
	
	
}
