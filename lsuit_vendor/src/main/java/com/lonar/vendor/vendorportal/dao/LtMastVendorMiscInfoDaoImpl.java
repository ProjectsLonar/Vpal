package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscInfo;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value = "classpath:queries/vendorMiscInfo.properties", ignoreResourceNotFound = true)
public class LtMastVendorMiscInfoDaoImpl implements LtMastVendorMiscInfoDao
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
	public List<LtMastVendorMiscInfo> getAllVendorMiscInfo() 
	{
		String query = env.getProperty("getAllVendorMiscInfo");
	
		List<LtMastVendorMiscInfo> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastVendorMiscInfo>(LtMastVendorMiscInfo.class)); 
			return list;
	}

	@Override
	public List<LtMastVendorMiscInfo> getVendorMiscByVenId(Long vendorId) 
	{
		
		String query = env.getProperty("getVendorMiscByVenId");
		
		List<LtMastVendorMiscInfo> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					new BeanPropertyRowMapper<LtMastVendorMiscInfo>(LtMastVendorMiscInfo.class)); 
			  return list;
	}
	
	@Override
	public LtMastVendorMiscInfo getVendorMiscInfoById(Long vendorMiscInfoId) throws ServiceException 
	{
		String query = env.getProperty("getVendorMiscInfoByIdVendorMisInfo");
		
			List<LtMastVendorMiscInfo> list=   jdbcTemplate.query(query, new Object[]{vendorMiscInfoId }, 
					 new BeanPropertyRowMapper<LtMastVendorMiscInfo>(LtMastVendorMiscInfo.class)); 
			 if(!list.isEmpty())
				 return list.get(0);
			 else
				 return null;
	}

	@Override
	public boolean save(LtMastVendorMiscInfo ltMastVendorMiscInfo)
	{
		String query = env.getProperty("saveVendorMisInfo");
		
		int res=jdbcTemplate.update(
     		query,
     		ltMastVendorMiscInfo.getVendorId(),ltMastVendorMiscInfo.getRevenue(),ltMastVendorMiscInfo.getNoOfEmployees(),
     		ltMastVendorMiscInfo.getGoodWill(),ltMastVendorMiscInfo.getSupportPresent(),ltMastVendorMiscInfo.getNetProfit(),
     		ltMastVendorMiscInfo.getDrCapabilities(),ltMastVendorMiscInfo.getExistingDependency(),ltMastVendorMiscInfo.getRelationshipManagement(),
     		ltMastVendorMiscInfo.getCertifications(),ltMastVendorMiscInfo.getImpactOnServices(),ltMastVendorMiscInfo.getCompetition(),
     		ltMastVendorMiscInfo.getCreatedBy(),
     		ltMastVendorMiscInfo.getCreationDate(),ltMastVendorMiscInfo.getLastUpdateLogin(),
     		ltMastVendorMiscInfo.getLastUpdatedBy(),ltMastVendorMiscInfo.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public boolean update(LtMastVendorMiscInfo ltMastVendorMiscInfo) throws ServiceException 
	{
		String query = env.getProperty("updateVendorMisInfo");
		
		int res=jdbcTemplate.update(/*" UPDATE LT_MAST_VENDOR_MISC_INFO SET "
				+ "  VENDOR_ID=?,REVENUE=?,NO_OF_EMPLOYEES=?,GOODWILL=?, "
				+ " SUPPORT_PRESENT=? ,NET_PROFIT=?,DR_CAPABILITIES=?, "
				+ " EXISTING_DEPENDENCY=?, RELATIONSHIP_MANAGEMENT=?,CERTIFICATIONS=?, "
				+ " IMPACT_ON_SERVICES=?,COMPETITION=?, CREATED_BY=?, "
				+ " CREATION_DATE=?, LAST_UPDATE_LOGIN=?, LAST_UPDATED_BY=?, LAST_UPDATE_DATE=? "
				+ " WHERE VENDOR_MISC_INFO_ID =?  "*/
				
			query,
     		ltMastVendorMiscInfo.getVendorId(),ltMastVendorMiscInfo.getRevenue(),ltMastVendorMiscInfo.getNoOfEmployees(),
     		ltMastVendorMiscInfo.getGoodWill(),ltMastVendorMiscInfo.getSupportPresent(),ltMastVendorMiscInfo.getNetProfit(),
     		ltMastVendorMiscInfo.getDrCapabilities(),ltMastVendorMiscInfo.getExistingDependency(),ltMastVendorMiscInfo.getRelationshipManagement(),
     		ltMastVendorMiscInfo.getCertifications(),ltMastVendorMiscInfo.getImpactOnServices(),ltMastVendorMiscInfo.getCompetition(),
     		ltMastVendorMiscInfo.getCreatedBy(),
     		ltMastVendorMiscInfo.getCreationDate(),ltMastVendorMiscInfo.getLastUpdateLogin(),
     		ltMastVendorMiscInfo.getLastUpdatedBy(),ltMastVendorMiscInfo.getLastUpdateDate(),ltMastVendorMiscInfo.getVendorMiscInfoId());
		
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public boolean delete(Long vendorMiscInfoId) throws ServiceException 
	{
		String query = env.getProperty("deleteVendorMisInfo");
		
		int res=jdbcTemplate.update(query,vendorMiscInfoId);
		
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException
	{
		
		String query = env.getProperty("deleteVendorMisInfo");
		
		int res=jdbcTemplate.update(/*" DELETE FROM LT_MAST_VENDOR_MISC_INFO WHERE VENDOR_ID = ? "*/query,vendorId);
		
		if(res==1)
			return true;
		else
			return false;
	}


	

}
