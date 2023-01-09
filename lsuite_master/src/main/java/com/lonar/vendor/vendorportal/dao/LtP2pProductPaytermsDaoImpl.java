package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtP2pProductPayterms;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository

@PropertySource(value = "classpath:queries/productPaytermMasterQueries.properties", ignoreResourceNotFound = true)
public class LtP2pProductPaytermsDaoImpl implements LtP2pProductPaytermsDao {

	@Autowired
	private Environment env;
	
	@PersistenceContext(name = "em")
	private EntityManager em;

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
	public List<LtP2pProductPayterms> findByProductId(Long productId)  throws ServiceException{
		String query = env.getProperty("findProductPaytermsByProductId");
		List<LtP2pProductPayterms> list=   jdbcTemplate.query(query, new Object[]{productId}, 
					 new BeanPropertyRowMapper<LtP2pProductPayterms>(LtP2pProductPayterms.class)); 
		
			 return list;	
	}




	@Override
	public List<LtP2pProductPayterms> getAll() throws ServiceException {
		String query = env.getProperty("getAllProductPayterms");
		List<LtP2pProductPayterms> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtP2pProductPayterms>(LtP2pProductPayterms.class)); 
		
		return list;	
	}




	@Override
	public List<LtP2pProductPayterms> findAllActive() throws ServiceException {
		String query = env.getProperty("findAllActiveProductPayterms");
		List<LtP2pProductPayterms> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtP2pProductPayterms>(LtP2pProductPayterms.class)); 
		
		return list;	
	}




	@Override
	public LtP2pProductPayterms getById(Long id) throws ServiceException {
		String query = env.getProperty("getProductPaytermsById");
		List<LtP2pProductPayterms> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtP2pProductPayterms>(LtP2pProductPayterms.class)); 
		
		return list.get(0);	
	}




	@Override
	public List<LtP2pProductPayterms> findByPaytermAndProduct(Long productId, String termName) throws ServiceException {
		String query = env.getProperty("findProductPaytermsByPaytermAndProduct");
		List<LtP2pProductPayterms> list=   jdbcTemplate.query(query, new Object[]{productId,termName.toUpperCase()}, 
					 new BeanPropertyRowMapper<LtP2pProductPayterms>(LtP2pProductPayterms.class)); 
		
		return list;	
	}

}
