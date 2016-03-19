package enteryourmealsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class Ingredients {

	public String name;
	public Double quantity;
	public Double priceForThisQuantity;
	public static String fichier ="C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\ListOfIngredients.txt";
	
	public static void addIngredient(String name, Double quantity, Double priceForThisQuantity) throws IOException{
		FileWriter fw = new FileWriter (fichier, true);
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter fichierSortie = new PrintWriter (bw);
		try {
			fichierSortie.println (name + " " + quantity + " " + priceForThisQuantity); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		finally{
			fichierSortie.close();
		}
	}
}



