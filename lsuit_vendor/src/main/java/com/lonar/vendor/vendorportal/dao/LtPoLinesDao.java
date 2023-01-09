package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtPoLinesDao {

	Long getLtPoLinesCount(Long headerId, LtPoLines input) throws ServiceException;

	List<LtPoLines> getLtPoLinesDataTable(Long headerId, LtPoLines input) throws ServiceException;

	List<LtPoLines> getAllPoLinesByHeaderId(Long headerId) throws ServiceException;

	LtPoLines getPoLinesByPolineId(Long poLineId) throws ServiceException;

	boolean updateFlage(Long ltPoLineId) throws ServiceException;

}
