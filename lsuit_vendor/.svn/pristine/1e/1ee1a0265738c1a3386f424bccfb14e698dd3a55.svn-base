package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorSisterConcernsDao 
{

	List<LtMastVendorSisterConcerns> getAllVendorSisterConcerns() throws ServiceException;

	LtMastVendorSisterConcerns getVendorSisterConcernsById(Long vendorSisterConcernsId) throws ServiceException;

	List<LtMastVendorSisterConcerns> getVendorSisConcByVenId(Long vendorId) throws ServiceException;
	
	boolean save(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException;

	boolean update(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException;

	boolean delete(Long vendorSisterConcernsId) throws ServiceException;

	boolean deleteByVendorId(Long vendorId)  throws ServiceException;

	Long getLtMastVendorSisterConcernsCount(Long vendorId, LtMastVendorSisterConcerns input) throws ServiceException;

	List<LtMastVendorSisterConcerns> getLtMastVendorSisterConcernsDataTable(Long vendorId,
			LtMastVendorSisterConcerns input) throws ServiceException;

	

}