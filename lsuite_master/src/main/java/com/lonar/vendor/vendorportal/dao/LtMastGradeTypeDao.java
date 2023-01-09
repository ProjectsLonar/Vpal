package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastGradeType;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastGradeTypeDao {

	Long getCount(LtMastGradeType input, Long companyId) throws ServiceException;

	List<LtMastGradeType> getDataTable(LtMastGradeType input, Long companyId) throws ServiceException;

	LtMastGradeType save(LtMastGradeType ltMastGradeType) throws ServiceException;

	LtMastGradeType update(LtMastGradeType ltMastGradeType) throws ServiceException;

	LtMastGradeType delete(Long id) throws ServiceException;

	LtMastGradeType findById(Long id) throws ServiceException;

	List<LtMastGradeType> getAll() throws ServiceException;

	List<LtMastGradeType> getLikeGradeName(String grade, Long companyId) throws ServiceException;

	List<LtMastGradeType> getByGradeCode(String gradeTypeCode, Long companyId)  throws ServiceException;

	List<LtMastGradeType> getByGradeName(String gradeTypeName, Long companyId) throws ServiceException;

	List<LtMastGradeType> getAllActive(Long companyId) throws ServiceException;

}
