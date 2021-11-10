package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Treatement;
import com.example.demo.repositories.TreatementRepository;

@Service
public class TreatementService {

	@Autowired
	TreatementRepository trepo;
	
	public List<Treatement> getByTreatement(int tid)
	{
		return trepo.getTreatement(tid);
	}
	
	public List<Treatement> getAll()
	{
		return trepo.findAll();
	}
}
