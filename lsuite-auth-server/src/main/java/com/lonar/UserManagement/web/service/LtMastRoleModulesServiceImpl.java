package com.lonar.UserManagement.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.common.BusinessException;
import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.dao.LtMastRoleModulesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastRoleModules;
import com.lonar.UserManagement.web.model.Menu;
import com.lonar.UserManagement.web.model.ModuleList;
import com.lonar.UserManagement.web.model.RoleModule;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastRoleModulesRepository;

@Service
public class LtMastRoleModulesServiceImpl implements LtMastRoleModulesService,CodeMaster {
	@Autowired
	LtMastRoleModulesDao ltMastRoleModulesDao;

	@Autowired
	LtMastRoleModulesRepository ltMastRoleModulesRepository;
	 
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastRoleModules> findByRoleIdANDModuleId(Long roleID, Long moduleID) throws BusinessException{
		return ltMastRoleModulesDao.findByRoleIdANDModuleId(roleID, moduleID);
	}

	@Override
	public List<Long> findByRoleIdOutputModuleID(Long roleID) throws BusinessException{
		return ltMastRoleModulesDao.findByRoleIdOutputModuleID(roleID);
	}

	@Override
	public List<LtMastRoleModules> findByUserIdANDRoleId(List<Long> roleId, List<Long> moduleId) throws BusinessException{
		return ltMastRoleModulesDao.findByUserIdANDRoleId(roleId, moduleId);
	}

	@Override
	public List<LtMastRoleModules> findInRoleIdAndModuleIdWithInDate(List<Long> roleId, List<Long> moduleId) throws BusinessException{
		// TODO Auto-generated method stub
		return ltMastRoleModulesDao.findInRoleIdAndModuleIdWithInDate(roleId, moduleId);
	}

	@Override
	public List findByRoleIdWithUserId() throws BusinessException{
		// TODO Auto-generated method stub
		return ltMastRoleModulesDao.findByRoleIdWithUserId();
	}

	@Override
	public List<Menu> findMenu(Long userID) throws BusinessException{
		return ltMastRoleModulesDao.findMenu(userID);
	}

	@Override
	public List<LtMastRoleModules> findAllActive() throws BusinessException{
		return ltMastRoleModulesDao.findAllActive();
	}

	@Override
	public List<RoleModule> findByRoleIdGetModuleName(Long roleId) throws BusinessException{
		return ltMastRoleModulesDao.findByRoleIdGetModuleName(roleId);
	}

	@Override
	public List<LtMastRoleModules> findByRoleId(Long roleId) throws BusinessException{
	
		return ltMastRoleModulesDao.findByRoleId(roleId);
	}

	@Override
	public List<ModuleList> getModuleListWithUserId(Long userId) throws BusinessException{
		return ltMastRoleModulesDao.getModuleListWithUserId(userId);
	}

	@Override
	public List<ModuleList> getModuleListWithRoleId(List<Long> roleId) throws BusinessException{
		return ltMastRoleModulesDao.getModuleListWithRoleId(roleId);
	}

	@Override
	public List<Menu> findMenuWithModuleName(Long userId, String moduleName) throws BusinessException {
		return ltMastRoleModulesDao.findMenuWithModuleName(userId, moduleName);
	}

	@Override
	public List<LtMastRoleModules> getByModuleId(Long moduleId) throws BusinessException {
		return ltMastRoleModulesDao.getByModuleId(moduleId);
	}

	@Override
	public CustomeDataTable getLtMastUsersDataTable(LtMastRoleModules input) {
		/*SELECT rl_mdl.ROLE_FUNC_ID, mdl.MODULE_NAME, rol.ROLE_NAME, rl_mdl.CREATE_FLAG, 
	    rl_mdl.READ_FLAG, rl_mdl.EDIT_FLAG, rl_mdl.DELETE_FLAG 
	 FROM LT_MAST_ROLE_MODULES rl_mdl, LT_MAST_ROLES rol, LT_MAST_MODULES mdl
	 WHERE rl_mdl.ROLE_ID = rol.ROLE_ID 
	 AND rl_mdl.MODULE_ID = mdl.MODULE_ID */
		return null;
	}

	@Override
	public Status save(LtMastRoleModules ltMastRoleModules) throws BusinessException {
		Status status = new Status();
		ltMastRoleModules.setCreatedBy(ltMastRoleModules.getLastUpdateLogin());
		ltMastRoleModules.setLastUpdatedBy(ltMastRoleModules.getLastUpdateLogin());
		ltMastRoleModules.setLastUpdateLogin(ltMastRoleModules.getLastUpdateLogin());
		ltMastRoleModules.setCreationDate(new Date());
		ltMastRoleModules.setLastUpdateDate(new Date());
		if(ltMastRoleModulesDao.checkForDuplicate(ltMastRoleModules)) {
		ltMastRoleModules = ltMastRoleModulesRepository.save(ltMastRoleModules);
		if(ltMastRoleModules.getRoleFuncId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		}else {
			status.setCode(FAIL);
			status.setMessage("Module already present for the role.");
		}
		return status;
	}

	@Override
	public Status update(LtMastRoleModules ltMastRoleModules) throws ServiceException {
		Status status = new Status();
		
		ltMastRoleModules.setLastUpdatedBy(ltMastRoleModules.getLastUpdateLogin());
		ltMastRoleModules.setLastUpdateDate(new Date());
		ltMastRoleModules = ltMastRoleModulesRepository.save(ltMastRoleModules);
		if(ltMastRoleModules.getRoleFuncId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}else {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed unsuccessfully.");
			}
		}
		
		return status;
	}
}
