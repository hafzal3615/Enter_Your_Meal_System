package tests;

import java.io.IOException;

import enteryourmealsystem.Ingredients;

public class TestIngredients {
	public static void main(String[] args) throws IOException {
		Ingredients ingrédient = new Ingredients();
		ingrédient.name =  "pomme";
		
		Ingredients.addIngredient(ingrédient.name, 1.0, 0.5);
	}
}
