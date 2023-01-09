package com.lonar.UserManagement.web.service;

import java.rmi.ServerException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastRolesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.LtMastRoles;
import com.lonar.UserManagement.web.model.RoleWithModule;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastRoleModulesRepository;
import com.lonar.UserManagement.web.repository.LtMastRolesRepository;

@Service
public class LtMastRolesServiceImpl implements LtMastRolesService,CodeMaster{

	
	@Autowired
	private LtMastRolesDao ltMastRolesDao;
	
	@Autowired
	LtMastRolesRepository ltMastRolesRepository;
	
	@Autowired
	LtMastRoleModulesRepository ltMastRoleModulesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastRoles> findByRole(String rolename,Long companyId) throws ServerException {
		return ltMastRolesDao.findByRole(rolename,companyId);
	}

	@Override
	public List<LtMastRoles> findInRoleId(List<Long> roleID) throws ServerException {
		return null;
	}

	@Override
	public List<LtMastRoles> findAllActive(Long companyId) throws ServerException {
		return ltMastRolesDao.findAllActive(companyId);
	}

	@Override
	public List<LtMastRoles> findByActiveLikeRoleName(String roleName,Long companyId)
			throws ServerException {
		return ltMastRolesDao.findByActiveLikeRoleName(roleName,companyId);
	}

	@Override
	public List<LtMastRoles> findByLikeRoleName(String roleName,Long companyId)
			throws ServerException {
		return ltMastRolesDao.findByLikeRoleName(roleName,companyId);
	}

/*	@Override
	public Long getLtMastRolesCount(LtMastRoles input) throws Exception {
		return ltMastRolesDao.getLtMastRolesCount(input);
	}
	@Override
	public List<LtMastRoles> getLtMastRolesDataTable(LtMastRoles input) throws Exception {
		return ltMastRolesDao.getLtMastRolesDataTable(input);
	}*/

	@Override
	public CustomeDataTable getDataTable(LtMastRoles input,Long companyId) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		Long count = ltMastRolesDao.getLtMastRolesCount(input,companyId);
	    customeDataTable.setRecordsTotal(count);
	    customeDataTable.setRecordsFiltered(count);
		List<LtMastRoles> ltMastRolesList= ltMastRolesDao.getLtMastRolesDataTable(input,companyId);
		customeDataTable.setData(ltMastRolesList);
		return customeDataTable;
	}

	@Override
	@Transactional
	public ResponseEntity<Status> saveRole(LtMastRoles ltMastRoles) throws ServerException {
		Status status = new Status();
		ltMastRoles.setLastUpdateDate(new Date());
		ltMastRoles.setCreationDate(new Date());
		List<LtMastRoles> ltMastRolesList = ltMastRolesDao.findByRole(ltMastRoles.getRoleName(),ltMastRoles.getCompanyId());
		if (!ltMastRolesList.isEmpty() && (ltMastRoles.getRoleId() == null ? true
				: !ltMastRoles.getRoleId().equals(ltMastRolesList.get(0).getRoleId()))) {
			status.setCode(ROLE_NAME_PRESENT);
			status.setMessage("Role name already exists.");

			return new ResponseEntity<Status>(status, HttpStatus.OK);

		}
		
		
		
		
		ltMastRoles = ltMastRolesRepository.save(ltMastRoles);
		
		
		
		if(ltMastRoles.getRoleId()!=null) {
			 status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					//status.setCode(INSERT_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			status.setData(ltMastRoles.getRoleId());
		}else {
			 status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> updateRole(LtMastRoles ltMastRoles) throws ServerException {
		Status status = new Status();
		ltMastRoles.setLastUpdateDate(new Date());
		List<LtMastRoles> ltMastRolesList = ltMastRolesDao.findByRole(ltMastRoles.getRoleName(),ltMastRoles.getCompanyId());
		if (!ltMastRolesList.isEmpty() && !(ltMastRolesList.get(0).getRoleId().equals(ltMastRoles.getRoleId()))) {
			status.setCode(ROLE_NAME_PRESENT);
			status.setMessage("Role name already exists.");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		
		LtMastRoles ltP2pRoles1 =  ltMastRolesRepository.findOne(ltMastRoles.getRoleId());
		
		ltMastRoles = ltMastRolesRepository.save(ltMastRoles);
		
		LtMastRoles ltP2pRoles2 =  ltMastRolesRepository.findOne(ltMastRoles.getRoleId());
		if(ltMastRoles.getRoleId()!=null) {
			  status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(UPDATE_SUCCESSFULLY);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
			status.setData(ltMastRoles.getRoleId());
		}else {
			
			 status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(UPDATE_FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> saveRoleWithModule(RoleWithModule roleWithModule) throws ServerException {
		Status status = new Status();
		
			List<LtMastRoleModules> ltMastRoleModulesList = roleWithModule.getLtMastRoleModules();
			for (LtMastRoleModules ltMastRoleModules : ltMastRoleModulesList)
			{
				ltMastRoleModules.setCreationDate(new Date());
				ltMastRoleModules.setLastUpdateDate(new Date());
				ltMastRoleModules.setCreatedBy(ltMastRoleModules.getLastUpdateLogin());
				ltMastRoleModules.setLastUpdatedBy(ltMastRoleModules.getLastUpdateLogin());
				ltMastRoleModules = ltMastRoleModulesRepository.save(ltMastRoleModules);
				if(ltMastRoleModules.getRoleFuncId()==null) {
					status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
					return new ResponseEntity<Status>(status, HttpStatus.OK);
				}
			}
		status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@Override
	public LtMastRoles getRolesByID(Long id) throws ServerException {
		return ltMastRolesDao.getRolesByID(id);
	}

	@Override
	public List<LtMastRoles> findAll(Long companyId) throws ServerException {
		// TODO Auto-generated method stub
		return ltMastRolesDao.findAll(companyId);
	}
	
}
