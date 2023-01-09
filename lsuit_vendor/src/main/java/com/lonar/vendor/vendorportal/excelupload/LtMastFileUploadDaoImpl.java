package com.lonar.vendor.vendorportal.excelupload;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Repository
@PropertySource(value = "classpath:queries/invoiceFileUploadQueries.properties", ignoreResourceNotFound = true)
public class LtMastFileUploadDaoImpl implements LtMastFileUploadDao,CodeMaster{

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Autowired
	LtInvoiceHeadersStgRepository ltInvoiceHeadersStgRepository;
	
	@Autowired
	private Environment env;
	
	//@Autowired
	///LtInvoiceLinesStgRepository ltInvoiceLinesStgRepository;
	
	//@Autowired
	//LtInvoiceLinesTaxStgRepository ltInvoiceLinesTaxStgRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(LtInvoiceHeadersStg ltInvoiceHeadersStg) throws ServiceException {
		
		ltInvoiceHeadersStg  = ltInvoiceHeadersStgRepository.save(ltInvoiceHeadersStg);
		if(ltInvoiceHeadersStg.getInvoiceImportId()!=null)
			return true;
		else
			return false;
	}

	@Override
	public Long getRequestId() throws ServiceException {
		String query = "SELECT LT_INVOICE_IMPORT_REQUEST_S.NEXTVAL FROM DUAL";
		String requestId  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {}, String.class);
		
		if(requestId!=null) {
			return Long.valueOf(requestId);
		}else
			return null;
	}

	@Override
	public List<LtInvoiceHeadersStg> getByRequestId(Long requestId) throws ServiceException {
		String query = "SELECT * FROM LT_INVOICE_HEADERS_STG WHERE REQUEST_ID = ?";
		List<LtInvoiceHeadersStg> list=   jdbcTemplate.query(query, new Object[]{requestId }, 
				 new BeanPropertyRowMapper<LtInvoiceHeadersStg>(LtInvoiceHeadersStg.class)); 
		return list;
	}

	@Override
	public Status createInvoiceProcedure(Long requestId) throws ServiceException {
		Status status = new Status();
		StoredProcedureQuery query = em
			    .createStoredProcedureQuery("lt_vpal_invoice_import_pkg.import_invoices")
			    .registerStoredProcedureParameter(1, Long.class, 
				         ParameterMode.IN)
			    .registerStoredProcedureParameter(2, String.class, 
			         ParameterMode.OUT)
		        .registerStoredProcedureParameter(3, String.class, 
		         ParameterMode.OUT)
			    .setParameter(1, requestId);
			query.execute();

			System.out.println("query.getOutputParameterValue(2).toString() "+query.getOutputParameterValue(2).toString()); 
			System.out.println("query.getOutputParameterValue(3).toString() "+query.getOutputParameterValue(3).toString());
			if(query.getOutputParameterValue(2).toString().trim().equals("ERROR")){
				
				System.out.println("1");
				status.setCode(FAIL);
				status.setMessage(query.getOutputParameterValue(3).toString().trim());
			}
			else if(query.getOutputParameterValue(2).toString().trim().equals("SUCCESS")){
				System.out.println("2");
				status.setCode(SUCCESS);
				status.setMessage(query.getOutputParameterValue(3).toString().trim());
				
			}else if(query.getOutputParameterValue(2).toString().trim().equals("WARNING")){
				System.out.println("3");
				status.setCode(FAIL);
				status.setMessage(query.getOutputParameterValue(3).toString().trim());
				
			}
			return status;
	}
	
	/*INVOICE_TYPE
	INVOICE_NUMBER
	INVOICE_DATE ==
	Description
	PO_NUMBER
	STATUS*/

	@Override
	public Long getLtInvoiceHeadersStgCount(Long requestId, LtInvoiceHeadersStg input) throws ServiceException {
		String query = env.getProperty("getLtInvoiceHeadersStgCount");

		String invoiceType = null;
		if (input.getInvoiceType() != null && !input.getInvoiceType().equals("")) {
			invoiceType = "%" + input.getInvoiceType().trim().toUpperCase() + "%";
		}

		String invoiceNumber = null;
		if (input.getInvoiceNumber() != null && !input.getInvoiceNumber().equals("")) {
			invoiceNumber =  "%" + input.getInvoiceNumber().trim().toUpperCase() + "%";
		}

		String invoiceLineNumber = null;
		if (input.getInvoiceLineNumber() != null && !input.getInvoiceLineNumber().equals("")) {
			invoiceLineNumber =  "%" + input.getInvoiceLineNumber() + "%";
		}
		
		String invoiceDescription = null;
		if (input.getDescription() != null && !input.getDescription().equals("")) {
			invoiceDescription = "%" + input.getDescription().trim().toUpperCase() + "%";
		}

		if(input.getiDate() == null || input.getiDate().trim().equals(""))
		{
			input.setiDate(null);
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String status = null;
		if (input.getRecordStatus() != null && !input.getRecordStatus().equals("")) {
			status = "%" + input.getRecordStatus().trim().toUpperCase() + "%";
		}
		
		String buyer = null;
		if (input.getBuyer() != null && !input.getBuyer().equals("")) {
			buyer = "%" + input.getBuyer().trim().toUpperCase() + "%";
		}
		
		String vendor = null;
		if (input.getVendorCode() != null && !input.getVendorCode().equals("")) {
			vendor = "%" + input.getVendorCode().trim().toUpperCase() + "%";
		}

		String taxName = null;
		if (input.getTaxName() != null && !input.getTaxName().equals("")) {
			taxName = "%" + input.getTaxName().trim().toUpperCase() + "%";
		}
		
		String count = (String) getJdbcTemplate().queryForObject(query, new Object[] { 
				requestId, invoiceType,invoiceNumber,
				input.getiDate(), poNumber,buyer,invoiceLineNumber,taxName,vendor, status}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtInvoiceHeadersStg> getLtInvoiceHeadersStgData(Long requestId, LtInvoiceHeadersStg input)
			throws ServiceException {
		String query = env.getProperty("getLtInvoiceHeadersStgData");
		
		String invoiceType = null;
		if (input.getInvoiceType() != null && !input.getInvoiceType().equals("")) {
			invoiceType = "%" + input.getInvoiceType().trim().toUpperCase() + "%";
		}

		String invoiceNumber = null;
		if (input.getInvoiceNumber() != null && !input.getInvoiceNumber().equals("")) {
			invoiceNumber =  "%" + input.getInvoiceNumber().trim().toUpperCase() + "%";
		}

		String invoiceDescription = null;
		if (input.getDescription() != null && !input.getDescription().equals("")) {
			invoiceDescription = "%" + input.getDescription().trim().toUpperCase() + "%";
		}

		String invoiceLineNumber = null;
		if (input.getInvoiceLineNumber() != null && !input.getInvoiceLineNumber().equals("")) {
			invoiceLineNumber =  "%" + input.getInvoiceLineNumber() + "%";
		}
		
		if(input.getiDate() == null || input.getiDate().trim().equals(""))
		{
			input.setiDate(null);
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String status = null;
		if (input.getRecordStatus() != null && !input.getRecordStatus().equals("")) {
			status = "%" + input.getRecordStatus().trim().toUpperCase() + "%";
		}
		
		String buyer = null;
		if (input.getBuyer() != null && !input.getBuyer().equals("")) {
			buyer = "%" + input.getBuyer().trim().toUpperCase() + "%";
		}
		
		String vendor = null;
		if (input.getVendorCode() != null && !input.getVendorCode().equals("")) {
			vendor = "%" + input.getVendorCode().trim().toUpperCase() + "%";
		}
		
		String taxName = null;
		if (input.getTaxName() != null && !input.getTaxName().equals("")) {
			taxName = "%" + input.getTaxName().trim().toUpperCase() + "%";
		}
		
		List<LtInvoiceHeadersStg> list = (List<LtInvoiceHeadersStg>) 
				jdbcTemplate.query(query , new Object[]{ requestId, invoiceType,invoiceNumber,
						input.getiDate(), poNumber,buyer,invoiceLineNumber,taxName,vendor, status,
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getStart()+input.getLength(),input.getStart()+1},
			 new  BeanPropertyRowMapper<LtInvoiceHeadersStg>(LtInvoiceHeadersStg.class));
		
			return list;
	}

}
