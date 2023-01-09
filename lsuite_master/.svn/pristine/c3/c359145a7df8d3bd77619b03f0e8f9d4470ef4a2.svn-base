package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtP2pProductPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtP2pProductPaytermsService {

	public List<LtP2pProductPayterms> findByProductId(Long productId) throws ServiceException;

	public List<LtP2pProductPayterms> getAll() throws ServiceException;

	public List<LtP2pProductPayterms> findAllActive() throws ServiceException;

	public LtP2pProductPayterms getById(Long id) throws ServiceException;

	public ResponseEntity<Status> save(LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException;

	public ResponseEntity<Status> update(LtP2pProductPayterms ltP2pProductPayterms) throws ServiceException;

	public ResponseEntity<Status> delete(Long id) throws ServiceException;
}
