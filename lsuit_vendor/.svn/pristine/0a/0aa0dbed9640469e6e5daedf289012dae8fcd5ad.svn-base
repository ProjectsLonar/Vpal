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

import com.lonar.vendor.vendorportal.model.LtMastVendorHsnSacCodes;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastVendorHsnSacCodesRepository;

@Component
@PropertySource(value = "classpath:queries/vendorHsnSacQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorHsnSacCodesDaoImpl implements LtMastVendorHsnSacCodesDao
{
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastVendorHsnSacCodesRepository ltMastVendorHsnSacCodesRepository;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LtMastVendorHsnSacCodes> getAllVendorHsnSacCodes() throws ServiceException 
	{
		String query = env.getProperty("getAllVendorHsnSacCodes");
		List<LtMastVendorHsnSacCodes> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class)); 
		return list;
	}

	
	@Override
	public List<LtMastVendorHsnSacCodes> getByVendorIdAndAddrId(Long vendorId, Long addrId) throws ServiceException
	{
		String query = env.getProperty("getByVendorIdAndAddrIdVendorHsnSacCodes");
		List<LtMastVendorHsnSacCodes> list =   jdbcTemplate.query(query, new Object[]{vendorId,addrId }, 
					 new BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class)); 
			 return list;
			 
	}
	
	@Override
	public LtMastVendorHsnSacCodes getByHsnId(Long vendorHsnId) throws ServiceException 
	{
		String query = env.getProperty("getByHsnIdVendorHsnSacCodes");
			List<LtMastVendorHsnSacCodes> list=   jdbcTemplate.query(query, new Object[]{vendorHsnId }, 
					 new BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class)); 
			 if(!list.isEmpty())
				 return list.get(0);
			 else
				 return null;
	}

	@Override
	public Long save(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException 
	{
		vendorhsnSacCode.setCreationDate(new Date());
		vendorhsnSacCode.setLastUpdateDate(new Date());
		vendorhsnSacCode.setCreatedBy(vendorhsnSacCode.getLastUpdateLogin());
		vendorhsnSacCode.setLastUpdatedBy(vendorhsnSacCode.getLastUpdateLogin());
		vendorhsnSacCode = ltMastVendorHsnSacCodesRepository.save(vendorhsnSacCode);
		return vendorhsnSacCode.getVendorHsnId();
		
		
		/*String query = env.getProperty("saveVendorHsnSacCodes");
		
		int res=jdbcTemplate.update(" INSERT INTO LT_MAST_VENDOR_HSN_SAC_CODES "
				+ " (VENDOR_ID,VENDOR_ADD_ID,HSN_SAC_CODE, START_DATE, END_DATE, CREATED_BY, "
				+ " CREATION_DATE, LAST_UPDATE_LOGIN, LAST_UPDATED_BY, LAST_UPADTE_DATE ) "
     		+ " VALUES(?,?,?,?,?,?,?,?,?,?) "
			query,
     		vendorhsnSacCode.getVendorId(),vendorhsnSacCode.getVendorAddId(),vendorhsnSacCode.getHsnSacCode(),
     		vendorhsnSacCode.getStartDate(),vendorhsnSacCode.getEndDate(),vendorhsnSacCode.getCreatedBy(),
     		vendorhsnSacCode.getCreationDate(),vendorhsnSacCode.getLastUpdateLogin(),
     		vendorhsnSacCode.getLastUpdatedBy(),vendorhsnSacCode.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;*/
	}

	@Override
	public boolean update(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException 
	{
		vendorhsnSacCode.setLastUpdateDate(new Date());
		vendorhsnSacCode.setCreatedBy(vendorhsnSacCode.getLastUpdateLogin());
		vendorhsnSacCode.setLastUpdatedBy(vendorhsnSacCode.getLastUpdateLogin());
		String query = env.getProperty("updateVendorHsnSacCodes");
		int res=jdbcTemplate.update(
			query,
     		vendorhsnSacCode.getVendorId(),vendorhsnSacCode.getVendorAddId(),vendorhsnSacCode.getHsnSacCode(),
     		vendorhsnSacCode.getStartDate(),vendorhsnSacCode.getEndDate(),vendorhsnSacCode.getCreatedBy(),
     		vendorhsnSacCode.getCreationDate(),vendorhsnSacCode.getLastUpdateLogin(),vendorhsnSacCode.getLastUpdatedBy(),
     		vendorhsnSacCode.getLastUpdateDate(),vendorhsnSacCode.getVendorHsnId());
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorHsnId) throws ServiceException
	{
		String query = env.getProperty("deleteVendorHsnSacCodes");
		int res=jdbcTemplate.update(query,vendorHsnId);
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastVendorHsnSacCodes> getVendorHsnByVendorId(Long vendorId) throws ServiceException
	{
		String query = env.getProperty("getVendorHsnBCodesVendorId");
		List<LtMastVendorHsnSacCodes> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class)); 
		if(!list.isEmpty())
				 return list;
		else
				 return null;
	}

	@Override
	public boolean deleteByvendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("deleteByvendorIdVendorHsnBCodes");
		int res=jdbcTemplate.update(query,vendorId);
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean checkforDuplicate(LtMastVendorHsnSacCodes vendorhsnSacCode) throws ServiceException
	{
		String query = env.getProperty("checkforDuplicateVendorHsnBCodes");
		List<LtMastVendorHsnSacCodes> list=   jdbcTemplate.query(query, new Object[]{vendorhsnSacCode.getHsnSacCode() }, 
					 new BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class)); 
		if(list.isEmpty())
				 return true;
		else
				 return false;
		
	}

	@Override
	public Long getLtMastVendorHsnSacCodesCount(Long vendorAddressId, LtMastVendorHsnSacCodes input)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorHsnSacCodesCount");
		 
		 String code=null;
		   if(input.getHsnSacCode()!=null && !input.getHsnSacCode().equals(""))
		   {code="%"+input.getHsnSacCode().trim().toUpperCase() + "%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		
	String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorAddressId,code,
			input.getStDate(),input.getEnDate()}, String.class);

	return Long.parseLong(count);
	}

	@Override
	public List<LtMastVendorHsnSacCodes> getLtMastVendorHsnSacCodesDataTable(Long vendorAddressId,
			LtMastVendorHsnSacCodes input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorHsnSacCodesDataTable");
		
		   String code=null;
		   if(input.getHsnSacCode()!=null && !input.getHsnSacCode().equals(""))
		   {code="%"+input.getHsnSacCode().trim().toUpperCase() + "%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			 
			List<LtMastVendorHsnSacCodes> list = (List<LtMastVendorHsnSacCodes>) 
					jdbcTemplate.query(query , new Object[]{vendorAddressId,code,
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastVendorHsnSacCodes>(LtMastVendorHsnSacCodes.class));
				return list;
	}

	

	

}
