package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admission;
import com.example.demo.services.AdmissionService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class AdmissionController {

	@Autowired
	AdmissionService aservice;
	
	@PostMapping("/admission")
	public Admission add(@RequestBody Admission p)
	{
		return aservice.add(p);
	}
}
