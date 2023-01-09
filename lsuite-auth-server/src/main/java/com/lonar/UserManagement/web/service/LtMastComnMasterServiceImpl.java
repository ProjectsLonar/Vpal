package com.lonar.UserManagement.web.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastComnMasterDao;
import com.lonar.UserManagement.web.model.CommonMasterWithValue;
import com.lonar.UserManagement.web.model.LtMastComnMaster;
import com.lonar.UserManagement.web.model.LtMastComnMasterValues;

@Service
public  class LtMastComnMasterServiceImpl implements LtMastComnMasterService
{
	@Autowired
	LtMastComnMasterDao ltMastComnMasterDao;

	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	@Transactional
	@Override
	public List<LtMastComnMaster> findByMasterName(String masterName) throws Exception{
		return ltMastComnMasterDao.findByMasterName(masterName);
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> findByMasterDesc(String masterDesc) throws Exception{
		return ltMastComnMasterDao.findByMasterDesc(masterDesc);
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> findAllActive() throws Exception{
		return ltMastComnMasterDao.findAllActive();
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> findActiveLikeName(String masterName) throws Exception{
		return ltMastComnMasterDao.findActiveLikeName(masterName);
	}

	@Transactional
	@Override
	public CommonMasterWithValue getById(String id) throws Exception {
		return ltMastComnMasterDao.getById(id);
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> getDataTable(LtMastComnMaster input) throws Exception 
	{
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("asc"))
		{
			input.setColumnNo(16);
		}
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(6);
		}
		return ltMastComnMasterDao.getDataTable(input);
	}

	@Transactional
	@Override
	public Long getCount(LtMastComnMaster input) throws Exception{
		return ltMastComnMasterDao.getCount(input);
	}

	@Transactional
	@Override
	public LtMastComnMaster getLtMastComnMasterByID(Long commonMasterId) throws Exception {
		LtMastComnMaster ltMastComnMaster = ltMastComnMasterDao.getLtMastComnMasterByID(commonMasterId);
		List<LtMastComnMasterValues> comnMasterValuesList = ltMastComnMasterValuesService.getByValueCode(ltMastComnMaster.getStatus());
		if(!comnMasterValuesList.isEmpty() || comnMasterValuesList.size()>0)
		{
			ltMastComnMaster.setStatus(comnMasterValuesList.get(0).getValueName());
		}
		return ltMastComnMaster;
	}

}
