package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;


public interface LtMastComnMasterValuesDao {

	public List<LtMastComnMasterValues> findByValueCode(String valueCode) throws ServiceException;

	public List<LtMastComnMasterValues> findByValueName(String valueName) throws ServiceException;

	public List<LtMastComnMasterValues> findAllActive() throws ServiceException;

	public List<LtMastComnMasterValues> findByMasteridWithValuecode(Long masterId, String valueCode) throws ServiceException;

	public List<LtMastComnMasterValues> findByMasterId(Long masterId) throws ServiceException;

	public List<LtMastComnMasterValues> findLikeValueNameWithMasterId(Long masterId, String valueName) throws ServiceException;

	public List<LtMastComnMasterValues> findByMasteridWithValueTag(Long masterId, String valueTag) throws ServiceException;

	public List<LtMastComnMasterValues> findByMasterNameWithValueCode(String masterName, String valueCode)
			throws ServiceException;

	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws ServiceException;

	public List<LtMastComnMasterValues> checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues)
			throws ServiceException;

	public List<LtMastComnMasterValues> findByCommanMasterName(String masterName) throws ServiceException;

	public List<LtMastComnMasterValues> getByCommonMasterID(String id) throws ServiceException;

	public List<LtMastComnMasterValues> getLikeNameWithMaster(String masterName, String valueName) throws ServiceException;

	public List<LtMastComnMasterValues> getMasterList(String masterName) throws ServiceException;

}
