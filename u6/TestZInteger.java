package u6;
import java.util.Scanner;



public class TestZInteger {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("Bitte geben sie zwei Natürlichezahlen ein");
		int a1 = scan.nextInt();
		int a2 = scan.nextInt();
		System.out.println("Bitte geben sie zwei Natürlichezahlen ein");
		int b1 = scan.nextInt();
		int b2 = scan.nextInt();
		
		ZInteger a = new ZInteger(a1,a2); 
		ZInteger b = new ZInteger(b1,b2); 
		System.out.println(Integer.toString(a1)+" "+Integer.toString(a2)+" als ZInteger = " + ZInteger.toString(a));
		System.out.println(Integer.toString(b1)+" "+Integer.toString(b2)+" als ZInteger = " + ZInteger.toString(b));
		System.out.println("simplify von " + ZInteger.toString(a) +" = " + ZInteger.toString(ZInteger.simplify(a.n, a.p)) );
		System.out.println("simplify von " + ZInteger.toString(b) +" = " + ZInteger.toString(ZInteger.simplify(b.n, b.p)) );
		System.out.println("add "+ ZInteger.toString(a)+" "+ZInteger.toString(b) + " = " + ZInteger.toString( ZInteger.add(a,b) ) );
		System.out.println("sub "+ ZInteger.toString(a)+" "+ZInteger.toString(b) + " = " + ZInteger.toString( ZInteger.sub(a,b) ) );
		System.out.println("mul "+ ZInteger.toString(a)+" "+ZInteger.toString(b) + " = " + ZInteger.toString( ZInteger.mul(a,b) ) );
		System.out.println("gleichheit "+ ZInteger.toString(a)+" == "+ZInteger.toString(b) + " = " + ( ZInteger.gleichheit(a,b) ) );
		System.out.println("größer "+ ZInteger.toString(a)+" > "+ZInteger.toString(b) + " = " + ( ZInteger.größer(a,b) ) );
		System.out.println("kleiner "+ ZInteger.toString(a)+" < "+ZInteger.toString(b) + " = " + ( ZInteger.kleiner(a,b) ) );
		System.out.println("größergleich "+ ZInteger.toString(a)+" >= "+ZInteger.toString(b) + " = " + ( ZInteger.größergleich(a,b) ) );
		System.out.println("kleinergleich "+ ZInteger.toString(a)+" <= "+ZInteger.toString(b) + " = " + ( ZInteger.kleinergleich(a,b) ) );
	}


}
