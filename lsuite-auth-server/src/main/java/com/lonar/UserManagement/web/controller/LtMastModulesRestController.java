package com.lonar.UserManagement.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastModules;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastModulesRepository;
import com.lonar.UserManagement.web.service.LtMastCommonMessageService;
import com.lonar.UserManagement.web.service.LtMastComnMasterValuesService;
import com.lonar.UserManagement.web.service.LtMastModulesService;
import com.lonar.UserManagement.web.service.LtMastRoleModulesService;

@RestController
@RequestMapping("/api/module")
public class LtMastModulesRestController implements CodeMaster {
	
	final String restBaseUrl = "/API/rolemodule";
	static final Logger logger = Logger.getLogger(LtMastModulesRestController.class);
	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	@Autowired
	LtMastModulesService ltMastModulesService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	@Autowired
	LtMastRoleModulesService ltMastRoleModulesService;
	@Autowired
	LtMastComnMasterValuesService ltMastComnMasterValuesService;
	
	// ================================================================================================================
	@RequestMapping(value = "/dataTable1/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getDataTable(@PathVariable("companyId") Long companyId,LtMastModules input,@PathVariable("logTime") String logTime) {
		try {
			return ltMastModulesService.getDataTable(input,companyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// -------------------Retrieve All Module Details-----------------------------
	@RequestMapping(value = "/getAll/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastModules>> listAllLtMastModules(@PathVariable("companyId") DataTablesInput companyId,@PathVariable("logTime") String logTime) {
		List<LtMastModules> ltMastModules = new ArrayList<LtMastModules>();
		try {
			ltMastModules =  ltMastModulesService.findAll(companyId);
			if (ltMastModules.isEmpty()) {
				return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
			}
		} catch (Exception e) {
			
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
	}

	// -------------------Retrieve All Active Module Details-----------------------------
	@RequestMapping(value = "/getAllActive/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastModules>> listAllActiveLtMastModules(@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) {
		List<LtMastModules> ltMastModules = new ArrayList<LtMastModules>();
		try {
			ltMastModules = (List<LtMastModules>) ltMastModulesService.findAllActive(companyId);
			if (ltMastModules.isEmpty()) {
				return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
	}

	// -------------------Retrieve All Module Like ModuleName-----------------------------
	@RequestMapping(value = "/getLikeModuleName/{moduleName}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastModules>> listLikeModuleName(@PathVariable("moduleName") String moduleName,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) {
		List<LtMastModules> ltMastModules = new ArrayList<LtMastModules>();
		try {
			ltMastModules = (List<LtMastModules>) ltMastModulesService.findByModuleName(moduleName,companyId);
			if (ltMastModules.isEmpty()) {
				return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
	}

	// -------------------Retrieve All Active Module Like Module Name-----------------------------
	@RequestMapping(value = "/getActiveLikeModuleName/{companyId}/{moduleName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastModules>> listActiveLikeModuleName(@PathVariable("moduleName") String moduleName,@PathVariable("companyId") Long companyId,@PathVariable("logTime") String logTime) {
	
		List<LtMastModules> ltMastModules = new ArrayList<LtMastModules>();
		try {
			ltMastModules = (List<LtMastModules>) ltMastModulesService.findByActiveLikeModuleName(moduleName,companyId);
			if (ltMastModules.isEmpty()) {
			
				return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	
		return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
	}

	// -------------------Retrieve All Active Module Like Module Name-----------------------------
		@RequestMapping(value = "/getLikeModule/{userId}/{moduleName}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastModules>> getLikeModuleNameAndUser(@PathVariable("userId") Long userId,@PathVariable("moduleName") String moduleName,@PathVariable("logTime") String logTime) {
			List<LtMastModules> ltMastModules = null;
			try {
			 ltMastModules =  ltMastModulesService.getLikeModuleNameAndUser(userId,moduleName);
			}catch(Exception e)	{
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
			}
			return new ResponseEntity<List<LtMastModules>>(ltMastModules, HttpStatus.OK);
		}
	// -------------------Retrieve Single Module Details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastModules> getLtMastModulesByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) {
		
		LtMastModules ltMastModules = null;
		try {
			ltMastModules = ltMastModulesService.getLtMastModulesByID(Long.parseLong(id));
			return new ResponseEntity<LtMastModules>(ltMastModules, HttpStatus.OK);
		
		} catch (NumberFormatException e) {
			
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		} catch (Exception e) {
			
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
	
	}
	// -------------------Create Module Details-----------------
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> addLtMastModules(@RequestBody LtMastModules ltMastModules) {
		Status status = new Status();
		try {
			status = ltMastModulesService.save(ltMastModules);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateLtMastModules(@RequestBody LtMastModules ltMastModules) {
		Status status = new Status();
		try {
				status = ltMastModulesService.update(ltMastModules);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	// -------------------Delete Single Module Details----------------------------

	@RequestMapping(value = "/deleteByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtMastModulesByID(@PathVariable("id") String id,@PathVariable("logTime") String logTime) {
		Status status = new Status();
		try {
			if (ltMastModulesRepository.exists(Long.parseLong(id))) {
				List<LtMastRoleModules> list = ltMastRoleModulesService.getByModuleId(Long.parseLong(id));
			
				if(list.size()<1)
				{
					ltMastModulesRepository.delete(Long.parseLong(id));
					if(! ltMastModulesRepository.exists(Long.parseLong(id))){
					status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
					if( status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action is completed successfully.");
					}
					}else {
						 status=ltMastCommonMessageService.getCodeAndMessage(DELETE_FAIL);
							if( status.getMessage()==null)
							{
								status.setCode(FAIL);
								status.setMessage("Error in finding message! The action is completed unsuccessfully.");
							}
					}
				}
				else {
					 status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
						if( status.getMessage()==null)
						{
							status.setCode(FAIL);
							status.setMessage("Error in finding message! The action is completed unsuccessfully.");
						}
				}
			} else {

				return new ResponseEntity<Status>(
						new Status(NO_RESULT,
								messageSource.getMessage("noresult", null, "Default", Locale.getDefault())),
						HttpStatus.OK);

			}

		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			e.printStackTrace();
			logger.error("ERROR "+ e );
		} catch (NumberFormatException e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		
		return new ResponseEntity<Status>(status,HttpStatus.OK);
		
	}

}