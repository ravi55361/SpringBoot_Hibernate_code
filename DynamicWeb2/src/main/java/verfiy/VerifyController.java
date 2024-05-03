package verfiy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/verifyReg")
public class VerifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public VerifyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernm=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root","test");
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("select * from login_db.login where email='"+usernm+"'and password='"+password+"'");
			if(result.next()) {
				out.println("Welcom Verfiy Is Sucessfull!!!");
			}else
				out.println("Invalid Username/Password!!!");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
