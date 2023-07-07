package u6;

public class Rectangle {
    public double x;
    public double y;
    public double width;
    public double height;
	
	public Rectangle( double x, double y, double width, double height ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
   }

    public Rectangle() {
       this( 0, 0, 10, 10 );
    }

    public double perimeter() {
         return 2*(width + height);
    }

    public double area() {
         return (width * height);
    }

} // End of class Rectangle
