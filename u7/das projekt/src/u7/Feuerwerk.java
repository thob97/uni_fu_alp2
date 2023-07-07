package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Feuerwerk implements Shape, Animation{

	   double radius;
	   Point center; 
	   Color color;
	   ShapesWorld theWorld;
	
	   public Feuerwerk() {
		   this.radius = 45;
		   this.color = Color.magenta; 
		   this.center = new Point(x,y);	
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
	
	// Random
		Random zahl = new Random();
		int x = zahl.nextInt(411)-205;
		int y = zahl.nextInt(311)-155;
		
	//Draw
	public void draw(Graphics g) {
		g.setColor(color);
	    g.fillRect((int)center.x, (int)center.y,(int)radius/4,(int)radius/2);
}
	
	
	//Move to
	public void moveTo(double x, double y){
        center.x = (int) x;
        center.y = (int) y;
    }
	
	//Click
	public void userClicked(double at_X, double at_Y) {	
		if (contains(at_X,at_Y)) {
			this.theWorld.removeShape(this);
			
				for (int i = 0; i < 10; i++) {
					MiniFeuerwerk miniFeuerwerk = new MiniFeuerwerk();
					this.theWorld.addShape(miniFeuerwerk);
					Stern stern = new Stern();
					this.theWorld.addShape(stern);
					miniFeuerwerk.moveTo(center.x+radius/3, center.y+radius/3);
					stern.moveTo(center.x+radius/3, center.y+radius/3);
				}	
			
		}
			
	}
		
	
	//Type
	public void userTyped(char key) {
		System.out.println("key");
	}
	
	//Contain
	public boolean contains(double x, double y) {
        if (x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius))
            return false;
        else
            return true;
    }
	
	//Set Shape
	public void setShapesWorld(ShapesWorld theWorld) {
		this.theWorld = theWorld;	
		}

	 //Animation-Interface
	   public void play (){		 
	   }	    	
   }
	   