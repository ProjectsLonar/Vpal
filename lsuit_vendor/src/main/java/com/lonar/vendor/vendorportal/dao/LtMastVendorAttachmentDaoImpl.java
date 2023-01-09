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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value = "classpath:queries/vendorQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorAttachmentDaoImpl implements LtMastVendorAttachmentDao {

	
	
	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Autowired
	private Environment env;
	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	@Override
	public List<LtMastVendorAttachment> getAllFilesByVendorId(Long vendorId) throws ServiceException
	{
		
		String query = env.getProperty("getAllVendorAttachedFilesByVendorId");
		
		/*String query = "SELECT l.VENDOR_ATTACHMENT_ID,l.VENDOR_ID,l.VENDOR_AGREEMENT_ID, l.VENDOR_ATTACHMENT_TYPE, "
				+ " cmv.value_name as ATTACHMENT_TYPE,l.FILE_NAME,l.FILE_PATH,l.CREATED_BY, "
				+ " l.LAST_UPDATE_LOGIN   "
				+ " FROM LT_MAST_VENDOR_FILE_ATTACHMENT l,LT_MAST_COMN_MASTER_VALUES cmv "
				+ " WHERE l.VENDOR_ID = ? "
				+ " AND l.VENDOR_ATTACHMENT_TYPE = cmv.value_code(+) "
				+ " AND l.VENDOR_ATTACHMENT_TYPE != 'COC' ";*/
		
		 return jdbcTemplate.query(query, new Object[]{vendorId }, new RowMapper<LtMastVendorAttachment>(){
				@Override
				public LtMastVendorAttachment mapRow(ResultSet rs, int row)
						throws SQLException {
					LtMastVendorAttachment ltMastVendorAttachment=new LtMastVendorAttachment();
					
					ltMastVendorAttachment.setVendorAttachmentId(rs.getLong("VENDOR_ATTACHMENT_ID"));
					ltMastVendorAttachment.setVendorId(rs.getLong("VENDOR_ID"));
					ltMastVendorAttachment.setVendorAgreementId(rs.getLong("VENDOR_AGREEMENT_ID"));
					ltMastVendorAttachment.setFileName(rs.getString("FILE_NAME"));
					ltMastVendorAttachment.setFilePath(rs.getString("FILE_PATH"));
					ltMastVendorAttachment.setVendorAttachmentType(rs.getString("VENDOR_ATTACHMENT_TYPE"));
					ltMastVendorAttachment.setCreatedBy(rs.getLong("CREATED_BY"));
					ltMastVendorAttachment.setVendorAttachmentType(rs.getString("VENDOR_ATTACHMENT_TYPE"));
					ltMastVendorAttachment.setAttachmentType(rs.getString("ATTACHMENT_TYPE"));
					//ltMastVendorAttachment.setCreationDate(rs.getDate("CREATION_DATE"));
					//ltMastVendorAttachment.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
					//ltMastVendorAttachment.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
					//ltMastVendorAttachment.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
					
						return ltMastVendorAttachment;
					}
					
			   });
	}
	
	@Override
	public boolean delete(String expenseFileUploadId) throws ServiceException 
	{
		String query = env.getProperty("sdgfdhfjgkhljxbdjhfvg");
		
		int res = jdbcTemplate.update(query, expenseFileUploadId);

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteLtMastVendorAttachment(Long expenseFileUploadId) throws ServiceException {
	String query = 	env.getProperty("deleteExpenseAttachment");
		int res= 0;
		res= jdbcTemplate.update(query,expenseFileUploadId);
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteLtMastVendorAttachmentFile(Long vendorAttachmentId) {
		String query = 	"delete from LT_MAST_VENDOR_FILE_ATTACHMENT where VENDOR_ATTACHMENT_ID = ?";
		int res= 0;
		res= jdbcTemplate.update(query,vendorAttachmentId);
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public LtMastVendorAttachment getAttachmentByVendorIdAndType(Long vendorId) throws ServiceException {
		String query = "SELECT l.VENDOR_ATTACHMENT_ID,l.VENDOR_ID,l.VENDOR_AGREEMENT_ID, l.VENDOR_ATTACHMENT_TYPE, "
				+ " l.FILE_NAME,l.FILE_PATH,l.CREATED_BY, "
				+ " l.LAST_UPDATE_LOGIN   "
				+ " FROM LT_MAST_VENDOR_FILE_ATTACHMENT l "
				+ " WHERE l.VENDOR_ID = ? "
				+ " AND l.VENDOR_ATTACHMENT_TYPE = 'COC' ";
		
		List<LtMastVendorAttachment> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
				 new BeanPropertyRowMapper<LtMastVendorAttachment>(LtMastVendorAttachment.class)); 
		if(!list.isEmpty())
				return list.get(0);
		else
			return null;
		
	}

	
}
