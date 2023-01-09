package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastValidation;
import com.lonar.vendor.vendorportal.model.LtMastVendorManagements;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value = "classpath:queries/vendorManagements.properties", ignoreResourceNotFound = true)
public class LtMastVendorManagementsDaoImpl implements LtMastVendorManagementsDao
{

	
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LtMastVendorManagements> getAllVendorManagements() throws ServiceException 
	{
		String query = env.getProperty("getAllVendorManagements");
	
		List<LtMastVendorManagements> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastVendorManagements>(LtMastVendorManagements.class)); 
	 
	
	return list;
	}

	@Override
	public List<LtMastVendorManagements> getVendorManagementByVenId(Long vendorId) throws ServiceException
	{
		
		String query = env.getProperty("getByVendorIdVendorManagement");
			
			List<LtMastVendorManagements> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorManagements>(LtMastVendorManagements.class)); 
			 
				 return list;
	}

	@Override
	public LtMastVendorManagements getVendorManagementById(Long vendorManagementId) throws ServiceException 
	{
		String query = env.getProperty("getVendorManagementById");
		
			List<LtMastVendorManagements> list=   jdbcTemplate.query(query, new Object[]{vendorManagementId }, 
					 new BeanPropertyRowMapper<LtMastVendorManagements>(LtMastVendorManagements.class)); 
			 
			 if(!list.isEmpty())
				 return list.get(0);
			 else
				 return null;
	}

	@Override
	public boolean save(LtMastVendorManagements ltMastVendorManagements) throws ServiceException
	{
		String query = env.getProperty("saveVendorManagement");
		ltMastVendorManagements.setCreationDate(new Date());
		ltMastVendorManagements.setLastUpdateDate(new Date());
		ltMastVendorManagements.setCreatedBy(ltMastVendorManagements.getLastUpdateLogin());
		ltMastVendorManagements.setLastUpdatedBy(ltMastVendorManagements.getLastUpdateLogin());
		int res=jdbcTemplate.update(
     		query,
     		ltMastVendorManagements.getVendorId(),ltMastVendorManagements.getName(),ltMastVendorManagements.getVenManDesgId(),
     		ltMastVendorManagements.getMobileNo(),ltMastVendorManagements.getPhoneNo(),ltMastVendorManagements.getEmailAdd(),
     		ltMastVendorManagements.getCreatedBy(),ltMastVendorManagements.getCreationDate(),ltMastVendorManagements.getLastUpdateLogin(),
     		ltMastVendorManagements.getLastUpdatedBy(),ltMastVendorManagements.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(LtMastVendorManagements ltMastVendorManagements) throws ServiceException 
	{
		String query = env.getProperty("updateVendorManagement");
		ltMastVendorManagements.setCreationDate(new Date());
		ltMastVendorManagements.setLastUpdateDate(new Date());
		ltMastVendorManagements.setLastUpdatedBy(ltMastVendorManagements.getLastUpdateLogin());
		int res=jdbcTemplate.update(
			query,
     		ltMastVendorManagements.getVendorId(),ltMastVendorManagements.getName(),ltMastVendorManagements.getVenManDesgId(),
     		ltMastVendorManagements.getMobileNo(),ltMastVendorManagements.getPhoneNo(),ltMastVendorManagements.getEmailAdd(),
     		ltMastVendorManagements.getCreatedBy(),ltMastVendorManagements.getCreationDate(),ltMastVendorManagements.getLastUpdateLogin(),
     		ltMastVendorManagements.getLastUpdatedBy(),ltMastVendorManagements.getLastUpdateDate(),ltMastVendorManagements.getVendorManagementId());
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorManagementId) throws ServiceException 
	{
		String query = env.getProperty("deleteVendorManagement");
		
		int res=jdbcTemplate.update(query,vendorManagementId);
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("deleteByVendorIdVendorManagement");
		
		int res=jdbcTemplate.update(query,vendorId);
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastValidation> getValidationByTableName(String name) throws ServiceException {
		String query = " SELECT COL_NM as COLUMNS_NAME, " + 
				" VAL AS VALIDATION FROM LT_MAST_VALIDATION WHERE TABLE_NAME = 'LT_MAST_VENDOR_MANAGEMENTS' ";
		
		List<LtMastValidation> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastValidation>(LtMastValidation.class)); 
		return list;
	}

	@Override
	public Long getLtMastVendorManagementsCount(Long vendorId, LtMastVendorManagements input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorManagementsCount");
		 
		   String name=null;
		   if(input.getName()!=null && !input.getName().equals(""))
		   {name="%"+input.getName().trim().toUpperCase() + "%";}
		   
		   String designation=null;
		   if(input.getDesignationValueName()!=null && !input.getDesignationValueName().equals(""))
		   {designation="%"+input.getDesignationValueName().trim().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getEmailAdd()!=null && !input.getEmailAdd().equals("")) 
		   {email="%"+input.getEmailAdd().trim().toUpperCase()+"%";}
		   
		   String mobile=null;
		   if(input.getMobileNo()!=null &&  !input.getMobileNo().equals("")) 
		   {mobile="%"+input.getMobileNo().trim()+"%";}
		   
		   
		   String phone=null;
		   if(input.getPhoneNo()!=null &&  !input.getPhoneNo().equals("")) 
		   {phone="%"+input.getPhoneNo().trim()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		
	String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorId,name,designation,email,mobile,phone}, String.class);

	return Long.parseLong(count);
	}

	@Override
	public List<LtMastVendorManagements> getLtMastVendorManagementsDataTable(Long vendorId,
			LtMastVendorManagements input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorManagementsDataTable");
		
		   String name=null;
		   if(input.getName()!=null && !input.getName().equals(""))
		   {name="%"+input.getName().trim().toUpperCase() + "%";}
		   
		   String designation=null;
		   if(input.getDesignationValueName()!=null && !input.getDesignationValueName().equals(""))
		   {designation="%"+input.getDesignationValueName().trim().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getEmailAdd()!=null && !input.getEmailAdd().equals("")) 
		   {email="%"+input.getEmailAdd().trim().toUpperCase()+"%";}
		   
		   String mobile=null;
		   if(input.getMobileNo()!=null &&  !input.getMobileNo().equals("")) 
		   {mobile="%"+input.getMobileNo().trim()+"%";}
		   
		   
		   String phone=null;
		   if(input.getPhoneNo()!=null &&  !input.getPhoneNo().equals("")) 
		   {phone="%"+input.getPhoneNo().trim()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			List<LtMastVendorManagements> list = (List<LtMastVendorManagements>) 
					jdbcTemplate.query(query , new Object[]{vendorId,name,designation,email,mobile,phone,
						
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastVendorManagements>(LtMastVendorManagements.class));
				return list;
	}

}
