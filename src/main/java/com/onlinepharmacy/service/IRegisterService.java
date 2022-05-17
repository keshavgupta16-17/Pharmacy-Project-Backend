package com.onlinepharmacy.service;

import com.onlinepharmacy.model.User;
import com.onlinepharmacy.model.UserList;

public interface IRegisterService {

User registerUser(User user);
	
	User getUser(Integer userId);
	
	UserList getAllUsers();
	
	User loginUser(String userName,String userPassword); 
	
	boolean removeAllUsers();
	
	boolean removeUserById(Integer userId);
}
