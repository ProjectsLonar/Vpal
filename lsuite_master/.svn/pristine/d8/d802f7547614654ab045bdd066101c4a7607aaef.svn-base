package com.lonar.vendor.vendorportal.dao;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastProductDivisions;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/productDivisionQueries.properties", ignoreResourceNotFound = true)
public class LtMastProductDivisionsDaoImpl implements LtMastProductDivisionsDao {

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public List<LtMastProductDivisions> findByDivisionId(Long divisionId) throws ServiceException{
		String query = env.getProperty("findProductDivisionsByDivisionId");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{divisionId}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list;
		//return em.createNamedQuery("LtP2pProductDivisions.findByDivisionId").setParameter("divisionId", divisionId).getResultList();
	}
	
	@Override
	public List<LtMastProductDivisions> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveProductDivisions");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list;
		//return em.createNamedQuery("LtP2pProductDivisions.findAllActive").getResultList();
	}

	@Override
	public List<LtMastProductDivisions> findByProductIdAndDivisionId(Long productId, Long divisionId) throws ServiceException{
		String query = env.getProperty("findByProductIdAndDivisionId");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{divisionId,productId}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list;
		//return em.createNamedQuery("LtP2pProductDivisions.findByProductIdAndDivisionId").setParameter("productId", productId).setParameter("divisionId", divisionId).getResultList();
	}

	@Override
	public List<LtMastProductDivisions> findByProductId(Long productId) throws ServiceException{
		String query = env.getProperty("findProductDivisionsByProductId");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{productId}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list;
		//return em.createNamedQuery("LtP2pProductDivisions.findByProductId").setParameter("productId", productId).getResultList();
	}

	@Override
	public LtMastProductDivisions getById(Long id) throws ServiceException {
		String query = env.getProperty("getProductDivisionsById");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list.get(0);
	}

	@Override
	public List<LtMastProductDivisions> getAll() throws ServiceException {
		String query = env.getProperty("getAllProductDivisions");
		
		List<LtMastProductDivisions> list=   jdbcTemplate.query(query, new Object[]{}, 
		 new BeanPropertyRowMapper<LtMastProductDivisions>(LtMastProductDivisions.class)); 
		return list;
	}

}
