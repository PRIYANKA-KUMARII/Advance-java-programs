package adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class ResultSetMetaData10 {
	public static void main(String [] args) {
		try {
			
		Connection con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:ORCL","system","1234");
		
			PreparedStatement psmt= con.prepareStatement("select * from emp");
			
			ResultSet rs= psmt.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			int columnCount= metaData.getColumnCount();
			//System.out.println(columnCount);
			for(int i=1; i<=columnCount; i++)
			{
				System.out.print(metaData.getColumnClassName(i)+"\t");
				System.out.print(metaData.getColumnTypeName(i)+"\t\t");
                System.out.print(metaData.getPrecision(i)+"\t");
                System.out.print(metaData.getScale(i));
                System.out.println("\n");
                //System.out.println("\n==============================================================");
			}
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
