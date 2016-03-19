package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.AlreadyExistingIngredientException;
import Exceptions.WritingInFileErrorException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import enteryourmealsystem.Ingredients;

/**
 * @author Pierre
 *
 */
public class IngredientsTest{
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws AlreadyExistingIngredientException
	 * 
	 * This test was first made to see if adding and then removing an ingredient works
	 * @throws WritingInFileErrorException 
	 * 
	 */
	public static void main(String[] args) throws IOException, AlreadyExistingIngredientException, WritingInFileErrorException {
		IngredientsTest IT = new IngredientsTest();
		IT.testAddIngredient();
	}
	
	
	/**
	 * @throws WritingInFileErrorException
	 * @throws IOException
	 * @throws AlreadyExistingIngredientException
	 * 
	 * This test expects "pomme 1.0 0.5" in the textfile and checks if that's what is happening
	 * 
	 */
	@Test
	public void testAddIngredient() throws WritingInFileErrorException, IOException, AlreadyExistingIngredientException {
		Ingredients ingrédient = new Ingredients();
		ingrédient.name =  "pomme";
		ingrédient.quantity = 1.0;
		ingrédient.priceForThisQuantity = 0.5;
		ingrédient.removeIngredient("pomme"); //pour enlever les occurences précédentes
		Ingredients.addIngredient(ingrédient.name, ingrédient.quantity, ingrédient.priceForThisQuantity);
		
		String expected = "pomme 1.0 0.5";
		String fichier =ingrédient.fichier;
			
			//lecture du fichier texte	
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		try{
			String ligne;
			ligne=br.readLine();
			assertEquals(expected, ligne);
			}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			br.close(); 
		}

	}
	@Test
	public void testRemoveIngredient() throws IOException, AlreadyExistingIngredientException{
		Ingredients ingrédient = new Ingredients();
		ingrédient.name =  "pomme";
		ingrédient.quantity = 1.0;
		ingrédient.priceForThisQuantity = 0.5;
		ingrédient.removeIngredient("pomme"); //pour enlever les occurences précédentes
		Ingredients.addIngredient(ingrédient.name, ingrédient.quantity, ingrédient.priceForThisQuantity);
		Ingredients.removeIngredient(ingrédient.name);
		
		String fichier =ingrédient.fichier;
		
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		try{
			String ligne;
			ligne=br.readLine();
			assertNull(ligne);
			}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			br.close(); 
		}
		
	}
	
	@Test(expected = AlreadyExistingIngredientException.class)
	public void testTwiceSameIngredient() throws IOException, AlreadyExistingIngredientException {
		Ingredients ingrédient = new Ingredients();
		ingrédient.name =  "pomme";
		ingrédient.quantity = 1.0;
		ingrédient.priceForThisQuantity = 0.5;
		ingrédient.removeIngredient("pomme"); //pour enlever les occurences précédentes
		Ingredients.addIngredient(ingrédient.name, ingrédient.quantity, ingrédient.priceForThisQuantity);
		Ingredients.addIngredient(ingrédient.name, ingrédient.quantity, ingrédient.priceForThisQuantity);
		
	}
}
