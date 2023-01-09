package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.model.LtMastStates;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastStatesService 
{

	Long getCount(LtMastStates input) throws ServiceException;

	List<LtMastStates> getStateDataTableRecords(LtMastStates input) throws ServiceException;

	List<LtMastStates> findAll() throws ServiceException;

	List<LtMastStates> findAllActive() throws ServiceException;

	LtMastStates getByID(Long id) throws ServiceException;

	List<LtMastStates> findActiveLikeStateName(String trim) throws ServiceException;

	ResponseEntity<Status> save(LtMastStates ltMastStates) throws ServiceException;

	ResponseEntity<Status> update(LtMastStates ltMastStates) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

}
