package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;
import com.lonar.vendor.vendorportal.repository.LtMastVendorAddressRepository;

@Component
@PropertySource(value = "classpath:queries/vendorAddressQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorsAddressDaoImpl implements LtMastVendorsAddressDao
{

	@Autowired
	private Environment env;
	
	@Autowired
	LtMastVendorAddressRepository ltMastVendorAddressRepository;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LtMastVendorAddress> getAllVendors() throws ServiceException 
	{
		
		String query = env.getProperty("findAllActiveVendorAddress");
		
		 List<LtMastVendorAddress> vendorAddressList = jdbcTemplate.query(query, new Object[]{}, 
	               new RowMapper<LtMastVendorAddress>(){
	                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
	                   {
	                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
	                	   ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
	                	   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
	                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
	                	   ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
	                	   ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
	                	   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
	                	   ltMastVendorAddress.setCity(rs.getString("CITY"));
	                	   ltMastVendorAddress.setStateName(rs.getString("STATE_NAME"));
	                	   ltMastVendorAddress.setCountry(rs.getString("COUNTRY"));
	                	   ltMastVendorAddress.setPinCode(rs.getString("PIN_CODE"));
	                	   ltMastVendorAddress.setPrimaryAddress(rs.getString("PRIMARY_ADDRESS"));
	                	   ltMastVendorAddress.setBilling(rs.getString("BILLING"));
	                	   ltMastVendorAddress.setShipping(rs.getString("SHIPPING"));
	                	   ltMastVendorAddress.setStateCode(rs.getString("STATE_CODE"));
	                	   ltMastVendorAddress.setPanBasedProvId(rs.getString("PAN_BASED_PROV_ID"));
	                	   ltMastVendorAddress.setGstRegNo(rs.getString("GST_REG_NO"));
	                	   ltMastVendorAddress.setStartDate(rs.getDate("START_DATE"));
	                	   ltMastVendorAddress.setEndDate(rs.getDate("END_DATE"));
	                	   ltMastVendorAddress.setCreatedBy(rs.getLong("CREATED_BY"));
	                	   ltMastVendorAddress.setCreationDate(rs.getDate("CREATION_DATE"));
	                	   ltMastVendorAddress.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
	                	   ltMastVendorAddress.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
	                	   ltMastVendorAddress.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
	                	   ltMastVendorAddress.setGstStartDate(rs.getDate("GST_Start_Date"));
	                	   ltMastVendorAddress.setGstEndDate(rs.getDate("GST_End_Date"));
	                	   
						return ltMastVendorAddress;
	                  
	                   } 
	               }); 
	       return vendorAddressList;
	}
	
	
	@Override
	public List<LtMastVendorAddress> getAllVendorsAddressByVendorId(Long vendorId) throws ServiceException
	{
		
		String query = env.getProperty("getAllVendorsAddressByVendorId");
		
		 List<LtMastVendorAddress> vendorAddressList = jdbcTemplate.query(query, new Object[]{vendorId}, 
	               new RowMapper<LtMastVendorAddress>(){
	                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
	                   {
	                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
	                	   ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
	                	   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
	                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
	                	  ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
	                	  ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
	                	   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
	                	   ltMastVendorAddress.setCity(rs.getString("CITY"));
	                	   ltMastVendorAddress.setStateId(rs.getLong("STATE_ID"));
	                	   ltMastVendorAddress.setStateName(rs.getString("STATE_NAME"));
	                	   ltMastVendorAddress.setCountry(rs.getString("COUNTRY"));
	                	   ltMastVendorAddress.setPinCode(rs.getString("PIN_CODE"));
	                	   ltMastVendorAddress.setPrimaryAddress(rs.getString("PRIMARY_ADDRESS"));
	                	   ltMastVendorAddress.setBilling(rs.getString("BILLING"));
	                	  ltMastVendorAddress.setShipping(rs.getString("SHIPPING"));
	                	   ltMastVendorAddress.setStateCode(rs.getString("STATE_CODE"));
	                	   ltMastVendorAddress.setPanBasedProvId(rs.getString("PAN_BASED_PROV_ID"));
	                	   ltMastVendorAddress.setGstRegNo(rs.getString("GST_REG_NO"));
	                	   ltMastVendorAddress.setStartDate(rs.getDate("START_DATE"));
	                	   ltMastVendorAddress.setEndDate(rs.getDate("END_DATE"));
	                	   ltMastVendorAddress.setCreatedBy(rs.getLong("CREATED_BY"));
	                	 ltMastVendorAddress.setCreationDate(rs.getDate("CREATION_DATE"));
	                	   ltMastVendorAddress.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
	                	   ltMastVendorAddress.setStateName(rs.getString("state_name"));
	                	   ltMastVendorAddress.setGstRegistered(rs.getString("GST_Registered"));
	                	//   ltMastVendorAddress.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
	                	//   ltMastVendorAddress.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
	                	   
						return ltMastVendorAddress;
	                  
	                   } 
	               }); 
	       return vendorAddressList;
	}

	@Override
	public List<LtMastVendorAddress> getAllActiveVendorsAddressByVendorId(Long vendorId) throws ServiceException 
	{
		
		
		String query = env.getProperty("getAllActiveVendorsAddressByVendorId");
			
			  List<LtMastVendorAddress> vendorAddressList = jdbcTemplate.query(query, new Object[]{vendorId}, 
		               new RowMapper<LtMastVendorAddress>(){
		                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
		                   {
		                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
		                	   ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
		                	   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
		                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
		                	   ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
		                	//   ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
		                	//   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
		                	//   ltMastVendorAddress.setCity(rs.getString("CITY"));
		                	//   ltMastVendorAddress.setState(rs.getString("STATE"));
		                	//   ltMastVendorAddress.setCountry(rs.getString("COUNTRY"));
		                	 //  ltMastVendorAddress.setPinCode(rs.getString("PIN_CODE"));
		                	 //  ltMastVendorAddress.setPrimaryAddress(rs.getString("PRIMARY_ADDRESS"));
		                	//   ltMastVendorAddress.setBilling(rs.getString("BILLING"));
		                	//   ltMastVendorAddress.setShipping(rs.getString("SHIPPING"));
		                	 //  ltMastVendorAddress.setStateCode(rs.getString("STATE_CODE"));
		                	 //  ltMastVendorAddress.setPanBasedProvId(rs.getString("PAN_BASED_PROV_ID"));
		                	  // ltMastVendorAddress.setGstRegNo(rs.getString("GST_REG_NO"));
		                	  // ltMastVendorAddress.setStartDate(rs.getDate("START_DATE"));
		                	  // ltMastVendorAddress.setEndDate(rs.getDate("END_DATE"));
		                	 //  ltMastVendorAddress.setCreatedBy(rs.getLong("CREATED_BY"));
		                	 //  ltMastVendorAddress.setCreationDate(rs.getDate("CREATION_DATE"));
		                	 //  ltMastVendorAddress.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
		                	 //  ltMastVendorAddress.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
		                	 //  ltMastVendorAddress.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
		                	   ltMastVendorAddress.setGstStartDate(rs.getDate("GST_Start_Date"));
		                	   ltMastVendorAddress.setGstEndDate(rs.getDate("GST_End_Date"));
							return ltMastVendorAddress;
		                  
		                   } 
		               }); 
		/*List<LtMastVendorAddress> vendorAddressList = (List<LtMastVendorAddress>) 
				jdbcTemplate.query(query , new Object[]{ vendorId},
			 new  BeanPropertyRowMapper<LtMastVendorAddress>(LtMastVendorAddress.class));*/

		       return vendorAddressList;
			
	}
	
	
	
	@Override
	public LtMastVendorAddress getVendorById(Long vendorAddId) throws ServiceException 
	{
		
		String query = env.getProperty("getVendorByIdVendorsAddress");
	
	  List<LtMastVendorAddress> list = jdbcTemplate.query(query, new Object[]{ vendorAddId }, 
               new RowMapper<LtMastVendorAddress>(){
                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
                   {
                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
                	   ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
                	   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
                	   ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
                	   ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
                	   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
                	   ltMastVendorAddress.setCity(rs.getString("CITY"));
                	   ltMastVendorAddress.setStateId(rs.getLong("STATE_ID"));
                	   ltMastVendorAddress.setStateName(rs.getString("STATE_NAME"));
                	   ltMastVendorAddress.setCountry(rs.getString("COUNTRY"));
                	   ltMastVendorAddress.setPinCode(rs.getString("PIN_CODE"));
                	   ltMastVendorAddress.setPrimaryAddress(rs.getString("PRIMARY_ADDRESS"));
                	   ltMastVendorAddress.setBilling(rs.getString("BILLING"));
                	   ltMastVendorAddress.setShipping(rs.getString("SHIPPING"));
                	   ltMastVendorAddress.setStateCode(rs.getString("STATE_CODE"));
                	   ltMastVendorAddress.setPanBasedProvId(rs.getString("PAN_BASED_PROV_ID"));
                	   ltMastVendorAddress.setGstRegNo(rs.getString("GST_REG_NO"));
                	   ltMastVendorAddress.setGstReg(rs.getString("GST_REG"));
                	   ltMastVendorAddress.setStartDate(rs.getDate("START_DATE"));
                	   ltMastVendorAddress.setEndDate(rs.getDate("END_DATE"));
                	   ltMastVendorAddress.setCreatedBy(rs.getLong("CREATED_BY"));
                	   ltMastVendorAddress.setCreationDate(rs.getDate("CREATION_DATE"));
                	   ltMastVendorAddress.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
                	   ltMastVendorAddress.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
                	   ltMastVendorAddress.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
                	   ltMastVendorAddress.setGstRegistered(rs.getString("GST_Registered"));
                	   ltMastVendorAddress.setFreightTerms(rs.getString("FREIGHT_TERMS"));
                	   ltMastVendorAddress.setFobTerms(rs.getString("FOB_TERMS"));
                	   ltMastVendorAddress.setGstStartDate(rs.getDate("GST_Start_Date"));
                	   ltMastVendorAddress.setGstEndDate(rs.getDate("GST_End_Date"));
                	   ltMastVendorAddress.setGstVendorType(rs.getString("GST_VENDOR_TYPE"));
                	   ltMastVendorAddress.setVendorRegStatus(rs.getString("VENDOR_REG_STATUS"));
                	   ltMastVendorAddress.setPaytermId(rs.getLong("PAYTERM_ID"));
					return ltMastVendorAddress;
                  
                   } 
               }); 
	//String query = env.getProperty("getLtVendCompanyBycompanyId");
		
		/*List<LtMastVendorAddress> list = (List<LtMastVendorAddress>) 
				jdbcTemplate.query(query , new Object[]{ vendorAddId},
			 new  BeanPropertyRowMapper<LtMastVendorAddress>(LtMastVendorAddress.class));*/

		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	  
	}

	@Override
	public Long save(LtMastVendorAddress vendorsAdd) throws ServiceException 
	{
		vendorsAdd = ltMastVendorAddressRepository.save(vendorsAdd);

		return vendorsAdd.getVendorAddId();
		
		/*//String query = env.getProperty("saveVendorsAddress");
		
		int res=jdbcTemplate.update(" INSERT INTO LT_MAST_VENDOR_ADDRESSES (Vendor_Add_Id,Vendor_id,Address_Code,Address_1,Address_2,Address_3, "
				+ " City,State,Country,Pin_Code, Primary_Address, Billing,Shipping,State_Code,PAN_Based_Prov_ID,GST_REG_NO, "
				+ " Start_Date, End_Date, Created_by, Creation_date, Last_update_login, Last_updated_by, Last_update_date ) "
     		+ " VALUES(lt_mast_vendor_addresses_s.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
			,
			//vendorsAdd.getVendorAddId(),
     		vendorsAdd.getVendorId(),vendorsAdd.getAddressCode(),vendorsAdd.getAddress1(),vendorsAdd.getAddress2(),vendorsAdd.getAddress3(),
     		vendorsAdd.getCity(),vendorsAdd.getState(),vendorsAdd.getCountry(),vendorsAdd.getPinCode(),vendorsAdd.getPrimaryAddress(),
     		vendorsAdd.getBilling(),vendorsAdd.getShipping(),vendorsAdd.getStateCode(),vendorsAdd.getPanBasedProvId(),vendorsAdd.getGstRegNo(),
     		vendorsAdd.getStartDate(),vendorsAdd.getEndDate(),vendorsAdd.getCreatedBy(),vendorsAdd.getCreationDate(),
     		vendorsAdd.getLastUpdateLogin(),vendorsAdd.getLastUpdatedBy(),vendorsAdd.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;*/
	}

	@Override
	public boolean update(LtMastVendorAddress vendorsAdd) throws ServiceException 
	{
		if(ltMastVendorAddressRepository.save(vendorsAdd)!=null)
		{return true;}
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorAddId) throws ServiceException 
	{
		int res=jdbcTemplate.update(" DELETE FROM LT_MAST_VENDOR_ADDRESSES WHERE Vendor_Add_Id = ? ",vendorAddId);
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("deleteByVendorIdVendorsAddress");
		int res=jdbcTemplate.update(query,vendorId);
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastVendorAddress> getAllActiveShippingAddressByVendId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getAllActiveShippingAddressByVendId");
		
		  List<LtMastVendorAddress> vendorAddressList = jdbcTemplate.query(query, new Object[]{vendorId}, 
	               new RowMapper<LtMastVendorAddress>(){
	                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
	                   {
	                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
	                	   ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
	                	   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
	                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
	                	   ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
	                	
	                	   ltMastVendorAddress.setGstStartDate(rs.getDate("GST_Start_Date"));
	                	   ltMastVendorAddress.setGstEndDate(rs.getDate("GST_End_Date"));
						return ltMastVendorAddress;
	                  
	                   } 
	               }); 

	       return vendorAddressList;
	}

	@Override
	public List<LtMastVendorAddress> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getVendorAddressDataForReport");
		
		  List<LtMastVendorAddress> list = jdbcTemplate.query(query, new Object[]{ reportParameters.getCompanyId(),
				  reportParameters.getVendorId(),reportParameters.getStatus(),reportParameters.getAddressCode(),
				  reportParameters.getAddressState(),reportParameters.getGstRegistered(),reportParameters.getGstRegStatus()}, 
	               new RowMapper<LtMastVendorAddress>(){
	                   public LtMastVendorAddress mapRow(ResultSet rs, int arg1) throws SQLException 
	                   {
	                	   LtMastVendorAddress ltMastVendorAddress = new LtMastVendorAddress();
	                	 //  ltMastVendorAddress.setVendorAddId(rs.getLong("VENDOR_ADD_ID"));
	                	//   ltMastVendorAddress.setVendorId(rs.getLong("VENDOR_ID"));
	                	   ltMastVendorAddress.setVendorCode(rs.getString("VENDOR_CODE"));
	                	   ltMastVendorAddress.setVendorName(rs.getString("VENDOR_NAME"));
	                	   ltMastVendorAddress.setVendorStatus(rs.getString("VENDOR_STATUS"));
	                	   ltMastVendorAddress.setAddressCode(rs.getString("ADDRESS_CODE"));
	                	   ltMastVendorAddress.setAddress1(rs.getString("ADDRESS_1"));
	                	   ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
	                	   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
	                	   ltMastVendorAddress.setCity(rs.getString("CITY"));
	                	   ltMastVendorAddress.setStateName(rs.getString("STATE_NAME"));
	                	   ltMastVendorAddress.setCountry(rs.getString("COUNTRY"));
	                	   ltMastVendorAddress.setPinCode(rs.getString("PIN_CODE"));
	                	   ltMastVendorAddress.setPrimaryAddress(rs.getString("PRIMARY_ADDRESS"));
	                	   ltMastVendorAddress.setBilling(rs.getString("BILLING"));
	                	   ltMastVendorAddress.setShipping(rs.getString("SHIPPING"));
	                	   ltMastVendorAddress.setStartDate(rs.getDate("START_DATE"));
	                	   ltMastVendorAddress.setEndDate(rs.getDate("END_DATE"));
	                	   ltMastVendorAddress.setGstReg(rs.getString("GST_Registered"));
	                	   ltMastVendorAddress.setStateCode(rs.getString("STATE_CODE"));
	                	   ltMastVendorAddress.setGstRegNo(rs.getString("GST_REG_NO"));
	                	   ltMastVendorAddress.setGstVendorType(rs.getString("GST_VENDOR_TYPE"));
	                	   ltMastVendorAddress.setVendorRegStatus(rs.getString("VENDOR_REG_STATUS"));
	                	   ltMastVendorAddress.setGstStartDate(rs.getDate("GST_Start_Date"));
	                	   ltMastVendorAddress.setGstEndDate(rs.getDate("GST_End_Date"));
	                	//   ltMastVendorAddress.setAddress2(rs.getString("ADDRESS_2"));
	                	//   ltMastVendorAddress.setAddress3(rs.getString("ADDRESS_3"));
	                	
	                	  // ltMastVendorAddress.setStateId(rs.getLong("STATE_ID"));
						return ltMastVendorAddress;
	                  
	                   } 
	               });
		return list; 
	}

	@Override
	public Long getLtMastVendorAddressCount(Long vendorId, LtMastVendorAddress input) throws ServiceException {
		String query = env.getProperty("getLtMastVendorAddressCount");
		 
			String addrCode=null;
		   if(input.getAddressCode()!=null && !input.getAddressCode().equals(""))
		   {addrCode="%"+input.getAddressCode().trim().toUpperCase() + "%";}
		   
		   String addr=null;
		   if(input.getAddressLine()!=null && !input.getAddressLine().equals(""))
		   {addr="%"+input.getAddressLine().trim().toUpperCase()+"%";}
		   
		   String city=null;
		   if(input.getCity()!=null && !input.getCity().equals("")) 
		   {city="%"+input.getCity().trim().toUpperCase()+"%";}
		   
		   String state=null;
		   if(input.getStateName()!=null &&  !input.getStateName().equals("")) 
		   {state="%"+input.getStateName().trim().trim().toUpperCase()+"%";}
		   
		   
		   String country=null;
		   if(input.getCountry()!=null &&  !input.getCountry().equals("")) 
		   {country="%"+input.getCountry().trim().trim().toUpperCase()+"%";}
		   
		   String primaryAddr=null;
		   if(input.getPrimaryAddress()!=null &&  !input.getPrimaryAddress().equals("")) 
		   {primaryAddr="%"+input.getPrimaryAddress().trim().trim().toUpperCase()+"%";}
		   
		   
		   String stateCode=null;
		   if(input.getStateCode()!=null &&  !input.getStateCode().equals("")) 
		   {stateCode="%"+input.getStateCode().trim().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = jdbcTemplate.queryForObject(query, new Object[] {vendorId,addrCode,addr,city,state,country,primaryAddr,stateCode,
				input.getStDate(),input.getEnDate()}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtMastVendorAddress> getLtMastVendorAddressDataTable(Long vendorId, LtMastVendorAddress input)
			throws ServiceException {
		String query = env.getProperty("getLtMastVendorAddressDataTable");
		
		String addrCode=null;
		   if(input.getAddressCode()!=null && !input.getAddressCode().equals(""))
		   {addrCode="%"+input.getAddressCode().trim().toUpperCase() + "%";}
		   
		   String addr=null;
		   if(input.getAddressLine()!=null && !input.getAddressLine().equals(""))
		   {addr="%"+input.getAddressLine().trim().toUpperCase()+"%";}
		   
		   String city=null;
		   if(input.getCity()!=null && !input.getCity().equals("")) 
		   {city="%"+input.getCity().trim().toUpperCase()+"%";}
		   
		   String state=null;
		   if(input.getStateName()!=null &&  !input.getStateName().equals("")) 
		   {state="%"+input.getStateName().trim().toUpperCase()+"%";}
		   
		   
		   String country=null;
		   if(input.getCountry()!=null &&  !input.getCountry().equals("")) 
		   {country="%"+input.getCountry().trim().toUpperCase()+"%";}
		   
		   String primaryAddr=null;
		   if(input.getPrimaryAddress()!=null &&  !input.getPrimaryAddress().equals("")) 
		   {primaryAddr="%"+input.getPrimaryAddress().trim().toUpperCase()+"%";}
		   
		   
		   String stateCode=null;
		   if(input.getStateCode()!=null &&  !input.getStateCode().equals("")) 
		   {stateCode="%"+input.getStateCode().trim().toUpperCase()+"%";}
		   
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			List<LtMastVendorAddress> list = (List<LtMastVendorAddress>) 
					jdbcTemplate.query(query , new Object[]{vendorId,addrCode,addr,city,state,country,primaryAddr,stateCode,
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
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastVendorAddress>(LtMastVendorAddress.class));
				return list;
		
	}

	

	

}
