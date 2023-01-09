package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastProdSubcatPaytermsDao
{

	List<LtMastProdSubcatPayterms> getAll() throws ServiceException;

	List<LtMastProdSubcatPayterms> getAllActive() throws ServiceException;

	LtMastProdSubcatPayterms getById(Long id) throws ServiceException;

	List<LtMastProdSubcatPayterms> getAllBySubCatId(Long id) throws ServiceException;

	List<LtMastProdSubcatPayterms> getLikeTermCat(String category) throws ServiceException;

	List<LtMastProdSubcatPayterms> getLikeTermName(String name)  throws ServiceException;

}
