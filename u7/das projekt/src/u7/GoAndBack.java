package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GoAndBack implements Shape, Animation {

	double radius;
	int step;
	Point center;
	ShapesWorld theWorld;	   
	Color color;
	
	public GoAndBack () {
		super();
		this.radius = 8;
		this.step = 1;
		this.center = new Point(x,y);
		this.color = Color.YELLOW;		
	}
	
	// Random
	Random zahl = new Random();
	int leftOrRight = zahl.nextInt(2);
	int x = zahl.nextInt(481)-240;
	int y = zahl.nextInt(381)-190;
	
	public void play() {
		if (center.x+radius > theWorld.getMax_X()) {leftOrRight=0;}
		if (center.x < theWorld.getMin_X()) {leftOrRight=1;}
		
		if (leftOrRight==1) {center.x=center.x+step; }
		if (leftOrRight==0) {center.x=center.x-step; }
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval((int) center.x, (int) center.y, (int) radius, (int) radius);
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
