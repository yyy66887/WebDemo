package app3sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session==null){
			out.write("未曾购物！");
		}else{
			List<Book> list = (List<Book>) session.getAttribute("cart");
			if (list == null) {
				out.write("购物车为空！");
			} else {
				out.write("购买的商品如下：");
				for (Book b : list) {
					out.print(b.getName()+"<br/>");

				}
			}
		}		
		out.write("<a href='/WebDemo/servlet/ShowAllBooksServlet'>继续购物</a>");

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
