package com.train.book.dao;

import java.sql.*;  
public class MySqlCon{  
	
	public static void main(String args[]){
		//to get the connection
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		String connString="jdbc:mysql://localhost:3306/service?useTimezone=true&serverTimezone=UTC";
	
		
		String conn2="jdbc:mysql://localhost:3306/service";
		String username="root";
		String password="password";
		Connection con=DriverManager.getConnection(  
				connString,username,password);  
		
		//here service is database name, root is user name and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from hero");  
		while(rs.next())  
		System.out.println("id  "+rs.getInt(1)+"  name:"+rs.getString(2));  
		con.close();  
		}catch(Exception e){ 
			System.out.println("Exception occurred "+e.getMessage());
			}  
		}  
	
	public Connection getConnection() throws SQLException {
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connString="jdbc:mysql://localhost:3306/service?useTimezone=true&serverTimezone=UTC";
			
			
			String conn2="jdbc:mysql://localhost:3306/service";
			String username="root";
			String password="password";
			 conn=DriverManager.getConnection(  
					connString,username,password); 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return conn;
	}
	
}  
