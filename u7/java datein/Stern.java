package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;


public class Stern implements Shape, Animation{

	   double radius;
	   Point center;
	   

	   ShapesWorld theWorld;
	
	   public Stern() {
		   this.radius = 10;
		   this.center = new Point(0,0);	
	   }
	
	// Random
		Random zahl = new Random();
		int upDown = zahl.nextInt(3)-1;
		int leftRight = zahl.nextInt(3)-1;
		int ran = zahl.nextInt(20)+1;
		int ran2 = zahl.nextInt(20)+1;
		Color color = new Color((int)(Math.random() * 0x1000000));
		
	//Draw
	public void draw(Graphics g) {
		g.setColor(color);
	    drawStern(g,center.x,center.y,radius);
   }
	
	//Polygon Shape
	public void drawStern(Graphics g, double x, double y, double radius) {
		int[] x_coords = {
				
				(int) center.x,
				(int) (center.x),
				(int) center.x,
				(int) (center.x + radius),
				(int) center.x,
				(int) (center.x - radius),
				(int) center.x,
				(int) (center.x),
				(int) center.x,
				(int) (center.x + radius),
				(int) center.x,
				(int) (center.x - radius),
		};
		int[] y_coords = {
				(int) center.y,
				(int) (center.y + radius),
				(int) center.y,
				(int) (center.y + radius/2),
				(int) center.y,
				(int) (center.y + radius/2),
				(int) center.y,
				(int) (center.y - radius),
				(int) center.y,
				(int) (center.y - radius/2),
				(int) center.y,
				(int) (center.y - radius/2),
		};
		Polygon p = new Polygon(x_coords,y_coords,12);
		g.drawPolygon(p);
	}
	
	
	//Move to
	public void moveTo(double x, double y) {
		  center.x = (int) x;
          center.y = (int) y;
		}
	
	
	//Click
	public void userClicked(double at_X, double at_Y) {	
	}
	
	//Type
	public void userTyped(char key) {	
	}
	
	//Contain
	public boolean contains(double x, double y) {
		return false;
		}
	
	//Set Shape
	public void setShapesWorld(ShapesWorld theWorld) {
		this.theWorld = theWorld;	
		}
	
	  int n1 = 0;
	 //Animation-Interface
	   public void play () {	
		   if (upDown == 0 && leftRight == 0) {
				  leftRight = zahl.nextInt(3)-1;
			  	  upDown = zahl.nextInt(3)-1;
		   }
		   
		   else if (n1<5) { //Bubble  in Richtung
			center.x += leftRight*ran;
			center.y += upDown*ran2;
			n1 = n1+1;
			 }
		   else 
			   if ( this.radius> 0 ) {
			    	this.radius = this.radius -0.25;
			    	center.y=center.y+2;}
			    else if (radius <= 0) {
			    	this.theWorld.removeShape(this);
			    }
						
			}
		 
	   
	// GET	
	public Color getColor() {
		return color;
	}

	public Point getCenter() {
		return center;
	}
	
	public double getRadius() {
		return radius;
	}

}
