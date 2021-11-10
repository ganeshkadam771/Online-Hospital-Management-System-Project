package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import com.example.demo.services.PatientService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@PostMapping("/pregister")
	public Patient patientRegister(@RequestBody Patient pr)
	{
		return pservice.add(pr);
	}
	

	//@GetMapping("/getpatient")
	/*public List<Patient> getPatient(@RequestParam("pid")int pid)
	{
		return pservice.getPatient(pid);
	}*/
	
	@GetMapping("/getpatient")
	public Patient getOne(@RequestParam("pid")int pid)
	{
		return pservice.getOne(pid);
	}
	
	
	
}
