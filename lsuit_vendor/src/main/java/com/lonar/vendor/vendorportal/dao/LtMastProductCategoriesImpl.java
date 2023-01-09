package com.lonar.vendor.vendorportal.dao;

import java.math.BigDecimal;
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

import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Repository
@PropertySource(value = "classpath:queries/productCategoriesQueries.properties", ignoreResourceNotFound = true)
public class LtMastProductCategoriesImpl implements LtMastProductCategoriesDao {

	@PersistenceContext(name = "em")
	private EntityManager em;
	
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
	public List<LtMastProductCategories> findByCategoryName(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		//return em.createNamedQuery("LtP2pProductCategories.findByCategoryName")
			//	.setParameter("categoryName", categoryName).getResultList();
		String query = env.getProperty("findActiveLikeCategoryName");
		List<LtMastProductCategories> list=   jdbcTemplate.query(query, new Object[]{categoryName.toUpperCase()}, 
					 new BeanPropertyRowMapper<LtMastProductCategories>(LtMastProductCategories.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastProductCategories> findAllActive() throws Exception {
		
	String query = env.getProperty("findAllActiveProductCategories");
	List<LtMastProductCategories> list=   jdbcTemplate.query(query, new Object[]{}, 
				 new BeanPropertyRowMapper<LtMastProductCategories>(LtMastProductCategories.class)); 
	
		 return list;
	}

	@Override
	public List<LtMastProductCategories> findActiveLikeCategoryName(String categoryName) throws Exception {
		String query = env.getProperty("findActiveLikeCategoryName");
		List<LtMastProductCategories> list=   jdbcTemplate.query(query, new Object[]{"%"+categoryName.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastProductCategories>(LtMastProductCategories.class)); 
		
			 return list;
		/*return em.createNamedQuery("LtP2pProductCategories.findActiveLikeCategoryName")
				.setParameter("categoryName", "%" + categoryName.toLowerCase() + "%").getResultList();*/
	}

	@Override
	public List<LtMastProductCategories> findLikeCategoryName(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProductCategories.findLikeCategoryName")
				.setParameter("categoryName", "%" + categoryName.toLowerCase() + "%").getResultList();
	}

	@Override
	public List<LtMastProductCategories> findBycategoryCode(String categoryCode) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("LtP2pProductCategories.findBycategoryCode")
				.setParameter("categoryCode", categoryCode).getResultList();
	}

	@Override
	public Long getNextCodeSequence() throws Exception {
		// TODO Auto-generated method stub
		BigDecimal bigDecimal = (BigDecimal) em.createNativeQuery("SELECT LT_P2P_PROD_CAT_CODE_S.nextval from DUAL")
				.getSingleResult();
		return bigDecimal.longValue();
	}

	@Override
	public List<LtMastProductCategories> findAll() throws ServiceException {
		String query = env.getProperty("findAllProductCategories");
		//String query = " select * from LT_MAST_PRODUCT_CATEGORIES ";
		return  jdbcTemplate.query(query, new Object[]{}, 
				new BeanPropertyRowMapper(LtMastProductCategories.class));
	}

	@Override
	public LtMastProductCategories getById(Long id) throws ServiceException {
		String query = env.getProperty("getProductCategoriesById");
		List<LtMastProductCategories> list=   jdbcTemplate.query(query, new Object[]{id}, 
					 new BeanPropertyRowMapper<LtMastProductCategories>(LtMastProductCategories.class)); 
		if(list.isEmpty())
			return null;
		else
			 return list.get(0);
	}

	@Override
	public Long getCount(LtMastProductCategories input) throws ServiceException {
		String query = env.getProperty("getCountProductCategories");
		 
		 String categoryCode=null;
		   if(input.getCategoryCode()!=null)
		   {categoryCode="%"+input.getCategoryCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getCategoryName()!=null)
		   {name="%"+input.getCategoryName().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
	
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {categoryCode,name,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastProductCategories> getDataTable(LtMastProductCategories input) throws ServiceException {
		String query = env.getProperty("getProductCategoriesDatatableRecords");
		 
		 String categoryCode=null;
		   if(input.getCategoryCode()!=null)
		   {categoryCode="%"+input.getCategoryCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getCategoryName()!=null)
		   {name="%"+input.getCategoryName().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			List<LtMastProductCategories> list = (List<LtMastProductCategories>) 
					jdbcTemplate.query(query , new Object[]{categoryCode,name,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastProductCategories>(LtMastProductCategories.class));
				return list;
	}

	/*@Override
	public LtP2pCategoryQuestionnaire getConditionTemplateById(Long conditionTemplateId) throws Exception {
		String query = "select * from LT_P2P_CATEGORY_QUESTIONNAIRE where CATEGORY_QUESTION_ID = ?";
		return (LtP2pCategoryQuestionnaire)jdbcTemplate.queryForObject(query, new Object[]{ conditionTemplateId }, 
				new BeanPropertyRowMapper(LtP2pCategoryQuestionnaire.class));
	}

	@Override
	public List<LtP2pCategoryQuestionnaire> getCategoryQuestionnaireData(Long categoryId)
			throws Exception {
		String query = "select * from LT_P2P_CATEGORY_QUESTIONNAIRE where CATEGORY_ID = ?";
		return  jdbcTemplate.query(query, new Object[]{categoryId}, 
				new BeanPropertyRowMapper(LtP2pCategoryQuestionnaire.class));
	}

	@Override
	public Long getCategoryQuestionnaireCount(Long categoryId) throws Exception {
		String query = "select count(*) from LT_P2P_CATEGORY_QUESTIONNAIRE where CATEGORY_ID = ?";
		Long count = jdbcTemplate.queryForObject(query.toString(), new Object[]{categoryId }, Long.class );
		return count;
	}
*/
}
