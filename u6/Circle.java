package u6;

public class Circle {
	public double x;
	public double y;
	public double radius;
	
	public Circle( double x, double y, double radius) 
	{ 
		this.x=x;
		this.y=y;
		this.radius=radius;
	} 
	
	public  Circle() 
	{ 
		this ( 0, 0, 10);
	} 
	
	public Circle clone() 
	{
		return new Circle(this.x,this.y,this.radius);
	}
	
	//Hilfsfunktion
	public double distance (Circle c)
	{
		return (Math.pow((this.x - c.x),2.0) + Math.pow((this.y - c.y),2.0));
	}
	
	public int compareTo( Circle c ) 
	{
		if (this.x > c.x) {return 1;}
		if (this.x < c.x) {return -1;}
		else {return 0;}
	}
	
	public boolean contains( Circle c) 
	{
		double distance = distance(c);
		if ( this.radius > c.radius + Math.sqrt(distance) ) {return true;}
		else {return false;}
	}
	
	public boolean overlaps( Circle c )  
	{
		double distance = distance(c);
		if (Math.pow(this.radius - c.radius,2) <= distance && distance<= Math.pow(this.radius + c.radius,2)) {return true;}
		else {return false;}
	}
	
	
	public static Rectangle smallestBoundingRectangle ( Circle[] circles ) 
	{
		double maxX = -100000000000000.0; //Sehr kleine Zahl
		double minX = 100000000000000.0; //Sehr große Zahl
		double minY = 100000000000000.0;
		double maxY = -100000000000000.0;
		for (int i=0; i<circles.length;i++)
		{
			Circle c = circles[i];
			if (c.x+c.radius>maxX) {maxX=c.x+c.radius;}
			if (c.x-c.radius<minX) {minX=c.x-c.radius;}
			if (c.y+c.radius>maxY) {maxY=c.y+c.radius;}
			if (c.y-c.radius<minY) {minY=c.y-c.radius;}
		}
		return new Rectangle(minX,minY,maxX+ Math.abs(minX),Math.abs(Math.abs(minY)+maxY));
	}
	
}
