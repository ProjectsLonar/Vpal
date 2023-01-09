package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtPoShipment;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/poLineQueries.properties", ignoreResourceNotFound = true)
public class LtPoShipmentDaoImpl implements LtPoShipmentDao{

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
	public Long getLtPoShipmentCount(Long headerId, Long branchId, LtPoShipment input) throws ServiceException {
		String query = env.getProperty("poShipmentDataTableCount");
		
		String poNumber=null;
		if(input.getPoNumber()!=null && !input.getPoNumber().equals(""))
		{poNumber="%"+input.getPoNumber().trim().toUpperCase() + "%";}
		   
		String poLineId =null;
		if(input.getLineNum()!=null && !input.getLineNum().equals(""))
		{poLineId=input.getLineNum()+"";}
		
		String shipmentNumber =null;
		if(input.getShipmentNum()!=null && !input.getShipmentNum().equals(""))
		{shipmentNumber=input.getShipmentNum()+"";}
		
		String itemDescription =null;
		if(input.getProductDescription()!=null &&  !input.getProductDescription().equals("")) 
		{itemDescription="%"+input.getProductDescription().trim().trim().toUpperCase()+"%";}
		
		if(input.getDueDate() == null )
		{
			input.setDueDate(null);
		}
		
		String orderQuantity =null;
		if(input.getQuantityOrdered()!=null && !input.getQuantityOrdered().equals(""))
		{orderQuantity=input.getQuantityOrdered().longValue()+"";}
		
		String quantityRecived =null;
		if(input.getQuantityReceived()!=null && !input.getQuantityReceived().equals(""))
		{quantityRecived=input.getQuantityReceived().longValue()+"";}
		   
		String shipToLocation =null;
		if(input.getShipToLocation()!=null && !input.getShipToLocation().equals(""))
		{shipToLocation="%"+input.getShipToLocation().trim().trim().toUpperCase()+"%";}
		  
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {headerId,branchId,null,poNumber, poLineId, itemDescription,shipmentNumber
						, input.getDueDate(), orderQuantity,quantityRecived, shipToLocation,}, String.class);
		
		return Long.parseLong(count);
	}

	@Override
	public List<LtPoShipment> getLtPoShipmentDataTable(Long headerId, Long branchId, LtPoShipment input)
			throws ServiceException {
		String query = env.getProperty("poShipmentDataTableList");
		
		String poNumber=null;
		if(input.getPoNumber()!=null && !input.getPoNumber().equals(""))
		{poNumber="%"+input.getPoNumber().trim().toUpperCase() + "%";}
		   
		String poLineId =null;
		if(input.getLineNum()!=null && !input.getLineNum().equals(""))
		{poLineId=input.getLineNum()+"";}
		
		String shipmentNumber =null;
		if(input.getShipmentNum()!=null && !input.getShipmentNum().equals(""))
		{shipmentNumber=input.getShipmentNum()+"";}
		
		String itemDescription =null;
		if(input.getProductDescription()!=null &&  !input.getProductDescription().equals("")) 
		{itemDescription="%"+input.getProductDescription().trim().trim().toUpperCase()+"%";}
		
		if(input.getDueDate() == null )
		{
			input.setDueDate(null);
		}
		
		String orderQuantity =null;
		if(input.getQuantityOrdered()!=null && !input.getQuantityOrdered().equals(""))
		{orderQuantity=input.getQuantityOrdered().longValue()+"";}
		
		String quantityRecived =null;
		if(input.getQuantityReceived()!=null && !input.getQuantityReceived().equals(""))
		{quantityRecived=input.getQuantityReceived().longValue()+"";}
		   
		String shipToLocation =null;
		if(input.getShipToLocation()!=null && !input.getShipToLocation().equals(""))
		{shipToLocation="%"+input.getShipToLocation().trim().trim().toUpperCase()+"%";}
		
		List<LtPoShipment> list = (List<LtPoShipment>) 
				jdbcTemplate.query(query , new Object[]{headerId,branchId,null,
						poNumber, poLineId, itemDescription,shipmentNumber
						, input.getDueDate(), orderQuantity,
						quantityRecived, shipToLocation,
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getStart()+input.getLength(),input.getStart()+1},
			 new  BeanPropertyRowMapper<LtPoShipment>(LtPoShipment.class));
		
			return list;
	}

	@Override
	public LtPoShipment getByPoShipmentId(Long ltPoShipmentId) throws ServiceException {
		String query = env.getProperty("getPoShipmentByPoShipmentId");
		List<LtPoShipment> list = (List<LtPoShipment>) 
				jdbcTemplate.query(query , new Object[]{ltPoShipmentId},
			 new  BeanPropertyRowMapper<LtPoShipment>(LtPoShipment.class));
		if(!list.isEmpty())
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean updateFlag(Long ltPoShipmentId) throws ServiceException {
		String query =" UPDATE LT_PO_SHIPMENTS SET FLAG=? ,LAST_UPDATE_DATE= ? WHERE PO_SHIPMENT_LINE_ID=? ";
		int res=jdbcTemplate.update(query, 1,new Date(),ltPoShipmentId);
		if(res!=0)
			return true;
		else
			return false;
	}

}
