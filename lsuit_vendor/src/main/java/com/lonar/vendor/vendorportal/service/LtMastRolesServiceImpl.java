package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastRolesDao;
import com.lonar.vendor.vendorportal.model.LtMastRoles;

@Service
public class LtMastRolesServiceImpl implements LtMastRolesService{

	@Autowired
	LtMastRolesDao ltMastRolesDao;
	
	@Override
	public List<LtMastRoles> findByRole(String role) {
		// TODO Auto-generated method stub
		return ltMastRolesDao.findByRole(role);
	}

}
