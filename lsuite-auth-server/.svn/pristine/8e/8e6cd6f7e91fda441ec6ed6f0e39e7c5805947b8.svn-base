package com.lonar.UserManagement.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtModuleApprovals;
import com.lonar.UserManagement.web.repository.LtExpModuleApprovalsRepository;


@Component
@PropertySource(value = "classpath:queries/approverModuleQueries.properties", ignoreResourceNotFound = true)
public class LtModuleApprovalsDaoImpl implements LtModuleApprovalsDao
{
	@Autowired
	LtExpModuleApprovalsRepository ltExpModuleApprovalsRepository;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	@Autowired
	private Environment env;
	
	@Override
	public Long save(LtModuleApprovals ltExpModuleApprovals) throws Exception 
	{
		LtModuleApprovals moduleApprovals =ltExpModuleApprovalsRepository.save(ltExpModuleApprovals);
		if(moduleApprovals.getModuleApprovalId()!=null)
		{return moduleApprovals.getModuleApprovalId();}
		else
			return null;
	}

	@Override
	public boolean delete(Long moduleApprovalId) throws Exception
	{
		String query = env.getProperty("deleteLtExpModuleApprovals");
		int res=jdbcTemplate.update( query  ,moduleApprovalId);
		
		if(res!=0)
			return true;
		else
			return false;
		
	}



	@Override
	public String getByApprovalLevelAndModuleId(String approvalLevel,Long moduleApprovalId) throws Exception
	{
		String query = env.getProperty("getByApprovalLevelAndModuleId");
		
		List<LtModuleApprovals> list = jdbcTemplate.query(query , new Object[]{ approvalLevel,moduleApprovalId},
			 new  BeanPropertyRowMapper<LtModuleApprovals>(LtModuleApprovals.class));

		if(!list.isEmpty())
		return list.get(0).getApprovalRoleName();
		else
			return null;
	}



	@Override
	public List<LtModuleApprovals> getByExpenseHeaderId(Long divId) throws Exception
	{
		String query = env.getProperty("getByExpenseHeaderId");
		
		List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query, new Object[] { divId },
				new BeanPropertyRowMapper<LtModuleApprovals>(LtModuleApprovals.class));
		
