package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastGradeType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastGradeTypeService {

	Long getCount(LtMastGradeType input, Long companyId) throws ServiceException;

	List<LtMastGradeType> getDataTable(LtMastGradeType input, Long companyId) throws ServiceException;

	ResponseEntity<Status> save(LtMastGradeType ltMastGradeType) throws ServiceException;

	ResponseEntity<Status> update(LtMastGradeType ltMastGradeType) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

	LtMastGradeType findById(Long id) throws ServiceException;

	List<LtMastGradeType> getAll() throws ServiceException;

	List<LtMastGradeType> getLikeGradeName(String trim, Long companyId) throws ServiceException;

	List<LtMastGradeType> getAllActive(Long companyId) throws ServiceException;

	

}
