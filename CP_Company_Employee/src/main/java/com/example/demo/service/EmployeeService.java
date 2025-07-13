package com.example.demo.service;

import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.model.EmpDTOInput;
import com.example.demo.model.EmpDTOOutput;


public interface EmployeeService {
	
	public EmpDTOOutput  saveEmp(EmpDTOInput dtoinput);
	
	public EmpDTOOutput  getEmpbyID(Long Id) throws EmployeeNotFoundException ;

}