		return ltExpModuleApprovalsList;
	}



	@Override
	public List<LtModuleApprovals> getByStatus(String status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public LtModuleApprovals getBymoduleApprovalId(Long moduleApprovalId) throws Exception {
		String query = env.getProperty("getBymoduleApprovalId1");
		
				 List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] {moduleApprovalId},
						 new BeanPropertyRowMapper<LtModuleApprovals> (LtModuleApprovals.class));
		
				 if(!ltExpModuleApprovalsList.isEmpty())
		return ltExpModuleApprovalsList.get(0);
				 else
					 return null;
	}



	@Override
	public boolean update(LtModuleApprovals ltExpModuleApprovals) throws Exception {
		
		String query = env.getProperty("updateLtExpModuleApprovals");
		int res=jdbcTemplate.update(query,
			        ltExpModuleApprovals.getModule(),ltExpModuleApprovals.getApprovalLevel(),
			        ltExpModuleApprovals.getApprovalRoleCode(),ltExpModuleApprovals.getApprovalRoleName(),
			        ltExpModuleApprovals.getApprovedByAnyone(), ltExpModuleApprovals.getDivisionId(),
			        ltExpModuleApprovals.getStartDate(),ltExpModuleApprovals.getEndDate(),
			        ltExpModuleApprovals.getLastUpdateDate(),ltExpModuleApprovals.getLastUpdateLogin(),
			        ltExpModuleApprovals.getLastUpdatedBy(), ltExpModuleApprovals.getRequiredLevel(),
			        ltExpModuleApprovals.getStatus(),
			        ltExpModuleApprovals.getIsDelete(),ltExpModuleApprovals.getModuleApprovalId());
			        
			if(res!=0)           
			      return true;
			else
				return false;
	}



	@Override
	public List<LtModuleApprovals> getModuleApproval(Long companyId, LtModuleApprovals input) throws Exception 
	{ 
		String status=null;
	   if(input.getStatus()!=null) 
	   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
	   
	   String module=null;
	   if(input.getModule()!=null)
	   {module="%"+input.getModule().toUpperCase()+"%";}
	   
	   String roleName=null;
	   if(input.getApprovalRoleName()!=null)
	   {roleName="%"+input.getApprovalRoleName().trim().toUpperCase()+"%";}
	   
	   String roleCode=null;
	   if(input.getApprovalRoleCode()!=null)
	   {roleCode="%"+input.getApprovalRoleCode().trim().toUpperCase()+"%";}
	   
		String level=null;
		if(input.getApprovalLevel()!=null)
		{level="%"+input.getApprovalLevel().trim().toUpperCase()+"%";}

		
		
		if(input.getStDate() == null || input.getStDate().trim().equals(""))
		{
			input.setStDate(null);
		}
		if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		{
			input.setEnDate(null);
		}
	
		String division=null;
		if(input.getDivisionName()!=null)
		{division="%"+input.getDivisionName().trim()+"%";}
		
		String query = env.getProperty("getModuleApproval");
		
			  
		return (List<LtModuleApprovals>) 
				jdbcTemplate.query(query , new Object[]{companyId,status,module,roleName,roleCode,level,
						input.getStDate(),input.getEnDate(),division,
						
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getLength() + input.getStart(),input.getStart()+1
						},
			 new  BeanPropertyRowMapper<LtModuleApprovals>(LtModuleApprovals.class));
		
	}

	@Override
	public Long getCount(Long companyId, LtModuleApprovals input) throws Exception 
	{
		String query = env.getProperty("getCountOfModuleApprovals");
		
		
		 String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   String module=null;
		   if(input.getModule()!=null)
		   {module="%"+input.getModule().trim().toUpperCase()+"%";}
		   
		   String roleName=null;
		   if(input.getApprovalRoleName()!=null)
		   {roleName="%"+input.getApprovalRoleName().trim().toUpperCase()+"%";}
		   
		   String roleCode=null;
		   if(input.getApprovalRoleCode()!=null)
		   {roleCode="%"+input.getApprovalRoleCode().trim().toUpperCase()+"%";}
		   
			String level=null;
			if(input.getApprovalLevel()!=null)
			{level="%"+input.getApprovalLevel().trim().toUpperCase()+"%";}
	
		
			
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			String division=null;
			if(input.getDivisionName()!=null)
			{division="%"+input.getDivisionName().trim().toUpperCase()+"%";}
		
	
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,status,module,roleName,roleCode,level,
						input.getStDate(),input.getEnDate(),division }, String.class);
		return Long.parseLong(count);
	}

	@Override 
	public boolean checkForDuplicate(LtModuleApprovals ltExpModuleApprovals) throws Exception 
	{
		String query = env.getProperty("checkForDuplicateLtExpModuleApprovals");
	
				 List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
						 {ltExpModuleApprovals.getModule(),ltExpModuleApprovals.getApprovalLevel(),
								 ltExpModuleApprovals.getApprovalRoleCode().toUpperCase(),ltExpModuleApprovals.getDivisionId(),ltExpModuleApprovals.getStatus()},
						 new BeanPropertyRowMapper<LtModuleApprovals> (LtModuleApprovals.class));
				 if(  ltExpModuleApprovalsList.isEmpty()) {
					 return true; 
				}else if(ltExpModuleApprovalsList.get(0).getModuleApprovalId().equals(ltExpModuleApprovals.getModuleApprovalId()))
				{ return true;
				 }
				else return false;
	}

	@Override
	public LtModuleApprovals getByLevelAndHeaderId(String level, Long moduleApprovalId) throws Exception {
		String query = env.getProperty("getByLevelAndHeaderId");
		
		List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
			 {level,moduleApprovalId},
				 new BeanPropertyRowMapper<LtModuleApprovals> (LtModuleApprovals.class));
		
		if(!ltExpModuleApprovalsList.isEmpty())
			 return ltExpModuleApprovalsList.get(0);
		else
			 return new LtModuleApprovals();
	}

	
	@Override
	public List<LtModuleApprovals> getExpenseApprovalLevel(Long expenseHeaderId) throws Exception 
	{
		String query = env.getProperty("getExpenseApprovalLevel");
		
		List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
				 {expenseHeaderId,expenseHeaderId},
		 new BeanPropertyRowMapper<LtModuleApprovals> (LtModuleApprovals.class));
		 return ltExpModuleApprovalsList;
	}

	@Override
	public boolean checkForDuplicateForUpdate(LtModuleApprovals ltExpModuleApprovals) throws Exception {

		String query = env.getProperty("checkForDuplicateLtExpModuleApprovals");

				 List<LtModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
						 {ltExpModuleApprovals.getModule(),ltExpModuleApprovals.getApprovalLevel(),
								 ltExpModuleApprovals.getApprovalRoleCode(),ltExpModuleApprovals.getDivisionId(),ltExpModuleApprovals.getStatus()},
						 new BeanPropertyRowMapper<LtModuleApprovals> (LtModuleApprovals.class));
				 if(ltExpModuleApprovalsList.isEmpty())
				 {	 
					 return true; 
				}else if(ltExpModuleApprovalsList.get(0).getModuleApprovalId().equals(ltExpModuleApprovals.getModuleApprovalId()))
				 {
					 return true;
				 }else return false;
	}




}
