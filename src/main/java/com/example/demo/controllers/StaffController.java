package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Staff;
import com.example.demo.entities.StaffRegister;
import com.example.demo.entities.User;

import com.example.demo.services.StaffService;
import com.example.demo.services.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class StaffController {
	@Autowired
	StaffService sservice;
	
	@Autowired
	UserService uservice;
	
	@PostMapping("/staffregisteruser")
	public Staff staffRegister(@RequestBody StaffRegister sf)
	{
		User u=new User(sf.getUseremail(),sf.getPassword(),"Staff");
		
		User inserted=uservice.add(u);
		Staff s=new Staff(sf.getFname(),sf.getLname(),sf.getMobile(),sf.getGender(),inserted);
		return sservice.add(s);
	}
}
