package app4domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class FormBean {
	private String username;
	private String nick;
	private String password;
	private String password1;
	private String email;
	private String birthday;
	private Map<String,String> errors = new HashMap<String, String>();
	
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public boolean validate(){
		//如果有错就向Map中添加东东
				//*用户名(3~8位字母)
				if(username==null||"".equals(username.trim())){
					errors.put("username", "请输入用户名");
				}else{
					if(!username.matches("[a-zA-Z]{3,8}")){
						errors.put("username", "用户名必须是3~8位的字母组成");
					}
				}
				//*密码(3~8位数字)
				if(password==null||"".equals(password.trim())){
					errors.put("password", "请输入密码");
				}else{
					if(!password.matches("\\d{3,8}")){
						errors.put("password", "密码必须是3~8位的数字组成");
					}
				}
				//*重复密码
				if(!password.equals(password1)){
					errors.put("password1", "两次密码必须一致");
				}
				//*邮箱
				if(email==null||"".equals(email.trim())){
					errors.put("email", "请输入邮箱");
				}else{
					if(!email.matches("\\w+@\\w+(.\\w+)+")){
						errors.put("email", "请输入正确的邮箱");
					}
				}
				//*出生日期
				if(birthday==null||"".equals(birthday.trim())){
					errors.put("birthday", "请输入出生日期");
				}else{
					DateLocaleConverter dlc = new DateLocaleConverter();
					
					try {
						dlc.convert(birthday);
					} catch (Exception e) {
						errors.put("birthday", "请输入正确格式的日期.比如：2012-09-31");
					}
				}
		return errors.isEmpty();
	}
}
