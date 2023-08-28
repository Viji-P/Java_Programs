package Crud_Operation;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

	public class CrudOperations {
	    

	    public static void main(String[] args) throws Exception {
	    	
	    	DatabaseConnection.getConnection();
	    	 
	            
	         // Create
	            
	            
	            Map<String, Integer> dm = new HashMap<>();
	            	
	            	dm.put("stu_id", 6);
	            	
	            Map<String, Integer> dm2 = new HashMap<>();
	            	
	            	dm2.put("stu_age", 19);
	            	
	            Map<String, String> dm3 = new HashMap<>();
		            
		            dm3.put("stu_name","Pavi");
		            
	            InsertionDemo id=new InsertionDemo();
	            

	           
	            // Update
	            
	            
	            Map<String, Integer> up = new HashMap<>();
	            
	            	up.put("stu_id", 6);
	            	
	            Map<String, Integer> up2 = new HashMap<>();
	            	
	            	up2.put("stu_age", 18);
	            	
	            Map<String, String> up3 = new HashMap<>();
		           
		            up3.put("stu_name","Shalini");
		            
		        UpdateDemo ud=new UpdateDemo();
		        
		        
		        //Delete
		        
		        
		        Map<String, Integer> rm = new HashMap<>();
		        
		        rm.put("stu_id", 4);
		        DeleteDemo dd=new DeleteDemo();
		        

	            // Read 
		        
		        
		        List<Map<String,Object>> re =new ArrayList<>();
	            ReadDemo rd2=new ReadDemo();
	            
	            //Method Calling
	            
	            
	            
	            //id.insertRecord(dm,dm2,dm3);
	            //rd2.readRecords(re);
	            //ud.updateRecord(up,up2,up3);
	            dd.deleteRecord(rm);

	            
	    }
	}

	 


