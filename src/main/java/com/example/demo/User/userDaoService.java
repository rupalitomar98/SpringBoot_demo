package com.example.demo.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
	private static List<User> users = new ArrayList<>();
	public static int UserCount = 3;
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null)
		{
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users)
		{
			if(user.getId() == id)
			{
				return user;
			}
		}
		return null;
	}
	
	public User DeleteById(int id) {
		Iterator<User>iterator = users.iterator();
		while(iterator.hasNext())
		{
			User user = iterator.next();
			if(user.getId() == id)
			{
				iterator.remove(); 
				return user;
			}
		}
		return null;
	}
}
