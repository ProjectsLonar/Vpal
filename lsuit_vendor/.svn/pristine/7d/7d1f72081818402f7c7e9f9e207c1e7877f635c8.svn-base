package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendCompanyAttachmentsService
{

	List<LtVendCompanyAttachments> getBycompanyId(Long companyId) throws ServiceException;

	LtVendCompanyAttachments getById(Long id) throws ServiceException;

	List<LtVendCompanyAttachments> getAll() throws ServiceException;

	List<LtVendCompanyAttachments> getAllActive() throws ServiceException;

	ResponseEntity<Status> save(LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException;

	ResponseEntity<Status> update(LtVendCompanyAttachments ltVendCompanyAttachments) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong) throws ServiceException;

}
