package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastBusinessNature;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastBusinessNatureRepository;

@Repository
@PropertySource(value = "classpath:queries/businessNatureMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastBusinessNatureDaoImpl implements LtMastBusinessNatureDao{

	@Autowired
	LtMastBusinessNatureRepository 	ltMastBusinessNatureRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override
	public Long getCount(LtMastBusinessNature input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastBusinessNature");
		 
		 String code=null;
		   if(input.getBusinessNatureCode()!=null)
		   {code="%"+input.getBusinessNatureCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getBusinessNatureName()!=null)
		   {name="%"+input.getBusinessNatureName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getBusinessNatureDesc()!=null)
		   {desc="%"+input.getBusinessNatureDesc().toUpperCase()+"%";}
		   
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
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId, code,name,desc,status,input.getStDate(),input.getEnDate() }, String.class);
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastBusinessNature> getDataTable(LtMastBusinessNature input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastBusinessNatureDatatableRecords");
		 
		 String code=null;
		   if(input.getBusinessNatureCode()!=null)
		   {code="%"+input.getBusinessNatureCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getBusinessNatureName()!=null)
		   {name="%"+input.getBusinessNatureName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getBusinessNatureDesc()!=null)
		   {desc="%"+input.getBusinessNatureDesc().toUpperCase()+"%";}
		   
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
			
			if(input.getColumnNo()==0) {
				input.setColumnNo(7);
			}
			List<LtMastBusinessNature> list = (List<LtMastBusinessNature>) 
					jdbcTemplate.query(query , new Object[]{companyId, code,name,desc,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class));
				return list;
	}

	@Override
	public LtMastBusinessNature save(LtMastBusinessNature ltMastBusinessNature) throws ServiceException {
		return ltMastBusinessNatureRepository.save(ltMastBusinessNature);
	}

	@Override
	public LtMastBusinessNature update(LtMastBusinessNature ltMastBusinessNature) throws ServiceException {
		return ltMastBusinessNatureRepository.save(ltMastBusinessNature);
	}

	@Override
	public LtMastBusinessNature delete(Long id) throws ServiceException {
		if( ltMastBusinessNatureRepository.exists(id) ) {
			ltMastBusinessNatureRepository.delete(id);
			return null;
		}
		return ltMastBusinessNatureRepository.findOne(id);
	}

	@Override
	public LtMastBusinessNature findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastBusinessNatureById");
		LtMastBusinessNature list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class));
		return list;
	}

	@Override
	public List<LtMastBusinessNature> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastBusinessNature");
		List<LtMastBusinessNature> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class)); 
		return list;
	}

	@Override
	public List<LtMastBusinessNature> getLikeName(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastBusinessNatureMasterLikeName");
		List<LtMastBusinessNature> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%", 
				"%"+name.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class)); 
		return list;
	}
	
	@Override
	public List<LtMastBusinessNature> getByName(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastBusinessNatureMasterByName");
		List<LtMastBusinessNature> list=   jdbcTemplate.query(query, new Object[]{ name.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class)); 
		return list;
	}
	

	@Override
	public List<LtMastBusinessNature> getByCode(String businessNatureCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastBusinessNatureMasterByCode");
		List<LtMastBusinessNature> list=   jdbcTemplate.query(query, new Object[]{ businessNatureCode.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class)); 
		return list;
	}

	@Override
	public List<LtMastBusinessNature> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastBusinessNature");
		List<LtMastBusinessNature> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
		 new BeanPropertyRowMapper<LtMastBusinessNature>(LtMastBusinessNature.class)); 
		return list;
	}

}
