package com.lonar.UserManagement.web.service;

import java.util.List;
import java.util.Locale;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastComnMasterValuesDao;
import com.lonar.UserManagement.web.model.LtMastComnMasterValues;

@Service
public class LtMastComnMasterValuesServiceImpl implements LtMastComnMasterValuesService {
	@Autowired
	LtMastComnMasterValuesDao ltMastComnMasterValuesDao;

	@Autowired
	private MessageSource messageSource;

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByValueCode(String valueCode) throws Exception {
		return ltMastComnMasterValuesDao.findByValueCode(valueCode);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByValueName(String valueName) throws Exception {
		return ltMastComnMasterValuesDao.findByValueName(valueName);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findAllActive() throws Exception {
		return ltMastComnMasterValuesDao.findAllActive();
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValuecode(Long masterId, String valueCode) throws Exception {
		return ltMastComnMasterValuesDao.findByMasteridWithValuecode(masterId, valueCode);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterId(Long masterId) throws Exception {
		return ltMastComnMasterValuesDao.findByMasterId(masterId);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findLikeValueNameWithMasterId(Long masterId, String valueName)
			throws Exception {
		return ltMastComnMasterValuesDao.findLikeValueNameWithMasterId(masterId, valueName);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasteridWithValueTag(Long masterId, String valueTag) throws Exception {
		return ltMastComnMasterValuesDao.findByMasteridWithValueTag(masterId, valueTag);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> findByMasterNameWithValueCode(String masterName, String valueCode)
			throws Exception {
		return ltMastComnMasterValuesDao.findByMasterNameWithValueCode(masterName, valueCode);
	}

	@Transactional
	@Override
	public List<LtMastComnMasterValues> getByValueCode(String valueCode) throws Exception {
		return ltMastComnMasterValuesDao.getByValueCode(valueCode);
	}

	@Transactional
	@Override
	public String checkCommonMasterValuesDetails(LtMastComnMasterValues ltMastComnMasterValues) throws Exception {
		String status = null;

		List<LtMastComnMasterValues> list = ltMastComnMasterValuesDao
				.checkCommonMasterValuesDetails(ltMastComnMasterValues);
		for (LtMastComnMasterValues comnMasterValues : list) {

			if (comnMasterValues.getValueCode().equals(ltMastComnMasterValues.getValueCode())) {

				status = messageSource.getMessage("Common Master Value Code is already Exists", null,
						"Common Master Value Code is already Exists", Locale.getDefault());
			}

		}
		return status;
	}

	@Override
	public List<LtMastComnMasterValues> findByCommanMasterName(String masterName) throws Exception {
		return ltMastComnMasterValuesDao.findByCommanMasterName(masterName);
	}

}
