package u7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Scared implements Shape, Animation{

	double radius;
	   Point center;
	   Color color;
	   ShapesWorld theWorld;
	   double distance;
	
	   public Scared() {
		   this.radius = 15;
		   this.color = Color.PINK; 
		   this.center = new Point(x,y);	
	   }
	
	// Random
		Random zahl = new Random();
		int x = zahl.nextInt(471)-235;
		int y = zahl.nextInt(371)-185;
		int newx = zahl.nextInt(471)-235;
		int newy = zahl.nextInt(371)-185;
	

	//Contain
	public boolean contains(double x, double y) {
		if (x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius)) {
			return false;
		}
		return true;
    }
	
	 //Animation-Interface
	   public void play (){	
		   if (this.theWorld.getClosestShape(this) != null) {
		   Shape closestShape = this.theWorld.getClosestShape(this);	
				
		   		if (contains(closestShape.getCenter().x,closestShape.getCenter().y) && color!=Color.RED) {
						moveTo(newx,newy);
						this.color= Color.RED;
					}
					
					else if (contains(closestShape.getCenter().x,closestShape.getCenter().y)) {
						this.theWorld.removeShape(this);
						for (int i = 0; i!=5; i++) {
							Shape stein = new mini_stein();
							stein.moveTo(center.x, center.y);
							this.theWorld.addShape(stein);
						}
					}			
				
					 
				//Zittern
			   if (closestShape.getCenter().x <= center.x+radius*1.8 &&
						closestShape.getCenter().x >= center.x-radius*1.8 ||
						closestShape.getCenter().y <= center.y+radius*1.8 &&
						closestShape.getCenter().y >= center.y-radius*1.8) {
						
						if (center.x%2==0) {
							center.x=center.x+1;
						}
						else  {
							center.x=center.x-1;
						}
				}			
		   }
    }
	   
	 //Draw
		public void draw(Graphics g) {
			g.setColor(color);
		    fillCapative(g,x,y,radius);
	}
		
		//Polygon Shape
		public void fillCapative(Graphics g, double x, double y, double radius) {
			int[] x_coords = {				
					
					(int) (center.x + radius), 
								
					(int) (center.x + radius), 
					
					(int) (center.x), 
					
					(int) (center.x - radius), 
					
					(int) (center.x - radius), 
					
					(int) (center.x - radius*0.5),
					
					(int) (center.x), 
						
					(int) (center.x + radius*0.5),
			};
			
			int[] y_coords = {			
					
					(int) (center.y + radius), 
							
					(int) (center.y - radius/2), 
					
					(int) (center.y - radius), 
					
					(int) (center.y - radius/2), 
					
					(int) (center.y + radius), 
					
					(int) (center.y + radius/2),
					
					(int) (center.y + radius), 
					
					(int) (center.y + radius/2),						
					
			};
			
			Polygon p = new Polygon(x_coords,y_coords,8);
			g.fillPolygon(p);
		}
		
		public Color getColor() {
			return color;
		}

		public Point getCenter() {
			return center;
		}
		
		public double getRadius() {
			return radius;
		}
		
		//Move to
		public void moveTo(double x, double y){
	          center.x = (int) x;
	          center.y = (int) y;
	    }	
		
		//Click
		public void userClicked(double at_X, double at_Y) {			
				System.out.println(at_X + at_Y);	
		}
		
		//Type
		public void userTyped(char key) {
			System.out.println("key");
		}
	   
		//Set Shape
		public void setShapesWorld(ShapesWorld theWorld) {
			this.theWorld = theWorld;	
			}
	   
 }
	   