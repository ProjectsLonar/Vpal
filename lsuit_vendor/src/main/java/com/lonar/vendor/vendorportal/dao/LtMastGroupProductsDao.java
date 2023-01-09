package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastGroupProductsDao {
	
public List<LtMastGroupProducts> findByParentProductId(Long parentProductId) throws ServiceException;
public List<LtMastGroupProducts> findByChildProductId(Long childProductId) throws ServiceException;
public List<LtMastGroupProducts>	findAllActive() throws ServiceException;
public List<LtMastGroupProducts> getAll() throws ServiceException;
public LtMastGroupProducts getById(Long id) throws ServiceException;

}
