package jdbc_Proj;

import java.sql.*;

public class Demo {

	public static void main(String[] args) {
		try {
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aug_demo_db","root","test");
		    System.out.println(con);
		    Statement stmt = con.createStatement();
		    stmt.execute("insert into registration values('Priti','Kolkota','priti@gmail.com','7368885212')");
		    System.out.println("statment is successfully created!!!");
		    con.close();  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
