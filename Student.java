package Adv_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
	
	public static void main(String [] args) {
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
		Scanner sc= new Scanner(System.in);
//		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPRESUME VALUES(?,?)");
//		System.out.print("Enter the phn num :");
//		long phn  = Long.parseLong(sc.nextLine());
//		System.out.print("Enter the resume path :");
//		String  path  = sc.nextLine();
//		File f= new File(path);
//		if(f.exists()) {
//			FileInputStream fis= new FileInputStream(f);
//			ps.setLong(1, phn);
//			ps.setBinaryStream(2, fis);
//			
//			int k = ps.executeUpdate();
//			if(k>0) {
//				System.out.println("File Inserted");
//			}else {
//				System.err.println("not inserted");
//			}
//			
//		}else {
//			System.err.println("Invalid path");
//		}
		
		
		PreparedStatement ps= con.prepareStatement("select * from empresume where phnnum =? ");
		System.out.println("Enter phno to get the associated empResume");
		long empPhno=sc.nextLong();
		ps.setLong(1,  empPhno);
		ResultSet rs= ps.executeQuery();
		//System.out.print("Enter the resume path for Retreive :");
		//String  phno  = sc.nextLine();
		if(rs.next())
		{
			File f1= new File("D:\\data\\resume.txt");
			FileOutputStream fos= new FileOutputStream(f1);
			InputStream binaryStream = rs.getBinaryStream(2);
			byte[] allBytes = binaryStream.readAllBytes();
				System.out.println(Arrays.toString(allBytes));
			fos.write(allBytes, 0, allBytes.length);
			System.out.println("Success");
		}
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
		}
}
