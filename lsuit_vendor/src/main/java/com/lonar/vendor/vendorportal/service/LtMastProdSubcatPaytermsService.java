package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastProdSubcatPaytermsService
{

	ResponseEntity<Status> save(LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException;

	ResponseEntity<Status> update(LtMastProdSubcatPayterms prodSubcatPayterms) throws ServiceException;

	List<LtMastProdSubcatPayterms> getAll() throws ServiceException;

	List<LtMastProdSubcatPayterms> getAllActive()  throws ServiceException;

	LtMastProdSubcatPayterms getById(Long id) throws ServiceException;

	List<LtMastProdSubcatPayterms> getAllBySubCatId(Long id) throws ServiceException;

	List<LtMastProdSubcatPayterms> getLikeTermCat(String category) throws ServiceException;

	List<LtMastProdSubcatPayterms> getLikeTermName(String name) throws ServiceException;

	ResponseEntity<Status> delete(Long id) throws ServiceException;

}
