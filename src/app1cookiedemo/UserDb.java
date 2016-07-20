package app1cookiedemo;

import java.util.ArrayList;

public class UserDb {
	private static ArrayList<User> al = new ArrayList<User>();
	static{
		al.add(new User("abc", "123"));
		al.add(new User("def", "456"));
		al.add(new User("ghi", "789"));
	}

	public static User findUser(String name,String psd){
		User user = null;
		for(User u:al){
			if(name.equals(u.getName())&&psd.equals(u.getPsd())){
				user = u;
				break;
			}
		}
		return user;
	}
}
