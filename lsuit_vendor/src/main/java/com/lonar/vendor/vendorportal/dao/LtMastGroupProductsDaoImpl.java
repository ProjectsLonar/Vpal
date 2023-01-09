package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastGroupProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/groupProductMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastGroupProductsDaoImpl implements LtMastGroupProductsDao {

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
	public List<LtMastGroupProducts> findByParentProductId(Long parentProductId) throws ServiceException{
		String query = env.getProperty("findByParentProductId");
		List<LtMastGroupProducts> list=   jdbcTemplate.query(query, new Object[]{parentProductId}, 
					 new BeanPropertyRowMapper<LtMastGroupProducts>(LtMastGroupProducts.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pGroupProducts.findByParentProductId").setParameter("parentProductId", parentProductId).getResultList();
	}

	@Override
	public List<LtMastGroupProducts> findByChildProductId(Long childProductId) throws ServiceException{
		String query = env.getProperty("findByChildProductId");
		List<LtMastGroupProducts> list=   jdbcTemplate.query(query, new Object[]{childProductId}, 
					 new BeanPropertyRowMapper<LtMastGroupProducts>(LtMastGroupProducts.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pGroupProducts.findByChildProductId").setParameter("childProductId", childProductId).getResultList();
	}

	@Override
	public List<LtMastGroupProducts> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveGroupProducts");
		List<LtMastGroupProducts> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastGroupProducts>(LtMastGroupProducts.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pGroupProducts.findAllActive").getResultList();
	}

	@Override
	public List<LtMastGroupProducts> getAll() throws ServiceException {
		String query = env.getProperty("getAllGroupProducts");
		List<LtMastGroupProducts> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastGroupProducts>(LtMastGroupProducts.class)); 
		
			 return list;
	}

	@Override
	public LtMastGroupProducts getById(Long id) throws ServiceException {
		String query = env.getProperty("getByIdGroupProducts");
		List<LtMastGroupProducts> list=   jdbcTemplate.query(query, new Object[]{id}, 
					 new BeanPropertyRowMapper<LtMastGroupProducts>(LtMastGroupProducts.class)); 
		if(list.isEmpty())
			return null;
		else
		return list.get(0);
	}

}
