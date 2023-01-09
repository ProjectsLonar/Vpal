package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtInvoiceHeadersRepository;
import com.lonar.vendor.vendorportal.repository.LtInvoiceLinesRepository;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;

@Repository
@PropertySource(value = "classpath:queries/invoiceLinesQueries.properties", ignoreResourceNotFound = true)
public class LtInvoiceLinesDaoImpl implements LtInvoiceLinesDao,CodeMaster{

	@Autowired
	LtInvoiceLinesRepository ltInvoiceLinesRepository;
	
	@Autowired
	LtInvoiceHeadersRepository ltInvoiceHeadersRepository;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Long getLtInvoiceLinesCount(LtInvoiceLines input) throws ServiceException {
		String query = env.getProperty("getLtInvoiceLinesCount");
		 
		String linetype=null;
		   if(input.getLineType()!=null && !input.getLineType().equals(""))
		   {linetype="%"+input.getLineType().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getProductName()!=null && !input.getProductName().equals(""))
		   {product="%"+input.getProductName().trim().toUpperCase()+"%";}
		   
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String amount=null;
		   if(input.getInvoiceLineAmount()!=null)
		   {amount="%"+Double.valueOf(input.getInvoiceLineAmount()).intValue()+"%";}
			
		   
		   
		   String qty=null;
		   if(input.getInvoiceQuantity()!=null &&  !input.getInvoiceQuantity().equals("")) 
		   {qty="%"+input.getInvoiceQuantity()+"%";}
		   

		  
		  
		   
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {linetype,product,desc,qty,amount}, String.class);

