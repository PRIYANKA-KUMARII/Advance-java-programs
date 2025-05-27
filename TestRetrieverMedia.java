package com.adv_java;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestRetrieverMedia {
	public static void main(String [] args) {
		try {
			Connection con= DriverManager.getConnection
					("jdbc:oracle:@localhost:1521:XE:","system", "1234");
			Scanner sc= new Scanner(System.in);
			System.out.println("Connection established.");
			PreparedStatement ps= con.prepareStatement("select * from MultiMediaDB3 where id=?");
			System.out.println("Enter id to get the associated media");
			String id= sc.nextLine();
			ps.setString(1,id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(2);
				b.getBytes(1,(int)(b.length()));
				System.out.println("Enter the path where you want to load the media:");
				String path= sc.nextLine();
				File f= new File(path); 
				FileOutputStream fos= new FileOutputStream(f);
				fos.write(arr);
				System.out.println("File loaded into driver successfully.");
				
						
		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	
	}