package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendMiscQuestionsMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendMiscQuestionsDaoImpl implements LtVendMiscQuestionsDao{


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
	public List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException {
		String query = env.getProperty("getVendMiscQuestionsBycompanyMiscId");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{companyMiscId },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getAll() throws ServiceException {
		String query = env.getProperty("getAllVendMiscQuestions");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveVendMiscQuestions");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public LtVendMiscQuestions getById(Long id) throws ServiceException {
		String query = env.getProperty("getLtVendMiscQuestionsById");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{id },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

}
