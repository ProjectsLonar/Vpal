package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastDivisionEmployeeGrade;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastDivisionEmployeeGradeDao {
	
public List<LtMastDivisionEmployeeGrade> findByDivisionId(Long divisionId) throws ServiceException;
public List<LtMastDivisionEmployeeGrade> findByGrade(String grade) throws ServiceException;
public List<LtMastDivisionEmployeeGrade>	findAllActive() throws ServiceException;
public List<LtMastDivisionEmployeeGrade> findActiveLikeDivisionName(String divisionName) throws ServiceException;
public List<LtMastDivisionEmployeeGrade> findByDivisionIdANDGrade(Long divisionId,String grade) throws ServiceException;
public List<LtMastDivisionEmployeeGrade> getAll() throws ServiceException;
public LtMastDivisionEmployeeGrade getLtP2pDivisionEmployeeGradeByID(Long id) throws ServiceException;
public Long getCount(LtMastDivisionEmployeeGrade input) throws ServiceException;
public List<LtMastDivisionEmployeeGrade> getDataTableRecords(LtMastDivisionEmployeeGrade input) throws ServiceException;
}
