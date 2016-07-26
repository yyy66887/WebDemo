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
//��ɹ���ṩ�������������
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		//���Ƿ��й��ﳵ �оͰѶ���ȡ���� û�оʹ���һ��
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("cart");
		if(list==null){
			list = new ArrayList<Book>();
			session.setAttribute("cart", list);
		}
		list.add(book);
		out.write(book.getName()+"�Ѿ�������Ĺ��ﳵ<br/>");
		out.write("<a href='/WebDemo/servlet/ShowAllBooksServlet'>��������</a>");
		//���Ҫ��"����"����ʱ �����Լ�дCOOKIE  JSESSION

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
