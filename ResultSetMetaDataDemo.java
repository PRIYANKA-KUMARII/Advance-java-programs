package adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataDemo {
public static void main(String [] args) {
	try {
		Connection con = DriverManager.getConnection 
				("jdbc:oracle:thin:@localhost:1521:ORCL","system","1234");
		PreparedStatement psmt= con.prepareStatement("select * from Laptop");
		ResultSet  rs= psmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
}
