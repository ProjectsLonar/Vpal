package com.lonar.UserManagement.web.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastSysVariablesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastSysVariables;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.SysVariableWithValues;

@Service
public class LtMastSysVariablesServiceImpl implements LtMastSysVariablesService,CodeMaster
{
	@Autowired
	LtMastSysVariablesDao ltMastSysVariablesDao;
	
	/*@Autowired
	LtMastSysVariablesRepository ltMastSysVariablesRepository;*/
	
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Transactional
	@Override
	public SysVariableWithValues getBySysVariableName(String name) throws Exception 
	{
		List<SysVariableWithValues> sysVariableWithValuesList=
				ltMastSysVariablesDao.getBySysVariableName(name);
		
		if(sysVariableWithValuesList.isEmpty())
			return new SysVariableWithValues();
		else
			return sysVariableWithValuesList.get(0);
	}

	//=================================================================================

	@Override
	public Long getCount(LtMastSysVariables input) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastSysVariablesDao.getCount(input);
	}

	@Override
	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input) throws Exception 
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
		if(input.getColumnNo()==8 && input.getSort().equals("asc"))
		{
			input.setColumnNo(18);
		}
		return ltMastSysVariablesDao.getDatatableRecords(input);
	}

	@Override
	public Status save(SysVariableWithValues sysVariableWithValues) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status update(SysVariableWithValues sysVariableWithValues) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	

}
