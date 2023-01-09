package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.LtVendCompanyCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanyCocService 
{

	List<LtVendCompanyCoc> getBycompanyId(Long companyId) throws ServiceException;

	LtVendCompanyCoc getById(Long id) throws ServiceException;

	List<LtVendCompanyCoc> getAll() throws ServiceException;

	List<LtVendCompanyCoc> getAllActive() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompanyCoc ltVendCompanyCoc, MultipartFile[] files) throws ServiceException;

	ResponseEntity<Status> update(LtVendCompanyCoc ltVendCompanyCoc, MultipartFile[] files) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong, Long companyId) throws ServiceException;

	List<LtVendCompanyCoc> getBycompanyAndVendorId(Long companyId, Long venId) throws ServiceException;

}
