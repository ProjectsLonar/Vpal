package com.lonar.UserManagement.web.dao;


import java.util.List;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastSysVariables;
import com.lonar.UserManagement.web.model.SysVariableWithValues;


public interface LtMastSysVariablesDao
{
	public List<SysVariableWithValues> getBySysVariableName(String name) throws ServiceException;

	LtMastSysVariables getByName(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	LtMastSysVariables getByCode(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	public Long getCount(LtMastSysVariables input)  throws Exception;

	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input)  throws Exception;
}
