package u6;
public class Aufgabe1 
{
	public static void main(String[] args) 
	{
		//Test-Funktionen
		System.out.println(" bauermul 3*9 = " + bauermul(3,9));
		System.out.println(" bauermul 20*10 = " + bauermul(20,10));
	
	}
	//Aufgabe 1
	public static int bauermul(int a, int b) //T(n) = 3c + 2log n => O(log n)
	{
		if(a==1 || a==0) {return b;}					//c
		if ( (a&1) ==0) {return bauermul(a>>1,b<<1);}	//c + log n		
		else {return bauermul(a>>1,b<<1) + (b);}		//log n + c
	}
	
}
	