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
import com.lonar.vendor.vendorportal.reports.ReportParameters;

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
		
			 return list;		
	}

	@Override
	public List<LtMastTaxes> findByTaxCategoryId(Long taxCategoryId) throws ServiceException{
		String query = env.getProperty("findTaxesByTaxCategoryId");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{taxCategoryId}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastTaxes> findAllActive(Long companyId) throws ServiceException{
		String query = env.getProperty("findAllActiveTaxes");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{companyId}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastTaxes> findActiveLikeTaxName(String taxName,Long companyId) throws ServiceException{
		String query = env.getProperty("findActiveTaxesLikeTaxName");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{"%"+taxName.toUpperCase()+"%",companyId}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
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
	public List<LtMastTaxes> getAll(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllTaxes");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{companyId}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;
	}

	@Override
	public Long getCount(Long companyId,LtMastTaxes input) throws ServiceException {
		String query = env.getProperty("getCountTaxes");
		 
		   String taxName=null;
		   if(input.getTaxName()!=null)
		   {taxName="%"+input.getTaxName().toUpperCase()+"%";}
		   
		   String taxRate=null;
		   if(input.getTaxRate()!=null)
		   {taxRate="%"+input.getTaxRate()+"%";}
		   
		   String sourceStateCode=null;
		   if(input.getSourceStateCode()!=null)
		   {sourceStateCode="%"+input.getSourceStateCode().toUpperCase()+"%";}
		   
		   String destinationStateCode=null;
		   if(input.getDestinationStateCode()!=null)
		   {destinationStateCode="%"+input.getDestinationStateCode().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getTaxDesc()!=null)
		   {desc="%"+input.getTaxDesc().toUpperCase()+"%";}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,taxName,taxRate,desc, hsn, sourceStateCode, destinationStateCode}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastTaxes> getDatatableRecords(Long companyId,LtMastTaxes input) throws ServiceException {
		String query = env.getProperty("getTaxesDatatableRecords");
		 
		 String taxName=null;
		   if(input.getTaxName()!=null)
		   {taxName="%"+input.getTaxName().toUpperCase()+"%";}
		   
		   String taxRate=null;
		   if(input.getTaxRate()!=null)
		   {taxRate="%"+Double.valueOf(input.getTaxRate()).intValue()+"%";}
		   
		   String sourceStateCode=null;
		   if(input.getSourceStateCode()!=null)
		   {sourceStateCode="%"+input.getSourceStateCode().toUpperCase()+"%";}
		   
		   String destinationStateCode=null;
		   if(input.getDestinationStateCode()!=null)
		   {destinationStateCode="%"+input.getDestinationStateCode().toUpperCase()+"%";}
		   
		   String hsn=null;
		   if(input.getHsnSacCode()!=null)
		   {hsn="%"+input.getHsnSacCode().toUpperCase()+"%";}
			
		   String desc=null;
		   if(input.getTaxDesc()!=null)
		   {desc="%"+input.getTaxDesc().toUpperCase()+"%";}
		   
			List<LtMastTaxes> list = (List<LtMastTaxes>) 
					jdbcTemplate.query(query , new Object[]{companyId,taxName,taxRate,desc,hsn, sourceStateCode, destinationStateCode,
						
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


	@Override
	public List<LtMastTaxes> findByTaxNameAndRate(String taxName, Double taxRate,Long companyId) throws ServiceException {
		String query = env.getProperty("findByTaxNameAndRate");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{companyId,taxName.toUpperCase(),taxRate}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
		
			 return list;	
	}


	@Override
	public List<LtMastTaxes> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastTaxesDataForReport");
		List<LtMastTaxes> list=   jdbcTemplate.query(query, new Object[]{reportParameters.getStatus().toUpperCase(),
				reportParameters.getStartDate(),reportParameters.getEndDate(),reportParameters.getCompanyId()}, 
					 new BeanPropertyRowMapper<LtMastTaxes>(LtMastTaxes.class)); 
			 return list;
	}

}
