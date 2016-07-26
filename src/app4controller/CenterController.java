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
		request.setAttribute("message", "ע���ɹ�");
		result ="/message.jsp";
		request.getRequestDispatcher(result).forward(request, response);

	}
	//�û���¼
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		LoginBean lb = FormbeanUtils.fillBean(request, LoginBean.class);
		if(!lb.validate()){
			request.setAttribute("formBean", lb);
			result="/login.jsp";
		}else{
			User user = service.login(lb.getUsername(), lb.getPassword());
			if(user==null){
				lb.getErrors().put("message", "������û���������");
				request.setAttribute("formBean", lb);
				result = "/login.jsp";
			}else{
				//��¼�ɹ�
				request.getSession().setAttribute("user", user);
				response.setHeader("Refresh", "2;URL="+request.getContextPath());
				request.setAttribute("message", "��½�ɹ�");
				result ="/message.jsp";
			}
		}
		request.getRequestDispatcher(result).forward(request, response);

	}

	// �û�ע��
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		FormBean fb = null;
		try {
			// ��ȡ���������
			 fb = FormbeanUtils.fillBean(request, FormBean.class);
			// ��װ formBean(�������������ȫ��Ӧ�������֤����)
			if (!fb.validate()) {
				// ��֤��ͨ�������ݻ��ԣ���ʾ�������
				request.setAttribute("formBean", fb);
				result = "/regist.jsp";
			} else {
				// ��FormBean�е�����ת�Ƶ�User�� ���ģ��
				User user = new User();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, fb);// ����formBean�е��������ԣ���User�е�ͨ���Ƶ�����û�еĲ�����
				service.regist(user);
				request.setAttribute("message", "����ɹ�<a href ='"+request.getContextPath()+"'>��ҳ<a/>");
				result="/message.jsp";									
			}
		}catch(UserNotFoundException e){
			fb.getErrors().put("username","�Ѵ���");
			request.setAttribute("formBean", fb);
			result = "/regist.jsp";
		}
		catch (Exception e) {
			request.setAttribute("message", "������æ��");
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
