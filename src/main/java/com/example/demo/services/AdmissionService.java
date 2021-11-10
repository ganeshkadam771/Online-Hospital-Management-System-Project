package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admission;
import com.example.demo.repositories.AdmissionRepository;
import com.example.demo.repositories.RoomRepository;

@Service
public class AdmissionService {

	@Autowired
	AdmissionRepository arepo;
	
	@Autowired
	RoomRepository rrepo;
	
	public Admission add(Admission p)
	{
		int n=p.getRid();
		rrepo.updateRoomStatus("Occupied", n);
		return arepo.save(p);
	}

}
