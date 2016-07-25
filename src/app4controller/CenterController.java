package app4controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import app4Utils.FormbeanUtils;
import app4domain.FormBean;
import app4domain.LoginBean;
import app4domain.User;
import app4exception.UserNotFoundException;
import app4service.UserService;
import app4service.impl.UserServiceImpl;

public class CenterController extends HttpServlet {

	private UserService service = new UserServiceImpl();
	private String encoding = "UTF-8";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		String operation = request.getParameter("operation");
		if ("regist".equals(operation)) {
			regist(request, response);
		}else if("login".equals(operation)){
			login(request,response);
		}else if("loginout".equals(operation)){
			loginout(request,response);
		}
	}
	private void loginout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result="";
		request.getSession().removeAttribute("user");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		request.setAttribute("message", "注销成功");
		result ="/message.jsp";
		request.getRequestDispatcher(result).forward(request, response);

	}
	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		LoginBean lb = FormbeanUtils.fillBean(request, LoginBean.class);
		if(!lb.validate()){
			request.setAttribute("formBean", lb);
			result="/login.jsp";
		}else{
			User user = service.login(lb.getUsername(), lb.getPassword());
			if(user==null){
				lb.getErrors().put("message", "错误的用户名或密码");
				request.setAttribute("formBean", lb);
				result = "/login.jsp";
			}else{
				//登录成功
				request.getSession().setAttribute("user", user);
				response.setHeader("Refresh", "2;URL="+request.getContextPath());
				request.setAttribute("message", "登陆成功");
				result ="/message.jsp";
			}
		}
		request.getRequestDispatcher(result).forward(request, response);

	}

	// 用户注册
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		FormBean fb = null;
		try {
			// 获取输入的数据
			 fb = FormbeanUtils.fillBean(request, FormBean.class);
			// 封装 formBean(与表单的输入域完全对应，完成验证功能)
			if (!fb.validate()) {
				// 验证不通过，数据回显，提示具体错误
				request.setAttribute("formBean", fb);
				result = "/regist.jsp";
			} else {
				// 把FormBean中的数据转移到User中 填充模型
				User user = new User();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, fb);// 遍历formBean中的所有属性，找User中的通名称的属性没有的不管了
				service.regist(user);
				request.setAttribute("message", "保存成功<a href ='"+request.getContextPath()+"'>主页<a/>");
				result="/message.jsp";									
			}
		}catch(UserNotFoundException e){
			fb.getErrors().put("username","已存在");
			request.setAttribute("formBean", fb);
			result = "/regist.jsp";
		}
		catch (Exception e) {
			request.setAttribute("message", "服务器忙！");
			result="/message.jsp";
		}

		// service.regist(user);
		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
