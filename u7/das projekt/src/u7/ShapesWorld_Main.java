package u7;

/**
 * @author M. Esponda
 * @version 1.01
 */

public class ShapesWorld_Main {
	/**
	 * @param args 
	 * has the name of the shape classes, we want to use in the ShapesWorld-object.
	 */
	public static void main(String[] args) 
	{
		String[] a = {"GoAndBack","Capative","stein","Scared","roboter","Feuerwerk"};
		
		if (args.length==0) {
			System.err.println("Bitte Shape-Klassennamen als Argumente eingeben");
		}
		new ShapeFrame(a);
	}
} // end of class ShapesWorld_Main
