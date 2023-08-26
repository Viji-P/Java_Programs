package Crud_Operation;

import java.sql.*;
import java.util.Map;

public class UpdateDemo {
	public void updateRecord(Connection con,Map<String,Integer> up,Map<String,Integer> up2,Map<String,String> up3) throws Exception {
		
		Object Id =up.get("stu_id");
		
		Object Name =up3.get("stu_name");
		
		Object Age =up2.get("stu_age");
		
		String qurey ="update Students set stu_name=?,stu_age=? where stu_id=?";
		
		PreparedStatement ps=con.prepareStatement(qurey);
		ps.setString(1, (String) Name);
		ps.setInt(2, (int) Age);
		ps.setInt(3, (int) Id);
		ps.executeUpdate();
		System.out.println("Updated");
	}

}
