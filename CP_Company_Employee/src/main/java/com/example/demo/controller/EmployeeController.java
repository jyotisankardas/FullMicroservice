package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.model.EmpDTOInput;
import com.example.demo.model.EmpDTOOutput;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empservice;
	
	@PostMapping("/save")
	public ResponseEntity<EmpDTOOutput> saveEmployeeDetails(@RequestBody EmpDTOInput dtoinput){
		
		return new ResponseEntity<EmpDTOOutput>(empservice.saveEmp(dtoinput), HttpStatus.CREATED) ;
	}
	
	@GetMapping("/getemp/{id}")
	public ResponseEntity<EmpDTOOutput> getEmployeeDetailsbyID(@PathVariable Long id ) throws EmployeeNotFoundException{
		 return new ResponseEntity<EmpDTOOutput>(empservice.getEmpbyID(id), HttpStatus.OK) ;
	}
//	@GetMapping("/getemp/{id}")
//	public ResponseEntity<String> getEmployeeDetailsbyID(@PathVariable Long id ) throws EmployeeNotFoundException{
//		 return new ResponseEntity<String>("employe achi re", HttpStatus.OK) ;
//	}
	
	@GetMapping("/getempquery")
	public ResponseEntity<EmpDTOOutput> getEmployeeDetailsbyIDQ(@RequestParam(value = "c") Long id ) throws EmployeeNotFoundException{
		 return new ResponseEntity<EmpDTOOutput>(empservice.getEmpbyID(id), HttpStatus.OK) ;
	}

}
