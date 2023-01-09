package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;


public interface LtMastSysVariablesService
{

	public SysVariableWithValues getBySysVariableName(String name, Long companyId) throws ServiceException;

	public ResponseEntity save(SysVariableWithValues sysVariableWithValues) throws ServiceException;

	public ResponseEntity update(SysVariableWithValues sysVariableWithValues) throws ServiceException;

	public Long getCount(LtMastSysVariables input) throws Exception;

	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input) throws Exception;

	public ResponseEntity getAll() throws ServiceException;

	public ResponseEntity<Status> delete(String id) throws ServiceException;

	public ResponseEntity<Status> deleteLtMastSysVariableValuesByID(Long id) throws ServiceException;

	public ResponseEntity<Status> saveSysVariable(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	public ResponseEntity<Status> updateSysVariable(LtMastSysVariables ltMastSysVariables) throws ServiceException;

	public List<LtMastSysVariables> getSysvariableProperties() throws ServiceException;
}
