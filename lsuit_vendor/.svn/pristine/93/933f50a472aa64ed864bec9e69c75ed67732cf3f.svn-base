package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastEmailtokenDao {

	Long makeEntryInEmailToken(LtMastEmailtoken ltMastEmailtoken) throws ServiceException;

	List<LtMastEmailtoken> findAllActive() throws ServiceException;

	void updateStatus(Long emailTokenId, String status, Integer count) throws ServiceException;

}
