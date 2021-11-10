package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Patient;
import com.example.demo.entities.Room;
import com.example.demo.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository prepo;
	
	public Patient add(Patient p)
	{
		return prepo.save(p);
	}
	
	/*public List<Patient> getPatient(int pid)
	{
		return prepo.getPatient(pid);
		
	}*/
	public Patient getOne(int pid)
	{
		Optional<Patient> op = prepo.findById(pid);
		 Patient p = null;
		 try
			{
				p = op.get();
			}
			catch(NoSuchElementException e)
			{
				p=null;
			}
			return p;
	}

}
