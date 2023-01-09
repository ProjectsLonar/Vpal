package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastProductDivisionsDao {

public List<LtMastProductDivisions> findByProductId(Long productId) throws ServiceException;	
public List<LtMastProductDivisions> findByDivisionId(Long divisionId) throws ServiceException;
public List<LtMastProductDivisions>	findAllActive() throws ServiceException;
public List<LtMastProductDivisions> findByProductIdAndDivisionId(Long productId,Long divisionId) throws ServiceException;
public LtMastProductDivisions getById(Long id) throws ServiceException;
public List<LtMastProductDivisions> getAll() throws ServiceException;
//public ResponseEntity<List<LtP2pProductDivisions>> getAllByProdId(Long id);
}
