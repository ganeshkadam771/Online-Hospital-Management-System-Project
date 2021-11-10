package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController

public class UserController {
	@Autowired
	UserService uservice;
	
	@PostMapping("/chechlogin")
	public Object checkLogin(@RequestBody User u)
	{
		
		return uservice.checkLogin(u.getUseremail(), u.getPassword());
	}
	
	
}
