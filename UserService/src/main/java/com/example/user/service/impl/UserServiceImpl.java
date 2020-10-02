package com.example.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.IUserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	
}
