package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Repository
@PropertySource(value = "classpath:queries/communicationQueries.properties", ignoreResourceNotFound = true)
public class LtMastCommunicationTabDaoImpl implements LtMastCommunicationTabDao{

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
	public LtMastCommunicationTab getByVendorBuyer(Long vendorId,Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastCommunicationTabByVendorBuyer");
		//String query = " SELECT * FROM LT_MAST_COMMUNICATION_TAB WHERE VENDOR_ID = ? AND COMPANY_ID = ? ";
		
		List<LtMastCommunicationTab> list=   jdbcTemplate.query(query, new Object[]{ vendorId,companyId }, 
				 new BeanPropertyRowMapper<LtMastCommunicationTab>(LtMastCommunicationTab.class)); 
		 
		if(!list.isEmpty())
		return list.get(0);
		else return null;
	}

	@Override
	public List<LtMastCommunicationTab> getAllCommunicationByComId(Long companyId) throws ServiceException {
		
		String query = env.getProperty("getAllCommunicationByComId");
		
		List<LtMastCommunicationTab> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
				 new BeanPropertyRowMapper<LtMastCommunicationTab>(LtMastCommunicationTab.class));
		return list; 
	}

	@Override
	public List<LtMastCommunicationTab> getallvendorcommunication(Long commId) throws ServiceException {
		
		String query = env.getProperty("getallvendorcommunication");
		List<LtMastCommunicationTab> list=   jdbcTemplate.query(query, new Object[]{commId }, 
				 new BeanPropertyRowMapper<LtMastCommunicationTab>(LtMastCommunicationTab.class));
		return list; 
	}

	@Override
	public List<LtMastCommunicationTab> getAllBuyerCommunication(Long vendorId) throws ServiceException {
		String query = env.getProperty("getAllBuyerCommunication");
		List<LtMastCommunicationTab> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
				 new BeanPropertyRowMapper<LtMastCommunicationTab>(LtMastCommunicationTab.class));
		return list; 
	}

	@Override
	public Status getVendorNotificationCount(Long buyerId) throws ServiceException {
		
		String query = env.getProperty("getVendorNotificationCount");
		  Status status = new Status();
					List<VendorBuyerDetails> list = jdbcTemplate.query(query, new Object[]{ buyerId }, 
							 new BeanPropertyRowMapper<VendorBuyerDetails>(VendorBuyerDetails.class)); 
				  status.setData(list);
				  status.setMessage("Vendor Notification Count");
				return status;
	}

	@Override
	public Status getBuuyerNotificationCount(Long buyerId) throws ServiceException {
		  Status status = new Status();
		  String query = env.getProperty("getBuuyerNotificationCount"); 
					List<VendorBuyerDetails> list = jdbcTemplate.query(query, new Object[]{ buyerId }, 
							 new BeanPropertyRowMapper<VendorBuyerDetails>(VendorBuyerDetails.class)); 
				  status.setData(list);
				  status.setMessage("Buyer Notification Count");
				return status;
	}

	@Override
	public Status updateVendorNotification(Long buyerId) throws ServiceException {
		Status status = new Status();
		
		String query = env.getProperty("updateVendorNotification"); 
		jdbcTemplate.update(query, new Object[] { buyerId});
		status.setMessage("Data updated successfully");
		return status;
	}

	@Override
	public Status updateBuuyerNotification(Long buyerId, Long vendorId) throws ServiceException {
		Status status = new Status();
		 
		String query = env.getProperty("updateBuuyerNotification");
		
		//String query = " update LT_MAST_COMMUNICATION_TAB_DET set NOTIFICATION_FLAG = 'N' Where BUYER_ID = ? AND VENDOR_ID = ?";
		jdbcTemplate.update(query, new Object[] {  vendorId});
		status.setMessage("Data updated successfully");
		return status;
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerId(String name, Long buyerId) throws ServiceException {
		String query = env.getProperty("getLikeNameByBuyerId"); 
		List<LtMastVendors> list=   jdbcTemplate.query(query, new Object[]{ buyerId,"%"+ name.toUpperCase() +"%"
				}, 
				 new BeanPropertyRowMapper<LtMastVendors>(LtMastVendors.class)); 
		return list;
	}

	@Override
	public List<LtMastVendors> getLikeNameByBuyerName(String name) throws ServiceException {
		String query = env.getProperty("getLikeNameByBuyerName"); 
		List<LtMastVendors> list=   jdbcTemplate.query(query, new Object[]{ "%"+ name.toUpperCase() +"%"
				}, 
				 new BeanPropertyRowMapper<LtMastVendors>(LtMastVendors.class)); 
		return list;
	}

	@Override
	public List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException {
		String query = env.getProperty("getVendorMsgByBuyerId");
		
		List<VendorBuyerDetails> list = jdbcTemplate.query(query, new Object[]{ buyerId }, 
				 new BeanPropertyRowMapper<VendorBuyerDetails>(VendorBuyerDetails.class)); 
		return list;
	}

}
