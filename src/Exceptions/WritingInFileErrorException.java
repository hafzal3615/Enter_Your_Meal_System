package Exceptions;

public class WritingInFileErrorException extends Exception{
	@Override
	public void printStackTrace(){
		System.out.println("An error occurred in  the writing into file process");
	}
}
