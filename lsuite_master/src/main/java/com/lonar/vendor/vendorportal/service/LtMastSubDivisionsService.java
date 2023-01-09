package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastSubDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastSubDivisionsService 
{

	public List<LtMastSubDivisions> findAllActive() throws ServiceException;
	
	public List<LtMastSubDivisions> findByDivisionId(Long divisionId) throws ServiceException;

	public String checkDetails(LtMastSubDivisions ltMastSubDivisions) throws ServiceException;

	public List<LtMastSubDivisions> checkDetailsUpdate(LtMastSubDivisions ltMastSubDivisions) throws ServiceException;

	public List<LtMastSubDivisions> findActiveByDivisionId(Long parseLong) throws ServiceException;

	public ResponseEntity<Status> update(LtMastSubDivisions ltMastSubDivisions) throws ServiceException;

	public LtMastSubDivisions getById(String id) throws ServiceException;

	public List<LtMastSubDivisions> findAll() throws ServiceException;

	public ResponseEntity<Status> save(LtMastSubDivisions ltMastSubDivisions) throws ServiceException;

	public ResponseEntity<Status> delete(String id) throws ServiceException;

}