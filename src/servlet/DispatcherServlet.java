package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		test1(request, response);
		response.setIntHeader("refresh", 2);
		response.getWriter().write("!!!");
	}

	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Object value = request.getAttribute("p");
		response.getWriter().write(value.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
