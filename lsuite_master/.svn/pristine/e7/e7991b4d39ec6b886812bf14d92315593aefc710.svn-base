package com.lonar.vendor.vendorportal.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastEmailtokenDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;

@Service
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastEmailtokenServiceImpl implements LtMastEmailtokenService,CodeMaster {
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastEmailtokenDao ltMastEmailtokenDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;

	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	
	
	
	@Transactional
	@Override
	public List<LtMastEmailtoken> findByEmailtokenid(Long emailtokenid) throws Exception{
		return ltMastEmailtokenDao.findByEmailtokenid(emailtokenid);
	}

	@Transactional
	@Override
	public List<LtMastEmailtoken> findByTokenid(String tokenid) throws Exception{
		return ltMastEmailtokenDao.findByTokenid(tokenid);
	}

	@Transactional
	@Override
	public List<LtMastEmailtoken> findAllActive() throws Exception{
		return ltMastEmailtokenDao.findAllActive();
	}

	
	@Transactional
	@Override
	public List<LtMastEmailtoken> getDataTable(LtMastEmailtoken input) throws Exception 
	{
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		List<LtMastEmailtoken> list= ltMastEmailtokenDao.getDataTable(input);
		return list;
	}
	
	@Transactional
	@Override
	public Long getCount(LtMastEmailtoken input) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmailtokenDao.getCount(input);
	}

	@Override
	public LtMastEmailtoken getLtMastEmailtokenById(String emailtokenid) {
		// TODO Auto-generated method stub
		return ltMastEmailtokenDao.getLtMastEmailtokenById(emailtokenid);
	}

}
