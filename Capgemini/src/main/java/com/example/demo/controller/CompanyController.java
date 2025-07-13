package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CompanyException;
import com.example.demo.exception.CompanyNotfoundException;
import com.example.demo.feignclint.Employeefeignclint;
import com.example.demo.model.CompanyInputDTO;
import com.example.demo.model.CompanyOutputDTO;
import com.example.demo.service.CompanyService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyservice;
	
//	@Autowired
//	private RestTemplate resttemplete;
//	
	@Autowired
	private Employeefeignclint employeeclint;

	@PostMapping("/savecompany")
	public ResponseEntity<CompanyOutputDTO> savecompany(@RequestBody CompanyInputDTO companyinputdto)
			throws CompanyException {

		return new ResponseEntity<CompanyOutputDTO>(companyservice.savecompany(companyinputdto), HttpStatus.CREATED);
	}
	@GetMapping("/getcompany/{id}")
	public ResponseEntity<CompanyOutputDTO> getcompany(@PathVariable long id)
			throws CompanyException, CompanyNotfoundException {

		return new ResponseEntity<CompanyOutputDTO>(companyservice.getcompanybyID(id), HttpStatus.OK);
	}
	
	@GetMapping("/getcompanys/{id}")
	@CircuitBreaker(name="something",fallbackMethod = "handllefallback")
	public ResponseEntity<String> getemployeebyId(@PathVariable long id){
//		return new ResponseEntity<String>(resttemplete.getForObject(
//		        "http://localhost:8080/employee/getemp/{id}",
//		        String.class,
//		        id
//		    ),HttpStatus.OK);
		
		return new ResponseEntity<String>(employeeclint.getEmployeeDetailsbyID(id),HttpStatus.OK);
		//return new ResponseEntity<String>("hihi",HttpStatus.OK);


		
	}
	
	public ResponseEntity<String> handllefallback(Throwable t){
		return new ResponseEntity<String>("down achire ",HttpStatus.BAD_GATEWAY);

		
	}
	
	
	

}