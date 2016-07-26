package app4service;

import app4domain.User;
import app4exception.UserNotFoundException;

public interface UserService {
	/**
	 * �û���¼
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name,String password);
	/**
	 * �û�ע�ᣬ���ж��û��Ƿ����
	 * @param user
	 */
	void regist(User user) throws UserNotFoundException;
	
}
