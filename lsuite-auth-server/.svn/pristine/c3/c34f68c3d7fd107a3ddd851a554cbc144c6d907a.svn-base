package com.lonar.UserManagement.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.UserManagement.web.model.CommonMasterWithValue;
import com.lonar.UserManagement.web.model.LtMastComnMaster;
import com.lonar.UserManagement.web.model.LtMastComnMasterValues;

@Component
@PropertySource(value = "classpath:queries/commonMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastComnMasterDaoImpl implements LtMastComnMasterDao 
{

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	@Transactional
	public List<LtMastComnMaster> findByMasterName(String masterName) throws Exception
	{
		String query = env.getProperty("findByMasterName");
		
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{ "%"+masterName.trim().toUpperCase()+"%" }, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
			 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> findByMasterDesc(String masterDesc) throws Exception
	{
		String query = env.getProperty("findByMasterDesc");
		
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{ "%"+masterDesc.toLowerCase()+"%" }, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
			 
		return list;
	}

	@Override
	public List<LtMastComnMaster> findAllActive() throws Exception
	{
		String query = env.getProperty("findAllActive");
		
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{  }, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
			 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastComnMaster> findActiveLikeName(String masterName) throws Exception
	{
		String query = env.getProperty("findLtMastComnMasterActiveLikeName");
				
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{ masterName.trim().toUpperCase() }, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
		return list;
	}

	//--------------------------------------------------------------------------------------
	@Override
	@Transactional
	public CommonMasterWithValue getById(String id) throws Exception 
	{
		String query = env.getProperty("getById");
		CommonMasterWithValue commonMasterWithValue=new CommonMasterWithValue();
		
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{id}, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
		
		commonMasterWithValue.setLtMastComnMaster(list.get(0));
		
		String query1 = env.getProperty("getById2");
		
		List<LtMastComnMasterValues> valueList=   jdbcTemplate.query(query1, new Object[]{id}, 
					 new BeanPropertyRowMapper<LtMastComnMasterValues>(LtMastComnMasterValues.class)); 
		
		commonMasterWithValue.setLtMastComnMasterValues(valueList);
			 
		return commonMasterWithValue;
	}

	@Override
	public List<LtMastComnMaster> getDataTable(LtMastComnMaster input) throws Exception 
	{
		String query = env.getProperty("getLtMastComnMasterDataTable");
		
			   String masterName=null;
			   if(input.getMasterName()!=null)
			   {masterName="%"+input.getMasterName().toUpperCase()+"%";}
			   
			   String masterDesc=null;
			   if(input.getMasterDesc()!=null)
			   {masterDesc="%"+input.getMasterDesc().toUpperCase()+"%";}
			   else{
				   masterDesc="%";
			   }
			   
			   String status=null;
			   if(input.getStatus()!=null) 
			   {status="%"+input.getStatus().toUpperCase()+"%";}
				
				if(input.getStDate() == null || input.getStDate().trim().equals(""))
				{
					input.setStDate(null);
				}
				if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
				{
					input.setEnDate(null);
				}
				
				
		return (List<LtMastComnMaster>) 
				jdbcTemplate.query(query , new Object[]{masterName,masterDesc,status,
						input.getStDate(),input.getEnDate(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getLength() +input.getStart(),input.getStart()+1
						},
			 new  BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class));
	}

	@Override
	public Long getCount(LtMastComnMaster input) throws Exception 
	{
		String query = env.getProperty("getCountLtMastComnMaster");
		
			   String masterName=null;
			   if(input.getMasterName()!=null)
			   {masterName="%"+input.getMasterName()+"%";}
			   
			   String masterDesc=null;
			   if(input.getMasterDesc()!=null)
			   {masterDesc="%"+input.getMasterDesc()+"%";}
			   else{
				   masterDesc="%";
			   }
			   
			   String status=null;
			   if(input.getStatus()!=null) 
			   {status="%"+input.getStatus()+"%";}
				
				if(input.getStDate() == null || input.getStDate().trim().equals(""))
				{
					input.setStDate(null);
				}
				if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
				{
					input.setEnDate(null);
				}
			
				String count  = (String)getJdbcTemplate().queryForObject(
						query, new Object[] {masterName,masterDesc,status,
								input.getStDate(),input.getEnDate()}, String.class);

				return Long.parseLong(count);
	}

	@Override
	public LtMastComnMaster getLtMastComnMasterByID(Long commonMasterId) throws Exception
	{
		String query = env.getProperty("getLtMastComnMasterByID");
		
		List<LtMastComnMaster> list=   jdbcTemplate.query(query, new Object[]{ commonMasterId }, 
					 new BeanPropertyRowMapper<LtMastComnMaster>(LtMastComnMaster.class)); 
		return list.get(0);
	}

	

	

}
