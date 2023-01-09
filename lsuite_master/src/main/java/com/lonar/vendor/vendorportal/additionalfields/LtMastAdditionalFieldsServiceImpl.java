package com.lonar.vendor.vendorportal.additionalfields;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.model.BaseClass;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@Service
public class LtMastAdditionalFieldsServiceImpl implements LtMastAdditionalFieldsService, CodeMaster {

	@Autowired
	LtMastAdditionalFieldsDao additionalFieldsDao;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastAdditionalFieldsRepository additionalFieldsRepository;

	@Autowired
	LtMastAddFieldsColUsesRepository addFieldsColUsesRepository;

	@Override
	public ResponseEntity<Status> saveAdditionalFieldsDef(LtMastAdditionalFields additionalFields)
			throws ServiceException {
		Status status = new Status();
		
		if(additionalFields.getFieldDefinitionId() != null) {
			additionalFields.setLastUpdateDate(new Date());
			additionalFields.setLastUpdatedBy(additionalFields.getLastUpdateLogin());
			additionalFields = additionalFieldsDao.saveAdditionalFieldsDef(additionalFields);
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			status.setData(additionalFields.getFieldDefinitionId());
		}else {
			String chkDuplicate = checkDuplicateFieldDefName(additionalFields);
			if (chkDuplicate == null) {
				additionalFields.setCreationDate(new Date());
				additionalFields.setLastUpdateDate(new Date());
				additionalFields.setLastUpdatedBy(additionalFields.getLastUpdateLogin());
				additionalFields = additionalFieldsDao.saveAdditionalFieldsDef(additionalFields);
				if (additionalFields.getFieldDefinitionId() != null) {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
					status.setData(additionalFields.getFieldDefinitionId());
				} else {
					status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				}
			} else {
				status.setCode(FAIL);
				status.setMessage(chkDuplicate);
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private String checkDuplicateFieldDefName(LtMastAdditionalFields additionalFields) throws ServiceException {
		Long count = additionalFieldsDao.checkFieldDefinationNameAlreadyExits(additionalFields);
		if (count > 0) {
			return "Field definition name already exists";
		}
		return null;
	}

	@Override
	public ResponseEntity<Status> saveAdditionalFieldsColumnUses(LtMastAddFieldsColUses addFieldsColUses)
			throws ServiceException {
		Status status = new Status();
		if (addFieldsColUses.getAppColumnId() != null) {
			addFieldsColUses.setLastUpdateDate(new Date());
			addFieldsColUsesRepository.save(addFieldsColUses);
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
		} else {
			addFieldsColUses.setCreationDate(new Date());
			addFieldsColUses.setLastUpdateDate(new Date());
			addFieldsColUsesRepository.save(addFieldsColUses);
			status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public Long getAddFieldsDefiSummaryDataTableCount(Long companyId, LtMastAdditionalFields input)
			throws ServiceException {
		return additionalFieldsDao.getAddFieldsDefiSummaryDataTableCount(companyId, input);
	}

	@Override
	public List<LtMastAdditionalFields> getAddFieldsDefiSummaryDataTableData(Long companyId,
			LtMastAdditionalFields input) throws ServiceException {
		if (input.getColumnNo() == 2 && input.getSort().equals("desc")) {
			input.setColumnNo(12);
		}
		if (input.getColumnNo() == 3 && input.getSort().equals("desc")) {
			input.setColumnNo(13);
		}
		if (input.getColumnNo() == 4 && input.getSort().equals("asc")) {
			input.setColumnNo(14);
		}
		List<LtMastAdditionalFields> lLtMastAdditionalFieldsList = additionalFieldsDao
				.getAddFieldsDefiSummaryDataTableData(companyId, input);
		return lLtMastAdditionalFieldsList;
	}

	@Override
	public LtMastAdditionalFields getAddFieldDefSummById(Long fieldDefinationId) throws ServiceException {
		return additionalFieldsRepository.findOne(fieldDefinationId);
	}

	@Override
	public ResponseEntity<Status> deleteAddFieldDefSummById(Long fieldDefinationId) throws ServiceException {
		Status status = new Status();
		try {
			additionalFieldsRepository.delete(fieldDefinationId);
			status.setMessage("Data deleted successfully");
		} catch (Exception e) {
			status = ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if (status.getMessage() == null) {
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public Long getAddFieldsDataTableCount(Long fieldDefId, LtMastAddFieldsColUses input) throws ServiceException {
		return additionalFieldsDao.getAddFieldsDataTableCount(fieldDefId, input);
	}

	@Override
	public List<LtMastAddFieldsColUses> getAddFieldsDataTableData(Long fieldDefId, LtMastAddFieldsColUses input)
			throws ServiceException {
		if (input.getColumnNo() == 2 && input.getSort().equals("desc")) {
			input.setColumnNo(12);
		}
		if (input.getColumnNo() == 3 && input.getSort().equals("desc")) {
			input.setColumnNo(13);
		}
		if (input.getColumnNo() == 4 && input.getSort().equals("desc")) {
			input.setColumnNo(14);
		}

		if (input.getColumnNo() == 5 && input.getSort().equals("desc")) {
			input.setColumnNo(15);
		}

		if (input.getColumnNo() == 6 && input.getSort().equals("desc")) {
			input.setColumnNo(16);
		}

		if (input.getColumnNo() == 7 && input.getSort().equals("desc")) {
			input.setColumnNo(17);
		}

		if (input.getColumnNo() == 8 && input.getSort().equals("desc")) {
			input.setColumnNo(18);
		}

		if (input.getColumnNo() == 9 && input.getSort().equals("asc")) {
			input.setColumnNo(19);
		}

		List<LtMastAddFieldsColUses> ltMastAddFieldsColUsesList = additionalFieldsDao
				.getAddFieldsDataTableData(fieldDefId, input);
		return ltMastAddFieldsColUsesList;
	}

	@Override
	public LtMastAddFieldsColUses getAddFieldsColUsesByAppId(Long appColumnId) throws ServiceException {
		return addFieldsColUsesRepository.findOne(appColumnId);
	}

	@Override
	public ResponseEntity<Status> deleteAddFieldsColUsesByAppId(Long appColumnId) throws ServiceException {
		Status status = new Status();
		try {
			addFieldsColUsesRepository.delete(appColumnId);
			status.setMessage("Data deleted successfully");
		} catch (Exception e) {
			status = ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			if (status.getMessage() == null) {
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public List<String> getTableName(String tablename) throws ServiceException {
		return additionalFieldsDao.getTableName(tablename);
	}

	@Override
	public List<String> getColumnNameByTableName(String tablename) throws ServiceException {
		return additionalFieldsDao.getColumnNameByTableName(tablename);
	}

	@Override
	public List<LtMastAddFieldsColUses> getAddFieldDetailsByTableName(String tableName,Long companyId) throws ServiceException {
		return additionalFieldsDao.getAddFieldDetailsByTableName(tableName,companyId);
	}

	@Override
	public ResponseEntity<Status> saveAditionalfieldDataToDB(Long id, BaseClass input)
			throws ServiceException {
		return additionalFieldsDao.saveAditionalfieldDataToDB(id, input);
	}

	@Override
	public BaseClass getAdditionalFieldById(Long id, String masterName) throws ServiceException {
		return additionalFieldsDao.getAdditionalFieldById(id,masterName);
	}

	@Override
	public List<String> getColumnNameByFieldId(String fieldDefId) throws ServiceException {
		return additionalFieldsDao.getColumnNameByFieldId(fieldDefId);
	}
}
