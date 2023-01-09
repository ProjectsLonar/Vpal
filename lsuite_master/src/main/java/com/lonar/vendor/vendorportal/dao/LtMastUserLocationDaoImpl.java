package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastUserLocation;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/userLocationMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastUserLocationDaoImpl implements LtMastUserLocationDao{

	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	
	@Override
	public List<LtMastUserLocation> getAllLtMastUserLocation() throws ServiceException {
		String query = env.getProperty("getAllLtMastUserLocation");
		List<LtMastUserLocation> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class)); 
		return list;
	}

	@Override
	public List<LtMastUserLocation> findAllActive() throws ServiceException {
		String query = env.getProperty("findAllActiveUserlocation");
		List<LtMastUserLocation> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class)); 
		return list;
	}

	@Override
	public LtMastUserLocation getByID(Long id) throws ServiceException {
		String query = env.getProperty("findUserlocationById");
		
		List<LtMastUserLocation> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class));
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtMastUserLocation> listAllActiveUserLocationByLocId(Long id) throws ServiceException {
		String query = env.getProperty("listAllActiveUserLocationByLocId");
		List<LtMastUserLocation> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class)); 
		return list;
	}

	@Override
	public List<LtMastUserLocation> listAllActiveUserLocationByUserId(Long id) throws ServiceException {
		String query = env.getProperty("listAllActiveUserLocationByUserId");
		List<LtMastUserLocation> list=   jdbcTemplate.query(query, new Object[]{ id}, 
				 new BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class)); 
		return list;
	}

	@Override
	public List<LtMastUserLocation> getDatatableRecords(LtMastUserLocation input) throws ServiceException {
		String query = env.getProperty("getLtMastUserLocationRecords");
		 
		 String userName=null;
		   if(input.getUserName()!=null)
		   {userName="%"+input.getUserName().toUpperCase()+"%";}
		   
		   String locationName=null;
		   if(input.getLocationName()!=null)
		   {locationName="%"+input.getLocationName().toUpperCase()+"%";}
		   
		   String userType=null;
		   if(input.getUserType()!=null)
		   {userType="%"+input.getUserType().toUpperCase()+"%";}
		   
		   String defaultSubInv=null;
		   if(input.getSubInventory()!=null)
		   {defaultSubInv="%"+input.getSubInventory().toUpperCase()+"%";}
			
		   String locator=null;
		   if(input.getLocatorCode()!=null)
		   {locator="%"+input.getLocatorCode().toUpperCase()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		   
			List<LtMastUserLocation> list = (List<LtMastUserLocation>) 
					jdbcTemplate.query(query , new Object[]{userName,locationName,userType,defaultSubInv, locator, 
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastUserLocation>(LtMastUserLocation.class));
				return list;
	}

	@Override
	public Long getCount(LtMastUserLocation input) throws ServiceException {
		String query = env.getProperty("getCountLtMastUserLocation");
		 
		 String userName=null;
		   if(input.getUserName()!=null)
		   {userName="%"+input.getUserName().toUpperCase()+"%";}
		   
		   String locationName=null;
		   if(input.getLocationName()!=null)
		   {locationName="%"+input.getLocationName().toUpperCase()+"%";}
		   
		   String userType=null;
		   if(input.getUserType()!=null)
		   {userType="%"+input.getUserType().toUpperCase()+"%";}
		   
		   String defaultSubInv=null;
		   if(input.getSubInventory()!=null)
		   {defaultSubInv="%"+input.getSubInventory().toUpperCase()+"%";}
			
		   String locator=null;
		   if(input.getLocatorCode()!=null)
		   {locator="%"+input.getLocatorCode().toUpperCase()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		   
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {userName,locationName,userType,defaultSubInv, locator, 
						input.getStDate(),input.getEnDate()}, String.class);

		
		return Long.parseLong(count);
	}

}
