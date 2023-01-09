package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/prodSubCatPaytermMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastProdSubcatPaytermsDaoImpl implements LtMastProdSubcatPaytermsDao{

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
	public List<LtMastProdSubcatPayterms> getAll() throws ServiceException {
		String query = env.getProperty("getAllProdSubcatPayterms");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		return list;
	}

	@Override
	public List<LtMastProdSubcatPayterms> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveProdSubcatPayterms");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		return list;
	}

	@Override
	public LtMastProdSubcatPayterms getById(Long id) throws ServiceException {
		String query = env.getProperty("getProdSubcatPaytermsById");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ id}, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public List<LtMastProdSubcatPayterms> getAllBySubCatId(Long id) throws ServiceException {
		String query = env.getProperty("getAllProdSubcatPaytermsBySubCatId");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ id}, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		return list;
	}

	@Override
	public List<LtMastProdSubcatPayterms> getLikeTermCat(String category) throws ServiceException {
		String query = env.getProperty("getProdSubcatPaytermsLikeTermCat");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ "%"+category.toUpperCase()+"%"}, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		return list;
	}

	@Override
	public List<LtMastProdSubcatPayterms> getLikeTermName(String name) throws ServiceException {
		String query = env.getProperty("getProdSubcatPaytermsLikeTermName");
		
		List<LtMastProdSubcatPayterms> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%"}, 
		 new BeanPropertyRowMapper<LtMastProdSubcatPayterms>(LtMastProdSubcatPayterms.class)); 
		return list;
	}

}
