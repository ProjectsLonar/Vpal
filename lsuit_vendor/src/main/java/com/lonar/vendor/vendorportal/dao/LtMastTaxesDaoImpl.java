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

import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/taxesMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastTaxesDaoImpl implements LtMastTaxesDao {

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
	public List<LtMastTaxes> findByTaxName(String taxName) throws ServiceException{
		String query = env.getProperty("findTaxesByTaxName");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{"%"+taxName.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;		//return em.createNamedQuery("LtP2pTaxes.findByTaxName").setParameter("taxName", taxName).getResultList();
	}

	@Override
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException{
		String query = env.getProperty("findTaxesByTaxCategoryId");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{taxCategoryId}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pTaxes.findByTaxCategoryId").setParameter("taxCategoryId", taxCategoryId).getResultList();
	}

	@Override
	public List<LtMastTaxes> findAllActive() throws ServiceException{
		String query = env.getProperty("findAllActiveTaxes");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pTaxes.findAllActive").getResultList();
	}

	@Override
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName) throws ServiceException{
		String query = env.getProperty("findActiveTaxesLikeTaxName");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{"%"+taxName.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
		//return em.createNamedQuery("LtP2pTaxes.findActiveLikeTaxName").setParameter("taxName", "%"+taxName.toLowerCase()+"%").getResultList();
	}

	@Override
	public LtMastTaxes getById(Long id) throws ServiceException {
		String query = env.getProperty("getTaxesById");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{id}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		if(list.isEmpty())
			return null;
		else
			 return list.get(0);
	}

	@Override
	public List<LtMastTaxes> getAll() throws ServiceException {
		String query = env.getProperty("getAllTaxes");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
	}

	@Override
	public Long getCount(LtMastTaxes input) throws ServiceException {
		String query = env.getProperty("getCountTaxes");
		 
		   String taxName=null;
		   if(input.getTaxName()!=null)
		   {taxName="%"+input.getTaxName().toUpperCase()+"%";}
		   
		   String taxRate=null;
		   if(input.getTaxRate()!=null)
		   {taxRate="%"+input.getTaxRate()+"%";}
		   
		   String productType=null;
		   if(input.getProductType()!=null)
		   {productType="%"+input.getProductType().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
		   
		   String stateCode=null;
		   if(input.getStateCode()!=null)
		   {stateCode="%"+input.getStateCode().toUpperCase()+"%";}
		   
		   String itc=null;
		   if(input.getItcFlag()!=null)
		   {hsn="%"+input.getItcFlag().toUpperCase()+"%";}
		   
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {taxName,taxRate,productType,hsn,stateCode,itc}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastTaxes> getDatatableRecords(LtMastTaxes input) throws ServiceException {
		String query = env.getProperty("getTaxesDatatableRecords");
		 
		 String taxName=null;
		   if(input.getTaxName()!=null)
		   {taxName="%"+input.getTaxName().toUpperCase()+"%";}
		   
		   String taxRate=null;
		   if(input.getTaxRate()!=null)
		   {taxRate="%"+input.getTaxRate()+"%";}
		   
		   String productType=null;
		   if(input.getProductType()!=null)
		   {productType="%"+input.getProductType().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
		   
		   String stateCode=null;
		   if(input.getStateCode()!=null)
		   {stateCode="%"+input.getStateCode().toUpperCase()+"%";}
		   
		   String itc=null;
		   if(input.getItcFlag()!=null)
		   {hsn="%"+input.getItcFlag().toUpperCase()+"%";}
			
			List<LtMastTaxes> list = (List<LtMastTaxes>) 
					jdbcTemplate.query(query , new Object[]{taxName,taxRate,productType,hsn,stateCode,itc,
							
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class));
				return list;
	}

}
