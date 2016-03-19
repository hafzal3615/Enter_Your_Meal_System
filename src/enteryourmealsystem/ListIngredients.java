package enteryourmealsystem;

import java.io.IOException;
import java.util.ArrayList;

public class ListIngredients {
	public static ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();
	private static String filename = "C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\ListOfIngredients.txt";
	
	
	public static Ingredient add(String name, Double price) throws IOException{
		Ingredient ing = new Ingredient();
		ing.name = name;
		ing.price = price;
		Ingredients.add(ing);
		save();
		return (ing);
		
	}
	
	public static void remove(String keyname) throws IOException{
		for (int i = 0; i < ListIngredients.Ingredients.size(); i++){
			if (ListIngredients.Ingredients.get(i).name.toLowerCase() == keyname.toLowerCase()){
				ListIngredients.Ingredients.remove(i);
				save(); // save is here so that is nothing is removed, we don't rewrite the file
			}
		}
			
	}
	
	public static void modify(String keyname, String newname, Double newprice) throws IOException{
		for (int i = 0; i < ListIngredients.Ingredients.size(); i++){
			if (ListIngredients.Ingredients.get(i).name.toLowerCase() == keyname.toLowerCase()){
				ListIngredients.Ingredients.remove(i);
			}
		}
		add(newname, newprice);
	}
	
	private static void save() throws IOException{
		String sOutput ="";
		ArrayList<String> aOutput = new ArrayList<String>();
		for (int i = 0; i < Ingredients.size(); i++){
			sOutput = "";
			sOutput = sOutput + Ingredients.get(i).name + ";";
			sOutput = sOutput + Ingredients.get(i).price.toString();
			aOutput.add(sOutput);
		}
	
		DataManagement.writeFile(filename, aOutput);
	}
}