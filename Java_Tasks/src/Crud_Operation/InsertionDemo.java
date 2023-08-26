package Crud_Operation;

import java.sql.*;
import java.util.Map;

public class InsertionDemo {
	public void insertRecord(Connection con, Map<String, Integer> dm,Map<String, Integer> dm2,Map<String, String> dm3) throws Exception{
		
		
		Object Id =dm.get("stu_id");
		
		Object Name =dm3.get("stu_name");
		
		Object Age =dm2.get("stu_age");
  	    
		String query="insert into Students(stu_id,stu_name,stu_age) values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,(int) Id);
		ps.setString(2,(String) Name);
		ps.setInt(3,(int) Age);
		ps.execute();
		System.out.println("Inserted");
		ps.close();
	}
	

}
