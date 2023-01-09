package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.lonar.vendor.vendorportal.model.LtMastAttachmentType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastAttachmentTypeService {

	Long getCount(Long companyId, LtMastAttachmentType input) throws ServiceException;

	List<LtMastAttachmentType> getDataTableRecords(Long companyId, LtMastAttachmentType input) throws ServiceException;

	List<LtMastAttachmentType> findAll(Long companyId) throws ServiceException;

	List<LtMastAttachmentType> findAllActive(Long companyId) throws ServiceException;

	LtMastAttachmentType getLtMastAttachmentTypeByID(Long id) throws ServiceException;

	List<LtMastAttachmentType> getLtMastAttachmentTypeByCompID(Long id) throws ServiceException;

	List<LtMastAttachmentType> findActiveLikeName(String trim, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastAttachmentType ltMastAttachmentType, BindingResult bindingResult) throws ServiceException;

	ResponseEntity<Status> update(LtMastAttachmentType ltMastAttachmentType) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	List<LtMastAttachmentType> listAllActiveByModule(String module, Long companyId) throws ServiceException;

}
