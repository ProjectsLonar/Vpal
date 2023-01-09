package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/invoiceLinetaxesQueries.properties", ignoreResourceNotFound = true)
public class LtInvoiceLineTaxesDaoImpl implements LtInvoiceLineTaxesDao{

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
	public LtInvoiceLineTaxes getInvoiceLineTaxesById(Long id) throws ServiceException {
		String query = env.getProperty("getInvoiceLineTaxesById");
		
		List<LtInvoiceLineTaxes> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceLineTaxes>(LtInvoiceLineTaxes.class)); 
		if(list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtInvoiceLineTaxes> getAllInvoiceLinesByHeaderId(Long id) throws ServiceException {
		String query = env.getProperty("getAllInvoiceLinesTaxesByHeaderId");
		
		List<LtInvoiceLineTaxes> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceLineTaxes>(LtInvoiceLineTaxes.class)); 
		return list;
	}

	@Override
	public List<LtInvoiceLineTaxes> getAllInvoiceLinesByLineId(Long id) throws ServiceException {
		String query = env.getProperty("getAllInvoiceLinesByTaxesLineId");
		
		List<LtInvoiceLineTaxes> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceLineTaxes>(LtInvoiceLineTaxes.class)); 
		return list;
	}

	@Override
	public void deleteTax(Long invoiceHeaderId) throws ServiceException {
		//String query = env.getProperty("deleteLtExpExpenseHeaders");
		String query = " DELETE * FROM LT_INVOICE_LINE_TAXES WHERE INVOICE_LINE_ID = ? ";
		int res=jdbcTemplate.update(query,invoiceHeaderId);

		/*if(res!= 0)
			return true;
		else
			return false;*/
		
	}

}
