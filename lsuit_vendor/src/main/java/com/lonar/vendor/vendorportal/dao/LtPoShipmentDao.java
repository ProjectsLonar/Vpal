package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtPoShipment;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtPoShipmentDao {

	Long getLtPoShipmentCount(Long headerId, Long branchId, LtPoShipment input) throws ServiceException;

	List<LtPoShipment> getLtPoShipmentDataTable(Long headerId, Long branchId, LtPoShipment input) throws ServiceException;

	LtPoShipment getByPoShipmentId(Long ltPoShipmentId) throws ServiceException;

	boolean updateFlag(Long ltPoShipmentId) throws ServiceException;

}
