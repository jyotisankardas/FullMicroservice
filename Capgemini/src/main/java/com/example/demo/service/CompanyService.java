package com.example.demo.service;

import com.example.demo.exception.CompanyException;
import com.example.demo.exception.CompanyNotfoundException;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.CompanyInputDTO;
import com.example.demo.model.CompanyOutputDTO;

public interface CompanyService {

	public CompanyOutputDTO savecompany(CompanyInputDTO companydto) throws CompanyException;

	public CompanyOutputDTO getcompanybyID(Long id) throws CompanyNotfoundException;

	public String gettoken(AuthRequest authrequest);

}
