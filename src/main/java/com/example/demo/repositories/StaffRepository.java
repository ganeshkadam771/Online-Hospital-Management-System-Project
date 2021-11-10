package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Staff;
import com.example.demo.entities.User;

@Transactional
@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{
	@Query("select s from Staff s where user_id = :u")
	public Staff getStaff(User u);
}
