package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastVendorCoc;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
public class LtMastVendorCocDaoImpl implements LtMastVendorCocDao {

	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public LtMastVendorCoc getAttachmentByVendorId(Long vendorId) throws ServiceException {
		String query = " SELECT l.Comp_Conduct_Id,l.VENDOR_ID, l.Attachment_COC," + 
				"				 IS_AGREE,l.CREATED_BY, " + 
				"				 l.LAST_UPDATE_LOGIN   ,fa.FILE_NAME,fa.VENDOR_ATTACHMENT_ID   " + 
				"				 FROM LT_MAST_VENDOR_COC l ,LT_MAST_VENDOR_FILE_ATTACHMENT fa  " + 
				"				 WHERE l.VENDOR_ID =?   " + 
				"                 AND l.VENDOR_ID = fa.VENDOR_ID AND fa.VENDOR_ATTACHMENT_TYPE = 'COC' ";
		
		List<LtMastVendorCoc> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
				 new BeanPropertyRowMapper<LtMastVendorCoc>(LtMastVendorCoc.class)); 
		if(!list.isEmpty())
				return list.get(0);
		else
			return null;
	}

	@Override
	public boolean deleteLtMastVendorCoc(Long vendorId) throws ServiceException {
		String query1 = " DELETE FROM LT_MAST_VENDOR_COC WHERE VENDOR_ID = ? " ;
		int res1= 0;
		 res1=jdbcTemplate.update(query1,vendorId);
		 if(res1!=0) 
		 {   
			 String query = " DELETE FROM LT_MAST_VENDOR_FILE_ATTACHMENT WHERE VENDOR_ID = ? "
			 		+ " AND VENDOR_ATTACHMENT_TYPE = 'COC' " ;
			 int res= 0;
			 res=jdbcTemplate.update(query,vendorId);
			 if(res!=0) {
			 return true;
			 }else {
				 return false;
			 }
		 }
		 else
		 {   return false; }
			
	}

	

}
