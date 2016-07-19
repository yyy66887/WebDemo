package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class LifeServlet extends GenericServlet {

	

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getServletName());
		System.out.println("ִ����init������");
		
	}

	@Override
	public void service(ServletRequest servletrequest,
			ServletResponse servletresponse) throws ServletException,
			IOException {		
		System.out.println("ִ����service������");
	}

	@Override
	public void destroy() {
		System.out.println("ִ����destory������");
	}
	

}
