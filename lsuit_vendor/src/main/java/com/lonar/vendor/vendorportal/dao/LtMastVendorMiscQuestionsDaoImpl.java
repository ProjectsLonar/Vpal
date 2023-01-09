package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendMiscQuestionsMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastVendorMiscQuestionsDaoImpl implements LtMastVendorMiscQuestionsDao{

	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastVendorMiscQuestions> getVendorMiscQuestionByVenId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getVendorMiscQuestionAnsByVenId");
		
		List<LtMastVendorMiscQuestions> list=   jdbcTemplate.query(query, new Object[]{vendorId }, 
			 new BeanPropertyRowMapper<LtMastVendorMiscQuestions>(LtMastVendorMiscQuestions.class)); 
			return list;
	}

	@Override
	public LtMastVendorMiscQuestions getVendorMiscQuesById(Long vendorMiscQuesId) throws ServiceException {
		String query = env.getProperty("getVendorMiscQuesAnsById");
		
		List<LtMastVendorMiscQuestions> list=   jdbcTemplate.query(query, new Object[]{ vendorMiscQuesId}, 
			 new BeanPropertyRowMapper<LtMastVendorMiscQuestions>(LtMastVendorMiscQuestions.class)); 
			return list.get(0);
	}

}
