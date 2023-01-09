package com.lonar.UserManagement.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.common.ServiceException;
import com.lonar.UserManagement.web.model.LtMastModules;
import com.lonar.UserManagement.web.repository.LtMastModulesRepository;

@Component
@PropertySource(value = "classpath:queries/moduleMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastModulesDaoImpl implements LtMastModulesDao {

	@Autowired
	LtMastModulesRepository ltMastModulesRepository;
	
	@PersistenceContext(name = "em")
	private EntityManager em;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	@Transactional
	@Override
	public List<LtMastModules> findByModuleName(String moduleName,Long companyId)
			throws Exception {
		     String sqlQuery = env.getProperty("findByModuleName");
		     return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleName.toUpperCase()+"%", companyId}, 
					 new RowMapper<LtMastModules>(){
						@Override
						public LtMastModules mapRow(ResultSet rs, int row)
								throws SQLException {
							LtMastModules modules=new LtMastModules();
							modules.setModuleId(rs.getLong("MODULE_ID"));
							modules.setModuleName(rs.getString("MODULE_NAME"));
							return modules;
						}
			   
		   });
	
	}

	@Override
	public List<LtMastModules> findByModuleUrl(String moduleUrl,Long companyId)
			throws Exception {
		  String sqlQuery = env.getProperty("findByModuleUrl");
		   return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleUrl.toUpperCase()+"%",companyId }, 
					 new RowMapper<LtMastModules>(){
						@Override
						public LtMastModules mapRow(ResultSet rs, int row)
								throws SQLException {
							LtMastModules modules=new LtMastModules();
							modules.setModuleId(rs.getLong("MODULE_ID"));
							modules.setModuleName(rs.getString("MODULE_NAME"));
							modules.setSequenceNumber(rs.getLong("SEQUENCE_NUMBER"));
							return modules;
						}
		   });
		
		
	}

	@Override
	public List<LtMastModules> findInModuleId(List<Long> moduleid)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LtMastModules> findAllActive(Long companyId) throws Exception {
		  String sqlQuery = env.getProperty("findAllActive");
		   return jdbcTemplate.query(sqlQuery,new Object[]{ companyId }, new RowMapper<LtMastModules>(){
						@Override
						public LtMastModules mapRow(ResultSet rs, int row)
								throws SQLException {
							LtMastModules modules=new LtMastModules();
							modules.setModuleId(rs.getLong("MODULE_ID"));
							modules.setModuleName(rs.getString("MODULE_NAME"));
							return modules;
						}
			   
		   });
	}

	@Override
	public List<LtMastModules> findByActiveLikeModuleName(String moduleName,Long companyId)
			throws Exception {
			String sqlQuery = env.getProperty("findByActiveLikeModuleName");
			return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleName.toLowerCase()+"%",companyId }, 
					 new RowMapper<LtMastModules>(){
						@Override
						public LtMastModules mapRow(ResultSet rs, int row)
								throws SQLException {
							LtMastModules modules=new LtMastModules();
							modules.setModuleId(rs.getLong("MODULE_ID"));
							modules.setModuleName(rs.getString("MODULE_NAME"));
							modules.setModuleDesc(rs.getString("MODULE_DESC"));
							modules.setModuleUrl(rs.getString("MODULE_URL"));
							modules.setSequenceNumber(rs.getLong("SEQUENCE_NUMBER"));
							return modules;
						}
			   
		   });
	}

	@Override
	public List<LtMastModules> findByLikeModuleName(String moduleName)
			throws Exception {
		  String sqlQuery = env.getProperty("findByLikeModuleName");
		   return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleName.toLowerCase()+"%" }, 
					 new RowMapper<LtMastModules>(){
						@Override
						public LtMastModules mapRow(ResultSet rs, int row)
								throws SQLException {
							LtMastModules modules=new LtMastModules();
							modules.setModuleId(rs.getLong("MODULE_ID"));
							modules.setModuleName(rs.getString("MODULE_NAME"));
							return modules;
						}
		   });
	}

	@Override
	public LtMastModules save(LtMastModules ltMastModules) throws Exception 
	{
		return ltMastModulesRepository.save(ltMastModules);
		/*if(ltMastModules.getModuleId()!=null)
			return true;
			else
				return false;*/
	}

	
	
	@Override
	public List<LtMastModules> findByModuleCode(String moduleCode,Long companyId) throws Exception {
		String sqlQuery = env.getProperty("findLtMastModulesActiveLikeModuleCode");
		return jdbcTemplate.query(sqlQuery,new Object[]{ "%"+moduleCode.trim().toUpperCase()+"%",companyId }, 
				 new RowMapper<LtMastModules>(){
					@Override
					public LtMastModules mapRow(ResultSet rs, int row)
							throws SQLException {
						LtMastModules modules=new LtMastModules();
						modules.setModuleId(rs.getLong("MODULE_ID"));
						modules.setModuleName(rs.getString("MODULE_CODE"));
						modules.setModuleDesc(rs.getString("MODULE_NAME"));
						modules.setModuleUrl(rs.getString("MODULE_URL"));
						return modules;
					}
		   
	   });
	}

	@Override
	public List<LtMastModules> findByModuleSequence(Long sequenceNumber,Long companyId) throws Exception {
		String sqlQuery = env.getProperty("findLtMastModulesActiveLikeModuleSequence");
		return jdbcTemplate.query(sqlQuery,new Object[]{ sequenceNumber,companyId }, 
				 new RowMapper<LtMastModules>(){
					@Override
					public LtMastModules mapRow(ResultSet rs, int row)
							throws SQLException {
						LtMastModules modules=new LtMastModules();
						modules.setModuleId(rs.getLong("MODULE_ID"));
						modules.setModuleName(rs.getString("MODULE_CODE"));
						modules.setModuleDesc(rs.getString("MODULE_NAME"));
						modules.setSequenceNumber(rs.getLong("SEQUENCE_NUMBER"));
						return modules;
					}
		   
	   });
	}

	@Override
	public Long getCount(LtMastModules input,Long companyId) {
		String query = env.getProperty("getCountOfModule");
			
		String seq=null;
		if(input.getSequenceNumber()!=null && !input.getSequenceNumber().equals("")) 
		{seq="%"+input.getSequenceNumber()+"%";}
		   
		String code=null;
		if(input.getModuleCode()!=null && !input.getModuleCode().equals("")) 
		{code="%"+input.getModuleCode().trim().toUpperCase()+"%";}
		   
		String name=null;
		if(input.getModuleName()!=null && !input.getModuleName().equals("")) 
		{name="%"+input.getModuleName().trim().toUpperCase()+"%";}
		
		String group=null;
		if(input.getModuleGroup()!=null && !input.getModuleGroup().equals("")) 
		{group="%"+input.getModuleGroup().trim().toUpperCase()+"%";}
		 
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,seq,code,name,group}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastModules> getModuleData(LtMastModules input,Long companyId) 
	{
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{ input.setColumnNo(17); }
		
		String seq=null;
		if(input.getSequenceNumber()!=null && !input.getSequenceNumber().equals("")) 
		{seq="%"+input.getSequenceNumber()+"%";}
		   
		String code=null;
		if(input.getModuleCode()!=null && !input.getModuleCode().equals("")) 
		{code="%"+input.getModuleCode().trim().toUpperCase()+"%";}
		   
		String name=null;
		if(input.getModuleName()!=null && !input.getModuleName().equals("")) 
		{name="%"+input.getModuleName().trim().toUpperCase()+"%";}
		
		String group=null;
		if(input.getModuleGroup()!=null && !input.getModuleGroup().equals("")) 
		{group="%"+input.getModuleGroup().trim().toUpperCase()+"%";}
		if(input.getColumnNo()==0)	
		{
			input.setColumnNo(2);
		}
			String query = env.getProperty("getModuleData");
			
			return (List<LtMastModules>) 
					jdbcTemplate.query(query , new Object[]{companyId,seq,code,name,group,
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getLength() + input.getStart(),input.getStart()+1
							},
				 new  BeanPropertyRowMapper<LtMastModules>(LtMastModules.class));
			
	}

	@Override
	public LtMastModules getLtMastModulesByID(Long moduleId) throws Exception {
		String query = env.getProperty("getLtMastModulesByID");
		
		List<LtMastModules> list=   jdbcTemplate.query(query, new Object[]{ moduleId}, 
		 new BeanPropertyRowMapper<LtMastModules>(LtMastModules.class)); 
		if(list.isEmpty())
			return null;
		else
		return list.get(0);
	}

	@Override
	public List<LtMastModules> getLikeModuleNameAndUser(Long userId, String moduleName) throws ServiceException {
		String query = env.getProperty("getLikeModuleNameAndUserId");
		
		List<LtMastModules> list=   jdbcTemplate.query(query, new Object[]{ userId,"%"+moduleName.toUpperCase()+"%"}, 
		 new BeanPropertyRowMapper<LtMastModules>(LtMastModules.class));
		return list; 
	}

	
}
