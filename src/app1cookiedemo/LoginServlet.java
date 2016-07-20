package app1cookiedemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		// ��֤�û���������
		User user = UserDb.findUser(username, password);
		if (user == null) {
			out.write("������û���������");
			return;
		}
		Cookie c = new Cookie("userInfo", username);
		c.setPath(request.getContextPath());
		if(remember == null){
			c.setMaxAge(0);
		}else{
			c.setMaxAge(Integer.MAX_VALUE);
		}
		response.addCookie(c);
		out.print("��½�ɹ�");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
