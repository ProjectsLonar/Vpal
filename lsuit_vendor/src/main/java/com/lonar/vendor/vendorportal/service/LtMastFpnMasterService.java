package com.lonar.vendor.vendorportal.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastFpnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastFpnMasterService {
	
	public List<LtMastFpnMaster> findByFpnNumber(String fpnNumber) throws ServiceException;

	public List<LtMastFpnMaster> findByFpnValue(Long fpnValue) throws ServiceException;
	
	public List<LtMastFpnMaster> getLikeFpnNumber(String fpnNumber) throws ServiceException;
	
	public LtMastFpnMaster getFpnNumberById(String fpnId) throws ServiceException;
	
	
	public BigDecimal getFpnUtilizedAmt(String poHeaderId,String fpnNumber) throws ServiceException;
	
	boolean revertFpnUtilizedAmt(Long fpnId, Double amount) throws ServiceException;

	public ResponseEntity<List<LtMastFpnMaster>> getAll() throws ServiceException;

	public ResponseEntity<LtMastFpnMaster> getById(Long id) throws ServiceException;

	public ResponseEntity<Status> save(LtMastFpnMaster ltP2pFpnMaster) throws ServiceException;

	public ResponseEntity<Status> update(LtMastFpnMaster ltP2pFpnMaster) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;

	public Long getCount(LtMastFpnMaster input) throws ServiceException;

	public List<LtMastFpnMaster> getDatatableRecords(LtMastFpnMaster input) throws ServiceException;
	
}
