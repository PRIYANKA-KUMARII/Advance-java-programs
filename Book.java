import java.sql.*;

public class Book {
	public static void main(String[]args) {
		System.out.println("Execution start from main method");
		try {
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
			if(con!=null) {
				System.out.println("Connection found");
				
			}
		
			Statement stmt=con.createStatement();
			ResultSet rSet= stmt.executeQuery("Select * from Book");
			System.out.println("Books Details:");
			while(rSet.next()) {
			System.out.println("ISBN: "+rSet.getInt(1)
			+"\"TITLT:   "+rSet.getString(2)
			+"\"AUTHOR:   "+rSet.getString(3)+  "\"PRICE:   "+rSet.getInt(4)
			+"\"PUBLICATIONYEAR:  "+rSet.getInt(5));
			}

		rSet.close();
		stmt.close();
		con.close();
		
		
		
		
		}
	catch(

	Exception e)
	{
		e.printStackTrace();
	}
}}
