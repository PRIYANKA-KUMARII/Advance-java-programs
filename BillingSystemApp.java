package customer_adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class BillingSystemApp{
	public static void main(String [] args) {
		Customer pri= new Customer();
		Customer priya= new Customer();
		Customer pihu= new Customer();
		
		pri.insertCustomer("101", "Priya","p@gmail", "9279493023","Ammerpet", "Hyderabad",500016);
		priya.insertCustomer("102", "Priya","p@gmail", "9279493023","Ammerpet", "Hyderabad",500016);
		pihu.insertCustomer("103", "Priya","p@gmail", "9279493023","Ammerpet", "Hyderabad",500016);
	}
}

 class Customer{
	String  id;
	String name;
	String email;
	String phoneNumber;
	String address;
	String city;
	int pincode;
	public void  insertCustomer(String id, String name, String email, String phoneNumber, String address, String city, int pincode) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
	    	PreparedStatement psmt= con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");	
	    	psmt.setString(1, id);
	    	psmt.setString(2, name );
	    	psmt.setString(3, email);
	    	psmt.setString(4, phoneNumber);
	    	psmt.setString(5,  address);
	    	psmt.setString(6,city);
	    	psmt.setInt(7,  pincode);
	    	int rowInserted= psmt.executeUpdate();
	    	if(rowInserted>0) {
	    		System.out.println("Record entered successfully.");
	    	}
	    	else
	    	{
	    		System.out.println("Record not inserted.");
	    	
	    	}
		}
	    	catch(Exception e) {
	    		System.out.println(e.toString());

	    	}

	    	
	}
}
