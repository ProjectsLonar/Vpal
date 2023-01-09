package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.LtMastVendorContacts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastVendorContactsRepository;

@Component
@PropertySource(value = "classpath:queries/vendorContactsQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorContactsDaoImpl implements LtMastVendorContactsDao
{

	
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastVendorContactsRepository ltMastVendorContactsRepository;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastVendorContacts> getAllVendorsContact() throws ServiceException 
	{
		String query = env.getProperty("getAllVendorsContact");
		List<LtMastVendorContacts> list=   jdbcTemplate.query(query, new Object[]{ }, 
			 new BeanPropertyRowMapper<LtMastVendorContacts>(LtMastVendorContacts.class)); 
		return list;
	}
	
	
	@Override
	public List<LtMastVendorContacts> getVendorContactByAddressIdAndVendorId(String vendorAddrId, String vendorId)
			throws ServiceException 
	{
		String query = env.getProperty("getVendorContactByAddressIdAndVendorId");
			List<LtMastVendorContacts> list=   jdbcTemplate.query(query, new Object[]{vendorAddrId,vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorContacts>(LtMastVendorContacts.class)); 
				 return list;
	}
	
	@Override
	public LtMastVendorContacts getVendorContactByContactId(Long vendorContactId) throws ServiceException 
	{
		String query = env.getProperty("getVendorContactByContactId");
		List<LtMastVendorContacts> list=   jdbcTemplate.query(query, new Object[]{vendorContactId }, 
					 new BeanPropertyRowMapper<LtMastVendorContacts>(LtMastVendorContacts.class)); 
		if(!list.isEmpty())
				 return list.get(0);
		else
				 return null;
	}

	@Override
	public Long save(LtMastVendorContacts vendorContact) throws ServiceException
	{
		vendorContact = ltMastVendorContactsRepository.save(vendorContact);
		return vendorContact.getVendorContactId();
		/*String query = env.getProperty("saveVendorContacts");
		
		int res=jdbcTemplate.update(" INSERT INTO LT_MAST_VENDOR_CONTACTS (VENDOR_ID,VENDOR_ADD_ID,CONTACT_PERSON, "
				+ " CONTACT_MOBILE, CONTACT_EMAIL, CONTACT_TEL, CONTACT_EXT, CONTACT_FAX,Start_Date, End_Date, Created_by, "
				+ " Creation_date, Last_update_login, Last_updated_by, Last_update_date ) "
     		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
				query,
     		vendorContact.getVendorId(),vendorContact.getVendorAddId(),vendorContact.getContactPerson(),
     		vendorContact.getContactMobile(),vendorContact.getContactEmail(),vendorContact.getContactTel(),
     		vendorContact.getContactExt(),vendorContact.getContactFax(),vendorContact.getStartDate(),
     		vendorContact.getEndDate(),vendorContact.getCreatedBy(),vendorContact.getCreationDate(),
     		vendorContact.getLastUpdateLogin(),vendorContact.getLastUpdatedBy(),vendorContact.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;*/
	}

	@Override
	public boolean update(LtMastVendorContacts vendorContact) throws ServiceException 
	{
		String query = env.getProperty("updateVendorContacts");
		int res=jdbcTemplate.update(/*" UPDATE LT_MAST_VENDOR_CONTACTS SET VENDOR_ID=?,VENDOR_ADD_ID=?,CONTACT_PERSON=?, "
				+ " CONTACT_MOBILE=?, CONTACT_EMAIL=?, CONTACT_TEL=?, CONTACT_EXT=?, CONTACT_FAX=?,Start_Date=?, "
				+ " End_Date=?, Created_by=?, Creation_date=?, Last_update_login=?, Last_updated_by=?, "
				+ "Last_update_date=?  WHERE VENDOR_CONTACT_ID=? "*/
				query,
     		vendorContact.getVendorId(),vendorContact.getVendorAddId(),vendorContact.getContactPerson(),
     		vendorContact.getContactMobile(),vendorContact.getContactEmail(),vendorContact.getContactTel(),
     		vendorContact.getContactExt(),vendorContact.getContactFax(),vendorContact.getStartDate(),
     		vendorContact.getEndDate(),vendorContact.getCreatedBy(),vendorContact.getCreationDate(),
     		vendorContact.getLastUpdateLogin(),vendorContact.getLastUpdatedBy(),vendorContact.getLastUpdateDate(),
     		vendorContact.getVendorContactId());
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorContactId) throws ServiceException
	{
		String query = env.getProperty("deleteVendorContacts");
		int res=jdbcTemplate.update(query,vendorContactId);
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public List<LtMastVendorContacts> getVendorContactByVendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("getVendorContactByVendorId");
		List<LtMastVendorContacts> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
					 new BeanPropertyRowMapper<LtMastVendorContacts>(LtMastVendorContacts.class)); 
		if(!list.isEmpty())
				 return list;
		else
				 return null;
	}


	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException
	{
		String query = env.getProperty("deleteByVendorIdVendorContacts");
		int res=jdbcTemplate.update(query,vendorId);
		if(res==1)
			return true;
		else
			return false;
	}


	@Override
	public Long getLtMastVendorContactsCount(Long vendorAddressId, LtMastVendorContacts input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorContactsCount");
		 
			String contactPerson=null;
		   if(input.getContactPerson()!=null && !input.getContactPerson().equals(""))
		   {contactPerson="%"+input.getContactPerson().trim().toUpperCase() + "%";}
		   
		   String mobile=null;
		   if(input.getContactMobile()!=null && !input.getContactMobile().equals(""))
		   {mobile="%"+input.getContactMobile().trim()+"%";}
		   
		   String email=null;
		   if(input.getContactEmail()!=null && !input.getContactEmail().equals("")) 
		   {email="%"+input.getContactEmail().trim().toUpperCase()+"%";}
		   
		   String telephone=null;
		   if(input.getContactTel()!=null &&  !input.getContactTel().equals("")) 
		   {telephone="%"+input.getContactTel().trim()+"%";}
		   
		   
		   String ext=null;
		   if(input.getContactExt()!=null &&  !input.getContactExt().equals("")) 
		   {ext="%"+input.getContactExt().trim().toUpperCase()+"%";}
		   
		   String fax=null;
		   if(input.getContactFax()!=null &&  !input.getContactFax().equals("")) 
		   {fax="%"+input.getContactFax().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		
	String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorAddressId,contactPerson,mobile,email,telephone,ext,fax,
			input.getStDate(),input.getEnDate()}, String.class);

	return Long.parseLong(count);
	}


	@Override
	public List<LtMastVendorContacts> getLtMastVendorContactsDataTable(Long vendorAddressId, LtMastVendorContacts input)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorContactsDataTable");
		
		String contactPerson=null;
		   if(input.getContactPerson()!=null && !input.getContactPerson().equals(""))
		   {contactPerson="%"+input.getContactPerson().trim().toUpperCase() + "%";}
		   
		   String mobile=null;
		   if(input.getContactMobile()!=null && !input.getContactMobile().equals(""))
		   {mobile="%"+input.getContactMobile().trim()+"%";}
		   
		   String email=null;
		   if(input.getContactEmail()!=null && !input.getContactEmail().equals("")) 
		   {email="%"+input.getContactEmail().trim().toUpperCase()+"%";}
		   
		   String telephone=null;
		   if(input.getContactTel()!=null &&  !input.getContactTel().equals("")) 
		   {telephone="%"+input.getContactTel().trim()+"%";}
		   
		   
		   String ext=null;
		   if(input.getContactExt()!=null &&  !input.getContactExt().equals("")) 
		   {ext="%"+input.getContactExt().trim().toUpperCase()+"%";}
		   
		   String fax=null;
		   if(input.getContactFax()!=null &&  !input.getContactFax().equals("")) 
		   {fax="%"+input.getContactFax().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			 
			List<LtMastVendorContacts> list = (List<LtMastVendorContacts>) 
					jdbcTemplate.query(query , new Object[]{vendorAddressId,contactPerson,mobile,email,telephone,ext,fax,
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastVendorContacts>(LtMastVendorContacts.class));
				return list;
	}


	



	

}
