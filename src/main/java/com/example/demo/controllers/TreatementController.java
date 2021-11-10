package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Treatement;
import com.example.demo.services.TreatementService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class TreatementController {

	@Autowired
	TreatementService tservice;
	
	@GetMapping("/getbytreatement1")
	public List<Treatement> getByTreatement (@RequestParam("tid") int tid)
	{
		return tservice.getByTreatement(tid);
	}
	
	@PostMapping("/getbytreatement")
	public List<Treatement> getAll()
	{
		return tservice.getAll();
	}

} 
