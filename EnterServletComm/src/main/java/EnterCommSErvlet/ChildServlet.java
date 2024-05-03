package EnterCommSErvlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/child")
public class ChildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChildServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(String)request.getAttribute("name");
		String phone = (String)request.getAttribute("phone");
		String email= (String)request.getAttribute("email");
		request.setAttribute("phone", phone);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		RequestDispatcher rd = request.getRequestDispatcher("subChild");
		rd.forward(request, response);
		System.out.println("**********************");
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
	}

}
