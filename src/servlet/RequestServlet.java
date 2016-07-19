package servlet;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.server.ObjID;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;

public class RequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		test7(request);
//		test8(request);
//		test9(request);
//		test10(request);
	}
	private void test10(HttpServletRequest request) throws IOException {
		//������
		ServletInputStream in = request.getInputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
	}
	private void test9(HttpServletRequest request) {
		//Beanutils����з�װ��
		User user  = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user);
	}
	private void test8(HttpServletRequest request) {
		//map+��ʡ��ȡ���ݵ�javabean
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		for(Map.Entry<String, String[]> me : map.entrySet()){
			String paraName = me.getKey();
			String[] values = me.getValue();
			try {
				PropertyDescriptor pd = new PropertyDescriptor(paraName, User.class);
				Method m = pd.getWriteMethod();
				if(values.length>1)
					m.invoke(user, (Object)values);
				else
					m.invoke(user, values);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(user);
	}
	private void test7(HttpServletRequest request) {
		//��ʡ��װjavabean �������������Ҫ����JAVABean�е�����һ��
		Enumeration<String> en = request.getParameterNames();
		User user = new User();
		System.out.println(user);
		while (en.hasMoreElements()) {
			String paraName = (String) en.nextElement();
			String[] values = request.getParameterValues(paraName);
			try {
				PropertyDescriptor pd = new PropertyDescriptor(paraName, User.class);
				Method m = pd.getWriteMethod();
				if(values.length>1)
					m.invoke(user, (Object)values);
				else
					m.invoke(user, values);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(user);
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
