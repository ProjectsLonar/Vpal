package com.lonar.vendor.vendorportal.additionalfields;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BaseClass;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@RestController
@RequestMapping("/API/additionalfields")
public class LtMastAdditionalFieldsController implements CodeMaster {

	@Autowired
	LtMastAdditionalFieldsService additionalFieldsService;

	@RequestMapping(value = "/saveAdditionalFieldsDef", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveAdditionalFieldsDef(@RequestBody LtMastAdditionalFields additionalFields)
			throws ServiceException {
		try {
			return additionalFieldsService.saveAdditionalFieldsDef(additionalFields);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	@RequestMapping(value = "/addFieldsDefiSummaryDataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable addFieldsDefiSummaryDataTable(@PathVariable("companyId") Long companyId,
			LtMastAdditionalFields input) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = additionalFieldsService.getAddFieldsDefiSummaryDataTableCount(companyId, input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastAdditionalFields> ltMastAdditionalFieldsList = additionalFieldsService
					.getAddFieldsDefiSummaryDataTableData(companyId, input);
			customeDataTable.setData(ltMastAdditionalFieldsList);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}

	@RequestMapping(value = "/getAddFieldDefSummById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LtMastAdditionalFields getAddFieldDefSummById(@PathVariable("id") Long id,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getAddFieldDefSummById(id);
	}

	@RequestMapping(value = "/deleteAddFieldDefSummById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteAddFieldDefSummById(@PathVariable("id") Long id,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.deleteAddFieldDefSummById(id);
	}

	@RequestMapping(value = "/saveAdditionalFieldsColumnUses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveAdditionalFieldsColumnUses(@RequestBody LtMastAddFieldsColUses addFieldsColUses)
			throws ServiceException {
		try {
			return additionalFieldsService.saveAdditionalFieldsColumnUses(addFieldsColUses);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	}

	@RequestMapping(value = "/addFieldsDataTable/{fieldDefId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable addFieldsDefiSummaryDataTable(@PathVariable("fieldDefId") Long fieldDefId,
			LtMastAddFieldsColUses input) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = additionalFieldsService.getAddFieldsDataTableCount(fieldDefId, input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastAddFieldsColUses> ltMastAdditionalFieldsList = additionalFieldsService
					.getAddFieldsDataTableData(fieldDefId, input);
			customeDataTable.setData(ltMastAdditionalFieldsList);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;
	}

	@RequestMapping(value = "/getAddFieldsColUsesByAppId/{appColumnId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LtMastAddFieldsColUses getAddFieldsColUsesByAppId(@PathVariable("appColumnId") Long appColumnId,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getAddFieldsColUsesByAppId(appColumnId);
	}

	@RequestMapping(value = "/deleteAddFieldsColUsesByAppId/{appColumnId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteAddFieldsColUsesByAppId(@PathVariable("appColumnId") Long appColumnId,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.deleteAddFieldsColUsesByAppId(appColumnId);
	}
	
	@RequestMapping(value = "/gettablename/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getTableName(@PathVariable("name") String name,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getTableName(name);
	}
	
	@RequestMapping(value = "/getColumnNameByTableName/{tableName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getColumnNameByTableName(@PathVariable("tableName") String tableName,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getColumnNameByTableName(tableName);
	}
	
	//
	@RequestMapping(value = "/getAddFieldDetailsByTableName/{tableName}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastAddFieldsColUses> getAddFieldDetailsByTableName(@PathVariable("tableName") String tableName,@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getAddFieldDetailsByTableName(tableName,companyId);
	}
	
	@RequestMapping(value = "/saveAditionalfieldDataToDB/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> saveAditionalfieldDataToDB(@PathVariable("id") Long id, 
			@RequestBody BaseClass input)throws ServiceException {
		return additionalFieldsService.saveAditionalfieldDataToDB(id, input);
	}
	
	@RequestMapping(value = "/getAdditionalFieldById/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseClass getAdditionalFieldById(@PathVariable("id") Long id,
			@PathVariable("logTime") String logTime,BaseClass input) throws ServiceException {
		return additionalFieldsService.getAdditionalFieldById(id,input.getMasterName());
	}
	
	@RequestMapping(value = "/getColumnNameByFieldDefId/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getColumnNameByFieldId(@PathVariable("id") String fieldDefId,
			@PathVariable("logTime") String logTime) throws ServiceException {
		return additionalFieldsService.getColumnNameByFieldId(fieldDefId);
	}
}


