package com.lonar.UserManagement.web.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastSysVariableValuesDao;
import com.lonar.UserManagement.web.model.LtMastSysVariableValues;

@Service
public class LtMastSysVariableValuesServiceImpl implements LtMastSysVariableValuesService
{

	@Autowired
	LtMastSysVariableValuesDao ltMastSysVariableValues;
	
	@Transactional
	@Override
	public List<LtMastSysVariableValues> getByVariableId(Long parseLong) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastSysVariableValues.getByVariableId(parseLong);
	}

}
