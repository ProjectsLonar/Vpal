package com.lonar.UserManagement.web.service;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastModulesDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.CustomeDataTable;
import com.lonar.UserManagement.web.model.LtMastModules;
import com.lonar.UserManagement.web.model.Status;
import com.lonar.UserManagement.web.repository.LtMastModulesRepository;

@Service
public class LtMastModulesServiceImpl implements LtMastModulesService,CodeMaster  {
	
	@Autowired
	private LtMastModulesDao ltMastModuleDao;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	
	@Transactional
	@Override
	public List<LtMastModules> findByModuleName(String moduleName,Long companyId)
			throws Exception {
		List<LtMastModules> list = ltMastModuleDao.findByModuleName(moduleName,companyId) ;
		return list;
	}

	@Transactional
	@Override
	public List<LtMastModules> findByModuleUrl(String moduleUrl,Long companyId) throws Exception {
		return ltMastModuleDao.findByModuleUrl(moduleUrl,companyId);
	}

	@Transactional
	@Override
	public List<LtMastModules> findInModuleId(List<Long> ltP2pUserRolesList)
			throws Exception {
		return null;
	}

	@Transactional
	@Override
	public List<LtMastModules> findAllActive(Long companyId) throws Exception {
		
		
		return ltMastModuleDao.findAllActive(companyId) ;
	}

	@Transactional
	@Override
	public List<LtMastModules> findByActiveLikeModuleName(String moduleName,Long companyId)
			throws Exception {
		return ltMastModuleDao.findByActiveLikeModuleName(moduleName,companyId);
	}

	@Transactional
	@Override
	public List<LtMastModules> findByLikeModuleName(String moduleName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status save(LtMastModules ltMastModules) throws Exception
	{
		Status status = new Status();
		ltMastModules.setCreationDate(new Date());
		ltMastModules.setLastUpdateDate(new Date());
		String stat = checkDuplicate(ltMastModules);
		if(stat.equals("null"))
		{
			 ltMastModules =ltMastModulesRepository.save(ltMastModules);
			if(ltMastModules.getModuleId()!=null) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if( status.getMessage()==null)
			{
				status.setCode(INSERT_SUCCESSFULLY);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
			status.setData(ltMastModules.getModuleId());
		   }else {
			   status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				if( status.getMessage()==null)
				{
					status.setCode(INSERT_FAIL);
					status.setMessage("Error in finding message! The action is completed unsuccessfully.");
				}
		   }
		}
		else {
			status.setMessage(stat);
			status.setCode(EXCEPTION);
		}
		return status;
	}

	@Transactional
	private LtMastModules saveModule(LtMastModules ltMastModules) throws Exception {
		LtMastModules ltMastModule = ltMastModuleDao.save(ltMastModules);
		return ltMastModule;
	}
	
	public String checkDuplicate(LtMastModules ltMastModules) throws Exception {
		List<LtMastModules> ltMastModulesList; 
		ltMastModulesList = ltMastModuleDao.findByModuleCode(ltMastModules.getModuleCode(),ltMastModules.getCompanyId());
		if (ltMastModulesList.size()>0)  {
			if(ltMastModulesList.get(0).getModuleId().toString()!=null
					&& !ltMastModulesList.get(0).getModuleId().equals(ltMastModules.getModuleId())) {
				return "Module code already exists";
			}
		}
		
		ltMastModulesList =ltMastModuleDao.findByModuleName(ltMastModules.getModuleName(),ltMastModules.getCompanyId());
		if (ltMastModulesList.size()>0) {
			if(	ltMastModulesList.get(0).getModuleId().toString()!=null
					&& !ltMastModulesList.get(0).getModuleId().equals(ltMastModules.getModuleId())) {
				return "Module name already exists";
			}
		}
		ltMastModulesList = ltMastModuleDao.findByModuleSequence(ltMastModules.getSequenceNumber(),ltMastModules.getCompanyId());
		if (ltMastModulesList.size()>0)  {
			if(	ltMastModulesList.get(0).getModuleId().toString()!=null
					&& !ltMastModulesList.get(0).getModuleId().equals(ltMastModules.getModuleId())) {
				return "Module sequence already exists";
			}
		}
		ltMastModulesList = ltMastModuleDao.findByModuleUrl(ltMastModules.getModuleUrl(),ltMastModules.getCompanyId());
		if (ltMastModulesList.size()>0)  {
			if(	ltMastModulesList.get(0).getModuleId().toString()!=null
					&& !ltMastModulesList.get(0).getModuleId().equals(ltMastModules.getModuleId())) {
				return "Module URL already exists";
			}
		}
		return "null";
	}

	/*@Override
	public Long getCount(LtMastModules input) throws Exception  {
		return ltMastModuleDao.getCount(input);
	}

	@Override
	public List<LtMastModules> getModuleData(LtMastModules input) throws Exception {
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		
		return ltMastModuleDao.getModuleData(input);
	}*/

	@Override
	public CustomeDataTable getDataTable(LtMastModules input,Long companyId) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		Long count=ltMastModuleDao.getCount(input,companyId);
		customeDataTable.setRecordsTotal(count);
	    customeDataTable.setRecordsFiltered(count);
	    List<LtMastModules> modulelList= ltMastModuleDao.getModuleData(input,companyId);
	    customeDataTable.setData(modulelList);
	    return customeDataTable;
	}

	@Override
	public Status update(LtMastModules ltMastModules) throws Exception {
		Status status = new Status();
		String stat = checkDuplicate(ltMastModules);
		if(stat.equals("null"))
		{
			 ltMastModules =ltMastModulesRepository.save(ltMastModules);
			if(ltMastModules.getModuleId()!=null) {
				status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
				if( status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action is completed successfully.");
				}
				status.setData(ltMastModules.getModuleId());
			   }else {
				   status=ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
					if( status.getMessage()==null)
					{
						status.setCode(FAIL);
						status.setMessage("Error in finding message! The action is completed unsuccessfully.");
					}
			   }
		}
		else {
			status.setMessage(stat);
			status.setCode(EXCEPTION);
		}
		return status;
	}

	@Override
	public LtMastModules getLtMastModulesByID(Long moduleId) throws Exception {
		return ltMastModuleDao.getLtMastModulesByID(moduleId);
	}

	@Override
	public List<LtMastModules> getLikeModuleNameAndUser(Long userId, String moduleName) throws Exception {
		return ltMastModuleDao.getLikeModuleNameAndUser(userId,moduleName);
	}

	@Override
	public List<LtMastModules> findAll(DataTablesInput companyId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
