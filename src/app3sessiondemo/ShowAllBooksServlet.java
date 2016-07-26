package app3sessiondemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllBooksServlet extends HttpServlet {
	//��ʾ������Ʒ
	//�ṩ��������
	//�ṩ�鿴���ﳵ����	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>��վ��������Ʒ</h1>");
		Map<String,Book> map = BookDB.findAllBooks();
		for(Map.Entry<String, Book> me :map.entrySet()){
			Book b = me.getValue();
			out.print(b.getName()+"<a href='/WebDemo/servlet/BuyServlet?id="+b.getId()+"'>����</a>");
			out.print("<br/>");
		}
		out.print("<a href='/WebDemo/servlet/ShowCartServlet'>�鿴���ﳵ</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
