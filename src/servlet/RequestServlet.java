package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	private void test6(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("GBK");
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			System.out.println(name+":::"+request.getParameter(name));
		}
	}
	private void test5(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("GBK");
		String[] names = request.getParameterValues("username");
		String[] psds = request.getParameterValues("password");
		for(String name :names){
			System.out.println(name);
		}
		for(String psd:psds){
			System.out.println(psd);
		}
	}
	private void test4(HttpServletRequest request)
			throws UnsupportedEncodingException {//��ȡָ���ĵ�һ����
		request.setCharacterEncoding("GBK");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"::"+password);
	}
	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//��ȡ����ͷ��ֵ
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header+" : "+request.getHeader(header)); ;
			
		}
	}

	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//һ��ͷ�еĶ��ֵ
		Enumeration<String> en = request.getHeaders("User-Agent");
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement()); ;
			
		}
	}
	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//��ȡͷ��ֵ
		String header = request.getHeader("Accept-Encoding");
		System.out.println(header);
		response.setContentType("text/hetml;chartset=utf-8");
		response.getOutputStream().write(header.getBytes());
	}

	private void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//��ȡrequest�е���Ϣ
		PrintWriter out = response.getWriter();
		response.setContentType("text/hetml;chartset=utf-8");
		String uri = request.getRequestURI();//������Դ������
		StringBuffer url = request.getRequestURL();//����ȫ��
		String a = request.getQueryString();//�������������еĲ�������
		String ip =request.getRemoteAddr();
		int port =  request.getRemotePort();//��������Ŀͻ����Ķ˿ں�
		String host = request.getRemoteHost();// ��������Ŀͻ���ip
		String addr = request.getLocalAddr();//��������ip
		String name = request.getLocalName();//������������
		String method = request.getMethod();//���ʷ�ʽ get post
		out.write("uri:"+uri+ "<br/>");
		out.write("url:"+url+ "<br/>");		
		out.write("a:"+a+"<br/>");
		out.write("ip:"+ip+"<br/>");
		out.write("port:"+port+"<br/>");
		out.write("host:"+host+"<br/>");
		out.write("addr:"+addr+"<br/>");
		out.write("name:"+name+"<br/>");
		out.write("method:"+method+"<br/>");
		System.out.println("uri: "+uri+ "<br/>");
		System.out.println("url:"+url+ "<br/>");
		System.out.println("a:"+a+"<br/>");
		System.out.println("ip:"+ip+"<br/>");
		System.out.println("port:"+port+"<br/>");
		System.out.println("host:"+host+"<br/>");
		System.out.println("addr:"+addr+"<br/>");
		System.out.println("name:"+name+"<br/>");
		System.out.println("method:"+method+"<br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
