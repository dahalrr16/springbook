package com.train.book.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.book.dao.BookGiver;
import com.train.book.dao.MySqlCon;
import com.train.book.model.Book;
import com.train.book.service.BookPublisher;

@RestController
public class BookController {
	//I need a publisher just to confirm the name of publisher 
	@Autowired //whenever we create the spring bean, it will be wired/connected here 
	private BookPublisher publisher;
	
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
	System.out.println("publisher name and logo "+publisher.getLogo()+"  and name "+ publisher.getName());
BookGiver bookGiver=new BookGiver();
return bookGiver.getOneBook();

	
}

//this is the method to return all booklist 
@GetMapping ("/get/bookList")
public List<Book> getBookList() {
	BookGiver bookGiver = new BookGiver();

	return bookGiver.getBookList();

	
	
}

@GetMapping ("/get/books")
public List<Book> getBookListFromDB(){
	BookGiver bookGiver = new BookGiver();
	
	return bookGiver.getBookListFromDb();
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

