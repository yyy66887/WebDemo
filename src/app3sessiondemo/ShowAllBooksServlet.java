package app3sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllBooksServlet extends HttpServlet {
	//显示所有商品
	//提供购买链接
	//提供查看购物车链接	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>本站有以下商品</h1>");
		Map<String,Book> map = BookDB.findAllBooks();
		for(Map.Entry<String, Book> me :map.entrySet()){
			Book b = me.getValue();
			out.print(b.getName()+"<a href='/WebDemo/servlet/BuyServlet?id="+b.getId()+"'>购买</a>");
			out.print("<br/>");
		}
		out.print("<a href='/WebDemo/servlet/ShowCartServlet'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
