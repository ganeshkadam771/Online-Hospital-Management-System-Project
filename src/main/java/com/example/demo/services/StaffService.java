package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Staff;

import com.example.demo.repositories.StaffRepository;

@Service
public class StaffService {
	@Autowired
	StaffRepository srepo;
	
	public Staff add(Staff s)
	{
		return srepo.save(s);
	}
}
