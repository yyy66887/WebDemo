package app4dao;

import app4domain.User;

public interface UserDao {
	/**
	 * 保存用于到XML中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户名密码查询
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(String username,String password);
}
