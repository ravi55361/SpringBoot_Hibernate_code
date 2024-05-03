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


@WebServlet("/newReg")
public class Newregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Newregistration() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("firstname");
		String city =request.getParameter("city");
		String phoneNumber =request.getParameter("phone");
		String email =request.getParameter("emailid");
		String gender =request.getParameter("gender");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo_db","root","test");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into studentinfo_db.student values('"+name+"','"+city+"','"+email+"','"+phoneNumber+"','"+gender+"')");
			con.close();
			System.out.println("New registration sucessfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
