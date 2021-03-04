package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private userDaoService service;
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return service.getUsers();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) throws Exception {
		User user = service.getUser(id);
		if(user == null)
		{
			throw new userNotFoundException("id-"+id);
		}
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		User savedUser = service.addUser(user);
	}
	@PutMapping("/users/")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User user){
		try {
			service.updateUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
