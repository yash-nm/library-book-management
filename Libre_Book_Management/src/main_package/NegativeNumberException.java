package main_package;

@SuppressWarnings("serial")
public class NegativeNumberException extends Exception {

	NegativeNumberException()
	{
		super();
		System.out.println("Number is Negative");
	}
	
}
