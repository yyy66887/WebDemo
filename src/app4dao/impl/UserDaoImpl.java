package app4dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import app4Utils.Dom4jUtils;
import app4dao.UserDao;
import app4domain.User;
import app4exception.DaoException;

public class UserDaoImpl implements UserDao {
	/*
	
	 */
	public void addUser(User user) {
		try {
			Document document = Dom4jUtils.getDocument();
			Element root = document.getRootElement();
			root.addElement("user")
				.addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", user.getBirthday().toLocaleString())
				.addAttribute("nick", user.getNick());
			Dom4jUtils.write2xml(document);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	/*
	
	 */
	public User findUser(String username, String password) {
		try {
			Document document = Dom4jUtils.getDocument();
			String xpath = "//user[@username='"+username+"' and @password='"+password+"']";
			Node node = document.selectSingleNode(xpath);
			if(node==null){
				return null;
			}else{
				User user = new User();
				user.setUsername(node.valueOf("@username"));
				user.setPassword(node.valueOf("@password"));
				user.setEmail(node.valueOf("@email"));
				
				String sDate = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(sDate));
				user.setNick(node.valueOf("@nick"));
				return user;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User findUserByUsername(String username) {
		try {
			Document document = Dom4jUtils.getDocument();
			String xpath = "//user[@username='"+username+"']";
			Node node = document.selectSingleNode(xpath);
			if(node==null){
				return null;
			}else{
				User user = new User();
				user.setUsername(node.valueOf("@username"));
				user.setPassword(node.valueOf("@password"));
				user.setEmail(node.valueOf("@email"));
				
				String sDate = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(df.parse(sDate));
				user.setNick(node.valueOf("@nick"));
				return user;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
