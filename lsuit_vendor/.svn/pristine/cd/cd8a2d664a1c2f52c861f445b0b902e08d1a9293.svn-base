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

import com.lonar.vendor.vendorportal.model.LtMastVendorAgreements;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastVendorAgreementsRepository;
import com.lonar.vendor.vendorportal.repository.LtMastVendorsRepository;

@Component
@PropertySource(value = "classpath:queries/vendorAgreementsQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorAgreementsDaoImpl implements LtMastVendorAgreementsDao
{
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastVendorAgreementsRepository ltMastVendorAgreementsRepository;
	
	
	
	@Autowired
	LtMastVendorsRepository ltMastVendorsRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public List<LtMastVendorAgreements> getAllVendorAgrrement() throws ServiceException 
	{
		
		String query = env.getProperty("getAllVendorAgrrement");
	
		List<LtMastVendorAgreements> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastVendorAgreements>(LtMastVendorAgreements.class)); 
	 
	
		return list;
	}

	@Override
	public LtMastVendorAgreements getVendorAgreementById(Long vendorAggId) throws ServiceException
	{
		String query = env.getProperty("getVendorAgreementById");
		
			List<LtMastVendorAgreements> list=   jdbcTemplate.query(query, new Object[]{ vendorAggId }, 
					 new BeanPropertyRowMapper<LtMastVendorAgreements>(LtMastVendorAgreements.class)); 
			 
			if(!list.isEmpty())
			return list.get(0);
			else
				return null;
	}

	@Override
	public Long save(LtMastVendorAgreements vendorAggreement) throws ServiceException 
	{
		vendorAggreement.setCreationDate(new Date());
		vendorAggreement.setLastUpdateDate(new Date());
		vendorAggreement.setCreatedBy(vendorAggreement.getLastUpdateLogin());
		vendorAggreement.setLastUpdatedBy(vendorAggreement.getLastUpdateLogin());
		vendorAggreement = ltMastVendorAgreementsRepository.save(vendorAggreement);
		return vendorAggreement.getAgreementId();
	}

	@Override
	public boolean update(LtMastVendorAgreements vendorAggreement) throws ServiceException 
	{
		vendorAggreement.setLastUpdateDate(new Date());
		vendorAggreement.setCreatedBy(vendorAggreement.getLastUpdateLogin());
		vendorAggreement.setLastUpdatedBy(vendorAggreement.getLastUpdateLogin());
		vendorAggreement = ltMastVendorAgreementsRepository.save(vendorAggreement);
		if( vendorAggreement.getAgreementId() !=null )
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorAgreementId) throws ServiceException 
	{
		String query = env.getProperty("deleteVendorAgreement");
		
		int res=jdbcTemplate.update(/*" DELETE FROM LT_MAST_VENDOR_AGREEMENTS WHERE AGREEMENT_ID = ? "*/query,vendorAgreementId);
	
		if(res!=0)
			return true;
		else
			return false;
	}


	@Override
	public List<LtMastVendorAgreements> getAllVendorAgrrementByVendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("getAllVendorAgrrementByVendorId");
		List<LtMastVendorAgreements> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
			 new BeanPropertyRowMapper<LtMastVendorAgreements>(LtMastVendorAgreements.class)); 
		return list;
	}


	@Override
	public boolean deleteByVendor(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("deleteAgrrementByVendorIdByVendorId");
		
		int res=jdbcTemplate.update(query,vendorId);
	
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public Long getLtMastVendorAgreementsCount(LtMastVendorAgreements input,Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastVendorAgreementsCount");
		 
		String venName=null;
		   if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		   {venName="%"+input.getVendorName().trim().toUpperCase() + "%";}
		   
		   String aggrCode=null;
		   if(input.getAgreementCode()!=null && !input.getAgreementCode().equals(""))
		   {aggrCode="%"+input.getAgreementCode().trim().toUpperCase()+"%";}
		   
		   String aggrDesc=null;
		   if(input.getAgreementDesc()!=null && !input.getAgreementDesc().equals(""))
		   {aggrDesc="%"+input.getAgreementDesc().trim().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,aggrCode,venName,status,
						input.getStDate(),input.getEnDate()}, String.class);

		return Long.parseLong(count);
	}


	@Override
	public List<LtMastVendorAgreements> getAgreementsDataTable(LtMastVendorAgreements input,Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorAgreementsDataTable");
		
		String venName=null;
		   if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		   {venName="%"+input.getVendorName().trim().toUpperCase() + "%";}
		   
		   String aggrCode=null;
		   if(input.getAgreementCode()!=null && !input.getAgreementCode().equals(""))
		   {aggrCode="%"+input.getAgreementCode().trim().toUpperCase()+"%";}
		   
		   String aggrDesc=null;
		   if(input.getAgreementDesc()!=null && !input.getAgreementDesc().equals(""))
		   {aggrDesc="%"+input.getAgreementDesc().trim().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(7);
			}
			
			
			List<LtMastVendorAgreements> list = (List<LtMastVendorAgreements>) 
					jdbcTemplate.query(query , new Object[]{companyId,aggrCode,venName,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()},
				 new  BeanPropertyRowMapper<LtMastVendorAgreements>(LtMastVendorAgreements.class));
				return list;
	}


	@Override
	public Long getLtMastVendorAgreementsCountByVenId(LtMastVendorAgreements input, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorAgreementsCountByVendorId");
		 
		String venName=null;
		   if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		   {venName="%"+input.getVendorName().trim().toUpperCase() + "%";}
		   
		   String aggrCode=null;
		   if(input.getAgreementCode()!=null && !input.getAgreementCode().equals(""))
		   {aggrCode="%"+input.getAgreementCode().trim().toUpperCase()+"%";}
		   
		   String aggrDesc=null;
		   if(input.getAgreementDesc()!=null && !input.getAgreementDesc().equals(""))
		   {aggrDesc="%"+input.getAgreementDesc().trim().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {vendorId,aggrCode,venName,status,
						input.getStDate(),input.getEnDate()}, String.class);

		return Long.parseLong(count);
	}


	@Override
	public List<LtMastVendorAgreements> getLtMastVendorAgreementsDataTable(LtMastVendorAgreements input, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorAgreementsDataTableByVendorId");
		
		String venName=null;
		   if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		   {venName="%"+input.getVendorName().trim().toUpperCase() + "%";}
		   
		   String aggrCode=null;
		   if(input.getAgreementCode()!=null && !input.getAgreementCode().equals(""))
		   {aggrCode="%"+input.getAgreementCode().trim().toUpperCase()+"%";}
		   
		   String aggrDesc=null;
		   if(input.getAgreementDesc()!=null && !input.getAgreementDesc().equals(""))
		   {aggrDesc="%"+input.getAgreementDesc().trim().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(8);
			}
			
			
			List<LtMastVendorAgreements> list = (List<LtMastVendorAgreements>) 
					jdbcTemplate.query(query , new Object[]{vendorId,aggrCode,venName,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()},
				 new  BeanPropertyRowMapper<LtMastVendorAgreements>(LtMastVendorAgreements.class));
				return list;
	}


	@Override
	public boolean deleteAttachment(Long vendorAgreementId) throws ServiceException {
		
		String query1 = env.getProperty("updateVendorAttchPath");
		int res=jdbcTemplate.update(query1,null,vendorAgreementId);
		if(res!=0) {
			String query = env.getProperty("deleteAttachmentByAgreementId");
		
			int res1=jdbcTemplate.update(query,vendorAgreementId);
	
			if(res1!=0)
				return true;
			else
				return false;
		}
		return false;
	}

}
