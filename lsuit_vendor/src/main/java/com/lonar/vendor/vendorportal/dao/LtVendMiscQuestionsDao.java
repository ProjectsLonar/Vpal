package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtVendMiscQuestionsDao
{

	List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException;

	List<LtVendMiscQuestions> getAll() throws ServiceException;

	List<LtVendMiscQuestions> getAllActive() throws ServiceException;

	LtVendMiscQuestions getById(Long id) throws ServiceException;

}