		return Long.parseLong(count);
		
	}

	@Override
	public List<LtInvoiceLines> getLtInvoiceLinesDataTable(LtInvoiceLines input) throws ServiceException {
		String query = env.getProperty("getLtInvoiceLinesDataTable");
		
		String linetype=null;
		   if(input.getLineType()!=null && !input.getLineType().equals(""))
		   {linetype="%"+input.getLineType().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getProductName()!=null && !input.getProductName().equals(""))
		   {product="%"+input.getProductName().trim().toUpperCase()+"%";}
		   
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String amount=null;
		   if(input.getInvoiceLineAmount()!=null)
		   {amount="%"+Double.valueOf(input.getInvoiceLineAmount()).intValue()+"%";}
			
		   
		   
		   String qty=null;
		   if(input.getInvoiceQuantity()!=null &&  !input.getInvoiceQuantity().equals("")) 
		   {qty="%"+input.getInvoiceQuantity()+"%";}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(8);
			}
			
			List<LtInvoiceLines> list = (List<LtInvoiceLines>) 
					jdbcTemplate.query(query , new Object[]{linetype,product,desc,qty,amount,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()},
				 new  BeanPropertyRowMapper<LtInvoiceLines>(LtInvoiceLines.class));
				return list;
		
	}

	@Override
	public LtInvoiceLines getInvoiceLineById(Long id) throws ServiceException {
		String query = env.getProperty("getInvoiceLineById");
		List<LtInvoiceLines> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtInvoiceLines>(LtInvoiceLines.class)); 
		if(list.isEmpty())
			return null;
		else
		 return list.get(0);
	}

	@Override
	public List<LtInvoiceLines> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException {
		String query = env.getProperty("getAllInvoiceLinesByHeaderId");
		List<LtInvoiceLines> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtInvoiceLines>(LtInvoiceLines.class)); 
		
			return list;
	}

	@Override
	public Long save(LtInvoiceLines ltInvoiceLines) throws ServiceException {
		ltInvoiceLines.setLastUpdateDate(new Date());
		ltInvoiceLines.setLastUpdatedBy(ltInvoiceLines.getLastUpdateLogin());
		ltInvoiceLines = ltInvoiceLinesRepository.save(ltInvoiceLines);
		if(ltInvoiceLines.getInvoiceLineId()!=null)
		return ltInvoiceLines.getInvoiceLineId();
		else 
			return null;
	}

	@Override
	public boolean updateAmount(LtInvoiceLines ltInvoiceLines) throws ServiceException {
		
		//String query = env.getProperty("updateInvoiceHeaderAmpunt");
		String query = " UPDATE LT_INVOICE_HEADERS SET BASE_AMOUNT = "
				+ " ( SELECT ROUND(SUM( TOTAL_AMOUNT),2) FROM LT_INVOICE_LINES WHERE INVOICE_HEADER_ID = ? ) "
				+ " WHERE INVOICE_HEADER_ID = ?  ";
		
		int res=jdbcTemplate.update(
				query,ltInvoiceLines.getInvoiceHeaderId(),ltInvoiceLines.getInvoiceHeaderId());
		
		if(res!=0) {
			 query = " UPDATE LT_INVOICE_HEADERS SET INVOICE_AMOUNT = "
					+ " ( SELECT BASE_AMOUNT*EXCHANGE_RATE FROM LT_INVOICE_HEADERS WHERE INVOICE_HEADER_ID = ? ) "
					+ " WHERE INVOICE_HEADER_ID = ?  ";
			
			int res1=jdbcTemplate.update(
					query,ltInvoiceLines.getInvoiceHeaderId(),ltInvoiceLines.getInvoiceHeaderId());
			if(res1!=0) {
				return true;
			}else {  
				return false;
			}
		}else {
			return false;
		}
			
	}

	@Override
	public Long getLtInvoiceLinesCountByHeader(LtInvoiceLines input, Long id) throws ServiceException {
		String query = env.getProperty("getLtInvoiceLinesCountByHeader");
		 
		String linetype=null;
		   if(input.getLineType()!=null && !input.getLineType().equals(""))
		   {linetype="%"+input.getLineType().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getProductName()!=null && !input.getProductName().equals(""))
		   {product="%"+input.getProductName().trim().toUpperCase()+"%";}
		   
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   /*String amount=null;
		   if(input.getTotalAmount()!=null)
		   {
			   amount="%"+Double.valueOf(input.getTotalAmount()).intValue()+"%";
		   }
			
		   String taxAmount=null;
		   if(input.getTaxAmount()!=null)
		   {taxAmount="%"+Double.valueOf(input.getTaxAmount()).intValue()+"%";}
		   
		   String qty=null;
		   if(input.getQuantity()!=null &&  !input.getQuantity().equals("")) 
		   {
			   //qty="%"+Double.valueOf(input.getInvoiceQuantity()).intValue()+"%";
			   qty="%"+input.getQuantity()+"%";
		   }*/
		   
		   String totalAmountStr=null;
		   if(input.getTotalAmountStr() !=null && !input.getTotalAmountStr().equals(""))
		   {
			   totalAmountStr="%"+input.getTotalAmountStr().trim()+"%";
		   }
			
		   String taxAmountStr=null;
		   if(input.getTaxAmountStr()!=null && !input.getTaxAmountStr().equals(""))
		   {taxAmountStr="%"+input.getTaxAmountStr().trim()+"%";}
		   
		   String invoiceQunStr=null;
		   if(input.getInvoiceQunStr()!=null &&  !input.getInvoiceQunStr().equals("")) 
		   {
			   invoiceQunStr="%"+input.getInvoiceQunStr()+"%";
		   }
		  
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {id,linetype,product,desc,invoiceQunStr,taxAmountStr,totalAmountStr}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtInvoiceLines> getLtInvoiceLinesDataTableByHeader(LtInvoiceLines input, Long id)
			throws ServiceException {
		String query = env.getProperty("getLtInvoiceLinesDataTableByHeader");
		
		String linetype=null;
		   if(input.getLineType()!=null && !input.getLineType().equals(""))
		   {linetype="%"+input.getLineType().trim().toUpperCase() + "%";}
		   
		   String product=null;
		   if(input.getProductName()!=null && !input.getProductName().equals(""))
		   {product="%"+input.getProductName().trim().toUpperCase()+"%";}
		   
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   /*String amount=null;
		   if(input.getTotalAmount()!=null)
		   {
			   amount="%"+Double.valueOf(input.getTotalAmount()).intValue()+"%";
		   }
			
		   String taxAmount=null;
		   if(input.getTaxAmount()!=null)
		   {taxAmount="%"+Double.valueOf(input.getTaxAmount()).intValue()+"%";}
		   
		   String qty=null;
		   if(input.getQuantity()!=null &&  !input.getQuantity().equals("")) 
		   {
			   //qty="%"+Double.valueOf(input.getInvoiceQuantity()).intValue()+"%";
			   qty="%"+input.getQuantity()+"%";
		   }*/
		   
		   String totalAmountStr=null;
		   if(input.getTotalAmountStr() !=null && !input.getTotalAmountStr().equals(""))
		   {
			   totalAmountStr="%"+input.getTotalAmountStr().trim()+"%";
		   }
			
		   String taxAmountStr=null;
		   if(input.getTaxAmountStr()!=null &&  !input.getTaxAmountStr().equals(""))
		   {taxAmountStr="%"+input.getTaxAmountStr().trim()+"%";}
		   
		   String invoiceQunStr=null;
		   if(input.getInvoiceQunStr()!=null &&  !input.getInvoiceQunStr().equals("")) 
		   {
			   invoiceQunStr="%"+input.getInvoiceQunStr()+"%";
		   }
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(18);
			}
			
			List<LtInvoiceLines> list = (List<LtInvoiceLines>) 
					jdbcTemplate.query(query , new Object[]{id,linetype,product,desc,invoiceQunStr,taxAmountStr,totalAmountStr,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtInvoiceLines>(LtInvoiceLines.class));
				return list;
	}

	@Override
	public boolean deleteByHeaderId(Long invoiceHeaderId) throws ServiceException {
		String query = env.getProperty("deleteLtInvoiceLinesByHeaderId");
		
		int res1=jdbcTemplate.update(query,invoiceHeaderId);
		if(res1!=0) {
			return true;
		}else {  
			return false;
		}
	}

	@Override
	public Status loadLines(List<LtPoLines> poLinelist, Long invoiceHeaderId) throws ServiceException{
		Status status = new Status();
		LtInvoiceHeaders ltInvoiceHeaders = ltInvoiceHeadersRepository.findOne(invoiceHeaderId);
		for(LtPoLines ltPoLine : poLinelist) {
			LtInvoiceLines ltInvoiceLines = new LtInvoiceLines();
			ltInvoiceLines.setInvoiceHeaderId(invoiceHeaderId);
			ltInvoiceLines.setPoHeaderId(ltPoLine.getPoHeaderId());
			ltInvoiceLines.setPoLineId(ltPoLine.getPoLineId());
			ltInvoiceLines.setLineType(ltPoLine.getLineType());
			ltInvoiceLines.setCategoryId(ltPoLine.getCategoryId());
			//ltInvoiceLines.setSubCategoryId(ltPoLine.gets);
			ltInvoiceLines.setProductId(ltPoLine.getProductId());
			ltInvoiceLines.setDescription(ltPoLine.getProductDescription());
			//	ltInvoiceLines.setUom(ltPoLine.get);
			ltInvoiceLines.setCreationDate(new Date());
			ltInvoiceLines.setLastUpdateDate(new Date());
			ltInvoiceLines.setCreatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
			ltInvoiceLines.setLastUpdateLogin(ltInvoiceHeaders.getLastUpdateLogin());
		
			ltInvoiceLines = ltInvoiceLinesRepository.save(ltInvoiceLines);
			if(ltInvoiceLines.getInvoiceLineId()==null) {
				status.setCode(FAIL);
				status=ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
				return status;
			}
		}
		status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		return status;
	}

	@Override
	public boolean updateFlag(LtInvoiceLines ltInvoiceLines) throws ServiceException {
		String query = " UPDATE LT_PO_SHIPMENTS SET FLAG = ? WHERE PO_SHIPMENT_LINE_ID = ? AND PO_HEADER_ID = ? ";
		int res1=jdbcTemplate.update(
					query,null,ltInvoiceLines.getPoShipmentLineId(),ltInvoiceLines.getPoHeaderId());
			if(res1!=0) {
				return true;
			}else
				return false;
	}

}
