package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		test1(response);
//		test2();
//		test3();
//		test4();
		//test5();
//		test6();
		test7();
	}

	private void test6() throws IOException {
		//�������������ȡa2.properties
		ClassLoader cl = ContextServlet.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("servlet/a2.properties");
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro.getProperty("username"));
	}
	private void test7() throws IOException {
		//�������������ȡa3.properties
		ClassLoader cl = ContextServlet.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("JSPTesr/a3.properties");
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro.getProperty("username"));
	}

	private void test4() {
		//����ResourceBundle��ȡa2properties
		ResourceBundle rb = ResourceBundle.getBundle("servlet.a2");//����
		String value = rb.getString("username");
		System.out.println(value);
	}
	private void test5() {
		//����ResourceBundle��ȡa2properties
		ResourceBundle rb = ResourceBundle.getBundle("JSPTesr.a3");//����
		String value = rb.getString("username");
		System.out.println(value);
	}

	private void test3() throws IOException, FileNotFoundException {
		//����ServletContext��ȡa2.properties
		ServletContext sc = this.getServletContext();
		String path =  sc.getRealPath("/WEB-INF/classes/servlet/a2.properties");
		Properties per = new Properties();
		per.load(new FileInputStream(path));
		String value = per.getProperty("username");
		System.out.println(value);
	}

	private void test2() throws IOException, FileNotFoundException {
		//����ServletContext��ȡa1.properties
		ServletContext sc = this.getServletContext();
		String path =  sc.getRealPath("/WEB-INF/a1.properties");
		Properties per = new Properties();
		per.load(new FileInputStream(path));
		String value = per.getProperty("username");
		System.out.println(value);
	}

	private void test1(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		ServletContext sc = this.getServletContext();
		
		String path = sc.getRealPath("/112.jpg");
		
		System.out.println(path);
		
		response.setHeader("Content-Disposition", "attachment;filename=112.jpg");
		
		response.setHeader("Content-Type", "application/octet-stream");
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b,0,len);
		}
		in.close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
