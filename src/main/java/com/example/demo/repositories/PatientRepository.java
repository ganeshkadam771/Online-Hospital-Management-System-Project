package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Patient;



@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	//retrive patient by pid
	@Query("select p.fname,p.lname from Patient p where p.pid =:pid")
	public List<Patient> getPatient(int pid);
}
