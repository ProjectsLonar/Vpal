package com.lonar.UserManagement.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastUserRolesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastUserRoles;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.model.UserMolule;
import com.lonar.UserManagement.web.model.UserRoleWithRoleName;
import com.lonar.UserManagement.web.repository.LtMastUserRolesRepository;

@Service
public class LtMastUserRolesServiceImpl implements LtMastUserRolesService,CodeMaster {
	@Autowired
	LtMastUserRolesDao ltMastUserRolesDao;

	@Autowired
	LtMastUserRolesRepository ltMastUserRolesRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Override
	public List<LtMastUserRoles> findByUserIdAndRoleId(Long userID, Long roleID) throws Exception{
		// TODO Auto-generated method stub
		return ltMastUserRolesDao.findByUserIdAndRoleId(userID, roleID);
	}

	/*@Override
	public List<Long> findByUserId(Long userID) throws Exception{
		// TODO Auto-generated method stub
		return ltMastUserRolesDao.findByUserId(userID);
	}

	@Override
	public List findByRoleIdWithUserId() throws Exception{
		// TODO Auto-generated method stub
		return ltMastUserRolesDao.findByRoleIdWithUserId();
	}
*/
	@Override
	public List<UserMolule> findByUserIdGetRoleName(Long userId) throws Exception{
		return ltMastUserRolesDao.findByUserIdGetRoleName(userId);
	}

	@Override
	public List<LtMastUserRoles> findAllActive() throws Exception{
		return ltMastUserRolesDao.findAllActive();
	}

	@Override
	public List<LtMastUserRoles> findByUserIdWithList(Long userID) throws Exception{
		return ltMastUserRolesDao.findByUserIdWithList(userID);
	}

	@Override
	public List<UserRoleWithRoleName> findListWithRoleNameModuleName(Long userId) throws Exception{
		return ltMastUserRolesDao.findListWithRoleNameModuleName(userId);
	}

	@Override
	public List<LtMastUserRoles> findByRoleId(Long roleId) throws Exception{
		return ltMastUserRolesDao.findByRoleId(roleId);
	}

	@Override
	public List<String> findAllActiveRoleName(Long userID) throws Exception{
		return ltMastUserRolesDao.findAllActiveRoleName(userID);
	}

	@Override
	public List<LtMastUserRoles> getByUserId(Long userId) throws Exception {
		return ltMastUserRolesDao.getByUserId(userId);
	}

	@Override
	public List<Long> findByUserId(Long userID) throws Exception {
		return null;
	}

	@Override
	public List findByRoleIdWithUserId() throws Exception {
		return null;
	}

	@Override
	public CustomeDataTable getDataTable(LtMastUserRoles input) {
		/*SELECT usr_rl.USER_ROLE_ID, usr.USER_ID, usr_rl.ROLE_ID, usr.USER_NAME, 
		CONCAT( CONCAT (emp.FIRST_NAME, ' '), emp.LAST_NAME) EMP_NAME,
		 rol.ROLE_NAME 
		FROM LT_MAST_USER_ROLES usr_rl,  LT_MAST_USERS usr , LT_MAST_EMPLOYEES emp, LT_MAST_ROLES rol
		WHERE usr_rl.USER_ID = usr.USER_ID 
		AND usr.EMPLOYEE_ID = emp.EMPLOYEE_ID
		AND rol.ROLE_ID = usr_rl.ROLE_ID
		AND usr.EMPLOYEE_ID > 0; */
		
		return null;
	}

	@Override
	public Status saveUserRole(LtMastUserRoles userRole) throws Exception {
		Status status = new Status();
		userRole.setLastUpdateDate(new Date());
		userRole.setCreationDate(new Date());
		userRole.setCreatedBy(userRole.getLastUpdateLogin());
		userRole.setLastUpdatedBy(userRole.getLastUpdateLogin());
		
		if(ltMastUserRolesDao.chkDuplicate(userRole)) {
		LtMastUserRoles usersRoles = ltMastUserRolesRepository.save(userRole);
		if(usersRoles.getUserRoleId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(FAIL);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return status;
		}
		}else {
			status.setCode(FAIL);
			status.setMessage("Same role exists for the user.");
		}
		
		return status;
	}

	@Override
	public List<LtMastUserRoles> getRoleByUserId(Long userId) throws Exception {
		return ltMastUserRolesDao.getRoleByUserId(userId);
	}

	@Override
	public Status updateUserRole(LtMastUserRoles userRole) throws Exception {
		Status status = new Status();
		userRole.setLastUpdateDate(new Date());
		userRole.setLastUpdatedBy(userRole.getLastUpdateLogin());
		LtMastUserRoles usersRoles = ltMastUserRolesRepository.save(userRole);
		if(usersRoles.getUserRoleId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		}
		else
		{
			status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if( status.getMessage()==null)
			{
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			return status;
		}
		
		return status;
	}

	@Override
	public LtMastUserRoles getUserRoleById(Long userId) throws Exception {
		return ltMastUserRolesDao.getUserRoleById(userId);
	}

}
