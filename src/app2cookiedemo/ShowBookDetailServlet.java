package app2cookiedemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBookDetailServlet extends HttpServlet {
	// 显示书籍的详细内容
	// 向客户端写bookHistory的Cookie
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 显示书籍的详细内容
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		out.write(book.toString());
		// 向客户端写bookHistory的Cookie
		String ids = makeIds(request, id);
		Cookie c = new Cookie(Constant.BOOK_HISTORY, ids);
		c.setPath(request.getContextPath());
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);

	}

	private String makeIds(HttpServletRequest request, String id) {
		// a
		Cookie cs[] = request.getCookies();
		if (cs == null)
			return id;
		// b
		Cookie cookie = null;
		for (Cookie c : cs) {
			if (Constant.BOOK_HISTORY.equals(c.getName())) {
				cookie = c;
				break;
			}
		}

		if (cookie == null)
			return id;
		// cdefg
		String ids[] = cookie.getValue().split("\\-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));// [1,2,3]
		// cde
		if (list.size() < 3) {
			if (list.contains(id)) {
				list.remove(id);
			}
			list.addFirst(id);
		} else {// fg
			if (list.contains(id)) {
				list.remove(id);
			} else {
				list.removeLast();
			}
			list.addFirst(id);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i > 0)
				sb.append("-");
			sb.append(list.get(i));
		}

		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
