package app4test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import app4dao.UserDao;
import app4dao.impl.UserDaoImpl;
import app4domain.User;

public class UserDaoImplTest {
	private UserDao dao = new UserDaoImpl();
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("gfy");
		user.setPassword("123");
		user.setNick("¸ð¸¶ÒÔ");
		user.setEmail("gfy@itcast.cn");
		user.setBirthday(new Date());
		dao.addUser(user);
	}

	@Test
	public void testFindUser() {
		User user = dao.findUser("gfy", "123");
		assertNotNull(user);
		user = dao.findUser("gfy1", "123");
		assertNull(user);
		user = dao.findUser("gfy", "1233");
		assertNull(user);
		user = dao.findUser("gfy1", "1233");
		assertNull(user);
	}

	@Test
	public void testFindUserByUsername() {
		User user = dao.findUserByUsername("gfy");
		assertNotNull(user);
		user = dao.findUserByUsername("gfy1");
		assertNull(user);
	}

}
