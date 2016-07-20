package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("上次登录时间是：");
		Cookie cs[] = request.getCookies();
		for(int i = 0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("lastAccessTime".equals(c.getName())){
				String value = c.getValue();
				long time = Long.parseLong(value);
				out.print(new Date(time));
			}
		}
		Cookie c = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		c.setMaxAge(30*60);
		c.setPath(request.getContextPath());
		System.out.println(request.getContextPath());
		response.addCookie(c);
		out.write("<a href='/WebDemo/servlet/CookieClearServlet'>clear</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
