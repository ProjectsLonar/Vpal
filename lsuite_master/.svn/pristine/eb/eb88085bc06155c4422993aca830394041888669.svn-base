package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastAuditRecords;
import com.lonar.vendor.vendorportal.model.LtMastCity;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/cityMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastCityDaoImpl implements LtMastCityDao{

	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Override
	public Long getCount(LtMastCity input) throws ServiceException {


		String query = env.getProperty("getCountLtMastCity");
		 
		String cityCode=null;
	   if(input.getCityCode()!=null && !input.getCityCode().equals(" ") && !input.getCityCode().isEmpty())
	   {cityCode="%"+input.getCityCode().toUpperCase()+"%";}
		   
		   String cityName=null;
		   if(input.getCityName()!=null && !input.getCityName().equals(" ") && !input.getCityName().isEmpty())
		   {cityName="%"+input.getCityName().toUpperCase()+"%";}
		   
		   String statename=null;
		   if(input.getStateName()!=null && !input.getStateName().equals(" ") && !input.getStateName().isEmpty())
		   {statename="%"+input.getStateName().toUpperCase()+"%";}
		   
		  		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
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
			query, new Object[] {cityCode,cityName,statename,status,
					input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
		
	}

	@Override
	public List<LtMastCity> getCityDataTableRecords(LtMastCity input) throws ServiceException {
		String query = env.getProperty("getLtMastCityDatatableRecords");
		 
		String cityCode=null;
		   if(input.getCityCode()!=null && !input.getCityCode().equals(" ") && !input.getCityCode().isEmpty())
		   {cityCode="%"+input.getCityCode().toUpperCase()+"%";}
		   
		   String cityName=null;
		   if(input.getCityName()!=null && !input.getCityName().equals(" ") && !input.getCityName().isEmpty())
		   {cityName="%"+input.getCityName().toUpperCase()+"%";}
		   
		   String stateName=null;
		   if(input.getStateName()!=null &&  !input.getStateName().equals(" ") && !input.getStateName().isEmpty())
		   {stateName="%"+input.getStateName().toUpperCase()+"%";}
		   
		   		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals(" ") && !input.getStatus().isEmpty()) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			if(input.getColumnNo() == 0) {
				input.setColumnNo(9);
			}
			List<LtMastCity> list = (List<LtMastCity>) 
					jdbcTemplate.query(query , new Object[]{cityCode,cityName,stateName,status,
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
			
				return list;
	}

	@Override
	public List<LtMastCity> findAll() throws ServiceException{
		
		String query = env.getProperty("findAllLtMastCity");
		
		List<LtMastCity> list= jdbcTemplate.query(query, new Object[] { },
				new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
		return list;
	}

	@Override
	public List<LtMastCity> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveLtMastCity");
		
		List<LtMastCity> list=jdbcTemplate.query(query, new Object[] { },
				new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
		return list;
	}

	@Override
	public LtMastCity getById(Long id) throws ServiceException{
		String query = env.getProperty("getLtMastCityByID");
		
		List<LtMastCity> list=jdbcTemplate.query(query, new Object[] { id },
				new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
		if(!list.isEmpty())
			return list.get(0);
			 else return null;
	}

	@Override
	public List<LtMastCity> findActiveLikeCityName(String city) throws ServiceException{
		String query = env.getProperty("findActiveLikeCityName");
		
		List<LtMastCity> list=jdbcTemplate.query(query, new Object[] { "%"+city.toUpperCase().trim()+"%"},
				new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
		return list;
	}

	@Override
	public LtMastCity getByCityCode(String cityCode, Long stateId) {
	 String query = env.getProperty("getByCityCode");
		
		List<LtMastCity> list=   jdbcTemplate.query(query, new Object[]{cityCode.toUpperCase().trim(),stateId }, 
				 new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class)); 
		if(!list.isEmpty()) 
		return list.get(0);
		else return null;
	}

	@Override
	public LtMastCity getByCityName(String cityName, Long stateId) {
		
     String query = env.getProperty("getByCityName");
		
		List<LtMastCity> list=   jdbcTemplate.query(query, new Object[]{cityName.toUpperCase().trim(),stateId }, 
				 new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class)); 
		if(!list.isEmpty()) 
		return list.get(0);
		else return null;
	}

	@Override
	public LtMastCity getForAuditByID(Long cityId) throws ServiceException {
		String query = env.getProperty("getForAuditByID");
		
		List<LtMastCity> list=jdbcTemplate.query(query, new Object[] { cityId },
				new BeanPropertyRowMapper<LtMastCity>(LtMastCity.class));
		if(!list.isEmpty())
			return list.get(0);
			 else return null;
	}

	@Override
	public void updateAuditId(float auditId,Long cityId) throws ServiceException {
		
		int res=0;
		res=jdbcTemplate.update(" UPDATE LT_MAST_CITY SET AUDIT_ID = ?  WHERE CITY_ID = ? ",auditId,cityId);
		
		
	}

	@Override
	public List<LtMastAuditRecords> getLtMastCityAudit(Long cityId) throws ServiceException {
		String query = env.getProperty("getLtMastCityAudit");
		
		List<LtMastAuditRecords> list=   jdbcTemplate.query(query, new Object[]{cityId }, 
				 new BeanPropertyRowMapper<LtMastAuditRecords>(LtMastAuditRecords.class));
		return list; 
	}
	
	

}
