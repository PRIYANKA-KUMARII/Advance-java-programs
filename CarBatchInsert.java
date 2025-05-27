package Car_model_adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarBatchInsert{
	public static void main(String [] args) {
		try {
			 Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","1234");
			 PreparedStatement ps= con.prepareStatement("Insert into Car_Info(carId, carModel, carRatePerDay,availabilityStatus)values(?,?,?,?)");
			 ps.setInt(1,  101);
			 ps.setString(2, "BMW");
			 ps.setDouble(3,  25.50);
			 ps.setString(4,"Available");
			 
			 ps.setInt(2,  102);
			 ps.setString(2,  "Honda");
			 ps.setDouble(3,  4.50);
			 ps.setString(4, "Available");
			 int[] rowInserted= ps.executeBatch();
			  
			  Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","1234");
			  PreparedStatement ps1= con.prepareStatement("Update Car_Info");
			 System.out.println("Record Successfully");
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		} 
		}
}
	