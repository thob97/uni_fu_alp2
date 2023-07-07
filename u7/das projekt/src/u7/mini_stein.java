package u7;

import java.util.Random;

public class mini_stein extends stein {

	int i = 30;
	
	public mini_stein () {
		super();
		this.radius = 15;
		this.center = new Point(x,y);		
	}
	
	// Random
	Random zahl = new Random();
	int leftRight = zahl.nextInt(6)-3;
	int up = zahl.nextInt(3)+1;
	int x = zahl.nextInt(481)-240;
	int y = zahl.nextInt(381)-190;
	
	public void play() {

		if (i !=0) {
			i--;
			center.y -=up;
			center.x +=leftRight;
		}
		
		else if (center.y + this.radius >= theWorld.getMax_Y()) {theWorld.removeShape(this);}
		else {center.y +=2;}
		
	}
}