package main_package;

import java.util.Objects;

public class Book {
	
//	Default Value Of ID
	//private int  id=1;
	private String title, author;
	
	
	
	public Book() {
		
		
	}
	
	public Book(String title, String author) {
		
		this.title = title;
		this.author = author;
	}

//	public Book(int id,String title, String author) {
//		this.id = id;
//		this.title = title;
//		this.author = author;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
//	}
	
	@Override
	public String toString() {
		return "Book [Title:" + title + ", Author:" + author + "]";
	}
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if(!(o instanceof Book)) return false;
		Book book = (Book) o ;
		if(title!=null && book.getTitle()!=null && author!=null && book.getAuthor()!=null)
		{
			return Objects.equals(title.toLowerCase(), book.getTitle().toLowerCase()) && Objects.equals(author.toLowerCase(), book.getAuthor().toLowerCase());
		}else 
		{
			return false;
		}
				
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(title.toLowerCase(),author.toLowerCase());
	}
	
	
	
	

}
