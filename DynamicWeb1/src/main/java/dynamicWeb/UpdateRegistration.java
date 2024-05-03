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


@WebServlet("/updateReg")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public UpdateRegistration() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber =request.getParameter("phone");
		String email =request.getParameter("emailid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo_db","root","test");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update studentinfo_db.student set phone='"+phoneNumber+"' where email= '"+email+"'");
			con.close();
			System.out.println("Update registration sucessfully!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
