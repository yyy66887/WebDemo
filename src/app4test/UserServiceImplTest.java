package app4test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import app4domain.User;
import app4exception.UserNotFoundException;
import app4service.UserService;
import app4service.impl.UserServiceImpl;

public class UserServiceImplTest {
private UserService service = new UserServiceImpl();
	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test(expected = app4exception.UserNotFoundException.class)
	public void testRegist() throws UserNotFoundException {
		User user = new User();
		user.setUsername("gfy");
		user.setPassword("123");
		user.setNick("¸ð¸¶ÒÔ");
		user.setEmail("gfy@itcast.cn");
		user.setBirthday(new Date());
		service.regist(user);
	}
	@Test
	public void testRegist1() throws UserNotFoundException {
		User user = new User();
		user.setUsername("zzz");
		user.setPassword("123");
		user.setNick("zzz");
		user.setEmail("zzz@itcast.cn");
		user.setBirthday(new Date());
		service.regist(user);
	}

}
