package tests;

import java.io.IOException;

import enteryourmealsystem.Ingredients;

public class TestIngredients {
	public static void main(String[] args) throws IOException {
		Ingredients ingr�dient = new Ingredients();
		ingr�dient.name =  "pomme";
		
		Ingredients.addIngredient(ingr�dient.name, 1.0, 0.5);
	}
}
