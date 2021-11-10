package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doctor;
import com.example.demo.repositories.DoctorRepository;


@Service
public class DoctorService {

	@Autowired
	DoctorRepository drepo;
	
	public Doctor add(Doctor d)
	{
		return drepo.save(d);
	}
}
