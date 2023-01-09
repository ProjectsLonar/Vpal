package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastBillingAddressesService 
{

	public List<LtMastBillingAddresses> getLikeBillingAddressCode(String name) throws ServiceException ;

	public List<LtMastBillingAddresses> getByBillingId(Long id) throws ServiceException;

	public List<LtMastBillingAddresses> getByBillingAddresses(String name) throws ServiceException;
	
	public List<LtMastBillingAddresses> getLikeBillingAddressByState(Long venId, String name) throws ServiceException ;

	public ResponseEntity<Status> save(LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException ;

	public ResponseEntity<Status> update(LtMastBillingAddresses ltP2pBillingAddresses) throws ServiceException ;

	public ResponseEntity<Status> delete(Long id) throws ServiceException ;

	public Long getCount(LtMastBillingAddresses input) throws ServiceException ;

	public List<LtMastBillingAddresses> getDatatableRecords(LtMastBillingAddresses input) throws ServiceException ;
}
