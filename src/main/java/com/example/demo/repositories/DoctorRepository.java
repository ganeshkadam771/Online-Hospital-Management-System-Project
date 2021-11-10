package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.User;



@Transactional
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	//Optional<Doctor> findById(int i);

	//Optional<Doctor> findById(int i);
	@Query("select d from Doctor d where user_id = :u")
	public Doctor getDoctor(User u);
	
		
	
}
