package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastVendorSisterConcerns;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value = "classpath:queries/vendorSisterConcernsQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorSisterConcernsDaoImpl implements LtMastVendorSisterConcernsDao 
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
	public List<LtMastVendorSisterConcerns> getAllVendorSisterConcerns() throws ServiceException 
	{
		
		String query = env.getProperty("listVendorSisterConcerns");
		
		//String query = " SELECT * FROM LT_MAST_VENDOR_SISTER_CONCERNS v ";

		List<LtMastVendorSisterConcerns> ltMastVendorSisterConcernsList = jdbcTemplate.query(query, new Object[] {},
				new RowMapper<LtMastVendorSisterConcerns>() {
					public LtMastVendorSisterConcerns mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorSisterConcerns ltMastVendorSisterConcerns = new LtMastVendorSisterConcerns();

						ltMastVendorSisterConcerns.setVendorSisterConcernsId(rs.getLong("VENDOR_SISTER_CONCERNS_ID"));
						ltMastVendorSisterConcerns.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorSisterConcerns.setCompanyName(rs.getString("COMPANY_NAME"));
						ltMastVendorSisterConcerns.setMajorProducts(rs.getString("MAJOR_PRODUCTS"));
						ltMastVendorSisterConcerns.setCompanyAddress(rs.getString("COMPANY_ADDRESS"));
						ltMastVendorSisterConcerns.setCompanyContactPerson(rs.getString("COMPANY_CONTACT_PERSON"));
						ltMastVendorSisterConcerns.setCompanyContactDesg(rs.getString("COMPANY_CONTACT_DESG"));
						ltMastVendorSisterConcerns.setCompanyContactNo(rs.getString("COMPANY_CONTACT_NO"));
						ltMastVendorSisterConcerns.setCompanyContactEmail(rs.getString("COMPANY_CONTACT_EMAIL"));
						ltMastVendorSisterConcerns.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorSisterConcerns.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorSisterConcerns.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorSisterConcerns.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorSisterConcerns.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorSisterConcerns;
					}
				});

		return ltMastVendorSisterConcernsList;
	}

	@Override
	public List<LtMastVendorSisterConcerns> getVendorSisConcByVenId(Long vendorId) throws ServiceException 
	{
		
		String query = env.getProperty("getVendorSisterConcernsBytVendorId");
				
		List<LtMastVendorSisterConcerns> ltMastVendorSisterConcernsList = jdbcTemplate.query(query,
				new Object[] { vendorId }, new RowMapper<LtMastVendorSisterConcerns>() {
					public LtMastVendorSisterConcerns mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorSisterConcerns ltMastVendorSisterConcerns = new LtMastVendorSisterConcerns();

						ltMastVendorSisterConcerns.setVendorSisterConcernsId(rs.getLong("VENDOR_SISTER_CONCERNS_ID"));
						ltMastVendorSisterConcerns.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorSisterConcerns.setCompanyName(rs.getString("COMPANY_NAME"));
						ltMastVendorSisterConcerns.setMajorProducts(rs.getString("MAJOR_PRODUCTS"));
						ltMastVendorSisterConcerns.setCompanyAddress(rs.getString("COMPANY_ADDRESS"));
						ltMastVendorSisterConcerns.setCompanyContactPerson(rs.getString("COMPANY_CONTACT_PERSON"));
						ltMastVendorSisterConcerns.setCompanyContactDesg(rs.getString("COMPANY_CONTACT_DESG"));
						ltMastVendorSisterConcerns.setCompanyContactNo(rs.getString("COMPANY_CONTACT_NO"));
						ltMastVendorSisterConcerns.setCompanyContactEmail(rs.getString("COMPANY_CONTACT_EMAIL"));
						ltMastVendorSisterConcerns.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorSisterConcerns.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorSisterConcerns.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorSisterConcerns.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorSisterConcerns.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorSisterConcerns;

					}
				});
		return ltMastVendorSisterConcernsList;
	}
	
	@Override
	public LtMastVendorSisterConcerns getVendorSisterConcernsById(Long vendorSisterConcernsId) throws ServiceException 
	{
		String query = env.getProperty("getByVendorSisterConcernsId");
		
		List<LtMastVendorSisterConcerns> ltMastVendorSisterConcernsList = jdbcTemplate.query(query,
				new Object[] { vendorSisterConcernsId }, new RowMapper<LtMastVendorSisterConcerns>() {
					public LtMastVendorSisterConcerns mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorSisterConcerns ltMastVendorSisterConcerns = new LtMastVendorSisterConcerns();

						ltMastVendorSisterConcerns.setVendorSisterConcernsId(rs.getLong("VENDOR_SISTER_CONCERNS_ID"));
						ltMastVendorSisterConcerns.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorSisterConcerns.setCompanyName(rs.getString("COMPANY_NAME"));
						ltMastVendorSisterConcerns.setMajorProducts(rs.getString("MAJOR_PRODUCTS"));
						ltMastVendorSisterConcerns.setCompanyAddress(rs.getString("COMPANY_ADDRESS"));
						ltMastVendorSisterConcerns.setCompanyContactPerson(rs.getString("COMPANY_CONTACT_PERSON"));
						ltMastVendorSisterConcerns.setCompanyContactDesg(rs.getString("COMPANY_CONTACT_DESG"));
						ltMastVendorSisterConcerns.setCompanyContactNo(rs.getString("COMPANY_CONTACT_NO"));
						ltMastVendorSisterConcerns.setCompanyContactEmail(rs.getString("COMPANY_CONTACT_EMAIL"));
						ltMastVendorSisterConcerns.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorSisterConcerns.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorSisterConcerns.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorSisterConcerns.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorSisterConcerns.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorSisterConcerns;

					}
				});
		return ltMastVendorSisterConcernsList.get(0);

	}

	@Override
	public boolean save(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException {

		ltMastVendorSisterConcerns.setCreationDate(new Date());
		ltMastVendorSisterConcerns.setLastUpdateDate(new Date());
		ltMastVendorSisterConcerns.setCreatedBy(ltMastVendorSisterConcerns.getLastUpdateLogin());
		ltMastVendorSisterConcerns.setLastUpdatedBy(ltMastVendorSisterConcerns.getLastUpdateLogin());
		String query = env.getProperty("saveVendorSisterConcerns");

		int res = jdbcTemplate.update(
				query,
				ltMastVendorSisterConcerns.getVendorId(), ltMastVendorSisterConcerns.getCompanyName(),
				ltMastVendorSisterConcerns.getMajorProducts(), ltMastVendorSisterConcerns.getCompanyAddress(),
				ltMastVendorSisterConcerns.getCompanyContactPerson(),
				ltMastVendorSisterConcerns.getCompanyContactDesg(), ltMastVendorSisterConcerns.getCompanyContactNo(),
				ltMastVendorSisterConcerns.getCompanyContactEmail(), ltMastVendorSisterConcerns.getCreatedBy(),
				ltMastVendorSisterConcerns.getCreationDate(), ltMastVendorSisterConcerns.getLastUpdateLogin(),
				ltMastVendorSisterConcerns.getLastUpdatedBy(), ltMastVendorSisterConcerns.getLastUpdateDate());

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(LtMastVendorSisterConcerns ltMastVendorSisterConcerns) throws ServiceException {

		ltMastVendorSisterConcerns.setLastUpdateDate(new Date());
		ltMastVendorSisterConcerns.setLastUpdatedBy(ltMastVendorSisterConcerns.getLastUpdateLogin());
		String query = env.getProperty("updateVendorSisterConcerns");
		
		int res = jdbcTemplate.update(/*" UPDATE lt_mast_vendor_sister_concerns SET VENDOR_ID =?,COMPANY_NAME=?,MAJOR_PRODUCTS=?, "
				+ " COMPANY_ADDRESS=?,COMPANY_CONTACT_PERSON=?,COMPANY_CONTACT_DESG=?,COMPANY_CONTACT_NO=?,COMPANY_CONTACT_EMAIL=?, "
				+ " CREATED_BY=?,CREATION_DATE=?,LAST_UPDATE_LOGIN=?,LAST_UPDATED_BY=?,LAST_UPDATE_DATE=? "
				+ " WHERE VENDOR_SISTER_CONCERNS_ID=? "*/
				query,

				
				ltMastVendorSisterConcerns.getVendorId(), ltMastVendorSisterConcerns.getCompanyName(),
				ltMastVendorSisterConcerns.getMajorProducts(), ltMastVendorSisterConcerns.getCompanyAddress(),
				ltMastVendorSisterConcerns.getCompanyContactPerson(),
				ltMastVendorSisterConcerns.getCompanyContactDesg(), ltMastVendorSisterConcerns.getCompanyContactNo(),
				ltMastVendorSisterConcerns.getCompanyContactEmail(), ltMastVendorSisterConcerns.getCreatedBy(),
				ltMastVendorSisterConcerns.getCreationDate(), ltMastVendorSisterConcerns.getLastUpdateLogin(),
				ltMastVendorSisterConcerns.getLastUpdatedBy(), ltMastVendorSisterConcerns.getLastUpdateDate(),
				ltMastVendorSisterConcerns.getVendorSisterConcernsId());

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorSisterConcernsId) throws ServiceException {
		String query = env.getProperty("deleteVendorSisterConcerns");
		int res = jdbcTemplate.update(query, vendorSisterConcernsId);
		if (res == 1)
			return true;
		else
			return false;
	}



	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("deleteByVendorIdVendorSisterConcerns");
		int res = jdbcTemplate.update(query, vendorId);
		if (res == 1)
			return true;
		else
			return false;
	}



	@Override
	public Long getLtMastVendorSisterConcernsCount(Long vendorId, LtMastVendorSisterConcerns input)
			throws ServiceException {
			String query = env.getProperty("getLtMastVendorSisterConcernsCount");
		 
			String name=null;
		   if(input.getCompanyName()!=null && !input.getCompanyName().equals(""))
		   {name="%"+input.getCompanyName().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getMajorProducts()!=null && !input.getMajorProducts().equals(""))
		   {product="%"+input.getMajorProducts().trim().toUpperCase() + "%";}
		   
		   String address=null;
		   if(input.getCompanyAddress()!=null && !input.getCompanyAddress().equals(""))
		   {address="%"+input.getCompanyAddress().trim().toUpperCase() + "%";}
		   
		   String managedBy=null;
		   if(input.getCompanyContactPerson()!=null && !input.getCompanyContactPerson().equals(""))
		   {managedBy="%"+input.getCompanyContactPerson().trim().toUpperCase() + "%";}
		   
		   String designation=null;
		   if(input.getCompanyContactDesg()!=null && !input.getCompanyContactDesg().equals(""))
		   {designation="%"+input.getCompanyContactDesg().trim().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getCompanyContactEmail()!=null && !input.getCompanyContactEmail().equals("")) 
		   {email="%"+input.getCompanyContactEmail().trim().toUpperCase()+"%";}
		   
		   String contact=null;
		   if(input.getCompanyContactNo()!=null &&  !input.getCompanyContactNo().equals("")) 
		   {contact="%"+input.getCompanyContactNo().trim()+"%";}
		
	String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorId,name,product,address,managedBy,designation,email,contact}, String.class);

	return Long.parseLong(count);
	}



	@Override
	public List<LtMastVendorSisterConcerns> getLtMastVendorSisterConcernsDataTable(Long vendorId,
			LtMastVendorSisterConcerns input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorSisterConcernsDataTable");
		
		   String name=null;
		   if(input.getCompanyName()!=null && !input.getCompanyName().equals(""))
		   {name="%"+input.getCompanyName().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getMajorProducts()!=null && !input.getMajorProducts().equals(""))
		   {product="%"+input.getMajorProducts().trim().toUpperCase() + "%";}
		   
		   String address=null;
		   if(input.getCompanyAddress()!=null && !input.getCompanyAddress().equals(""))
		   {address="%"+input.getCompanyAddress().trim().toUpperCase() + "%";}
		   
		   String managedBy=null;
		   if(input.getCompanyContactPerson()!=null && !input.getCompanyContactPerson().equals(""))
		   {managedBy="%"+input.getCompanyContactPerson().trim().toUpperCase() + "%";}
		   
		   String designation=null;
		   if(input.getCompanyContactDesg()!=null && !input.getCompanyContactDesg().equals(""))
		   {designation="%"+input.getCompanyContactDesg().trim().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getCompanyContactEmail()!=null && !input.getCompanyContactEmail().equals("")) 
		   {email="%"+input.getCompanyContactEmail().trim().toUpperCase()+"%";}
		   
		   String contact=null;
		   if(input.getCompanyContactNo()!=null &&  !input.getCompanyContactNo().equals("")) 
		   {contact="%"+input.getCompanyContactNo().trim()+"%";}
		   
			List<LtMastVendorSisterConcerns> list = (List<LtMastVendorSisterConcerns>) 
					jdbcTemplate.query(query , new Object[]{vendorId,name,product,address,managedBy,designation,email,contact,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastVendorSisterConcerns>(LtMastVendorSisterConcerns.class));
				return list;
	}
}
