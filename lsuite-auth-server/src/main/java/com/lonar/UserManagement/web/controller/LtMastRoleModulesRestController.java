package com.lonar.UserManagement.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lonar.UserManagement.web.repository.LtMastRoleModulesRepository;
import com.lonar.UserManagement.web.service.LtMastCommonMessageService;
import com.lonar.UserManagement.web.service.LtMastRoleModulesService;

@RestController
@RequestMapping("/api/roleandmodule")
public class LtMastRoleModulesRestController implements CodeMaster{
	@Autowired
	LtMastRoleModulesRepository ltMastRoleModulesRepository;
	@Autowired
	LtMastRoleModulesService ltMastRoleModulesService;
	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@RequestMapping(value = "/datatable/{logTime}", method = RequestMethod.GET)
	public CustomeDataTable getLtMastUsersDataTable(LtMastRoleModules input,@PathVariable("logTime") String logTime) {
		return ltMastRoleModulesService.getLtMastUsersDataTable(input);
	}

	// -------------------Retrieve All RoleModule details-----------------------------
	@RequestMapping(value = "/getAll/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastRoleModules>> listAllLtMastRoleModules(@PathVariable("logTime") String logTime) {
		List<LtMastRoleModules> ltMastRoleModules =new ArrayList<LtMastRoleModules>();
		try
		{
		ltMastRoleModules = (List<LtMastRoleModules>) ltMastRoleModulesRepository.findAll();
		for (LtMastRoleModules ltMastRoleModules2 : ltMastRoleModules) {
			LtMastModules ltMastModules=new LtMastModules();
			if(ltMastRoleModules2.getModuleId()!=null)
				if (ltMastModulesRepository.exists(ltMastRoleModules2.getModuleId()))
				ltMastModules= ltMastModulesRepository.findOne(ltMastRoleModules2.getModuleId());
			if (ltMastModules != null) {
				ltMastRoleModules2.setModuleName(ltMastModules.getModuleName());
				ltMastRoleModules2.setModuleDescription(ltMastModules.getModuleDesc());
			}
		}
		if (ltMastRoleModules.isEmpty()) {
			return new ResponseEntity<List<LtMastRoleModules>>(ltMastRoleModules, HttpStatus.OK);
		}
		} catch (Exception e) {
			/*e.printStackTrace();
			logger.error("ERROR "+ e );*/
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<List<LtMastRoleModules>>(ltMastRoleModules, HttpStatus.OK);
	}
	
	// -------------------Retrieve All Active RoleModule details-----------------------------
	@RequestMapping(value = "/getAllActive/{logTime}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastRoleModules>> listAllActiveLtMastRoleModules(@PathVariable("logTime") String logTime) {
			
		List<LtMastRoleModules> ltMastRoleModules =new ArrayList<LtMastRoleModules>();
		try
		{
			ltMastRoleModules = (List<LtMastRoleModules>) ltMastRoleModulesService.findAllActive();
			for (LtMastRoleModules ltMastRoleModules2 : ltMastRoleModules) {
					LtMastModules ltMastModules=new LtMastModules();
					if(ltMastRoleModules2.getModuleId()!=null)
						if (ltMastModulesRepository.exists(ltMastRoleModules2.getModuleId()))
						ltMastModules= ltMastModulesRepository.findOne(ltMastRoleModules2.getModuleId());
					if (ltMastModules != null) {
						ltMastRoleModules2.setModuleName(ltMastModules.getModuleName());
						ltMastRoleModules2.setModuleDescription(ltMastModules.getModuleDesc());
					}
				}
				if (ltMastRoleModules.isEmpty()) {
					return new ResponseEntity<List<LtMastRoleModules>>(ltMastRoleModules, HttpStatus.OK);
				}
				} catch (Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
	     }
		return new ResponseEntity<List<LtMastRoleModules>>(ltMastRoleModules, HttpStatus.OK);
	}
			
	// -------------------Retrieve Single RoleModule details----------------------------
	@RequestMapping(value = "/getByID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LtMastRoleModules> getByIDLtMastRoleModules(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
	
		LtMastRoleModules ltMastRoleModules = null;
		try {
			if (ltMastRoleModulesRepository.exists((id))) {
				ltMastRoleModules = ltMastRoleModulesRepository.findOne((id));
				
				LtMastModules ltMastModules=new LtMastModules();
				if(ltMastRoleModules.getModuleId()!=null)
					if (ltMastModulesRepository.exists(ltMastRoleModules.getModuleId()))
					ltMastModules= ltMastModulesRepository.findOne(ltMastRoleModules.getModuleId());
				if (ltMastModules != null) {
					ltMastRoleModules.setModuleName(ltMastModules.getModuleName());
					ltMastRoleModules.setModuleDescription(ltMastModules.getModuleDesc());
				}
			}

			else {
				return new ResponseEntity<LtMastRoleModules>(ltMastRoleModules, HttpStatus.OK);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<LtMastRoleModules>(ltMastRoleModules, HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return new ResponseEntity<LtMastRoleModules>(ltMastRoleModules, HttpStatus.OK);
	}

	// -------------------Retrieve Single RoleModule details----------------------------
		@RequestMapping(value = "/getByRoleID/{id}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LtMastRoleModules>> getLtMastRoleModulesById (@PathVariable("id") Long roleId,@PathVariable("logTime") String logTime) throws Exception {
		
			List<LtMastRoleModules> ltMastRoleModules = ltMastRoleModulesService.findByRoleId(roleId);
			
			return new ResponseEntity<List<LtMastRoleModules>>(ltMastRoleModules, HttpStatus.OK);
		}
	
	
			@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> saveLtMastRoleModules(@RequestBody  LtMastRoleModules ltMastRoleModules) throws BusinessException {
				Status status = new Status();
				try {
				status=ltMastRoleModulesService.save(ltMastRoleModules);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			
			@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Status> updateLtMastRoleModules(@RequestBody  LtMastRoleModules ltMastRoleModules)  {
				Status status = new Status();
				try {
				status=ltMastRoleModulesService.update(ltMastRoleModules);
				}catch(Exception e) {
					throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
				}
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
	
	// -------------------Delete Single RoleModule details----------------------------
	@RequestMapping(value = "/deleteById/{id}/{logTime}", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> deleteLtP2pRoleModulesByID(@PathVariable("id") Long id,@PathVariable("logTime") String logTime) {
		Status status = new Status();
		try {
			if (ltMastRoleModulesRepository.exists(id)) {
				ltMastRoleModulesRepository.delete(id);
			}
			

		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			status=ltMastCommonMessageService.getCodeAndMessage(ENTITY_CANNOT_DELETE);
			return new ResponseEntity<Status>(status,HttpStatus.OK);
		}
		 catch (Exception e) {
				throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		status=ltMastCommonMessageService.getCodeAndMessage(DELETE_SUCCESSFULLY);
		return new ResponseEntity<Status>(status,HttpStatus.OK);
	}

}