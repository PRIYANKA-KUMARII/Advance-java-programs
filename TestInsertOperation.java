package TestInsert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
	public class TestInsertOperation {
		public static void main(String[] args) {
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "1234");
			 PreparedStatement ps= con.prepareStatement
					 ("insert into laptop22(?,?,?,?,?)");
			 Scanner sc= new Scanner(System.in);
			 System.out.println("Enter your choice: 1 for entery, 2 for display");
			 int choice= Integer.parseInt(sc.nextLine());
			 switch (choice) {
			 case 1:
				 System.out.println("How many record you need:");
				 int entry=Integer.parseInt(sc.nextLine());
				 for(int i=1; i<=entry; i++);
				 
			 System.out.println("Enter BrandName:");
			 String brandName= sc.nextLine();
			 System.out.println("Enter Model:");
			 String model= sc.nextLine();
			 System.out.println("Enter processor:");
			 String processor= sc.nextLine();
			 System.out.println("Enter the ramSize:");
			 int RamSize=Integer.parseInt(sc.nextLine());
	         System.out.println("Enter price");
	         int price= Integer.parseInt(sc.nextLine());
	         
	         ps.setString(1, brandName);
	         ps.setString(2, model);
	         ps.setString(3, processor);
	         ps.setInt(4, RamSize);
	         int records= ps.executeUpdate();
	         if(records>0);
//	         System.out.println(records +"Records entered successfully");
//
//			 ps.setString(1, "Dell");
//			 ps.setString(2, "Vostro");
//			 ps.setString(3,  "i5");
//			 ps.setInt(4, 8);
//			 ps.setInt(5, 450000);
			 int record=ps.executeUpdate();
			 if(records>0) {
				 System.out.println(records+"Records entered successfully");
			 }
			 else {
				 System.out.println("Records couldnot be entered into DB.");
				 System.out.println("Kindly contact the Admin");
				 
			 }
			 break;
			 
			 
			 case 2:
				 ResultSet rSet= ps.executeQuery("Select * from laptop22");
				 while(rSet.next());
				 System.out.println(rSet.getString(1)+"\t"+rSet.getString(2)+"\t"+rSet.getString(3)+"\t"+rSet.getInt(4)+"\t"+rSet.getInt(5));
			 }
			 break;
			 
			 Default:
				 System.out.println("Invalid choice . Enter correct choice.");	
		}
		
				catch (Exception e) {
					System.out.println("error please enter valid input");
				

	}
	
	}
	



