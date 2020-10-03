package com.example.user.controller;

import java.net.URI;
import java.text.MessageFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.service.UserService;

@RestController
@RequestMapping(name = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@Valid @RequestBody User userRequest) {

		final User savedUser = userService.saveUser(userRequest);
		if (savedUser.getUserId() < 1) {
			throw new RuntimeException("Error in saving user, please try again");
		}
		URI location = URI.create(MessageFormat.format("/users/{}", savedUser.getUserId()));
		return ResponseEntity.created(location).body("User created successfully");
	}
}
