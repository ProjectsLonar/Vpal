package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.FilterTry;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Repository
@PropertySource(value = "classpath:queries/subProductCatMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastProdSubCategoriesDaoImpl implements LtMastProdSubCategoriesDao 
{

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
	public List<LtMastProdSubCategories> findAllActive() throws Exception {
		return em.createNamedQuery("LtP2pProdSubCategories .findAll").getResultList();
	}

	@Override
 	public List<LtMastProdSubCategories> findByCategoryId(Long id) throws Exception {
		 
	 StringBuilder strb = new StringBuilder("Select lpsc.CATEGORY_ID ,pc.CATEGORY_NAME||' ( '||pc.CATEGORY_CODE||' )' as category_name , "
	 		+ " lga.ACCOUNT_CODE  ,lga.ACCOUNT_NAME, adlga.ACCOUNT_CODE ADVANCE_GL_CODE  ,adlga.ACCOUNT_NAME ADVANCE_GL_NAME , SUB_CATEGORY_ID , " 
			 	+ " SUB_CATEGORY , HSN_SAC_CODE ,lpsc.START_DATE , lpsc.END_DATE ,lpsc.MAKERCHK ,lpsc.STATUS , lpsc.DESCRIPTION," 
			 	+ " lpsc.GL_ACCOUNT_ID, SUB_CATEGORY_CODE,  DELIVERY_TERMS,PENALTY_TERMS  ,"
			 	+ " WARRANTY_TERMS, PRICING_TERMS , DOCS_FOR_PAYMENT, BILLING_ADDRESS, CSA,OTHER_CONDITIONS, SAFETY, " 
			 	+ " INSURANCE , INVOICE_SUBMISSION_DATE, INVOICE_SUBMISSION, PROD_WORK_PROPERTY, ADVANCE_GL_ACCOUNT, " 
			 	+ " FA_MAJOR_CATEGORY, FA_MINOR_CATEGORY, lpsc.CREATED_BY, lpsc.CREATION_DATE " 
	 			+ " from lt_mast_prod_sub_categories lpsc, lt_mast_gl_accounts lga  , lt_mast_gl_accounts adlga,LT_MAST_PRODUCT_CATEGORIES pc " 
	 			+ " Where lpsc.gl_account_id= lga.account_id(+) and lpsc.CATEGORY_ID = pc.CATEGORY_ID(+) and " 
	 			+ " lpsc.advance_gl_account= adlga.account_id(+) and  lpsc.sub_category_id= ?");
	
	     List<LtMastProdSubCategories> ltP2pProdSubCategorieslist =  jdbcTemplate.query(strb.toString(), new Object[]{id }, 
			 new RowMapper<LtMastProdSubCategories>()  {
				
		 			public LtMastProdSubCategories mapRow(ResultSet rs, int row) throws SQLException  {
		 				LtMastProdSubCategories ltP2pProdSubCategories = new LtMastProdSubCategories();
		 				
		 			 
		 				ltP2pProdSubCategories.setSubCategoryId(rs.getLong("SUB_CATEGORY_ID"));;
		 				ltP2pProdSubCategories.setInvoiceSubmissionDate(rs.getString("INVOICE_SUBMISSION_DATE"));
		 				ltP2pProdSubCategories.setProdWorkProperty(rs.getString("PROD_WORK_PROPERTY"));
		 				ltP2pProdSubCategories.setCategoryName(rs.getString("category_name"));
		 				ltP2pProdSubCategories.setCategoryId(rs.getLong("CATEGORY_ID"));
		 				ltP2pProdSubCategories.setSubCategory(rs.getString("SUB_CATEGORY"));
		 				ltP2pProdSubCategories.setHsnSacCode(rs.getString("HSN_SAC_CODE"));
		 				ltP2pProdSubCategories.setStartDate(rs.getDate("START_DATE"));
		 				ltP2pProdSubCategories.setEndDate(rs.getDate("END_DATE"));
		 			
		 				ltP2pProdSubCategories.setSubCategoryCode(rs.getString("SUB_CATEGORY_CODE"));
		 				ltP2pProdSubCategories.setStatus(rs.getString("STATUS"));
		 				ltP2pProdSubCategories.setGlAccountId(rs.getLong("GL_ACCOUNT_ID"));
		 				ltP2pProdSubCategories.setDeliveryTerms(rs.getString("DELIVERY_TERMS"));
		 				ltP2pProdSubCategories.setPenaltyTerms(rs.getString("PENALTY_TERMS"));
		 				ltP2pProdSubCategories.setWarrantyTerms(rs.getString("WARRANTY_TERMS"));
		 				ltP2pProdSubCategories.setPricingTerms(rs.getString("PRICING_TERMS"));
		 				ltP2pProdSubCategories.setDocsForPayment(rs.getString("DOCS_FOR_PAYMENT"));
		 				ltP2pProdSubCategories.setBillingAddress(rs.getString("BILLING_ADDRESS"));
		 				ltP2pProdSubCategories.setCsa(rs.getString("CSA"));
		 				ltP2pProdSubCategories.setOtherConditions(rs.getString("OTHER_CONDITIONS"));
		 				ltP2pProdSubCategories.setSafety(rs.getString("SAFETY"));
		 				
		 				ltP2pProdSubCategories.setInsurance(rs.getString("INSURANCE"));
		 				ltP2pProdSubCategories.setInvoiceSubmission(rs.getString("INVOICE_SUBMISSION"));
		 				ltP2pProdSubCategories.setGlAccountName(rs.getString("ACCOUNT_NAME"));
		 				ltP2pProdSubCategories.setGlAccountCode(rs.getString("ACCOUNT_CODE"));
		 									   
		 				ltP2pProdSubCategories.setAdvanceGlAccount(rs.getLong("ADVANCE_GL_ACCOUNT"));
		 				ltP2pProdSubCategories.setFaMajorCategory(rs.getString("FA_MAJOR_CATEGORY"));
		 				ltP2pProdSubCategories.setFaMinorCategory(rs.getString("FA_MINOR_CATEGORY"));
		 				
		 				ltP2pProdSubCategories.setAdvanceGlAccountName(rs.getString("ADVANCE_GL_NAME"));
		 				ltP2pProdSubCategories.setAdvanceGlAccountCode(rs.getString("ADVANCE_GL_CODE"));
		 				
		 				ltP2pProdSubCategories.setCreatedBy(rs.getLong("CREATED_BY"));
		 				ltP2pProdSubCategories.setCreationDate(rs.getDate("CREATION_DATE"));
		 				ltP2pProdSubCategories.setDescription(rs.getString("DESCRIPTION"));
		 				
						return ltP2pProdSubCategories;
					}
	     	});
	     return ltP2pProdSubCategorieslist;
	} 

	@Override
	public List<LtMastProdSubCategories> getAll() throws Exception {
		String query = env.getProperty("getProdSubCategoriesAll");
		//String query = " SELECT * FROM LT_MAST_SYS_VARIABLE_VALUES s WHERE s.VARIABLE_ID = ? ";
		
		List<LtMastProdSubCategories> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastProdSubCategories>(LtMastProdSubCategories.class)); 
		 
		return list;
	}

	@Override
	public List<LtMastProdSubCategories> findBySubCategoryName(String name) throws Exception  {
		return em.createNamedQuery("LtP2pProdSubCategories .findByName").setParameter("subCategory", name).getResultList();
	}

	@Override
	public List<LtMastProdSubCategories> findLikeSubCategoryName(String name) {
		String query = env.getProperty("findLikeSubCategoryName");
	
		List<LtMastProdSubCategories> list=   jdbcTemplate.query(query, new Object[]{name.toUpperCase(),name.toUpperCase() }, 
			 new BeanPropertyRowMapper<LtMastProdSubCategories>(LtMastProdSubCategories.class)); 
	 
	return list;
	}
	
	
	@Override
	public List<LtMastProdSubCategories> getByProdSubCategory(FilterTry filterOb){
		//------------here------------
		if(filterOb != null ) {
			StringBuilder strb = new StringBuilder(" SELECT * FROM LT_P2P_PROD_SUB_CATEGORIES  s ,"
					+ " LT_P2P_PRODUCT_CATEGORIES pc "
					+ " WHERE  s.CATEGORY_ID = pc.CATEGORY_ID "
					+ "  AND s.START_DATE <= SYSDATE  and upper(s.STATUS)  = 'ACTIVE' "
					+ "   AND NVL(s.END_DATE, SYSDATE) >= SYSDATE AND s.MAKERCHK = 'N' "
					+ "  AND UPPER( NVL(pc.CATEGORY_NAME ,'X')) =  upper(NVL( ?, NVL( pc.CATEGORY_NAME , 'X'))) "
					+ "  AND UPPER(NVL(s.SUB_CATEGORY,'X')) LIKE  Upper(NVL( ?,  NVL(s.SUB_CATEGORY,'X')))  " );
			
			String categoryName = null;
			String subCategory = null;
			
			if(  filterOb.getCategoryName()!= null && !filterOb.getCategoryName().trim().equals("") ){
				categoryName = filterOb.getCategoryName().trim().toUpperCase();
			} 
			
			if( filterOb.getSubCategory()!= null  && !filterOb.getSubCategory().trim().equals("") ){
				subCategory = "%"+filterOb.getSubCategory().trim().toUpperCase()+"%";
			}
			 
			return  jdbcTemplate.query(strb.toString(),  new Object[] {categoryName ,subCategory} , 
					new RowMapper<LtMastProdSubCategories>() {
					@Override
						public LtMastProdSubCategories mapRow(ResultSet rs, int arg1) throws SQLException {
							LtMastProdSubCategories ltP2pProdSubCategories = new LtMastProdSubCategories();
							ltP2pProdSubCategories.setCategoryId(rs.getLong("CATEGORY_ID"));
							ltP2pProdSubCategories.setCategoryName(rs.getString("CATEGORY_NAME"));
							ltP2pProdSubCategories.setCategoryCode(rs.getString("CATEGORY_CODE"));
							ltP2pProdSubCategories.setSubCategoryId(rs.getLong("SUB_CATEGORY_ID"));
							ltP2pProdSubCategories.setSubCategory(rs.getString("SUB_CATEGORY"));
							ltP2pProdSubCategories.setSubCategoryCode(rs.getString("SUB_CATEGORY_CODE"));
							ltP2pProdSubCategories.setHsnSacCode(rs.getString("HSN_SAC_CODE"));
							return ltP2pProdSubCategories;
						}
			});
		}
		return null;
	}


	@Override
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryName(String name) throws Exception {
		return em.createNamedQuery("LtP2pProdSubCategories.findActiveLikeSubCategoryName").setParameter("subCategory", "%"+name.toLowerCase()+"%").getResultList();
	}

	@Override
	public List<LtMastProdSubCategories> findActiveLikeSubCategoryNameWithCategoryId(String name, Long categoryId) throws ServiceException{
		String query = env.getProperty("findActiveLikeSubCategoryNameWithCategoryId");
		
		List<LtMastProdSubCategories> list=   jdbcTemplate.query(query, new Object[]{"%"+name.toUpperCase()+"%",
				"%"+name.toUpperCase()+"%",categoryId }, 
			 new BeanPropertyRowMapper<LtMastProdSubCategories>(LtMastProdSubCategories.class)); 
	 
	return list;	}

	@Override
	public List<LtMastProdSubCategories> findCategoryId(Long categoryId) throws Exception {
		return  em.createNamedQuery("LtP2pProdSubCategories.findCategoryId").setParameter("categoryId", categoryId).getResultList();
	}

	/*@Override
	public List<LtP2pProdSubcatPayterms> getAllProdSubcatPayterms(Long subprodCatId)
			throws Exception {
		String query ="select * from LT_P2P_PROD_SUBCAT_PAYTERMS where SUB_CATEGORY_ID = ? ";
			return  jdbcTemplate.query(query.toString(),  new Object[] {subprodCatId} ,
				new RowMapper<LtP2pProdSubcatPayterms>() {
					@Override
					public LtP2pProdSubcatPayterms mapRow(ResultSet rs, int arg1) throws SQLException {
						LtP2pProdSubcatPayterms prodSubcatPayterms = new LtP2pProdSubcatPayterms();
						prodSubcatPayterms.setPayTermId(rs.getLong("PAY_TERM_ID"));
						prodSubcatPayterms.setCreatedBy(rs.getLong("CREATED_BY"));
						prodSubcatPayterms.setCreationDate(rs.getDate("CREATION_DATE"));
						prodSubcatPayterms.setEndDate(rs.getDate("END_DATE"));
						prodSubcatPayterms.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
						prodSubcatPayterms.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						prodSubcatPayterms.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						prodSubcatPayterms.setStartDate(rs.getDate("START_DATE"));
						prodSubcatPayterms.setSubCategoryId(rs.getLong("SUB_CATEGORY_ID"));
						prodSubcatPayterms.setTermCategory(rs.getString("TERM_CATEGORY"));
						prodSubcatPayterms.setTermName(rs.getString("TERM_NAME"));
						prodSubcatPayterms.setPercentage(rs.getFloat("PERCENTAGE"));
						return prodSubcatPayterms;
					}
				});
	}*/

	@Override
	public Long getProdSubcatPaytermsDataTableCount(Long subprodCatId) throws Exception {
		String query ="select count(*) from LT_P2P_PROD_SUBCAT_PAYTERMS where SUB_CATEGORY_ID = ? ";
		Long count = jdbcTemplate.queryForObject(query.toString(), 
	             new Object[]{ subprodCatId }, Long.class );
		return count;
	}

	@Override
	public List<LtMastProdSubCategories> getDataTable(LtMastProdSubCategories input) throws ServiceException {
		String query = env.getProperty("getProdSubCategoriesDatatableRecords");
		 
		   String subCat=null;
		   if(input.getSubCategory()!=null)
		   {subCat="%"+input.getSubCategory().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
		   
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
			
			List<LtMastProdSubCategories> list = (List<LtMastProdSubCategories>) 
					jdbcTemplate.query(query , new Object[]{subCat,hsn,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastProdSubCategories>(LtMastProdSubCategories.class));
				return list;
	}

	@Override
	public Long getCount(LtMastProdSubCategories input) throws ServiceException {
		String query = env.getProperty("getCountProdSubCategories");
		 
		 String subCat=null;
		   if(input.getSubCategory()!=null)
		   {subCat="%"+input.getSubCategory().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
		   
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
				query, new Object[] {subCat,hsn,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

}
