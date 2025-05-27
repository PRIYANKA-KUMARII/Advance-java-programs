package adv_java_priyanka;

import java.sql.*;

public class StuData {
public static void main(String [] args) {
	try {
		
		Class.forName(DbInformation.driver);
		Connection con= DriverManager.getConnection(DbInformation.url, DbInformation.userName, DbInformation.pass)
		
	}
}
}
