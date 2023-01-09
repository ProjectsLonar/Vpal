package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastLoggerDao;
import com.lonar.vendor.vendorportal.model.LtMastLogger;

@Service
public class LtMastLoggerServiceImpl implements LtMastLoggerService{

	@Autowired
	LtMastLoggerDao ltMastLoggerDao;
	
	@Override
	public Long getCount(LtMastLogger input) throws Exception {
		return ltMastLoggerDao.getCount(input);
	}

	@Override
	public List<LtMastLogger> getLoggerRecords(LtMastLogger input) throws Exception {
		
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("asc"))
		{ input.setColumnNo(14); }
		return ltMastLoggerDao.getLoggerRecords(input);
	}

	@Override
	public LtMastLogger getByID(Long id) throws Exception {
		return ltMastLoggerDao.getByID(id);
	}

}
