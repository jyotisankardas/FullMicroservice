package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompanyDao;
import com.example.demo.exception.CompanyException;
import com.example.demo.exception.CompanyNotfoundException;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.CompanyEntity;
import com.example.demo.model.CompanyInputDTO;
import com.example.demo.model.CompanyOutputDTO;

import io.jsonwebtoken.Jwts;

@Service
public class CompanyServiceimpl implements CompanyService {
	@Autowired
	private CompanyDao companydao;

	@Override
	public CompanyOutputDTO savecompany(CompanyInputDTO companydto) throws CompanyException {

		CompanyEntity companyentiy = new CompanyEntity();
		CompanyOutputDTO companyop = new CompanyOutputDTO();

		companyentiy.setCmpid(companydto.getCmpid());
		companyentiy.setCmpnmae(companydto.getCmpnmae());
		companyentiy.setAddress(companydto.getAddress());

		CompanyEntity save = companydao.save(companyentiy);
		if (save == null)
			throw new CompanyException("company has not insert porperly");
		else
			companyop.setCmpid(save.getCmpid());
		companyop.setCmpnmae(save.getCmpnmae());
		companyop.setAddress(save.getAddress());
		return companyop;
	}

	@Override
	public CompanyOutputDTO getcompanybyID(Long id) throws CompanyNotfoundException {
		CompanyEntity companyentity = companydao.findById(id)
				.orElseThrow(() -> new CompanyNotfoundException("company details is not aviable by this " + id));
		CompanyOutputDTO companyop = new CompanyOutputDTO();
		companyop.setCmpid(companyentity.getCmpid());
		companyop.setCmpnmae(companyentity.getCmpnmae());
		companyop.setAddress(companyentity.getAddress());
		return companyop;
	}

	@Override
	public String gettoken(AuthRequest authrequest) {
		Map<String, Object> claims=new HashMap<>();
		
		Jwts.builder()
		.setClaims(claims)
		.setSubject(authrequest.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
		.signWith(null);
		
		return null;
	}

}
