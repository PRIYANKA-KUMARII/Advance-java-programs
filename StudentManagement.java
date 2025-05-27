package test_adv_java;

import java.sql.*;

import java.util.Scanner;

public class StudentManagement {
	public static void main(String[] args) throws SQLException {
		boolean flag =true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("PRESS 1 for : Insert Record");
			System.out.println("PRESS 2 for : Fetch All Record ");
			System.out.println("PRESS 3 for : FecthStudentById");
			System.out.println("PRESS 4 for : updateStudentEmail");
			System.out.println("Press 5 for :Search");
			System.out.println("Press 6 for :Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("How many student records do you wants to store?");
				int ns = sc.nextInt();
				for (int i = 1; i <= ns; i++) {
					System.out.println("Enter ID");
					String id = sc.nextLine();
					id = sc.nextLine();
					System.out.println("Enter Name");
					String name = sc.nextLine();
					System.out.println("Enter Course");
					String course = sc.nextLine();
					System.out.println("Enter Semister");
					int semi = sc.nextInt();
					System.out.println("Enter Mail_Id");
					String mail = sc.nextLine();
					mail = sc.nextLine();
					System.out.println("Enter Phone Number");
					long phoNumber = sc.nextLong();
					Student s = new Student(id, name, course, semi, mail, phoNumber);
					Student. insertStudent(s);
				}
				break;
			case 2:
				Student.fetchAllStudents();
				break;
			case 3:
				System.out.println("Enter the student id");
				String id = sc.nextLine();
				id = sc.nextLine();
				Student.fetchById(id);
				break;
			case 4:
				System.out.println("Enter the student id:");
				String id1 = sc.nextLine();
				id1 = sc.nextLine();
				System.out.println("Enter the email1");
				String email1 = sc.nextLine();

				Student.updateStudentEmail(id1, email1);

				break;
			case 5:
				System.out.println("Enter the student id");
				String id2 = sc.nextLine();
				id2 = sc.nextLine();
				Student.deleteStudentById(id2);
				break;
			case 6:
				
				flag=false;
				System.out.println("exit the application");
				break;
			}
			
			
		}
	}
}
	class Student {
		String id;
		String name;
		String course;
		int semester;
		String email;
		long phoneNumber;
		public static Scanner sc = new Scanner(System.in);

		public Student(String id, String name, String course, int semester, String email, long phoneNumber) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
			this.semester = semester;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public static void fetchAllStudents() {
			try {
				PreparedStatement psmt = con.prepareStatement("select * from Student_Management");
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public static Connection con;

		static {
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public static void insertStudent(Student s) {
			try {
				PreparedStatement psmt = con.prepareStatement("insert into Student_Management values(?,?,?,?,?,?)");
				psmt.setString(1, s.id);
				psmt.setString(2, s.name);
				psmt.setString(3, s.course);
				psmt.setInt(4, s.semester);
				psmt.setString(5, s.email);
				psmt.setLong(6, s.phoneNumber);
				int rowInserted = psmt.executeUpdate();
				if (rowInserted > 0) {
					System.out.println("Record successfully.");
				} else {
					System.out.println("Could not inserted the record");
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		public static void fetchAllStudents(String id, String name, String course, int semeseter, String email,
				String phoneNumber) throws SQLException {

			PreparedStatement psmt = con.prepareStatement("select * from Student_Management where AllStudent=? ");
			psmt.setString(1, id);
			ResultSet r = psmt.executeQuery();
			if (r.next()) {
				System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getInt(4)
						+ " " + r.getString(5) + " " + r.getString(6));
			} else {
				System.out.println("Invalid Id");
			}
		}

		public static void fetchById(String id) throws SQLException {
			PreparedStatement psmt = con.prepareStatement("select * from Student_Management where id=? ");
			psmt.setString(1, id);
			ResultSet r = psmt.executeQuery();

			if (r.next()) {
				System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getInt(4)
						+ " " + r.getString(5) + " " + r.getString(6));
			} else {
				System.out.println("Invalid Id");
			}
		}

		public static void updateStudentEmail(String id, String email) throws SQLException {
			PreparedStatement psmt = con.prepareStatement("Update Student_Management set  email=? where id=?");
			
			psmt.setString(2, id);
			psmt.setString(1, email);

			int re = psmt.executeUpdate();
			if (re > 0) {
				System.out.println("email updated successfully");
			} else {
				System.out.println("email not updated:");
			}
		}

		public static void deleteStudentById(String Id) throws SQLException {
			PreparedStatement psmt = con.prepareStatement("delete from  Student_Management where Id = ?");
			psmt.setString(1, Id);
			int k = psmt.executeUpdate();
			if(k>0) {
				System.out.println("student deleted sucessfully");
			}
			else
			{
				System.out.println("student not deleted");
			}
			
		}
	}

