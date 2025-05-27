package Adv_java_Callable_Statement;

import java.sql.Connection;

class DbInformation{
	public static String driver= "oracle.driver.OracleDriver";
	public static String url= "jdbc:oracle:thin:@localhost:1521:orcl";
	public static String username="system";
	public static String password="1234";
}
public class Employee {
	Connection con= null;
	public void connect() {
		try {
			Class.forName(DbInformation.driver);
			con= DriverManager.getConnection(DbInformation.url.)
		}
		
	}
	
	public static void main(String [] args) {
		
	}

}
