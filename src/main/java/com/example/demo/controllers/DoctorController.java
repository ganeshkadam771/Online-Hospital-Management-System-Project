package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.DoctorRegister;
import com.example.demo.entities.User;
import com.example.demo.services.DoctorService;
import com.example.demo.services.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class DoctorController {
	
	@Autowired
	DoctorService dservice;
	
	@Autowired
	UserService uservice;
	
	@PostMapping("/registeruser")
	public Doctor doctorRegister(@RequestBody DoctorRegister dr)
	{
		User u=new User(dr.getUseremail(),dr.getPassword(),"Doctor");
		
		User inserted=uservice.add(u);
		Doctor d=new Doctor(dr.getFname(),dr.getLname(),dr.getMobile(),dr.getGender(),inserted);
		return dservice.add(d);
		
		/*
		String str1;
		if(str1=="Doctor")
		{
			User u=new User(dr.getUseremail(),dr.getPassword(),"Doctor");
			
			User inserted=uservice.add(u);
			Doctor d=new Doctor(dr.getFname(),dr.getLname(),dr.getMobile(),dr.getGender(),inserted);
			return dservice.add(d);
		}
		else if(str1=="Staff")
		{
			
		}*/
		
	}
}
