package u7;

import java.awt.Color;
import java.util.Random;


public class MiniFeuerwerk extends Feuerwerk{
	
	   public MiniFeuerwerk() {
		   this.radius = 10;
		   this.color = x;
	   }
	   
	// Random
			Random zahl = new Random();
			int upDown = zahl.nextInt(3)-1;
			int leftRight = zahl.nextInt(3)-1;
			int ran = zahl.nextInt(20)+1;
			int ran2 = zahl.nextInt(20)+1;
			
			Color x = new Color((int)(Math.random() * 0x1000000));
	   
	  int n1 = 0; 
	 //Animation-Interface
	   public void play (){	
		   if (upDown == 0 && leftRight == 0) {
				  leftRight = zahl.nextInt(3)-1;
			  	  upDown = zahl.nextInt(3)-1;
		   }
		   else if (n1<5) { //Bubble  in Richtung
			center.x = center.x + leftRight*ran;
			center.y = center.y + upDown*ran2;
			n1 = n1+1;
			 }
		   else 
			   if ( this.radius> 0 ) {
			    	this.radius = this.radius -0.5;
			    	center.y=center.y+3;}
			    else if (radius <= 0) {
			    	this.theWorld.removeShape(this);
			    }
	   }
	   }