package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtVendMiscQuestionsService {

	List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException;

	List<LtVendMiscQuestions> getAll() throws ServiceException;

	List<LtVendMiscQuestions> getAllActive() throws ServiceException;

	ResponseEntity<Status> save(LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException;

	ResponseEntity<Status> update(LtVendMiscQuestions ltVendMiscQuestions) throws ServiceException;

	ResponseEntity<Status> delete(Long parseLong, Long comId) throws ServiceException;

	List<LtVendMiscQuestions> getById(Long id) throws ServiceException;

	List<LtVendMiscQuestions> getMiscQueBycompanyId(Long companyId) throws ServiceException;

	List<LtVendMiscQuestions> getMiscQueBycompanyVendorId(Long companyId, Long vendorId) throws ServiceException;

}
