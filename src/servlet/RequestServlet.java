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
		//输入流
		ServletInputStream in = request.getInputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
	}
	private void test9(HttpServletRequest request) {
		//Beanutils类进行封装。
		User user  = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user);
	}
	private void test8(HttpServletRequest request) {
		//map+内省读取数据到javabean
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
		//内省封装javabean 表单输入域的名称要求与JAVABean中的属性一致
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
			throws UnsupportedEncodingException {//获取指定的单一参数
		request.setCharacterEncoding("GBK");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"::"+password);
	}
	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//获取所有头的值
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header+" : "+request.getHeader(header)); ;
			
		}
	}

	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//一个头中的多个值
		Enumeration<String> en = request.getHeaders("User-Agent");
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement()); ;
			
		}
	}
	private void test1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//获取头的值
		String header = request.getHeader("Accept-Encoding");
		System.out.println(header);
		response.setContentType("text/hetml;chartset=utf-8");
		response.getOutputStream().write(header.getBytes());
	}

	private void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {//获取request中的信息
		PrintWriter out = response.getWriter();
		response.setContentType("text/hetml;chartset=utf-8");
		String uri = request.getRequestURI();//访稳资源名部分
		StringBuffer url = request.getRequestURL();//访问全名
		String a = request.getQueryString();//方法返回请求行的参数部分
		String ip =request.getRemoteAddr();
		int port =  request.getRemotePort();//发出请求的客户机的端口号
		String host = request.getRemoteHost();// 发出请求的客户机ip
		String addr = request.getLocalAddr();//服务器的ip
		String name = request.getLocalName();//服务器的名称
		String method = request.getMethod();//访问方式 get post
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
