package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="admission")
public class Admission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aid;
	
	@Column
	Date dateofadmission;
	
	@Column
	Date dateofdischarge;

	//@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid" ,referencedColumnName = "pid")
	int pid;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="did")
	//i
	int did;
	
	//(cascade = CascadeType.ALL)
	@JoinColumn(name="rid")
	int rid;
	
	public Admission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admission(Date dateofadmission, Date dateofdischarge, int pid, int did, int rid) {
		super();
		this.dateofadmission = dateofadmission;
		this.dateofdischarge = dateofdischarge;
		this.pid = pid;
		this.did = did;
		this.rid = rid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Date getDateofadmission() {
		return dateofadmission;
	}

	public void setDateofadmission(Date dateofadmission) {
		this.dateofadmission = dateofadmission;
	}

	public Date getDateofdischarge() {
		return dateofdischarge;
	}

	public void setDateofdischarge(Date dateofdischarge) {
		this.dateofdischarge = dateofdischarge;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
	
