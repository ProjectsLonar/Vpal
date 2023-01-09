package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/billingMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastBillingAddressesDaoImpl implements LtMastBillingAddressesDao
{
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

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Override
	public List<LtMastBillingAddresses> getLikeBillingAddressCode(String name) throws ServiceException 
	{

		String query = env.getProperty("getLikeBillingAddressCode");
		
		List<LtMastBillingAddresses> list=   jdbcTemplate.query(query, new Object[]{ name.toUpperCase() }, 
				 new BeanPropertyRowMapper<LtMastBillingAddresses>(LtMastBillingAddresses.class)); 
		 
		
		return list;
	}

	@Override
	public LtMastBillingAddresses getByBillingId(Long id) throws ServiceException {

		String query = env.getProperty("getByBillingId");
		
		List<LtMastBillingAddresses> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtMastBillingAddresses>(LtMastBillingAddresses.class)); 
		 if(list.isEmpty())
			 return null;
		 else
		return list.get(0);
	}

	
	//------------------------------------------------------------------------------------------------
	@Override
	public List<LtMastBillingAddresses> getByBillingAddresses(String name) throws ServiceException{
			/*StringBuilder strb = new StringBuilder( " select  distinct lpv.vendor_id ,lpva.state vendor_state, BILLING_ADDRESS,BILLING_ADDRESS_ID " 
                    +" from lt_p2p_vendors  lpv, lt_p2p_vendor_addresses lpva , LT_P2P_BILLING_ADDRESSES lpba "
                   + " where lpv.vendor_id = lpva.vendor_id and lpva.STATE = lpba.BILLING_ADDRESS_STATE "
                   + " and lpva.vendor_id= ? and UPPER(BILLING_ADDRESS) like '%'|| ? ||'%' " );*/
			
			StringBuilder strb = new StringBuilder( "select BILLING_ADDRESS_ID, BILLING_ADDRESS, BILLING_ADDRESS_STATE "
				+ " FROM  LT_P2P_BILLING_ADDRESSES "
				+ " WHERE UPPER(BILLING_ADDRESS) like '%'|| ? ||'%'");
		
			List<LtMastBillingAddresses> ltP2pBillingAddressesList =jdbcTemplate.query(strb.toString(),  new Object[] {  name.toUpperCase()} , 
					new RowMapper<LtMastBillingAddresses>() {

						@Override
						public LtMastBillingAddresses mapRow(ResultSet rs, int arg1) throws SQLException {
							LtMastBillingAddresses ltP2pBillingAddresses = new LtMastBillingAddresses();
							//ltP2pBillingAddresses.setVendorId(rs.getLong("vendor_id"));
							ltP2pBillingAddresses.setBillingAddress(rs.getString("BILLING_ADDRESS"));
							ltP2pBillingAddresses.setBillingAddressId(rs.getLong("BILLING_ADDRESS_ID"));
							//ltP2pBillingAddresses.setBillingAddressCode(rs.getString("BILLING_ADDRESS_CODE"));
							//ltP2pBillingAddresses.setBillingAddress(rs.getString("BILLING_ADDRESS"));
							ltP2pBillingAddresses.setBillingAddressState(rs.getString("BILLING_ADDRESS_STATE"));
							return ltP2pBillingAddresses;
						}
			});
		
			return ltP2pBillingAddressesList;
	}

	@Override
	public List<LtMastBillingAddresses> getLikeBillingAddressByState(Long venId, String name) throws ServiceException
	{
			StringBuilder strb = new StringBuilder("select  distinct lpv.vendor_id ,lpva.state vendor_state, BILLING_ADDRESS "
						+" from lt_p2p_vendors  lpv, lt_p2p_vendor_addresses lpva , LT_P2P_BILLING_ADDRESSES lpba "
						+" where lpv.vendor_id=lpva.vendor_id and UPPER(lpva.STATE)=UPPER(lpba.BILLING_ADDRESS_STATE) and "
						+" lpva.vendor_id=? ");
			
			
			return   jdbcTemplate.query(strb.toString(),  new Object[] { venId,name} , 
					new RowMapper<LtMastBillingAddresses>() {

						@Override
						public LtMastBillingAddresses mapRow(ResultSet rs, int arg1) throws SQLException {
							LtMastBillingAddresses ltP2pBillingAddresses = new LtMastBillingAddresses();
							 
							ltP2pBillingAddresses.setVendorId(rs.getLong("vendor_id"));
							
							ltP2pBillingAddresses.setBillingAddressId(rs.getLong("BILLING_ADDRESS_ID"));
							ltP2pBillingAddresses.setBillingAddressCode(rs.getString("BILLING_ADDRESS_CODE"));
							ltP2pBillingAddresses.setBillingAddress(rs.getString("BILLING_ADDRESS"));
							ltP2pBillingAddresses.setBillingAddressState(rs.getString("BILLING_ADDRESS_STATE"));
							
						
							return ltP2pBillingAddresses;
						}
			});
			
		}

	@Override
	public Long getCount(LtMastBillingAddresses input) throws ServiceException {
		String query = env.getProperty("getCountBillingAddresses");
		 
		   String addrCode=null;
		   if(input.getBillingAddressCode()!=null)
		   {addrCode="%"+input.getBillingAddressCode().toUpperCase()+"%";}
		   
		   String addrName=null;
		   if(input.getBillingAddress()!=null)
		   {addrName="%"+input.getBillingAddress().toUpperCase()+"%";}
		   
		   String addState=null;
		   if(input.getBillingAddressState()!=null)
		   {addState="%"+input.getBillingAddressState().toUpperCase()+"%";}
		   
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
				query, new Object[] {addrCode,addrName,addState,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastBillingAddresses> getDatatableRecords(LtMastBillingAddresses input) throws ServiceException {
		String query = env.getProperty("getBillingAddressesDatatableRecords");
		 
		 String addrCode=null;
		   if(input.getBillingAddressCode()!=null && !input.getBillingAddressCode().equals(""))
		   {addrCode="%"+input.getBillingAddressCode().toUpperCase()+"%";}
		   
		   String addrName=null;
		   if(input.getBillingAddress()!=null && !input.getBillingAddress().equals(""))
		   {addrName="%"+input.getBillingAddress().toUpperCase()+"%";}
		   
		   String addState=null;
		   if(input.getBillingAddressState()!=null && !input.getBillingAddressState().equals(""))
		   {addState="%"+input.getBillingAddressState().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null && !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			
			
			List<LtMastBillingAddresses> list = (List<LtMastBillingAddresses>) 
					jdbcTemplate.query(query , new Object[]{addrCode,addrName,addState,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastBillingAddresses>(LtMastBillingAddresses.class));
			
				return list;
	}

	@Override
	public LtMastBillingAddresses getByBillingAddressCode(String billingAddressCode) throws ServiceException {
		String query = env.getProperty("getByBillingAddressCode");
		
		List<LtMastBillingAddresses> list=   jdbcTemplate.query(query, new Object[]{ billingAddressCode.toUpperCase() }, 
				 new BeanPropertyRowMapper<LtMastBillingAddresses>(LtMastBillingAddresses.class)); 
		 
		if(!list.isEmpty())
		return list.get(0);
		else return null;
		
	} 
		
		
		
	

}
