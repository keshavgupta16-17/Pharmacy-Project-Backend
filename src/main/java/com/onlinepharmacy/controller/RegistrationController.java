package com.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepharmacy.model.User;
import com.onlinepharmacy.model.UserList;
import com.onlinepharmacy.service.IRegisterService;
import com.onlinepharmacy.service.RegisterServiceImpl;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class RegistrationController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) 
	{
		return registerService.registerUser(user);
	}
	
	@GetMapping("/getuser/user-id/{userId}")
	public User getUser(@PathVariable Integer userId)
	{
		return registerService.getUser(userId);
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user)
	
	{
		String username=user.getUserName();
		String password=user.getUserPassword();
		User userObj=null;
		if(username!=null && password!=null) {
			userObj=registerService.loginUser(username, password);
		}
	
		return userObj;
	}
	
	@DeleteMapping("/removeallusers")
	public String removeAllUsers()
	{
		registerService.removeAllUsers();
		return "All Users Removed";
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public boolean removeUser(@PathVariable Integer userId)
	{
		return registerService.removeUserById(userId); 
	}
}