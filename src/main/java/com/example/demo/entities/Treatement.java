package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treatment")
public class Treatement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tid;
	
	@Column
	String tname;
	
	@Column
	String charges;

	public Treatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Treatement(int tid, String tname, String charges) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.charges = charges;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}
	
	
}
