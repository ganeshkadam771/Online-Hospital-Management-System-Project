package com.example.demo.entities;

import org.springframework.web.bind.annotation.CrossOrigin;


public class DoctorRegister {

	String useremail;
	String password;
	String fname;
	String lname;
	String mobile;
	String gender;
	public DoctorRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorRegister(String email, String password, String fname, String lname, String mobile, String gender) {
		super();
		this.useremail = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.gender = gender;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
