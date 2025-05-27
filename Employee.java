package adv_jav_priya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee {
	int id;
	String name;
	int age;
	double salary;
	public Employee(int id, String name, int age, double salary) {
		this.id= id;
		this.name= name;
		this.age=age;
		this.salary= salary;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}



	public static void main(String[] args) {
		try {
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:ORCL","system","1234");
				
			PreparedStatement ps= con .prepareStatement("select * from Employee12",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			int c=0;
			while(rs.next()) {
				c++;
			}
			Employee emps[]=new Employee[c];
			
			rs.beforeFirst();
			
			for (int i=0;rs.next();i++)
			{
				Employee em= new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				emps[i]= em;
			}
			
			for (Employee employee : emps) {
			if (employee.salary>30000) {
				System.out.println(employee);
			}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
