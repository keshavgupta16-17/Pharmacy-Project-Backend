package com.onlinepharmacy.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinepharmacy.model.User;

public interface IRegisterRepository extends JpaRepository<User, Integer>{

	//public User findByEmailId(String emailId);
	
public User getUserByUserName(String userName);
	
	public User getUserByContactNumber(BigInteger contactNumber);
	
	public User getUserByUserEmail(String userEmail);
	
    public User getUserByUserNameAndUserPassword(String userName,String userPassword);
}