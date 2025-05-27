package com.nit;
import java.sql.*;

public class Tester {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
				
					java.sql.Statement stmt = con.createStatement();
			ResultSet rs= stmt.executeQuery("select * from students");
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)
						   +"\t"+rs.getString(2)
						   +"\t"+rs.getString(3)
						   +"\t"+rs.getInt(4)
						   +"\t"+rs.getInt(5));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}
	}
}
