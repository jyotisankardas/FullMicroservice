package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeRepositery;
import com.example.demo.Exception.EmployeeNotFoundException;
import com.example.demo.model.EmpDTOInput;
import com.example.demo.model.EmpDTOOutput;
import com.example.demo.model.EmployeeEntity;

@Service
public class EmployeeDtoImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositery emprepo;

	@Override
	public EmpDTOOutput saveEmp(EmpDTOInput dtoinput) {

		// convert dtoinput to entity

		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpid(dtoinput.getEmpid());
		entity.setName(dtoinput.getName());
		entity.setAddress(dtoinput.getAddress());
		entity.setMob(dtoinput.getMob());

		EmployeeEntity save = emprepo.save(entity);

		EmpDTOOutput dtooutput = new EmpDTOOutput();

		dtooutput.setEmpid(save.getEmpid());
		dtooutput.setName(save.getName());
		dtooutput.setAddress(save.getAddress());
		dtooutput.setMob(save.getMob());

		return dtooutput;

	}

	@Override
	public EmpDTOOutput getEmpbyID(Long Id) throws EmployeeNotFoundException {

		EmployeeEntity employeeEntity = emprepo.findById(Id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + Id + " not found"));


		EmpDTOOutput dtooutput = new EmpDTOOutput();

		dtooutput.setEmpid(employeeEntity.getEmpid());
		dtooutput.setName(employeeEntity.getName());
		dtooutput.setAddress(employeeEntity.getAddress());
		dtooutput.setMob(employeeEntity.getMob());

		return dtooutput;
	}

}
