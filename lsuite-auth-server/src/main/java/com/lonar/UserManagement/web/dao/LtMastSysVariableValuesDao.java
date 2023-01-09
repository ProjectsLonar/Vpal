package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastSysVariableValues;

public interface LtMastSysVariableValuesDao
{

	public List<LtMastSysVariableValues> getByVariableId(Long parseLong) throws Exception;
}
