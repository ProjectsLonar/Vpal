package com.lonar.vendor.vendorportal.additionalfields;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lonar.vendor.vendorportal.model.BaseClass;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastAdditionalFieldsService {
	public ResponseEntity<Status> saveAdditionalFieldsDef(LtMastAdditionalFields additionalFields)
			throws ServiceException;

	public ResponseEntity<Status> saveAdditionalFieldsColumnUses(LtMastAddFieldsColUses addFieldsColUses)
			throws ServiceException;

	public Long getAddFieldsDefiSummaryDataTableCount(Long companyId, LtMastAdditionalFields input)
			throws ServiceException;

	public List<LtMastAdditionalFields> getAddFieldsDefiSummaryDataTableData(Long companyId,
			LtMastAdditionalFields input) throws ServiceException;

	public LtMastAdditionalFields getAddFieldDefSummById(Long fieldDefinationId) throws ServiceException;

	public ResponseEntity<Status> deleteAddFieldDefSummById(Long fieldDefinationId) throws ServiceException;

	public Long getAddFieldsDataTableCount(Long fieldDefId, LtMastAddFieldsColUses input) throws ServiceException;

	public List<LtMastAddFieldsColUses> getAddFieldsDataTableData(Long fieldDefId, LtMastAddFieldsColUses input)
			throws ServiceException;

	public LtMastAddFieldsColUses getAddFieldsColUsesByAppId(Long appColumnId) throws ServiceException;

	public ResponseEntity<Status> deleteAddFieldsColUsesByAppId(Long appColumnId) throws ServiceException;

	public List<String> getTableName(String tablename)throws ServiceException;
	
	public List<String> getColumnNameByTableName(String tablename)throws ServiceException;
	
	public List<LtMastAddFieldsColUses> getAddFieldDetailsByTableName(String tableName, Long companyId)throws ServiceException;
	
	public ResponseEntity<Status>saveAditionalfieldDataToDB(Long id, BaseClass input) throws ServiceException;

	public BaseClass getAdditionalFieldById(Long id, String masterName)  throws ServiceException;

	public List<String> getColumnNameByFieldId(String fieldDefId) throws ServiceException;
	
}
