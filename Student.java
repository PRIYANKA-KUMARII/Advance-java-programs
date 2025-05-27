package Adv_java_priya;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	private String id;
	private String name;
	private String course;
	private String email;
	private int semester;
	private String phoneNumber;
 public Student(String id,String name, String course, String email, int semester, String phoneNumber) {
	super();
	this.id= id;
	this.name= name;
	this.course= course;
	this.semester= semester;
	this.email= email;
	this.phoneNumber= phoneNumber;
}
public static void insertStudent(Student student) {
	try {
		Connection con= DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		
		PreparedStatement ps= con.prepareStatement("insert into university values(?,?,?,?,?,?)");
		Scanner sc= new Scanner(System.in);
		ps.setString(1, student.id);
		ps.setString(2,  student.name);
		ps.setString(3,student.course);
		ps.setInt(4, student.semester);
		ps.setString(5,  student.email);
		ps.setString(6,  student.phoneNumber);
		int rowInserted= ps.executeUpdate();
		if(rowInserted <0)
		{
			System.out.println("Row not inserted successfully");
		}
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}
	
public static void fetchAllStudents()
{
	try {
		Connection con= DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		Statement stmt= con.createStatement();
		ResultSet rSet=stmt.executeQuery("select * from university");
		while(rSet.next());
		{
			System.out.println("id:"+rSet.getString(2)+
					",name:"+rSet.getString(2)+
					",course:"+rSet.getString(3)+
					",semester:"+rSet.getInt(4)+
					",email :"+rSet.getString(5)+
					",phoneNumber:"+rSet.getString(6));
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

public static void  fetchStudentById(String Id) throws SQLException {
	try 
	{
		Connection con= DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:XE","system", "1234");
		PreparedStatement psmt=con.prepareStatement("select * from university");
		
		ResultSet rSet= psmt.executeQuery("select * from university where id=?");
		psmt.setString(1, Id);
		ResultSet rs= psmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+
					" "+rs.getString(2)+
					" "+rs.getString(3)+
					" "+rs.getString(4)+
					" "+rs.getString(5)+
					" "+rs.getInt(6));
		}
	}
}
	public static void updateStudentId(String id, String newEmail) {
		try
		{
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
			PreparedStatement psmt= con.prepareStatement("university");
			ResultSet rs= psmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+
						" "+rs.getString(2)+
						" "+rs.getString(3)+
						" "+rs.getString(4)+
						" "+rs.getString(5)+
						" "+rs.getInt(6));
				if(rs.next()) {
					System.out.println("Update successfull....................");
				}
			}
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		public static void deleteStudentById(String studentId)
		{
		try {

				Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
				PreparedStatement psmt= con.prepareStatement("delete* from university where Id=?");
				
			}
			}
		
		}
}