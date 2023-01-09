package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastSysVariables;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.SysVariableWithValues;

public interface LtMastSysVariablesService
{

	public SysVariableWithValues getBySysVariableName(String name) throws Exception;

	public Status save(SysVariableWithValues sysVariableWithValues) throws Exception;

	public Status update(SysVariableWithValues sysVariableWithValues) throws Exception;

	public Long getCount(LtMastSysVariables input) throws Exception;

	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input) throws Exception;

}
