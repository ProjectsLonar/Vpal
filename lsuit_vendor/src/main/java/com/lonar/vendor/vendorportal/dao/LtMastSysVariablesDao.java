package com.lonar.vendor.vendorportal.dao;


import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;


public interface LtMastSysVariablesDao
{
	public List<SysVariableWithValues> getBySysVariableName(String name, Long companyId) throws ServiceException;

	LtMastSysVariables getByName(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	LtMastSysVariables getByCode(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	public Long getCount(LtMastSysVariables input)  throws Exception;

	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input)  throws Exception;

	public List<LtMastSysVariables> getSysvariableProperties() throws ServiceException;
}
