package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	
	@Column
	String fname;
	
	@Column
	String lname;
	
	@Column
	String mobile;
	
	@Column
	String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	User user_id;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String fname, String lname, String mobile, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.gender = gender;
	}
	
	public Staff(String fname, String lname, String mobile, String gender, User user_id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.gender = gender;
		this.user_id = user_id;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	

}
