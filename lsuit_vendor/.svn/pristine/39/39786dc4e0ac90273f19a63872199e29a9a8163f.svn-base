package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;



public interface LtMastSysVariableValuesService
{

	public List<LtMastSysVariableValues> getByVariableId(Long parseLong) throws Exception;

	public ResponseEntity<Status> saveSysVariableValues(LtMastSysVariableValues ltMastSysVariableValues) throws ServiceException;

	public ResponseEntity<Status> updateSysVariableValues(LtMastSysVariableValues ltMastSysVariableValues) throws ServiceException;

	public ResponseEntity<List<LtMastSysVariableValues>> getAllValuesBySysVariableId(Long id) throws ServiceException;

	public ResponseEntity<LtMastSysVariableValues> getBySysVariableValuesId(Long id) throws ServiceException;

}
