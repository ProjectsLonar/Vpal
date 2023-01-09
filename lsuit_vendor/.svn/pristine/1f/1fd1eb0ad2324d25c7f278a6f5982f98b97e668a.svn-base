package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorSisterConcernsService extends CodeMaster
{

	List<LtMastVendorSisterConcerns> getAllVendorSisterConcerns() throws ServiceException;

	LtMastVendorSisterConcerns getVendorSisterConcernsById(Long vendorSisterConcernsId) throws ServiceException;

	Status save(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException;

	Status update(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException;

	Status delete(Long vendorSisterConcernsId) throws ServiceException;

	List<LtMastVendorSisterConcerns> getVendorSisConcByVenId(Long vendorId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

	Long getLtMastVendorSisterConcernsCount(Long vendorId, LtMastVendorSisterConcerns input) throws ServiceException;

	List<LtMastVendorSisterConcerns> getLtMastVendorSisterConcernsDataTable(Long vendorId,
			LtMastVendorSisterConcerns input) throws ServiceException;
}
