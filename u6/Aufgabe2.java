package u6;
import java.util.Random;

public class Aufgabe2 
{
	public static void main(String[] args) 
	{
		//Test-Funktionen
		Random rand = new Random();
		int auto = rand.nextInt(4);
		int wahl = rand.nextInt(4);
		System.out.println(" dreiTürenSpiel (random) 100 wiederholungen = " + repeatSpiel(100,0,auto,wahl)+"%");
		System.out.println(" dreiTürenSpiel (immer) 100 wiederholungen = " + repeatSpiel(100,2,auto,wahl)+"%");
		System.out.println(" dreiTürenSpiel (nie) 100 wiederholungen = " + repeatSpiel(100,1,auto,wahl)+"%");	
	}
		
	//Aufgabe 1
	public static int dreiTürenSpiel (int p, int wahl, int auto)
	{
		//Wenn er seine Entscheidung nie ändert
		if (p==1) 
		{
			if(wahl==auto) {return 1;}
			else {return 0;}
		}
		
		//Wenn er seine Entscheidung immer ändert. 
		if (p==2) 
		{
			if(wahl!=auto) {return 1;}
			else {return 0;}
		}
		
		//Wenn er jedes Mal zufällig seine Entscheidung ändert.
		else //(p==0)
		{
			Random rand = new Random();
			int n = rand.nextInt(3);
			if(n==1) {return dreiTürenSpiel (1, wahl, auto);}
			else /*(n==2)*/ {return dreiTürenSpiel (2, wahl, auto);}
		}
		
		
	}
	
	public static double repeatSpiel (int n,int p, int wahl, int auto)
	{
		double sum=0.0;
		for(int i=0; i<n; i++)
		{
			Random rand = new Random();
			int auto2 = rand.nextInt(4);
			int wahl2 = rand.nextInt(4);
			sum += dreiTürenSpiel (p, wahl2, auto2);
		}
		return (sum / n)*100 ;
	}
	
	
}
