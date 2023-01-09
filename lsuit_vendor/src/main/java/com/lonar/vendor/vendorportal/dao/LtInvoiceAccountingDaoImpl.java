package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtInvoiceAccounting;
import com.lonar.vendor.vendorportal.model.LtInvoiceLineTaxes;

@Repository
public class LtInvoiceAccountingDaoImpl implements LtInvoiceAccountingDao{

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
	public LtInvoiceAccounting getInvoiceAccountingById(Long id) {
		String query = env.getProperty("getInvoiceAccountingById");
		
		List<LtInvoiceAccounting> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceAccounting>(LtInvoiceAccounting.class)); 
		if(list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtInvoiceAccounting> getInvoiceAccountingByHeaderId(Long id) {
		String query = env.getProperty("getInvoiceAccountingByHeaderId");
		
		List<LtInvoiceAccounting> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceAccounting>(LtInvoiceAccounting.class)); 
		return list;
	}

	@Override
	public List<LtInvoiceAccounting> getInvoiceAccountingByLineId(Long id) {
		String query = env.getProperty("getInvoiceAccountingByLineId");
		
		List<LtInvoiceAccounting> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtInvoiceAccounting>(LtInvoiceAccounting.class)); 
		return list;
	}

}
