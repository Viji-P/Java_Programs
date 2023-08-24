package Java_Programs;

import java.sql.*;
import java.util.Scanner;

public class Crud_Operatios {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection con;
		String url="jdbc:mysql://localhost:3306/First_DB";
		String uname="root";
		String pwd="root";
		String query="";
		con=DriverManager.getConnection(url,uname,pwd);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Successfully Connected");
		Statement st=con.createStatement();
		PreparedStatement ps;
		ResultSet rs;
		System.out.println(); 
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		int stu_id;
		String stu_name;
		int stu_age,ch;
		
		
		while(true) {
			System.out.println("CRUD Operations");
			System.out.println("1.Create Record");
			System.out.println("2.Read Record");
			System.out.println("3.Update Record");
			System.out.println("4.Delete Record");
			System.out.println("5.Exit");
			System.out.println("Enter the Choice:");
			ch=in.nextInt();
			System.out.println("---------------------------------------");

			switch(ch) {
			case 1:
				System.out.println("Create Record");
				System.out.println("Enter the Id:");
				stu_id=in.nextInt();
				System.out.println("Enter the Name:");
				stu_name=str.nextLine();
				System.out.println("Enter the age:");
				stu_age=in.nextInt();
				query="insert into Students(stu_id,stu_name,stu_age) values(?,?,?)";
				ps=con.prepareStatement(query);
				ps.setInt(1, stu_id);
				ps.setString(2, stu_name);
				ps.setInt(3, stu_age);
				ps.executeUpdate();
				System.out.println("Inserted");
				break;
			case 2:
				System.out.println("Print all Record");
				query="select*from Students";
				rs=st.executeQuery(query);

				while(rs.next()) {
					stu_id=rs.getInt("stu_id");
					stu_name=rs.getString("stu_name");
					stu_age=rs.getInt("stu_age");
					System.out.println( stu_id+ "  "+  stu_name + "  "+  stu_age);
					
					
					
				}
				
				break;
			case 3:
				System.out.println("update Record");
				System.out.println("Enter the Id:");
				stu_id=in.nextInt();
				System.out.println("Enter the Name:");
				stu_name=str.nextLine();
				System.out.println("Enter the age:");
				stu_age=in.nextInt();
				query="update Students set stu_name=?,stu_age=? where stu_id=?";
				ps=con.prepareStatement(query);
				
				ps.setString(1, stu_name);
				ps.setInt(2, stu_age);
				ps.setInt(3, stu_id);
				ps.executeUpdate();
				System.out.println("Updated");
				
				break;
			case 4:
				System.out.println("Delete Record");
				System.out.println("Enter the Id:");
				stu_id=in.nextInt();
				query="delete from Students where stu_id=?";
				ps=con.prepareStatement(query);
				ps.setInt(1, stu_id);
				ps.executeUpdate();
				System.out.println("Deleted");

				break;
			case 5:
				System.out.println("Exit");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("---------------------------------------");
			
		}
		
		
	}

}
