package com.onlinepharmacy.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepharmacy.model.User;
import com.onlinepharmacy.model.UserList;
import com.onlinepharmacy.repository.IRegisterRepository;


@Service
public class RegisterServiceImpl implements IRegisterService{
	
	@Autowired
	private IRegisterRepository registerRepo;
//	@Autowired
//	private Random random;
	
	String errorMessage=" is Already Exist";
	
	@Override
	public User registerUser(User user) {
		
//		user.setUserId(random.nextInt(1000000));
		/*if(registerRepo.getUserByUserName(user.getUserName())!=null)
			throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+errorMessage);
		
		if(registerRepo.getUserByContactNumber(user.getContactNumber())!=null)
			throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getContactNumber()+errorMessage);
		
		if(registerRepo.getUserByUserEmail(user.getUserEmail())!=null)
			throw new EmailAlreadyExistException("User with Email "+user.getUserEmail()+errorMessage);*/
		return registerRepo.save(user);
	}

	@Override
	public User getUser(Integer userId) {
		
		return registerRepo.getById(userId);
	
	}

	@Override
	public UserList getAllUsers() {
	
		return new UserList(registerRepo.findAll());
	
	}

	@Override
	public User loginUser(String userName, String userPassword) {
        
	         User user=registerRepo.getUserByUserNameAndUserPassword(userName, userPassword);

		//if (user == null) {
			//throw new UserNotFoundException("Invalid UserName and Password");
		//}
		 return user;
	}

	@Override
	public boolean removeAllUsers() {
		registerRepo.deleteAll();
		return registerRepo.findAll().isEmpty();
	}
	
	@Override
	public boolean removeUserById(Integer userId) {
		registerRepo.deleteById(userId);
		return true;
	}

}