package u6;

public class Aufgabe7 {

	public static void main(String[] args) 
	{
		//Test-Funktionen
		System.out.println(" mersenne 8 = " + mersenne(8));
	
	}
	
	
	public static int mersenne(int k) 
	{
		int base = 2;
		int i = 1;
		int mersenne = 0;
		while (k!=i)
		{
			i++;
			mersenne = base;
			base <<= 1;
		}
		return mersenne;
	}

	
}
