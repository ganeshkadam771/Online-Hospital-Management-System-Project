package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Treatement;

@Repository
public interface TreatementRepository extends JpaRepository<Treatement, Integer> {

	@Query("select t from Treatement t where tid = ?1")
	public List<Treatement> getTreatement(int tid);
	
	
}
