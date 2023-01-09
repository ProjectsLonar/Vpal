package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastDocumentList;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastDocumentListDao {

	Long getCount(LtMastDocumentList input, Long companyId) throws ServiceException;

	List<LtMastDocumentList> getDataTableRecords(LtMastDocumentList input, Long companyId) throws ServiceException;

	Long getCompanyId(Long lastUpdateLogin) throws ServiceException;


	

}
