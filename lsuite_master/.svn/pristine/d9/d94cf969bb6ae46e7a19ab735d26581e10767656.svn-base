package com.lonar.vendor.vendorportal.additionalfields;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.BaseClass;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastAdditionalFieldsDao {

	LtMastAdditionalFields saveAdditionalFieldsDef(LtMastAdditionalFields additionalFields) throws ServiceException;

	Long checkFieldDefinationNameAlreadyExits(LtMastAdditionalFields additionalFields) throws ServiceException;

	Long getAddFieldsDefiSummaryDataTableCount(Long companyId, LtMastAdditionalFields input) throws ServiceException;

	List<LtMastAdditionalFields> getAddFieldsDefiSummaryDataTableData(Long companyId, LtMastAdditionalFields input)
			throws ServiceException;

	Long getAddFieldsDataTableCount(Long fieldDefId, LtMastAddFieldsColUses input) throws ServiceException;

	List<LtMastAddFieldsColUses> getAddFieldsDataTableData(Long fieldDefId, LtMastAddFieldsColUses input)
			throws ServiceException;
	
	List<String> getTableName(String tablename)throws ServiceException;
	
	List<String> getColumnNameByTableName(String tablename)throws ServiceException;
	
	List<LtMastAddFieldsColUses> getAddFieldDetailsByTableName(String tableName, Long companyId)throws ServiceException;
	
	ResponseEntity<Status>saveAditionalfieldDataToDB(Long id, BaseClass input) throws ServiceException;

	BaseClass getAdditionalFieldById(Long id, String masterName) throws ServiceException;

	List<String> getColumnNameByFieldId(String fieldDefId) throws ServiceException;

}
