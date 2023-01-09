package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastAttachmentType;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastAttachmentTypeDao {

	Long getCount(LtMastAttachmentType input, Long companyId) throws ServiceException;

	List<LtMastAttachmentType> getDataTable(LtMastAttachmentType input, Long companyId) throws ServiceException;

	List<LtMastAttachmentType> findAll(Long companyId) throws ServiceException;

	List<LtMastAttachmentType> findAllActive(Long companyId) throws ServiceException;

	LtMastAttachmentType getLtMastAttachmentTypeByID(Long id) throws ServiceException;

	List<LtMastAttachmentType> getLtMastAttachmentTypeByCompID(Long id) throws ServiceException;

	List<LtMastAttachmentType> findActiveLikeName(String name, Long companyId) throws ServiceException;

	LtMastAttachmentType save(LtMastAttachmentType ltMastAttachmentType) throws ServiceException;

	List<LtMastAttachmentType> getByName(String attachmentName, String moduleCode, Long companyId) throws ServiceException;

	LtMastAttachmentType update(LtMastAttachmentType ltMastAttachmentType) throws ServiceException;

	LtMastAttachmentType delete(Long id) throws ServiceException;

	List<LtMastAttachmentType> listAllActiveByModule(String module, Long companyId) throws ServiceException;

}
