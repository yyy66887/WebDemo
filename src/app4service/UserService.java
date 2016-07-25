package app4service;

import app4domain.User;
import app4exception.UserNotFoundException;

public interface UserService {
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name,String password);
	/**
	 * 用户注册，先判断用户是否存在
	 * @param user
	 */
	void regist(User user) throws UserNotFoundException;
	
}
