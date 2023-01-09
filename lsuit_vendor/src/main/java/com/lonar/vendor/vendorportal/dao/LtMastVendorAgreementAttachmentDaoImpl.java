package com.lonar.vendor.vendorportal.dao;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
public class LtMastVendorAgreementAttachmentDaoImpl implements LtMastVendorAgreementAttachmentDao
{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean multipleSave(Long vendorId,Long vendorAgreementtId, String fileName, String saveAttachmentDirectory) throws ServiceException
	{
		int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT (VENDOR_ATTACHMENT_ID,VENDOR_ID,VENDOR_AGREEMENT_ID,FILE_NAME, "
				+ " FILE_PATH,LAST_UPDATE_DATE,CREATION_DATE)"
        		+ " VALUES(LT_MAST_VENDOR_FILE_ATTACH_S.nextval,?,?,?,?,?,?)", 
        		vendorId,vendorAgreementtId,fileName,saveAttachmentDirectory,new Date(),new Date() );
		if(res!=0)
		 return true;
				
		else
			return false;// msg += "You have successfully uploaded " + fileName +"<br/>";
		
	}

	@Override
	public boolean deleteFile(Long vendorAttachmentId) throws ServiceException 
	{
		int res=jdbcTemplate.update("DELETE FROM LT_MAST_VENDOR_FILE_ATTACHMENT WHERE VENDOR_AGREEMENT_ID =? ", vendorAttachmentId);
		if(res==1)
		 return true;
				
		else
			return false;
	}

	@Override
	public boolean multipleUpdate(Long vendorId, Long agreementId, String fileName, String saveDirectory)
			throws ServiceException {
		/*int res=jdbcTemplate.update(" UPDATE LT_MAST_VENDOR_FILE_ATTACHMENT SET FILE_NAME = ?,FILE_PATH = ?,LAST_UPDATE_DATE = ? "
				+ " WHERE VENDOR_AGREEMENT_ID = ? AND VENDOR_ID = ? ",
				fileName,saveDirectory,new Date(),agreementId,vendorId);
		if(res!=0)
		 return true;
				
		else
			return false;*/
		int res=jdbcTemplate.update("INSERT INTO LT_MAST_VENDOR_FILE_ATTACHMENT (VENDOR_ATTACHMENT_ID,VENDOR_ID,VENDOR_AGREEMENT_ID,FILE_NAME, "
				+ " FILE_PATH,LAST_UPDATE_DATE,CREATION_DATE)"
        		+ " VALUES(LT_MAST_VENDOR_FILE_ATTACH_S.nextval,?,?,?,?,?,?)", 
        		vendorId,agreementId,fileName,saveDirectory,new Date(),new Date() );
		if(res!=0)
		 return true;
				
		else
			return false;
	}

	

}
