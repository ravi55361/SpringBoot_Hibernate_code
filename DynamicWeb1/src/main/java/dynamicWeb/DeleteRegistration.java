package dynamicWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delReg")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DeleteRegistration() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo_db","root","test");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("delete from studentinfo_db.student where name='"+name+"'");
			con.close();
			System.out.println("Delete registration sucessfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
