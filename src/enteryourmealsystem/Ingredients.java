package enteryourmealsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Exceptions.AlreadyExistingIngredientException;

public class Ingredients {

	public String name;
	public Double quantity;
	public Double priceForThisQuantity;
	public static String fichier ="C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\ListOfIngredients.txt";
	
	/**
	 * @param name
	 * @param quantity
	 * @param priceForThisQuantity
	 * @throws IOException
	 * 
	 * @returns It adds the given ingredient, the given quantity with the given price for such a quantity (so that we just have to multiply)
	 * to a textfile that references all the ingredients used by a restaurant.
	 * 
	 * We also need to check if the ingredient already exists in our list : we can't have twice the same ingredient with different infos.
	 */
	public static void addIngredient(String name, Double quantity, Double priceForThisQuantity) throws IOException, AlreadyExistingIngredientException{
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		FileWriter fw = new FileWriter(fichier, true);
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter fichierSortie = new PrintWriter (bw);
		try {
			boolean contient = false;
			String line = "";

			while ((line=br.readLine())!=null){
				if (line.contains(name.toLowerCase())){
					contient = true;
				}
			}
			if (contient ==true){
				throw new AlreadyExistingIngredientException();
			}
			
			fichierSortie.println (name + " " + quantity + " " + priceForThisQuantity);
			
		}
		catch (Exception e){
			e.printStackTrace();;
		}
		finally{
			fichierSortie.close();
			br.close();
		}
	}
	public static void removeIngredient(String name) throws IOException {
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		FileWriter fw = new FileWriter (fichier);
		BufferedWriter bw = new BufferedWriter (fw);
		try {
			String line;
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null){
				if (!(line.contains(name.toLowerCase()))){
					sb.append(line + "\n");
				}
			}
			bw.write(sb.toString());
		}
		catch (Exception e){
			e.printStackTrace();;
		}
		finally{
			br.close();
			bw.close();
		}
	}
	
	public static void modifyIngredient(String name, Double quantity, Double price) throws IOException{
		removeIngredient(name);
	}
	
}





	