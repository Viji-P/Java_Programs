package Crud_Operation;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDemo {
	public List<Map<String, Object>> readRecords(List<Map<String,Object>> re) throws Exception{
       
		Connection con=DatabaseConnection.getConnection();
		String query="select*from Students";
		
		Statement st=con.createStatement();
		ResultSet rs =st.executeQuery(query);
		while(rs.next()) {
			Map<String,Object> re1=new HashMap<>();
			
			re1.put("stu_id",rs.getInt("stu_id"));
			re1.put("stu_name", rs.getString("stu_name"));
			re1.put("stu_age", rs.getInt("stu_age"));
		
		re.add(re1);
		
		}
			System.out.println(re);
			
			rs.close();
			st.close();
			return re;
	      
	}
	
	
}
