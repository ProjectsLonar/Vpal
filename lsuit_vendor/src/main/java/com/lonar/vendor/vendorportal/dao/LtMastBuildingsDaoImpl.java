package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBuildings;
import com.lonar.vendor.vendorportal.model.ServiceException;


@Repository
@PropertySource(value = "classpath:queries/buildingMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastBuildingsDaoImpl implements LtMastBuildingsDao 
{
	

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
	public List<LtMastBuildings> findByBuildingCode(String buildingCode) throws ServiceException
	{
		String query = env.getProperty("findByBuildingCode");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{"%"+buildingCode.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastBuildings> findByBranchId(String branchId) throws ServiceException
	{
		String query = env.getProperty("findBuildingsByBranchId");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{branchId}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastBuildings> findAllActive() throws ServiceException
	{
		String query = env.getProperty("findAllActiveBuildings");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	/*@Override
	public  List<LtP2pBuildings> listLtP2pBuildingsAll(Integer pageNo) throws ServiceException 
	{
		int pageSize = 10;
	    String countQ = "SELECT l FROM LtP2pBuildings  l";
	    Query query = em.createQuery(countQ);
	    query.setFirstResult((pageNo - 1) * pageSize);
	    query.setMaxResults(pageSize);
	    List<LtP2pBuildings> list = query.getResultList();
	    
		return list;
	}*/
	
	/*@Override
	public Integer getLtP2pBuildingsCount() throws Exception
	{
		Integer count = ((Number)em.createNamedQuery("LtP2pBuildings .All").getSingleResult()).intValue();
		return count;
	}*/

	/*@Override
	public List<LtP2pBuildings> searchBuildings(LtP2pBuildings ob)throws ServiceException 
	{
		Query query =  em.createQuery(" from LtP2pBuildings "
				+ " where branchId = nvl(:branchId , branchId) "
				+ " and buildingId = nvl(:buildingId , buildingId) "
                + " and buildingCode like nvl(:buildingCode, buildingCode) " 
                + " and buildingAdress like nvl(:buildingAdress, buildingAdress)");
		
		Query query = em.createNamedQuery("LtP2pBuildings.search");
		Integer branchId = null;
		if(ob.getBranchId() != null){ 
			 branchId = Integer.parseInt(ob.getBranchId().toString());
		}
		query.setParameter("branchId", branchId); 
		query.setParameter("buildingId", ob.getBuildingId());
		//query.setParameter("buildingCode", ob.getBuildingCode());
		//query.setParameter("buildingAdress", ob.getBuildingAdress());
		
		List<LtP2pBuildings> buildings =  query.getResultList();
		return buildings;
	
	}*/

	/*@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public ResponseEntity<Status> saveBuildings(LtP2pBuildings ltP2pBuildings) 
	{
		
		Status status = new Status();
		 
	      try
	      {
	    	  ltP2pBuildings.setCreationDate(new Date()); 
	    	  
	    	  ltP2pBuildings.setCreatedBy(ltP2pBuildings.getLastUpdateLogin());
	    	  
	    	 // em.persist(ltP2pBuildings);

		      return new ResponseEntity<Status>(status, HttpStatus.OK);
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	    	 // return new ResponseEntity<Status>(status, HttpStatus.INTERNAL_SERVER_ERROR); 
	      }
		
		return null;
	}*/

	@Override
	public List<LtMastBuildings> findByBuildingId(Long buildingId) throws ServiceException
	{
		String query = env.getProperty("findByBuildingId");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{buildingId}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	
	@Override
	public List<LtMastBuildings> findAllBuildingAddr(String addr)throws ServiceException 
	{
		String query = env.getProperty("findAllBuildingAddr");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{"%"+addr.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastBuildings> findActiveLikeBuildingAddr(String buildingaddr)throws ServiceException {
		String query = env.getProperty("findActiveLikeBuildingAddr");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{"%"+buildingaddr.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastBuildings> findByActiveLikeBuildingName(String buildingName) throws ServiceException {
		String query = env.getProperty("findByActiveLikeBuildingName");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{"%"+buildingName.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}

	@Override
	public List<LtMastBuildings> findByLikeBuildingName(String buildingName) throws ServiceException {
		String query = env.getProperty("findByLikeBuildingName");
		List<LtMastBuildings> list=   jdbcTemplate.query(query, new Object[]{"%"+buildingName.toUpperCase()+"%"}, 
					 new BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class)); 
		
			 return list;
	}
	
	@Override
	@Transactional
	public List<LtMastBuildings> getBuildingsByBranchId(Long branchId) throws ServiceException{
		String query = "SELECT BUILDING_ID, BUILDING_NAME, BUILDING_CODE, BUILDING_ADDRESS  FROM LT_P2P_BUILDINGS "
				+ " WHERE BRANCH_ID =  ? "
				+ " AND START_DATE <= SYSDATE AND (END_DATE IS NULL OR  END_DATE >= SYSDATE) "
				+ " AND UPPER(STATUS) = UPPER(?) ";
		
		List<LtMastBuildings> buildings = jdbcTemplate.query(query, new Object[]{ branchId, CodeMaster.VENDOR_STATUS_ACTIVE }, 
				new RowMapper<LtMastBuildings>(){
					public LtMastBuildings mapRow(ResultSet rs, int arg1) throws SQLException {
						LtMastBuildings building = new LtMastBuildings();
						building.setBuildingId(rs.getLong("BUILDING_ID"));
						building.setBuildingName(rs.getString("BUILDING_NAME"));
						building.setBuildingCode(rs.getString("BUILDING_CODE"));
						building.setBuildingAddress(rs.getString("BUILDING_ADDRESS"));
						return building;
					} 
				}); 
		return buildings;
	}


	@Override
	public Integer getLtP2pBuildingsCount() throws Exception {
		return null;
	}


	@Override
	public List<LtMastBuildings> listLtP2pBuildingsAll(Integer pageNo) throws ServiceException {
		return null;
	}


	@Override
	public List<LtMastBuildings> searchBuildings(LtMastBuildings ob) throws ServiceException {
		return null;
	}


	@Override
	public Long getCount(LtMastBuildings input) throws ServiceException {
		String query = env.getProperty("getCountBuildings");
		 
		 String branchId=null;
		   if(input.getBranchId()!=null)
		   {branchId="%"+input.getBranchId()+"%";}
		   
		   String buildCode=null;
		   if(input.getBuildingCode()!=null)
		   {buildCode="%"+input.getBuildingCode().toUpperCase()+"%";}
		   
		   String buildName=null;
		   if(input.getBuildingName()!=null)
		   {buildName="%"+input.getBuildingName().toUpperCase()+"%";}
		   
		   String buildAddr=null;
		   if(input.getBuildingAddress()!=null)
		   {buildAddr="%"+input.getBuildingAddress().toUpperCase()+"%";}
		   
		   String buildDesc=null;
		   if(input.getBuildingDesc()!=null)
		   {buildDesc="%"+input.getBuildingDesc().toUpperCase()+"%";}
		   
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
				query, new Object[] {branchId,buildName,buildCode,buildAddr,buildDesc,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}


	@Override
	public List<LtMastBuildings> getDatatableRecords(LtMastBuildings input) throws ServiceException {
		String query = env.getProperty("getBuildingsDatatableRecords");
		 
		 String branchId=null;
		   if(input.getBranchId()!=null)
		   {branchId="%"+input.getBranchId()+"%";}
		   
		   String buildCode=null;
		   if(input.getBuildingCode()!=null)
		   {buildCode="%"+input.getBuildingCode().toUpperCase()+"%";}
		   
		   String buildName=null;
		   if(input.getBuildingName()!=null)
		   {buildName="%"+input.getBuildingName().toUpperCase()+"%";}
		   
		   String buildAddr=null;
		   if(input.getBuildingAddress()!=null)
		   {buildAddr="%"+input.getBuildingAddress().toUpperCase()+"%";}
		   
		   String buildDesc=null;
		   if(input.getBuildingDesc()!=null)
		   {buildDesc="%"+input.getBuildingDesc().toUpperCase()+"%";}
		   
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
			
			
			List<LtMastBuildings> list = (List<LtMastBuildings>) 
					jdbcTemplate.query(query , new Object[]{branchId,buildName,buildCode,buildAddr,buildDesc,status,
							input.getStDate(),input.getEnDate(),
							
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
				 new  BeanPropertyRowMapper<LtMastBuildings>(LtMastBuildings.class));
				return list;
	}
	


}
