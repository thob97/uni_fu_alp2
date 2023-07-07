package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class stein implements Shape, Animation {

	double radius;
	int step;
	Point center;
	ShapesWorld theWorld;	   
	Color color;
	
	public stein () {
		super();
		this.radius = 30;
		this.step = 1;
		this.center = new Point(x,y);
		this.color = Color.GRAY;		
	}
	
	// Random
	Random zahl = new Random();
	int x = zahl.nextInt(481)-240;
	int y = -190;
	
	public void play() {

		if (center.y + this.radius >= theWorld.getMax_Y()) {
			theWorld.removeShape(this);
			for (int i = 0; i!=5; i++) {
				mini_stein mini_stein = new mini_stein();
				mini_stein.moveTo(center.x, center.y);
				theWorld.addShape(mini_stein);
			}
		}
		else {center.y +=8;}
		

	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRoundRect((int) center.x, (int) center.y, (int) radius, (int) radius, (int) radius, (int) radius);
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
