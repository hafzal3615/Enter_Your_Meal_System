package Exceptions;

public class AlreadyExistingIngredientException extends Exception{
	@Override
	public void printStackTrace(){
		System.out.println("The ingredient already exists in the library. Please use remove method or modify method");
	}
}
