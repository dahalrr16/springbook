package com.train.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.train.book.model.Book;

public class BookGiver {
	
	public Book getOneBook() {
		Book book=new Book();
		book.setAuthor("DA");
		book.setId(1);
		book.setPrice(200);
		book.setTitle("Boink");
		System.out.println("Book "+book);
		return book;
	}

	
	public List<Book> getBookList(){
		List<Book> bookList = new ArrayList<Book>();
	
		   Book book1 = new Book();
			book1.setAuthor("Raj");
			book1.setId(2);
			book1.setPrice(100);
			book1.setTitle("Oink");
			System.out.println("BookList "+book1);
			
			
			Book book2 = new Book();
			book2.setAuthor("Pratham");
			book2.setId(3);
			book2.setPrice(150);
			book2.setTitle("Blink");
			System.out.println("BookList "+book2);
			
			
			Book book3 = new Book();
			book3.setAuthor("Sangita");
			book3.setId(4);
			book3.setPrice(50);
			book3.setTitle("Clink");
			System.out.println("BookList "+book3);
			
			
			bookList.add(book1);
			bookList.add(book2);
			bookList.add(book3);
			
			return bookList;	

	}
	
	
	public List<Book> getBookListFromDb() {
		List<Book> bookList= new ArrayList<Book>(); 	
		  
		MySqlCon mySqlCon=new MySqlCon();
		try {
			Connection conn=mySqlCon.getConnection();
			
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Book");  
			int count=0;
			while(rs.next()) { 
				count=count+1;
				System.out.println("count "+count);
			System.out.println("id  "+rs.getInt(1)+"  name:"+rs.getString(2));  
			int id=rs.getInt(1);
			String title=rs.getString(2);
			String  author=rs.getString(3);
			double price=rs.getDouble(4);
			Book b1=new Book();
			b1.setId(id);
			b1.setTitle(title);
			b1.setAuthor(author);
			b1.setPrice(price);
			
			bookList.add(b1);
		
			}
			
			}catch(Exception e){ 
				System.out.println("Exception occurred "+e.getMessage());
				}  
		
			// TODO Auto-generated catch block
		
			
			
			return bookList;
	}
	
	public Set<Book> getSetOfBook(){
		Set<Book> bookSet = new HashSet<Book>();
		
		return bookSet;
		

	}
	
	public Map<String,Book> getMapping(){
		Map<String,Book> bookMap = new HashMap<String, Book>();
		
		Book book1 = new Book();
		bookMap.put("myFirstBook", book1);
		
		Book book2 = new Book();
		bookMap.put("mySecondBook", book2);
		
		
		
		return bookMap;
		
	}

	
	public List<Book> getListOfBookByAuthor(String author1, String author2){
		
		List<Book> bookListByAuthor = new ArrayList<Book>(); // this is the first step to define bookbucket<list>
		
		Book bookAuthor1= new Book();
		bookAuthor1.setAuthor(author1);
		
		Book bookAuthor2 = new Book();
	    bookAuthor2.setAuthor(author2);
	    
	    bookListByAuthor.add(bookAuthor1);// now, second step to add first book on that bucket
	    bookListByAuthor.add(bookAuthor2); // now, second step to add second book on that bucket
	    
	    return bookListByAuthor;//return the bucket which has two books.
	    
	
	
	}
	
	
		
	
}//class closer

