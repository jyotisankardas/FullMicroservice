package com.example.demo.feignclint;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CP-Company",url = "http://localhost:8080/employee")
public interface Employeefeignclint {
	
	@GetMapping("/getemp/{id}")
	 String getEmployeeDetailsbyID(@PathVariable Long id ) ;
		 
	

}
