package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.repository.LtVendCompanyRepository;

@Repository
@PropertySource(value = "classpath:queries/vendCompanyMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyDaoImpl implements LtVendCompanyDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	LtVendCompanyRepository ltVendCompanyRepository;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public LtVendCompany getLtVendCompanyBycompanyId(Long companyId) {
		String query = env.getProperty("getLtVendCompanyBycompanyId");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ companyId},
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));

		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtVendCompany> getAllLtVendCompany() {
		String query = env.getProperty("getAllLtVendCompany");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ },
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));

		if(!list.isEmpty())
		return list;
		else
			return null;
	}

	@Override
	public List<LtVendCompany> getLtVendCompanyLikecompanyName(String companyName) {
		String query = env.getProperty("getLtVendCompanyLikecompanyName");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ "%"+companyName.toUpperCase()+"%"},
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));
			return list;
	}

	@Override
	public boolean delete(Long companyId) {
		int res=0;
		 res=jdbcTemplate.update(" DELETE FROM lt_vend_company_master "
				+ "  WHERE COMPANY_ID = ? ",companyId);
	
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public Long getCount(LtVendCompany input) {
		String query = env.getProperty("getCountLtVendCompany");
		
		   
		   String companyName=null;
		   if(input.getCompanyName()!=null)
		   {companyName="%"+input.getCompanyName().toUpperCase()+"%";}
		   
		   
		   
		   String city=null;
		   if(input.getCity()!=null)
		   {city="%"+input.getCity().toUpperCase()+"%";}
		   
		   String state=null;
		   if(input.getState()!=null)
		   {state="%"+input.getState().toUpperCase()+"%";}
		   
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
				query, new Object[] {companyName,city,state,status,
						input.getStDate(),input.getEnDate()}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtVendCompany> getDatatableRecords(LtVendCompany input) {
		String query = env.getProperty("getLtVendCompanyDatatableRecords");
		
		   String companyName=null;
		   if(input.getCompanyName()!=null)
		   {companyName="%"+input.getCompanyName().toUpperCase() + "%";}
		   
		 
		   
		   String city=null;
		   if(input.getCity()!=null)
		   {city="%"+input.getCity().toUpperCase()+"%";}
		   
		   String state=null;
		   if(input.getState()!=null)
		   {state="%"+input.getState().toUpperCase()+"%";}
		   
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
			
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(8);
			}
			
			
			List<LtVendCompany> list = (List<LtVendCompany>) 
					jdbcTemplate.query(query , new Object[]{companyName,city,state,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()},
				 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));
				return list;
		
	}

	@Override
	public boolean update(LtVendCompany ltMastCompany) {
		int res=0;
		 res=jdbcTemplate.update(" UPDATE lt_vend_company_master SET "
		        + "  COMPANY_NAME =? ,REGD_ADDRESS=? , CITY=? ,STATE=? ,"
		        + " PIN_CODE=? ,PAN_NUMBER=? , ORG_ID=? ,LOGO_PATH=?,"
		        + " STATUS=? ,START_DATE=? ,END_DATE=?, LAST_UPDATE_LOGIN=? ,LAST_UPDATED_BY=?,"
		        + "  LAST_UPDATE_DATE=?  WHERE COMPANY_ID = ? ",
		        ltMastCompany.getCompanyName(),ltMastCompany.getRegdAddress(),ltMastCompany.getCity(),ltMastCompany.getState()
		        ,ltMastCompany.getPinCode(),ltMastCompany.getPanNumber(),
		        ltMastCompany.getOrgId(),ltMastCompany.getLogoPath(),
		        ltMastCompany.getStatus(),ltMastCompany.getStartDate(),ltMastCompany.getEndDate(),
		        ltMastCompany.getLastUpdateLogin(),ltMastCompany.getLastUpdatedBy(),ltMastCompany.getLastUpdateDate(),
		        ltMastCompany.getCompanyId());
		 
		
	if(res!=0)
		return true;
	else
		return false;
	}

	@Override
	public LtVendCompany getByCompanyName(LtVendCompany ltMastCompany) {
		String query = env.getProperty("getByVendCompanyName");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ ltMastCompany.getCompanyName()},
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));

		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public LtVendCompany getByPanNumber(LtVendCompany ltMastCompany) {
		String query = env.getProperty("getVendCompanyByPanNumber");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ ltMastCompany.getPanNumber()},
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));

		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public LtVendCompany getByGstNumber(LtVendCompany ltMastCompany) {
		/*String query = env.getProperty("getByGstNumber");
		
		List<LtVendCompany> list = (List<LtVendCompany>) 
				jdbcTemplate.query(query , new Object[]{ ltMastCompany.getGstNumber()},
			 new  BeanPropertyRowMapper<LtVendCompany>(LtVendCompany.class));

		if(!list.isEmpty())
		return list.get(0);
		else*/
			return null;
	}

	@Override
	public boolean save(LtVendCompany ltVendCompany) {
		if (ltVendCompanyRepository.save(ltVendCompany) != null)
			return true;
		else
			return false;
	}

}
