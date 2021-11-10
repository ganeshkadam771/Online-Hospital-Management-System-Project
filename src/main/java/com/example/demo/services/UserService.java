package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.entities.Admin;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Staff;
import com.example.demo.entities.User;
import com.example.demo.repositories.DoctorRepository;
import com.example.demo.repositories.StaffRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository urepo;
	
	@Autowired
	DoctorRepository drepo;
	@Autowired
	StaffRepository srepo;
	
	
	
	public User add(User u)
	{
		return urepo.save(u);
	}

	public Object checkLogin(String useremail, String password) {
		
		List<Object[]> u=urepo.checkLogin(useremail,password);
		if(u.size()==1)
		{
			Doctor d=null;
			Staff s=null;

			Optional<User> ad=null;
			int flag=-1;
			//System.out.println(((User)u.get(0)[1]).getUser_id());
			if(u.get(0)[0].equals("Doctor"))
			{
				Optional<User> ou=urepo.findById((int)u.get(0)[1]);
				d=drepo.getDoctor(ou.get());
				flag=1;
			}
			else if(u.get(0)[0].equals("Staff"))
			{
				Optional<User> ou=urepo.findById((int)u.get(0)[1]);
				s=srepo.getStaff(ou.get());
				flag=0;
			}
			else if(u.get(0)[0].equals("Admin"))
			{
				Optional<User> ou=urepo.findById((int)u.get(0)[1]);
				//ad=urepo.getAdmin(ou.get());
				ad=ou;//returning same object
				flag=2;
			}
			if(flag==1)
			{
				return d;
			}
			else if(flag==2)
			{
				return ad;
			}
			else 
				return s;
		}
		else 
			return null;
		
	}
}

