package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtP2pProductPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtP2pProductPaytermsDao {

public List<LtP2pProductPayterms> findByProductId(Long productId) throws ServiceException;

public List<LtP2pProductPayterms> getAll() throws ServiceException;

public List<LtP2pProductPayterms> findAllActive() throws ServiceException;

public LtP2pProductPayterms getById(Long id) throws ServiceException;

public List<LtP2pProductPayterms> findByPaytermAndProduct(Long productId, String termName) throws ServiceException;
}
