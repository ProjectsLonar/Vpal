package com.lonar.vendor.vendorportal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastFpnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastFpnMasterDao {

	public List<LtMastFpnMaster> findByFpnNumber(String fpnNumber) throws ServiceException;

	public List<LtMastFpnMaster> findByFpnValue(Long fpnValue) throws ServiceException;
	
	public List<LtMastFpnMaster> getLikeFpnNumber(String fpnNumber) throws ServiceException;
	
	public LtMastFpnMaster getFpnNumberById(String fpnId) throws ServiceException;
	
	public BigDecimal getFpnUtilizedAmt(String poHeaderId, String fpnNumber) throws ServiceException;

	boolean revertFpnUtilizedAmt(Long fpnId, Double amount) throws ServiceException;

	public Long getCount(LtMastFpnMaster input) throws ServiceException;

	public List<LtMastFpnMaster> getDatatableRecords(LtMastFpnMaster input) throws ServiceException;

}
