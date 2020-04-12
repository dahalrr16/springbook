package com.train.book.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.book.dao.MySqlCon;
import com.train.book.model.Book;

@RestController
public class BookController {
	//this method just returns hello test 
@GetMapping ("/hello")
	public String hello() {
	
		String h="hello";
		System.out.println("Hello hello "+h);
		return h;
	}


//this is the method to return Book test (one list)
@GetMapping ("/get/book")
public Book getBook() {
Book book=new Book();
	book.setAuthor("DA");
	book.setId(1);
	book.setPrice(200);
	book.setTitle("Boink");
	System.out.println("Book "+book);
	return book;
}
//this is the method to return all booklist 
@GetMapping ("/get/bookList")
public List<Book> getBookList() {
	List<Book> bookList= new ArrayList<Book>(); 
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

@GetMapping ("/get/books")
public List<Book> getBookListFromDB() {
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

@PostMapping ("/add/book")
 public String addBook(@RequestBody Book book) {
	 	
	  
	MySqlCon mySqlCon=new MySqlCon();
	try {
		Connection conn=mySqlCon.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `book`(title, author, price) VALUE(?,?,?);");
		//pstmt.setInt(1, book.getId());
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setDouble(3, book.getPrice());
		pstmt.executeUpdate();
		
		return "added sccessfully";
	
		
		
		}catch(Exception e){ 
			System.out.println("Exception occurred "+e.getMessage());
			return "Book could not be added";
			}  
	
		// TODO Auto-generated catch block
}
	
	@PostMapping ("/delete/book")
	public String deleteBook(@RequestBody Book book) {
		
		MySqlCon mySqlCon=new MySqlCon();
		try {
			Connection conn=mySqlCon.getConnection();
			
			//execute sql query
		//	Statement stmt=conn.createStatement();
			
			String title=book.getTitle();
			
			String query1 = "delete from  book where title= ? And author=?";
		//	 String query = "delete from users where id = ?";
			System.out.println(query1);
			PreparedStatement pstmt=conn.prepareStatement(query1);
			pstmt.setString(1, title);
			pstmt.setString(2, book.getAuthor());
		pstmt.executeUpdate();
			return "deleted sccessfully";
		
			
			
			}catch(Exception e){ 
				System.out.println("Exception occurred "+e.getMessage());
				return "Book could not be deleted";
			}
	}
		
		
		@PostMapping ("/update/book")
		public String updateBook(@RequestBody Book book) {
			
			MySqlCon mySqlCon=new MySqlCon();
			try {
				Connection conn=mySqlCon.getConnection();
				
				//execute sql query
			//	Statement stmt=conn.createStatement();
				
				
				
				String query1 = "update book set price=? where title = ? and author = ?";
			//	 String query = "update from users where id = ?";
				System.out.println(query1);
				PreparedStatement pstmt=conn.prepareStatement(query1);
				pstmt.setDouble(1, book.getPrice());
				pstmt.setString(2, book.getTitle());
				pstmt.setString(3, book.getAuthor());
			pstmt.executeUpdate();
				return "updated sccessfully";
			
				
				
				}catch(Exception e){ 
					System.out.println("Exception occurred "+e.getMessage());
					return "Book could not be updated";
					}  
			
		
	}	
}

