package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CompanyEntity {
	
	
	@Id
	private Long cmpid;
	private String cmpnmae;
	private String address;
	
	
	public Long getCmpid() {
		return cmpid;
	}
	public void setCmpid(Long cmpid) {
		this.cmpid = cmpid;
	}
	public String getCmpnmae() {
		return cmpnmae;
	}
	public void setCmpnmae(String cmpnmae) {
		this.cmpnmae = cmpnmae;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
