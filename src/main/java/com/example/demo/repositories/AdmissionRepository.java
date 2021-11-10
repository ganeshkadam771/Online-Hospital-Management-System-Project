package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {

}
