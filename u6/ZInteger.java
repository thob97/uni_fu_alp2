package u6;

final public class ZInteger {
	public int p;
	public int n;
	
	public ZInteger( int n, int p ) {
		if (Math.abs(p) != p || Math.abs(n) !=n || p!=(int)p || n!=(int)n) {throw new IllegalArgumentException( "Falsche Eingabe" );}
		else 
		{
			this.n = n;
			this.p = p;
		}
   }
	
	public static ZInteger simplify(int a, int b) 
	{
		if (b>a) {return new ZInteger(0,b-a);}
		else {return new ZInteger(a-b,0);}
	}
	
	public static ZInteger add (ZInteger a, ZInteger b) 
	{
		
		return new ZInteger(a.n+b.n,a.p+b.p);
	}
	
	public static ZInteger sub (ZInteger a, ZInteger b) 
	{
		ZInteger c = new ZInteger(b.p,b.n);
		return add(a,c);
	}
	
	public static ZInteger mul (ZInteger a, ZInteger b) 
	{
		a = simplify(a.n,a.p);
		b = simplify(b.n,b.p);
		
		if (a.n==0) 
		{
			if(b.n==0) {return new ZInteger(0, a.p*b.p);}
			else {return new ZInteger(a.p*b.n, 0);}
		}
		if (a.p==0) 
		{
			if(b.n==0) {return new ZInteger(a.n*b.p,0);}
			else {return new ZInteger(0, a.n*b.n);}	
		}
		else {return new ZInteger(0,0);}
		
	}

	public static boolean gleichheit (ZInteger a, ZInteger b) 
	{
		if (a.p == b.p && a.n==b.n) {return true;}
		else {return false;}
	}
	
	public static boolean größer (ZInteger c, ZInteger d) 
	{
		ZInteger a = simplify(c.n,c.p);
		ZInteger b = simplify(d.n,d.p);
		if (a.p > b.p || a.n < b.n) {return true;}
		else {return false;}
	}
	
	public static boolean kleiner (ZInteger c, ZInteger d) 
	{
		ZInteger a = simplify(c.n,c.p);
		ZInteger b = simplify(d.n,d.p);
		if (a.p < b.p || a.n > b.n) {return true;}
		else {return false;}
	}
	
	public static boolean kleinergleich (ZInteger c, ZInteger d) 
	{
		if (kleiner(c,d) || gleichheit(c,d)) {return true;}
		else {return false;}
	}
	
	public static boolean größergleich (ZInteger c, ZInteger d) 
	{
		if (größer(c,d) || gleichheit(c,d)) {return true;}
		else {return false;}
	}
	
	public static String toString (ZInteger a)
	{
		String string = "(";
		string = string + Integer.toString(a.n) +",";
		string = string + Integer.toString(a.p) +")";
		return string;
	}
	
}
