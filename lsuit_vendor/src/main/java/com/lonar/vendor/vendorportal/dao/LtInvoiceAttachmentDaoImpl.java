package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtInvoiceAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
public class LtInvoiceAttachmentDaoImpl implements LtInvoiceAttachmentDao {
	
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

	@Override
	public List<LtInvoiceAttachment> getAllFilesByInvoiceId(Long invoiceId) throws ServiceException {
		String query  = " SELECT  nvl2(l.FILE_NAME,svm.SYSTEM_VALUE||l.FILE_NAME,'') AS FILE_PATH,\r\n" + 
				"l.INVOICE_ATTACHMENT_ID,l.INVOICE_ID,l.ATTACHMENT_TYPE_ID,l.FILE_NAME, atm.ATTACHMENT_NAME as ATTACHMENT_TYPE  " + 
				"FROM LT_INVOICE_ATTACHMENT l, "+
				"    LT_MAST_ATTACHMENT_TYPE atm  ," + 
				"    LT_MAST_SYS_VARIABLES svm " + 
				"     WHERE l.INVOICE_ID = ? AND svm.VARIABLE_NAME = 'FILE_OPEN_PATH'  " + 
				"     AND svm.COMPANY_ID = ( SELECT COMPANY_ID FROM LT_MAST_EMPLOYEES WHERE EMPLOYEE_ID = " + 
				"                            (SELECT BUYER_ID FROM LT_INVOICE_HEADERS ih WHERE ih.INVOICE_HEADER_ID = l.INVOICE_ID ) ) " + 
				"    AND l.ATTACHMENT_TYPE_ID = atm.ATTACHMENT_TYPE_ID(+)";
		List<LtInvoiceAttachment> list=   jdbcTemplate.query(query, new Object[]{invoiceId }, 
				 new BeanPropertyRowMapper<LtInvoiceAttachment>(LtInvoiceAttachment.class)); 
		
		return list;
	}

	@Override
	public LtInvoiceAttachment getAttachmentByInvoiceIdAndType(Long invoiceId) throws ServiceException {
		
		String query = " SELECT l.*   "
				+ "FROM LT_INVOICE_ATTACHMENT l  "
				+ "WHERE l.INVOICE_ID = ? "
				+ "AND l.ATTACHMENT_TYPE_ID = 'COC' ";
		
		List<LtInvoiceAttachment> list=   jdbcTemplate.query(query, new Object[]{invoiceId }, 
				 new BeanPropertyRowMapper<LtInvoiceAttachment>(LtInvoiceAttachment.class)); 
		if(!list.isEmpty())
				return list.get(0);
		else
			return null;
	}

	@Override
	public boolean deleteLtMastInvoiceAttachmentFile(Long invoiceAttachmentId) {
		String query = 	"delete from LT_INVOICE_ATTACHMENT where INVOICE_ATTACHMENT_ID = ?";
		int res= 0;
		res= jdbcTemplate.update(query,invoiceAttachmentId);
		if(res!=0)
			return true;
		else
			return false;
	}

}
