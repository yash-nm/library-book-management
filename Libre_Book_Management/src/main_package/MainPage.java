package main_package;

import java.util.Scanner;

public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("|===================================================|");
		System.out.println("\tWelcome to Yash's Libre Management System");
		System.out.println("|===================================================|");
		Scanner sc = new Scanner(System.in);
		Library lib = new Library();
		while(true)
		{
			System.out.println("|===================================================|");
			System.out.println(" \t1. Add Book \n \t2. Remove Book\n \t3. View All Books\n \t4. Issue Book \n \t5. All Issued Books \n \t6. Return Book \n \t7. Exit");
			System.out.println("|===================================================|");
			System.out.print("\nSelect one option(Press 'Enter' after input) : ");
			String option = sc.nextLine();
			String title;
			switch(option)
			{
				case "1":
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.print("\t|Enter Book Name:\t");
					title = sc.nextLine();
					System.out.print("\t|Enter Author Name:\t");
					String author = sc.nextLine();
					lib.addBook(title,author);
					break;
				case "2":
					System.out.println("Option 2 selcted");
					System.out.print("\tEnter Book Name: ");
					title = sc.nextLine();
					boolean bookremoved = lib.removeBook(title);
					if(bookremoved) System.out.println("The Book has been removed.");
					else System.out.println("The Book could not be removed, please try again...");
					break;
				case "3":
					lib.showallbooks();
					break;
				case "4":
					if(!lib.isBookAvailable())
					{
						System.out.println("\t|---------------------------------------------------------------------------------------------|");
						System.out.println("\t|Book not found. Cannot issue at this time.");
						System.out.println("\t|---------------------------------------------------------------------------------------------|");
						break;
					}
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.print("\t|Enter Borrower's Name:\t");
					String borrower = sc.nextLine();
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.println("\t|Select a book to be issued");
					lib.showallbooks();
					System.out.print("\t|Enter a Book Name: ");
					title = sc.nextLine();
					lib.addBorrower(borrower, title);
					break;
				case "5":
					lib.showallissuedbooks();
					break;
				case "6":
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.print("\t|Enter Borrower's Name:\t");
					borrower = sc.nextLine();
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.println("\t|Select a book to be returned.");
					lib.showallissuedbooks();
					System.out.print("\t|Enter a Book Name: ");
					title = sc.nextLine();
					lib.returnBook(borrower, title);
					break;	
				case "7":
					sc.close();
					System.out.println("System exiting...");
					System.exit(1);
					break;
				default:
					System.out.println("Please select one option by a single number");
					break;
			}
		}
	}
}
