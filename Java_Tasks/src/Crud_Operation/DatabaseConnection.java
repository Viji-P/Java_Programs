package Crud_Operation;

import java.sql.*;

class DatabaseConnection {
	static Connection con;
	public static Connection getConnection() throws Exception{
		 String url = "jdbc:mysql://localhost:3306/First_DB";
	     String uname = "root";
	     String pwd = "root";
	     
   	 
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection(url, uname, pwd);
          Statement st=con.createStatement();
           
           
		
		
		return con;
		
		
	}
	
	
	

}
