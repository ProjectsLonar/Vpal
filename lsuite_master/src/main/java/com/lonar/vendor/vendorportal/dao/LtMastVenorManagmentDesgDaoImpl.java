package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastVenorManagmentDesg;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastVenorManagmentDesgRepository;

@Repository
@PropertySource(value = "classpath:queries/vendorDesignationQueries.properties", ignoreResourceNotFound = true)
public class LtMastVenorManagmentDesgDaoImpl implements LtMastVenorManagmentDesgDao{

	@Autowired
	LtMastVenorManagmentDesgRepository ltMastVenorManagmentDesgRepository;
	
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
	public Long getCount(LtMastVenorManagmentDesg input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastVenorManagmentDesg");
		 
		 String code=null;
		   if(input.getVenManDesgCode()!=null)
		   {code="%"+input.getVenManDesgCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getVenManDesgName()!=null)
		   {name="%"+input.getVenManDesgName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getVenManDesgDesc()!=null)
		   {desc="%"+input.getVenManDesgDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastVenorManagmentDesg> getDataTable(LtMastVenorManagmentDesg input, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVenorManagmentDesgDatatableRecords");
		 
		 String code=null;
		   if(input.getVenManDesgCode()!=null)
		   {code="%"+input.getVenManDesgCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getVenManDesgName()!=null)
		   {name="%"+input.getVenManDesgName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getVenManDesgDesc()!=null)
		   {desc="%"+input.getVenManDesgDesc().toUpperCase()+"%";}
		   
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
			List<LtMastVenorManagmentDesg> list = (List<LtMastVenorManagmentDesg>) 
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
				 new  BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class));
				return list;
	}

	@Override
	public LtMastVenorManagmentDesg save(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException {
		return ltMastVenorManagmentDesgRepository.save(ltMastVenorManagmentDesg);
	}

	@Override
	public LtMastVenorManagmentDesg update(LtMastVenorManagmentDesg ltMastVenorManagmentDesg) throws ServiceException {
		return ltMastVenorManagmentDesgRepository.save(ltMastVenorManagmentDesg);
	}

	@Override
	public LtMastVenorManagmentDesg delete(Long id) throws ServiceException {
		if( ltMastVenorManagmentDesgRepository.exists(id) ) {
			ltMastVenorManagmentDesgRepository.delete(id);
			 return null;
		}
		return ltMastVenorManagmentDesgRepository.findOne(id);
	}

	@Override
	public LtMastVenorManagmentDesg findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastVenorManagmentDesgById");
		LtMastVenorManagmentDesg list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class));
		return list;
	}

	@Override
	public List<LtMastVenorManagmentDesg> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastVenorManagmentDesg");
		List<LtMastVenorManagmentDesg> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class)); 
		return list;
	}

	@Override
	public List<LtMastVenorManagmentDesg> getLikeDesignation(String designation, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVenorManagmentDesgLikedesg");
		List<LtMastVenorManagmentDesg> list=   jdbcTemplate.query(query, new Object[]{ "%"+designation.toUpperCase()+"%", 
				"%"+designation.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class)); 
		return list;
	}

	@Override
	public List<LtMastVenorManagmentDesg> getLikeDesgCode(String venManDesgCode, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVenorManagmentDesgLikeDesgCode");
		List<LtMastVenorManagmentDesg> list=   jdbcTemplate.query(query, new Object[]{ venManDesgCode.toUpperCase(),companyId}, 
		 new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class)); 
		return list;
	}

	@Override
	public List<LtMastVenorManagmentDesg> getByDesignationName(String venManDesgName, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVenorManagmentDesgByDesgName");
		List<LtMastVenorManagmentDesg> list=   jdbcTemplate.query(query, new Object[]{ venManDesgName.toUpperCase(),companyId}, 
		 new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class)); 
		return list;
	}

	@Override
	public List<LtMastVenorManagmentDesg> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastVenorManagmentDesg");
		List<LtMastVenorManagmentDesg> list=   jdbcTemplate.query(query, new Object[]{ companyId}, 
		 new BeanPropertyRowMapper<LtMastVenorManagmentDesg>(LtMastVenorManagmentDesg.class)); 
		return list;
	}

}
