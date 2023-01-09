package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastComnMasterValues;

public interface LtMastComnMasterValuesDao {

	public List<LtMastComnMasterValues> findByValueCode(String valueCode) throws Exception;

	public List<LtMastComnMasterValues> findByValueName(String valueName) throws Exception;

	public List<LtMastComnMasterValues> findAllActive() throws Exception;

	public List<LtMastComnMasterValues> findByMasteridWithValuecode(Long masterId, String valueCode) throws Exception;

	public List<LtMastComnMasterValues> findByMasterId(Long masterId) throws Exception;

	public List<LtMastComnMasterValues> findLikeValueNameWithMasterId(Long masterId, String valueName) throws Exception;

	public List<LtMastComnMasterValues> findByMasteridWithValueTag(Long masterId, String valueTag) throws Exception;

	public List<LtMastComnMasterValues> findByMasterNameWithValueCode(String masterName, String valueCode)
			throws Exception;

	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws Exception;

	public List<LtMastComnMasterValues> checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues)
			throws Exception;

	public List<LtMastComnMasterValues> findByCommanMasterName(String masterName) throws Exception;
}
