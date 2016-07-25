package app3sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyServlet extends HttpServlet {
//完成购物，提供继续购物的链接
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		//看是否有购物车 有就把东西取出来 没有就创建一个
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("cart");
		if(list==null){
			list = new ArrayList<Book>();
			session.setAttribute("cart", list);
		}
		list.add(book);
		out.write(book.getName()+"已经放入你的购物车<br/>");
		out.write("<a href='/WebDemo/servlet/ShowAllBooksServlet'>继续购物</a>");
		//如果要求"永久"保存时 可以自己写COOKIE  JSESSION

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
