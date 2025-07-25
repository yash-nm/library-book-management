package main_package;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
///import java.util.Scanner;
import java.util.Set;

public class Library extends HashSet<Book>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Book> books;
	private Map<String , Book> borrowerslist ;
	//private int nextid;
	
	
	public Library() {
		books = new HashSet<Book>();
		borrowerslist = new HashMap<String , Book>();
		//nextid = 1;
	}


	public void addBook(String title, String author) 
	{
//		Book book = new Book(nextid, title, author);
//		nextid++;
		Book book = new Book(title, author);
		books.add(book);
		System.out.println("\t|---------------------------------------------------------------------------------------------|");
		System.out.println("\t|The Book has been added: "+ book);
		System.out.println("\t|---------------------------------------------------------------------------------------------|");
	}
	
	public boolean removeBook(String bkname)
	{
		for(Book book:books)
		{
			if(book.getTitle().toLowerCase().equals(bkname.toLowerCase()))
			{
				books.remove(book);
				return true;
			}
		}
		return false;
	}
	
	public void showallbooks()
	{
		if(books.isEmpty())
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t| No Books are available yet! Please try after adding books...");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
		}
		else 
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t|    Available Books");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			for(Book book:books)
			{
				System.out.println("\t|"+book);	
			}
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
		}	
	}
	
	public boolean isBookAvailable() {
		
		if(!books.isEmpty())
		{
			return true;
		}
		
		return false;
	}
	
	public void  addBorrower(String brwname, String bookname)
	{
		if(books.isEmpty())
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t|Book not found. Cannot issue at this time.");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			return;
		}
		for(Book b: books)
		{
				if(b.getTitle().toLowerCase().equals(bookname.toLowerCase()))
				{
					borrowerslist.put(brwname, b);
					bookname = b.getTitle();
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.println("\t|The Book '"+ bookname + "' has been issued to "+brwname);
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					break;
				}
				else
				{
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
					System.out.println("\t|Book not found. Cannot issue at this time.");
					System.out.println("\t|---------------------------------------------------------------------------------------------|");
				}
		}
	}
	
	public void showallissuedbooks()
	{
		
		if(borrowerslist.isEmpty())
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t| No Books are issued yet! ");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
		}
		else 
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t|    Issued Books");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			for(Map.Entry<String, Book> borrower :  borrowerslist.entrySet())
			{
				String borrowername = borrower.getKey();
				Book bookname = borrower.getValue();
				System.out.println("\t| "+bookname+"\t\tIssued to: ["+borrowername+"]");
			}
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
		}	
	}


	public void returnBook(String brw, String title) {
		
		if(!borrowerslist.containsKey(brw))
		{
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			System.out.println("\t|No Book is issued on this name.");
			System.out.println("\t|Please try again...");
			System.out.println("\t|---------------------------------------------------------------------------------------------|");
			return;
		}
		else
		{
			Book book = null;
			boolean bookfound = false;
			for(Map.Entry<String, Book> borrower: borrowerslist.entrySet())
			{
				book = borrower.getValue();
				if(book.getTitle().toLowerCase().equals(title.toLowerCase()))
				{
					if(borrower.getKey().equals(brw))
					{
						borrowerslist.remove(brw, book);
						bookfound = true;
						break;
					}
				}
			}
			if(bookfound)
			{
				
				System.out.println("\t|---------------------------------------------------------------------------------------------|");
				System.out.println("\t|The Book named as "+book.getTitle()+" has been returned by "+brw);
				System.out.println("\t|Thank you "+brw+"!");
				System.out.println("\t|---------------------------------------------------------------------------------------------|");
			}
			else 
			{
				System.out.println("\t|---------------------------------------------------------------------------------------------|");
				System.out.println("\t|Icorrect Book Title");
				System.out.println("\t|Please try again...");
				System.out.println("\t|---------------------------------------------------------------------------------------------|");
			}
		}
	}
	
	
	
	

}
