package EnterCommSErvlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subChild")
public class SubChildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubChildServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone= (String)request.getAttribute("phone");
		String email= (String)request.getAttribute("email");
		String name = (String) request.getAttribute("name");
		System.err.println("**********************");
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
	}

}
