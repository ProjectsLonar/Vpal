package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProductDivisionsService {

	public List<LtMastProductDivisions> findByProductId(Long productId) throws ServiceException;

	public List<LtMastProductDivisions> findByDivisionId(Long divisionId) throws ServiceException;
	
	public List<LtMastProductDivisions> findAllActive() throws ServiceException;

	public List<LtMastProductDivisions> findByProductIdAndDivisionId(Long productId, Long divisionId) throws ServiceException;

	public List<LtMastProductDivisions> getAll() throws ServiceException;

	public LtMastProductDivisions getById(Long id) throws ServiceException;

	public ResponseEntity<Status> save(LtMastProductDivisions ltP2pProductDivisions) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

	public ResponseEntity<Status> update(LtMastProductDivisions ltP2pProductDivisions) throws ServiceException;

	//public ResponseEntity<List<LtP2pProductDivisions>> getAllByProdId(Long id) throws ServiceException;
}
