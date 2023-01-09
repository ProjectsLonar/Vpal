package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtAttachment;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendCompanyAttachments;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendCompanyAttachmentsQueries.properties", ignoreResourceNotFound = true)
public class LtVendCompanyAttachmentsDaoImpl implements LtVendCompanyAttachmentsDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public List<LtVendCompanyAttachments> getBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getVendCompanyAttachmentsBycompanyId");
		
		List<LtVendCompanyAttachments> list = (List<LtVendCompanyAttachments>) 
				jdbcTemplate.query(query , new Object[]{companyId },
		new  BeanPropertyRowMapper<LtVendCompanyAttachments>(LtVendCompanyAttachments.class));
		return list;
	}

	@Override
	public LtVendCompanyAttachments getById(Long id) throws ServiceException {
		String query = env.getProperty("getVendCompanyAttachmentsById");
		
		List<LtVendCompanyAttachments> list = (List<LtVendCompanyAttachments>) 
				jdbcTemplate.query(query , new Object[]{id },
		new  BeanPropertyRowMapper<LtVendCompanyAttachments>(LtVendCompanyAttachments.class));
		return list.get(0);
	}

	@Override
	public List<LtVendCompanyAttachments> getAll() throws ServiceException {
		String query = env.getProperty("getAllVendCompanyAttachments");
		
		List<LtVendCompanyAttachments> list = (List<LtVendCompanyAttachments>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyAttachments>(LtVendCompanyAttachments.class));
		return list;
	}

	@Override
	public List<LtVendCompanyAttachments> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveVendCompanyAttachments");
		
		List<LtVendCompanyAttachments> list = (List<LtVendCompanyAttachments>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendCompanyAttachments>(LtVendCompanyAttachments.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtAttachment> getCompanyVendAttachmentByCompanyId(Long companyId)
			throws ServiceException {
		String query = env.getProperty("getCompanyVendAttachmentByCompanyId");
		
		List<LtCompanyVenMgmtAttachment> list = (List<LtCompanyVenMgmtAttachment>) 
				jdbcTemplate.query(query , new Object[]{companyId },
		new  BeanPropertyRowMapper<LtCompanyVenMgmtAttachment>(LtCompanyVenMgmtAttachment.class));
		return list;
	}

	@Override
	public boolean deleteCompanyVendAttachmentByVendorCompanyId(Long companyId, Long vendorId) throws ServiceException {
		int res=0;
		 res=jdbcTemplate.update(" DELETE FROM LT_COMPANY_VEN_MGMT_ATTACHMENT "
				+ "  WHERE COMPANY_ID = ? AND VENDOR_ID = ? ",companyId,vendorId);
		if(res!=0) {
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<LtMastVendors> getVendorsByCompanyId(Long companyId) throws ServiceException {
		String query = " SELECT * FROM LT_MAST_VENDORS WHERE COMPANY_ID = ? AND STATUS IN ( ?,?,?,?,? ) ";
		
		List<LtMastVendors> list = (List<LtMastVendors>) 
				jdbcTemplate.query(query , new Object[]{companyId,"VENDOR_DRAFT","INVITED","REJECTED","VENDOR_ACTIVE","WITHDRAW" },
		new  BeanPropertyRowMapper<LtMastVendors>(LtMastVendors.class));
		return list;
	}

	@Override
	public boolean deleteVendorAttachment(Long companyId, Long vendorId) throws ServiceException {
		int res1=0;
		 res1=jdbcTemplate.update(" DELETE FROM LT_MAST_VENDOR_FILE_ATTACHMENT "
				+ "  WHERE  VENDOR_ID = ? AND VENDOR_ATTACHMENT_TYPE NOT IN "
				+ " ( SELECT ATTACHMENT_NAME FROM LT_COMPANY_VEN_MGMT_ATTACHMENT WHERE COMPANY_ID = ? AND VENDOR_ID = ? )"
				,vendorId,companyId,vendorId);
		 if(res1!=0) {
			 return true;
		 }else
		{	return false; }
	}

	@Override
	public List<LtVendCompanyAttachments> getDifference(Long companyId,Long vendorId) throws ServiceException {
		String query = env.getProperty("getDifferenceBetCompanyAndConfig");
		
		List<LtVendCompanyAttachments> list = (List<LtVendCompanyAttachments>) 
				jdbcTemplate.query(query , new Object[]{companyId,companyId,vendorId },
		new  BeanPropertyRowMapper<LtVendCompanyAttachments>(LtVendCompanyAttachments.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtAttachment> getConfigDifference(Long companyId, Long vendorId) throws ServiceException {
		String query = env.getProperty("getDifferenceBetConfigAndCompany");
		
		List<LtCompanyVenMgmtAttachment> list = (List<LtCompanyVenMgmtAttachment>) 
				jdbcTemplate.query(query , new Object[]{companyId,vendorId },
		new  BeanPropertyRowMapper<LtCompanyVenMgmtAttachment>(LtCompanyVenMgmtAttachment.class));
		return list;
	}

}
