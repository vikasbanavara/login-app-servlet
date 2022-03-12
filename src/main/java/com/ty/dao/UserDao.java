package com.ty.dao;

import com.ty.dto.User;

public class UserDao {
	
	public User validateUser(String email, String password) {
		//logic
		//EMF
		//EM
		User user = new User();
		user.setName("anil");
		user.setEmail("ani@mail.com");
		if(email.equals("admin") && password.equals("admin")) {
			return user;
		} else {
			return null;
		}
	}
}
