package com.example.demo.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userDaoService {
//	private static List<User> users = new ArrayList<>();
//	public static int UserCount = 3;
//	static {
//		users.add(new User(1,"Adam",new Date()));
//		users.add(new User(2,"Eve",new Date()));
//		users.add(new User(3,"Jack",new Date()));
//	}
//	
//	public List<User> findAll(){
//		return users;
//	}
//	
//	public User save(User user) {
//		if(user.getId() == null)
//		{
//			user.setId(++UserCount);
//			users.add(user);
//			return user;
//		}else {
//			int id = user.getId();
//			User u = DeleteById(id);
//			users.add(user);
//			return u;
//		}
//		
//		
//	}
//	
//	public User findOne(int id) {
//		for(User user: users)
//		{
//			if(user.getId() == id)
//			{
//				return user;
//			}
//		}
//		return null;
//	}
//	
//	public User DeleteById(int id) {
//		Iterator<User>iterator = users.iterator();
//		while(iterator.hasNext())
//		{
//			User user = iterator.next();
//			if(user.getId() == id)
//			{
//				iterator.remove(); 
//				return user;
//			}
//		}
//		return null;
//	}
	@Autowired
	private userJpaDaoService jpadao;
	
	public List<User> getUsers(){
		return jpadao.findAll();
	}
	public User getUser(Integer Id) {
		return jpadao.findById(Id).get();
	}
	public User addUser(User user) {
		jpadao.save(user);
		return user;
	}
	public User updateUser(User user) {
		jpadao.save(user);
		return user;
	}
	public void deleteUser(Integer Id) {
		User entity = jpadao.findById(Id).get();
		jpadao.delete(entity);
	}
	
}
