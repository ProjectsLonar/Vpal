package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastDivisionEmployeeGrade;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastDivisionEmployeeGradeService {
	
	public List<LtMastDivisionEmployeeGrade> findByDivisionId(Long divisionId) throws ServiceException;
	public List<LtMastDivisionEmployeeGrade> findByGrade(String grade) throws ServiceException;
	public List<LtMastDivisionEmployeeGrade>	findAllActive() throws ServiceException;
	public List<LtMastDivisionEmployeeGrade> findActiveLikeDivisionName(String divisionName) throws ServiceException;
	public List<LtMastDivisionEmployeeGrade> findByDivisionIdANDGrade(Long divisionId, String grade) throws ServiceException;
	public List<LtMastDivisionEmployeeGrade> getAll() throws ServiceException;
	public LtMastDivisionEmployeeGrade getLtP2pDivisionEmployeeGradeByID(Long id) throws ServiceException;
	public ResponseEntity<Status> save(LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade) throws ServiceException;
	public ResponseEntity<Status> update(LtMastDivisionEmployeeGrade ltP2pDivisionEmployeeGrade) throws ServiceException;
	public ResponseEntity<Status> delete(Long id) throws ServiceException;
	public Long getCount(LtMastDivisionEmployeeGrade input) throws ServiceException;
	public List<LtMastDivisionEmployeeGrade> getDatatableRecords(LtMastDivisionEmployeeGrade input) throws ServiceException;
	
}
