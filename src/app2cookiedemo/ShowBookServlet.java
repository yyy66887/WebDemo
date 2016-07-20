package app2cookiedemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBookServlet extends HttpServlet {
	//��ʾ���е��鼮
	//��ʾ�û�����������¼��Cookie:  bookHistory=1-2-3
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//��ʾ���е��鼮
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>��վ�����º���<h1/>");
		Map<String, Book> map = BookDB.findAllBooks();
		for(Map.Entry<String, Book> me :map.entrySet()){
			Book b = me.getValue();
			out.write(b.getName()+"  "+"<a href ='/WebDemo/servlet/ShowBookDetailServlet?id="+b.getId()+"'>�鿴����</a><br/>");
		}
		out.write("<hr/>");
		out.write("<h3>���������Ʒ�����¼��</h3>");
		//cookie 3-2-1
		Cookie[] cs = request.getCookies();
		for(int i =0;cs!=null&&i<cs.length;i++){
			if (Constant.BOOK_HISTORY.equals(cs[i].getName())) {
				String value = cs[i].getValue();
				String values[] = value.split("-");
				for(String v : values){
					Book b = BookDB.findBookById(v);
					out.write(b.getName()+"<br/>");
				}
				
			}
			break;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
