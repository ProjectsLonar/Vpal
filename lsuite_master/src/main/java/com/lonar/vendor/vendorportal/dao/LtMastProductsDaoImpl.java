package com.lonar.vendor.vendorportal.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

@Repository
@PropertySource(value = "classpath:queries/productsQueries.properties", ignoreResourceNotFound = true)
public class LtMastProductsDaoImpl implements LtMastProductsDao {

private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@PersistenceContext(name = "em")
	private EntityManager em;

	@Override
	public List<LtMastProducts> findByProductCode(String productCode,Long companyId) throws ServiceException {
		String query = env.getProperty("findProductByProductCode");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ productCode,companyId }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		 return list;
	}

	@Override
	public List<LtMastProducts> findByProductName(String productName) throws ServiceException {
		String query = env.getProperty("findProductByProductName");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ productName }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		 return list;
	}

	@Override
	public List<LtMastProducts> findAllActive() throws ServiceException {
		String query = env.getProperty("findAllActiveProducts");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{  }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		 return list;
	}

	@Override
	public List<LtMastProducts> findByCategoryIdAndGlAccountId(Long categoryId, Long glaccountId) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProducts.findByCategoryIdAndGlAccountId")
				.setParameter("categoryId", categoryId).setParameter("glaccountId", glaccountId).getResultList();
	}

	@Override
	public List<LtMastProducts> findActiveLikeName(String productName,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("findActiveProductsLikeName");
		
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ companyId,"%"+productName.trim().toUpperCase()+"%","%"+productName.trim().toUpperCase()+"%" }, 
					 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
			 
		return list;
	}

	@Override
	public List<LtMastProducts> findByGlAccountId(Long glAccountId) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProducts.findByGlAccountId").setParameter("glAccountId", glAccountId)
				.getResultList();
	}

	@Override
	public List<LtMastProducts> findActiveLikeProductNameWithCategoryId(String productName, long categoryId)
			throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProducts.findActiveLikeProductNameWithCategoryId")
				.setParameter("productName", "%" + productName.toLowerCase() + "%")
				.setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<LtMastProductCategories> findLikeProductCategoryLineType(String lineType, String categoryName)
			throws Exception {
		// TODO Auto-generated method stub
		List<LtMastProductCategories> list=em.createNamedQuery("LtP2pProducts.findLikeProductCategoryLineType").setParameter("lineType", lineType)
				.setParameter("categoryName", "%" + categoryName.toLowerCase() + "%").getResultList();
		Set<LtMastProductCategories> set= new HashSet(list);
		return new ArrayList(set);
	}

	@Override
	public List<LtMastProducts> findLikeNameWithProductCategory(String productName, Long categoryId) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProducts.findLikeNameWithProductCategory")
				.setParameter("productName", "%" + productName.toLowerCase() + "%")
				.setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<LtMastProducts> findBySubCategoryId(Long subCategoryId) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProducts.findBySubCategoryId").setParameter("subCategoryId", subCategoryId)
				.getResultList();
	}

	@Override
	public Long getNextCodeSequence() throws Exception {
		// TODO Auto-generated method stub
		BigDecimal bigDecimal = (BigDecimal) em.createNativeQuery("SELECT LT_P2P_PRODUCT_CODE_S.nextval from DUAL")
				.getSingleResult();
		return bigDecimal.longValue();
	}

	@Override
	public ResponseEntity<List<LtMastProducts>> getAll() throws ServiceException {
	String query = env.getProperty("getAllProducts");
		
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{  }, 
					 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
			 
		return (ResponseEntity<List<LtMastProducts>>) list;
	}

	@Override
	public LtMastProducts findOne(Long id) throws ServiceException {
		String query = env.getProperty("findOneProducts");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		if(list.isEmpty())
			return null;
			else
		 return list.get(0);
	}

	@Override
	public Long getCount(LtMastProducts input,Long companyId) throws ServiceException {
		String query = env.getProperty("getCountProduct");
		 
		 String prodCode=null;
		   if(input.getProductCode()!=null)
		   {prodCode="%"+input.getProductCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getProductName()!=null)
		   {name="%"+input.getProductName().toUpperCase()+"%";}
		   
		   String uom=null;
		   if(input.getUom()!=null)
		   {uom="%"+input.getUomValue().toUpperCase()+"%";}
		   
		   String type=null;
		   if(input.getProductType()!=null)
		   {type="%"+input.getProductType().toUpperCase()+"%";}
		  
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
	
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,prodCode,name,uom,type,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastProducts> getDataTable(LtMastProducts input,Long companyId) throws ServiceException {
		String query = env.getProperty("getProductDatatableRecords");
		 		
		 String prodCode=null;
		   if(input.getProductCode()!=null)
		   {prodCode="%"+input.getProductCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getProductName()!=null)
		   {name="%"+input.getProductName().toUpperCase()+"%";}
		   
		   String uom=null;
		   if(input.getUom()!=null)
		   {uom="%"+input.getUomValue().toUpperCase()+"%";}
		   
		   String type=null;
		   if(input.getProductType()!=null)
		   {type="%"+input.getProductType().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			List<LtMastProducts> list = (List<LtMastProducts>) 
					jdbcTemplate.query(query , new Object[]{companyId,prodCode,name,uom,type,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class));
				return list;
	}

	@Override
	public List<LtMastProducts> listActiveLikeNameByCategory(String product, Long catId, Long subcatId)
			throws ServiceException {
		String query = env.getProperty("listActiveLikeNameByCategory");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ "%"+product.toUpperCase()+"%", "%"+product.toUpperCase()+"%",catId,subcatId }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		 return list;
	}

	@Override
	public List<LtMastProducts> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastProductsDataForReport");
		List<LtMastProducts> list=   jdbcTemplate.query(query, new Object[]{ reportParameters.getStatus(),reportParameters.getStartDate(),reportParameters.getEndDate() }, 
				 new BeanPropertyRowMapper<LtMastProducts>(LtMastProducts.class)); 
		 return list;
	}

}
