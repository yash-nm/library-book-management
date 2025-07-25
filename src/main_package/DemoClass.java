package main_package;

import java.util.Scanner;

public class DemoClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int [] a = {23,34,45,76,98};
		 * 
		 * for(int i=0; i<a.length;i++) { if(a[i]%10==8) { System.out.println(a[i]
		 * +" ends with 8"); } }
		 */
		
		// Assignment 
		System.out.print("Enter a number:");
		Scanner sc= new Scanner(System.in);
		
		int num = sc.nextInt();
		try
		{
			if(num>=0)
			{
				System.out.println("Number is positive.");
				sc.close();
			}
			else {
				throw new NegativeNumberException();
			}
			sc.close();
		}
		catch(NegativeNumberException e)
		{
			e.printStackTrace();
			sc.close();
		}
		
	}

}
