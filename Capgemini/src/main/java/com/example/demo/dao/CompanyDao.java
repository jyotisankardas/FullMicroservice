package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CompanyEntity;

public interface CompanyDao extends CrudRepository<CompanyEntity, Long> {

}
