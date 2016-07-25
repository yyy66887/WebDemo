package app4service.impl;

import app4Utils.MD5Utils;
import app4dao.UserDao;
import app4dao.impl.UserDaoImpl;
import app4domain.User;
import app4exception.UserNotFoundException;
import app4service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		password = MD5Utils.encoding(password);
		return dao.findUser(username, password);
	}

	@Override
	public void regist(User user) throws UserNotFoundException {
		// 判断
		User u = dao.findUserByUsername(user.getUsername());
		if (u != null) {
			throw new UserNotFoundException("用户名已经存在");
		}
		user.setPassword(MD5Utils.encoding(user.getPassword()));
		dao.addUser(user);

	}
}
