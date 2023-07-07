package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;


public class roboter implements Shape, Animation{

	   double radius;
	   Point center;
	   Color color;
	   ShapesWorld theWorld;
	   boolean keypressed = false;
	   boolean keyready = true;
	   
	   public roboter() {
		   this.radius = 45;
		   this.color = Color.GRAY; 
		   this.center = new Point(x,y);
	   }

	
	// Random
		Random zahl = new Random();
		int x = zahl.nextInt(411)-205;
		int y = zahl.nextInt(311)-155;
		
	//Draw
	public void draw(Graphics g) {
		g.setColor(color);
		fillRoboter(g,center.x,center.y,radius);
		g.setColor(Color.RED);
		g.fillOval((int)(center.x + radius/6),(int) center.y,(int) radius/10,(int) radius/10);
		g.fillOval((int)(center.x + radius/2),(int) center.y,(int) radius/10,(int) radius/10);
	}
	
		
		//Polygon Shape
		public void fillRoboter(Graphics g, double x, double y, double radius) {
			int[] x_coords = {
				
					(int) (center.x), 	
					(int) (center.x),
					(int) (center.x+ radius*3/20),
					
					(int) (center.x+ radius*3/20),
					(int) (center.x+ radius*6/20),
					(int) (center.x+ radius*6/20),
					
					
					(int) (center.x+ radius*9/20),
					
					(int) (center.x+ radius*9/20),
					(int) (center.x+ radius*12/20),
					(int) (center.x+ radius*12/20),
					
					(int) (center.x+ 3*radius/4),
					(int) (center.x+ 3*radius/4),
					(int) (center.x+ 3*radius/4-radius/5),
					(int) (center.x+ 3*radius/4-radius/5- radius*7/20),
					(int) (center.x+ 3*radius/4-radius/5- radius*7/20- radius*1/5),
			
			};
			int[] y_coords = {
				
					(int) (center.y),	
					(int) (center.y+ radius),
					(int) (center.y+ radius),
					
					(int) (center.y+ radius + radius/3),
					(int) (center.y+ radius + radius/3),
					(int) (center.y+ radius),
					
					(int) (center.y+ radius),
					
					(int) (center.y+ radius + radius/3),
					(int) (center.y+ radius + radius/3),
					(int) (center.y+ radius),
					
					(int) (center.y+ radius),
					(int) (center.y),
					(int) (center.y- radius/5),
					(int) (center.y- radius/5),
					(int) (center.y),
		
			};
			Polygon p = new Polygon(x_coords,y_coords,15);
			g.fillPolygon(p);
		}
		
	
	
	//Move to
	public void moveTo(double x, double y){
        center.x = (int) x;
        center.y = (int) y;
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
	
	//Click
	public void userClicked(double at_X, double at_Y) {	
 
	}
	
	//Type
	public void userTyped(char key) {
		if (key == 'j' && keyready == true) {
			keypressed= true;
			keyready = false;
		}
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
	
	 int up = 0;
	 int down = 0;
	 //Animation-Interface
	   public void play (){
 
			if (keypressed==true) {
				keypressed = false;
				up = down = 5;
			}		 
			else if (up!=0) {
				up--;
				center.y-=6;
			}
			
			else if (down!=0) {
				down--;
				center.y+=6;
			}
			else if (down == 0){
				keyready = true;
			}
			
			
	   }
		
	   
   }
