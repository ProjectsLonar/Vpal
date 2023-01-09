package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastTaxesService {
	
	public List<LtMastTaxes> findByTaxName(String taxName) throws ServiceException;
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException;
	public List<LtMastTaxes> findAllActive() throws ServiceException;
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName) throws ServiceException;
	public List<LtMastTaxes> getAll() throws ServiceException;
	public ResponseEntity<LtMastTaxes> getById(Long id) throws ServiceException;
	public ResponseEntity<Status> save(LtMastTaxes ltP2pTaxes) throws ServiceException;
	public ResponseEntity<Status> update(LtMastTaxes ltP2pTaxes) throws ServiceException;
	public ResponseEntity<Status> delete(Long id) throws ServiceException;
	public Long getCount(LtMastTaxes input) throws ServiceException;
	public List<LtMastTaxes> getDatatableRecords(LtMastTaxes input) throws ServiceException;
	
}
