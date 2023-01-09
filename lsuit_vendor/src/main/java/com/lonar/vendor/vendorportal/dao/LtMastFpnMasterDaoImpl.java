package com.lonar.vendor.vendorportal.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastFpnMaster;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/fpnMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastFpnMasterDaoImpl implements LtMastFpnMasterDao {

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
	public List<LtMastFpnMaster> findByFpnNumber(String fpnNumber) throws ServiceException {
		String query = env.getProperty("findFpnByFpnNumber");
		List<LtMastFpnMaster> list=   jdbcTemplate.query(query, new Object[]{"%"+fpnNumber.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastFpnMaster>(LtMastFpnMaster.class)); 
		
			 return list;		
	}

	@Override
	public List<LtMastFpnMaster> findByFpnValue(Long fpnValue) throws ServiceException {
		String query = env.getProperty("findFpnByFpnValue");
		List<LtMastFpnMaster> list=   jdbcTemplate.query(query, new Object[]{fpnValue}, 
					 new BeanPropertyRowMapper<LtMastFpnMaster>(LtMastFpnMaster.class)); 
		
			 return list;	}

	@Override
	public List<LtMastFpnMaster> getLikeFpnNumber(String fpnNumber) throws ServiceException 
	{
		String query = env.getProperty("findFpnByFpnNumber");
		List<LtMastFpnMaster> list=   jdbcTemplate.query(query, new Object[]{"%"+fpnNumber.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastFpnMaster>(LtMastFpnMaster.class)); 
		
			 return list;
	}


	@Override
	public LtMastFpnMaster getFpnNumberById(String fpnId) throws ServiceException {
		String query = env.getProperty("getFpnNumberById");
		List<LtMastFpnMaster> list=   jdbcTemplate.query(query, new Object[]{fpnId}, 
					 new BeanPropertyRowMapper<LtMastFpnMaster>(LtMastFpnMaster.class)); 
		if(list.isEmpty())
			return null;
		else
			 return list.get(0);	
	}

	@Override
	public BigDecimal getFpnUtilizedAmt(String poHeaderId, String fpnNumber) throws ServiceException {
		/*Object obj= em.createNativeQuery("select LT_P2P_PO_VALIDATIONS_PUB.get_fpn_utilized_amount(?1, ?2) fpn_po_utilized_amt FROM DUAL").setParameter(1, Long.valueOf(poHeaderId)).setParameter(2, fpnNumber).getSingleResult();
		//Object obj= em.createNativeQuery("LtP2pFpnMaster.getFpnUtilizedAmt").setParameter(1, Long.valueOf(poHeaderId)).setParameter(2, fpnNumber).getSingleResult();
		return (BigDecimal) obj;*/
		return null;
	}
	
	@Transactional
	public boolean revertFpnUtilizedAmt(Long fpnId, Double amount) throws ServiceException{
		String query = "UPDATE LT_P2P_FPN_MASTER set FPN_BALANCE =  FPN_BALANCE + ?, FPN_UTILIZED = FPN_UTILIZED - ? WHERE FPN_ID = ?";
				jdbcTemplate.update(query, new Object[]{amount, amount, fpnId });
		return true;
	}

	@Override
	public Long getCount(LtMastFpnMaster input) throws ServiceException {
		/*String query = env.getProperty("getCountTaxes");
		 
		   String taxName=null;
		   if(input.getFpnNumber()!=null)
		   {taxName="%"+input.getTaxName().toUpperCase()+"%";}
		   
		   String taxRate=null;
		   if(input.getFpnDate()!=null)
		   {taxRate="%"+input.getTaxRate()+"%";}
		   
		   String productType=null;
		   if(input.getf!=null)
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

		
		return Long.parseLong(count);*/
		return null;
	}

	@Override
	public List<LtMastFpnMaster> getDatatableRecords(LtMastFpnMaster input) throws ServiceException {
		String query = env.getProperty("getTaxesDatatableRecords");
		 
		/* String taxName=null;
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
			
			List<LtP2pFpnMaster> list = (List<LtP2pFpnMaster>) 
					jdbcTemplate.query(query , new Object[]{taxName,taxRate,productType,hsn,stateCode,itc,
							
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtP2pFpnMaster>(LtP2pFpnMaster.class));
				return list;*/
		return null;
	}
	
	
}
