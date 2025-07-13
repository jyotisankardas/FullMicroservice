package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.EmployeeEntity;

public interface EmployeeRepositery extends CrudRepository<EmployeeEntity, Long>{

}
