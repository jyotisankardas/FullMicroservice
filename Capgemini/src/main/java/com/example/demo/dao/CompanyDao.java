package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CompanyEntity;


public interface CompanyDao extends CrudRepository<CompanyEntity, Long> {

	
	@Query(nativeQuery = true,value="select cmpnmae from CompanyEntity where cmpid=:cmpid")
	public CompanyEntity getCmpnmae();
}
