package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import enteryourmealsystem.Ingredient;
import enteryourmealsystem.ListIngredients;

public class ListIngredientsTest {

	@Test
	public void testAddAnElement() throws IOException {

		Ingredient ing = new Ingredient();

		int countbefore = ListIngredients.Ingredients.size();
		String IngName = "Pomme";
		Double IngPrice = 0.5;
		
		// Test Ajout d'un élément dans la liste
		ing = ListIngredients.add(IngName, IngPrice);
		int countafter = ListIngredients.Ingredients.size();
		
		assertFalse(!(countbefore +1 == countafter));
		// Vérification des valeurs insérées dans le nouvel élément
		assertFalse(!(IngName == ing.name));
		assertFalse(!(IngPrice == ing.price));
		
		
	}
	
	@Test
	public void testRemoveAnIngredient() throws IOException{
		Ingredient ing = new Ingredient();
		String IngName = "Pomme";
		Double IngPrice = 0.5;
		ing = ListIngredients.add(IngName, IngPrice);
		ListIngredients.remove(IngName);
		assertFalse(ListIngredients.Ingredients.contains(ing));
	}
	
	

}
