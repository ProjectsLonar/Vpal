package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.LtMastComnMasterValues;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;


public interface LtMastComnMasterValuesService {

	public ResponseEntity findByValueCode(String valueCode) throws ServiceException;

	public ResponseEntity findByValueName(String valueName) throws ServiceException;

	public ResponseEntity findAllActive() throws ServiceException;

	public ResponseEntity findByMasteridWithValuecode(Long masterId, String valueCode) throws ServiceException;

	public ResponseEntity findByMasterId(Long masterId) throws ServiceException;

	public ResponseEntity findLikeValueNameWithMasterId(Long masterId, String valueName) throws ServiceException;

	public ResponseEntity findByMasteridWithValueTag(Long masterId, String valueTag) throws ServiceException;

	public ResponseEntity findByMasterNameWithValueCode(String masterName, String valueCode)
			throws ServiceException;

	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws ServiceException;

	public String checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException;

	public ResponseEntity findByCommanMasterName(String trim) throws ServiceException;

	public ResponseEntity<List<LtMastComnMasterValues>> getAll() throws ServiceException;

	public ResponseEntity<List<LtMastComnMasterValues>> getAllActive() throws ServiceException;

	public ResponseEntity<LtMastComnMasterValues> getLtMastComnMasterValuesByID(String id)  throws ServiceException;

	public ResponseEntity<Status> save(LtMastComnMasterValues ltMastComnMasterValues)  throws ServiceException;

	public ResponseEntity<List<LtMastComnMasterValues>> getByCommonMasterID(String id)  throws ServiceException;

	public ResponseEntity<Status> update(LtMastComnMasterValues ltMastComnMasterValues) throws ServiceException;

	public ResponseEntity<List<LtMastComnMasterValues>> getMasterList(String masterName) throws ServiceException;
}
