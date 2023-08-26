package Crud_Operation;
import java.sql.*;
import java.util.Map;

public class DeleteDemo {
	public void deleteRecord(Connection con,Map<String, Integer> rm ) throws Exception{
		
		Object stu_id=rm.get("stu_id");
		
		String query="delete from Students where stu_id=?";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setObject(1, stu_id);
		ps.executeUpdate();
		
		
		System.out.println("Deleted");
		
	}
}
