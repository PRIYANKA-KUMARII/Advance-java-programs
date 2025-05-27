package adv_java_comm.nit;
import java.sql.*;

public class Employee {
			String name;
		String id;
		int Salary;
		public static void addEmployee(String name, String id, int Salary) {
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
				PreparedStatement psmt= con.prepareStatement("insert into employee1 values(?,?,?)");
				psmt.setString(1, id);
				psmt.setString(2, name);
				psmt.setInt(3, Salary);
				int rowInserted= psmt.executeUpdate();
				if(rowInserted>0) {
					System.out.println("Record entered successfully");
				}
				else {
					System.out.println("Could not inserrt the record");
				}
			}
			catch(Exception e) {
				System.out.println(e.toString());	
				e.printStackTrace();
			}
		}
}