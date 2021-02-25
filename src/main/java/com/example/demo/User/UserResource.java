package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private userDaoService service;
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
//		User user = service.findOne(id);
//		if(user == null)
//		{
//			throw new UserNotFoundException("id-"+id);
//		}
		return service.findOne(id);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.DeleteById(id);
		
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		User savedUser = service.save(user);
	}
}
