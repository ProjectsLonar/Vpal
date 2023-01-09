package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastGroupProductsService {

	public List<LtMastGroupProducts> findByParentProductId(Long parentProductId) throws ServiceException;

	public List<LtMastGroupProducts> findByChildProductId(Long childProductId) throws ServiceException;

	public List<LtMastGroupProducts> findAllActive() throws ServiceException;

	public List<LtMastGroupProducts> getAll() throws ServiceException;

	public LtMastGroupProducts getById(Long id) throws ServiceException;

	public ResponseEntity<Status> saveGroupProducts(LtMastGroupProducts ltP2pGroupProducts) throws ServiceException;

	public ResponseEntity<Status> deleteGroupProducts(Long id) throws ServiceException;

	public List<LtMastGroupProducts> getByProductId(Long id) throws ServiceException;

	public ResponseEntity<Status> updateGroupProducts(LtMastGroupProducts ltP2pGroupProducts) throws ServiceException;

	
}
