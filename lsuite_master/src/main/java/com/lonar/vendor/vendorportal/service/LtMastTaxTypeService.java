package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastTaxType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastTaxTypeService {

	Long getCount(LtMastTaxType input, Long companyId) throws ServiceException;

	List<LtMastTaxType> getDataTable(LtMastTaxType input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastTaxType ltMastTaxType) throws ServiceException;

	ResponseEntity<Status> update(LtMastTaxType ltMastTaxType) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastTaxType findById(Long id) throws ServiceException;

	List<LtMastTaxType> getAll() throws ServiceException;

	List<LtMastTaxType> getLikeTaxName(String trim, Long companyId) throws ServiceException;

}
