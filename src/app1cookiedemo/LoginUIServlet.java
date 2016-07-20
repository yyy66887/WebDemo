package app1cookiedemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "";
		String checked = "";
		Cookie cs[] = request.getCookies();
		for(int i=0;cs!=null&&cs.length>i;i++){
			Cookie c = cs[i];
			System.out.println(request.getContextPath());
			System.out.println(c.getDomain()+" "+c.getPath()+" "+c.getName()+" "+c.getValue());
			if("userInfo".equals(c.getName())){
				String value = c.getValue();
				name = value;
				checked = "checked='checked'";
				break;
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='/WebDemo/servlet/LoginServlet' method='post'>");//����ʱ���û����Ȳ�Ҫʹ������
		out.write("�û���:<input type='text' name='username' value='"+name+"'/><br/>");
		out.write("����:<input type='password' name='password' value=''/><br/>");
		out.write("<input type='checkbox' name='remember' "+checked+"/>��ס�û���<br/>");
		out.write("<input type='submit' value='��¼'/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
