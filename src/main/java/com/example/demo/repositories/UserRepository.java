package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select l.user_type, l.user_id from User l where l.useremail=:useremail and l.password=:password")
	public List<Object[]> checkLogin(String useremail,String password);	
	//@Query("select d from Doctor d where user_id = :u")
	//public Doctor getDoctor(User u);
	@Query("select ad from User ad where user_id = :u")
	public User getAdmin(User u);
}
