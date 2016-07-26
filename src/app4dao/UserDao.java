package app4dao;

import app4domain.User;

public interface UserDao {
	/**
	 * �������ڵ�XML��
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * �����û��������ѯ
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(String username,String password);
}
