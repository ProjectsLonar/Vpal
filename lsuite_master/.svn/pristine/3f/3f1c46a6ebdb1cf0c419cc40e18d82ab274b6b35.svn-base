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

import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.reports.ReportParameters;
import com.lonar.vendor.vendorportal.repository.LtMastEmployeesRepository;


@Repository
@PropertySource(value = "classpath:queries/employeeQueries.properties", ignoreResourceNotFound = true)
public class LtMastEmployeesDaoImpl implements LtMastEmployeesDao
{

	@Autowired
	LtMastEmployeesRepository ltMastEmployeesRepository;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<LtMastEmployees> findBySupervisorEmpId(Long supervisorEmpId) throws ServiceException {
		String query = env.getProperty("findBySupervisorEmpId");
	
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ supervisorEmpId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}
	

	public List<LtMastEmployees> findByEmployeeNumber(String employeeNumber) throws ServiceException
	{
		String query = env.getProperty("findByEmployeeNumber");

		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ employeeNumber}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	public List<LtMastEmployees> findByOfficialEmail(String officialEmail) throws ServiceException
	{
		String query = env.getProperty("findEmployeesByOfficialEmail");
			
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ officialEmail}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	public List<LtMastEmployees> findByPosition(String position) throws ServiceException
	{
		String query = env.getProperty("findEmployeesByPosition");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ position}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	public List<LtMastEmployees> findAllActive() throws ServiceException
	{
		String query = env.getProperty("findAllActiveEmployees");
	
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findLikeFirstName(String firstName) throws ServiceException
	{
		String query = env.getProperty("findEmployeesLikeFirstName");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ "%"+firstName.toUpperCase()+"%"}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
	
		return list;
		
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findLikeName(String name) throws ServiceException
	{
		String query = env.getProperty("findEmployeesLikeName");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ name, name},
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
		
	}

	@Override
	public List<LtMastEmployees> findUserNotEmployeeId() throws ServiceException{
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<LtMastEmployees> findByCostCenterId(Long costCenterId) throws ServiceException
	{
		String query = env.getProperty("findEmployeesByCostCenterId");
		
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ costCenterId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}
	
	@Transactional
	@Override
	public List<LtMastEmployees> findByEmployeeName(String name) throws ServiceException{

		String query = env.getProperty("findByEmployeeName");
		
		return jdbcTemplate.query(query,new Object[]{ "%"+name.toUpperCase()+"%" }, 
				 new RowMapper<LtMastEmployees>(){
					@Override
					public LtMastEmployees mapRow(ResultSet rs, int row) throws SQLException {
						LtMastEmployees employees = new LtMastEmployees();
						employees.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
						employees.setEmployeeNumber(rs.getString("EMPLOYEE_NUMBER"));
						return employees;
					}
		});
	}


	@Override
	@Transactional
	public List<LtMastEmployees> findByActiveLikeName(Long companyId, String name) throws ServiceException
	{
		String query = env.getProperty("findEmployeesByActiveLikeName");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{companyId, "%"+ name.toUpperCase() +"%","%"+ name.toUpperCase() +"%", "%"+ name.toUpperCase() +"%"}, 
				 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		 
		return list;
	}

	@Override
	public List<LtMastEmployees> checkDetails(LtMastEmployees ltMastEmployees) throws ServiceException
	{
		String query = env.getProperty("checkEmployeesDetails");
		
		return jdbcTemplate.query(query,new Object[]{ ltMastEmployees.getOfficialEmail().trim(), 
				ltMastEmployees.getPersonalEmail(),ltMastEmployees.getPanNo(), ltMastEmployees.getPassportNo(),ltMastEmployees.getEmployeeNumber() }, 
				 new RowMapper<LtMastEmployees>(){
					@Override
					public LtMastEmployees mapRow(ResultSet rs, int row) throws SQLException {
						LtMastEmployees employees = new LtMastEmployees();
						employees.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
						employees.setOfficialEmail(rs.getString("OFFICIAL_EMAIL"));
						employees.setPersonalEmail(rs.getString("PERSONAL_EMAIL"));
						employees.setPanNo(rs.getString("PAN_NO"));
						employees.setPassportNo(rs.getString("PASSPORT_NO"));
						employees.setEmployeeNumber(rs.getString("EMPLOYEE_NUMBER"));
						return employees;
					}
		});
	}


	@Transactional
	@Override
	public List<LtMastEmployees> getEmployeeDetailsByUserID(Long userId) throws ServiceException 
	{
		String query = env.getProperty("getEmployeeDetailsByUserID");
						 
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ userId}, 
				 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class));
			
				return list;
	}


	@Override
	public List<LtMastEmployees> getByEmpId(Long no) throws ServiceException 
	{
		String query = env.getProperty("getEmployeeByEmpId");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ no}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class));
	
		return list;
	}
	
	@Override
	public List<LtMastEmployees> getLikeNameByDivisionId(String name, String divisionId) {
		
		String query = env.getProperty("getLikeNameByDivisionId");

		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ divisionId,"%"+ name.toUpperCase() +"%",
				"%"+ name.toUpperCase() +"%"}, 
				 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		 
		return list;
		
		
	}


	@Override
	public LtMastEmployees getByEmployeeNumber(String employeeNumber,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("getByEmployeeNumber");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ employeeNumber.trim(),companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(list!=null && list.size()>0)
		return list.get(0);
		else
			return null;
	}


	@Override
	public LtMastEmployees getByofficialEmail(String officialEmail,Long companyId) throws ServiceException
	{
		String query = env.getProperty("getEmployeesByofficialEmail");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ officialEmail.trim(),companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(list!=null && list.size()>0)
		return list.get(0);
		else
			return null;
	}


	@Override
	public LtMastEmployees getByPersonalEmail(String personalEmail,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("getEmployeesByPersonalEmail");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ personalEmail.trim(),companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(list!=null && list.size()>0)
		return list.get(0);
		else
			return null;
	}


	@Override
	public LtMastEmployees getByPassportNumber(String passportNo,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("getEmployeesByPassportNumber");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ passportNo.trim(),companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(list!=null && list.size()>0)
		return list.get(0);
		else
			return null;
	}


	@Override
	public LtMastEmployees getByPanNumber(String panNo,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("getEmployeesByPanNumber");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ panNo.trim(),companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(list!=null && list.size()>0)
		return list.get(0);
		else
			return null;
	}


	/*@Override
	public Long save(LtMastEmployees ltMastEmployees) throws Exception 
	{
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator()
		{
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException 
		    {
		    	PreparedStatement statement = con.prepareStatement
		        (" INSERT INTO lt_mast_employees "
		        + " ( EMPLOYEE_NUMBER,TITLE,FIRST_NAME,MIDDLE_NAME,LAST_NAME,OFFICIAL_EMAIL,PERSONAL_EMAIL,"
		        + " MARITAL_STATUS,GENDER,PERSON_TYPE,DOB,POSITION,GRADE,DEPT_ID,PAN_NO,PASSPORT_NO,"
		        + " BRANCH_ID,SUPERVISOR_EMP_ID,COST_CENTER_ID,DIVISION_ID,SUB_DIVISION_ID,CREATED_BY,"
		        + " CREATION_DATE,START_DATE, END_DATE,LAST_UPDATE_DATE,LAST_UPDATE_LOGIN,LAST_UPDATED_BY,"
		        + " STATUS,COMPANY_ID) "
     		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
		        statement.setString(1, ltMastEmployees.getEmployeeNumber());
		       
		        statement.setString(2, ltMastEmployees.getTitle());
		        statement.setString(3, ltMastEmployees.getFirstName());
		        statement.setString(4, ltMastEmployees.getMiddleName());
		        statement.setString(5, ltMastEmployees.getLastName());
		        statement.setString(6, ltMastEmployees.getOfficialEmail());
		        statement.setString(7, ltMastEmployees.getPersonalEmail());
		        statement.setString(8, ltMastEmployees.getMaritalStatus());
		        statement.setString(9, ltMastEmployees.getGender());
		        statement.setString(10, ltMastEmployees.getPersonType());
		        statement.setTimestamp(11, new Timestamp(ltMastEmployees.getDob().getTime()));
		        
		        statement.setString(12, ltMastEmployees.getPosition());
		        statement.setString(13, ltMastEmployees.getGrade());
		        statement.setString(14, ltMastEmployees.getDeptId());
		        statement.setString(15, ltMastEmployees.getPanNo());
		        statement.setString(16, ltMastEmployees.getPassportNo());
		        statement.setLong(17, ltMastEmployees.getBranchId());
		        statement.setLong(18, ltMastEmployees.getSupervisorEmpId());
		        if(ltMastEmployees.getCostCenterId()!=null)
		        {
		        	statement.setLong(19, ltMastEmployees.getCostCenterId());
		        }
		        else{
		        	statement.setLong(19, 0);
		        }
		        statement.setLong(20, ltMastEmployees.getDivisionId());
		        if(ltMastEmployees.getSubDivisionId() != null){
		        statement.setLong(21, ltMastEmployees.getSubDivisionId());
		        }else
		        {
		        	statement.setLong(21, 0);
		        }
		        statement.setLong(22, ltMastEmployees.getCreatedBy());
		        statement.setTimestamp(23, new Timestamp(ltMastEmployees.getCreationDate().getTime()));
		        
		        statement.setTimestamp(24, new Timestamp(ltMastEmployees.getStartDate().getTime()));
		        if(ltMastEmployees.getEndDate()!=null)
		        {
		        	statement.setTimestamp(25, new Timestamp(ltMastEmployees.getEndDate().getTime()));
		        }
		        else
		        {
		        	statement.setTimestamp(25,null);
		        }
		        statement.setTimestamp(26,new Timestamp( ltMastEmployees.getLastUpdateDate().getTime()));
		  
		       
		       
		        statement.setLong(27, ltMastEmployees.getLastUpdateLogin());
		        statement.setLong(28, ltMastEmployees.getLastUpdatedBy());
		        statement.setString(29, ltMastEmployees.getStatus());
		        statement.setLong(30, ltMastEmployees.getCompanyId());
		       
		       
		        return statement;
		    }
		}, holder);

		
		Long primaryKey = holder.getKey().longValue();
		return primaryKey;
	}*/


	@Override
	public boolean updatePath(LtMastEmployees ltMastEmployees) throws ServiceException
	{
		int res1=0;
		ltMastEmployees = ltMastEmployeesRepository.save(ltMastEmployees);
		if(ltMastEmployees!=null)
		{	return true; }
		else
		{	return false; }
	}


	@Override
	public boolean delete(Long employeeId) throws ServiceException 
	{
		String query = env.getProperty("deleteEmployees");
		int res=0;
		res=jdbcTemplate.update(" DELETE FROM lt_mast_employees WHERE EMPLOYEE_ID = ? ",employeeId);
		
		res=jdbcTemplate.update(query,employeeId);
		
		if(res!=0)
			return true;
		else
			return false;
	}


	@Override
	public boolean update(LtMastEmployees ltMastEmployees) throws ServiceException
	{
		String query = env.getProperty("updateEmployees");
		int res=0;
		
		 res=jdbcTemplate.update(query,
		        ltMastEmployees.getTitle(),ltMastEmployees.getFirstName(),ltMastEmployees.getMiddleName(),
		        ltMastEmployees.getLastName(),ltMastEmployees.getOfficialEmail(),ltMastEmployees.getPersonalEmail(),
		        ltMastEmployees.getMaritalStatus(),ltMastEmployees.getGender(),ltMastEmployees.getPersonType(),
		        ltMastEmployees.getDob(),ltMastEmployees.getPosition(),ltMastEmployees.getGrade(),ltMastEmployees.getDeptId(),
		        ltMastEmployees.getPanNo(),ltMastEmployees.getPassportNo(),ltMastEmployees.getBranchId(),
		        ltMastEmployees.getSupervisorEmpId(),ltMastEmployees.getCostCenterId(),ltMastEmployees.getDivisionId(),
		        ltMastEmployees.getSubDivisionId(),
		        ltMastEmployees.getStatus(),ltMastEmployees.getStartDate(),ltMastEmployees.getEndDate(),
		        ltMastEmployees.getLastUpdateLogin(),ltMastEmployees.getLastUpdatedBy(),ltMastEmployees.getLastUpdateDate(),
		        ltMastEmployees.getEmployeeId());
	
		 if(res!=0)
			 return true;
		 else
			 return false;
	}


	@Override
	public List<LtMastEmployees> findAll(Long companyId) throws ServiceException 
	{
		String query = env.getProperty("findAllEmployees");

		List<LtMastEmployees> list = jdbcTemplate.query(query, new Object[] { companyId },
				new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class));

		return list;
	}


	@Override
	public LtMastEmployees getLtMastEmployeesByID(Long empId) throws ServiceException
	{
		String query = env.getProperty("getLtMastEmployeesByID");
			
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{empId }, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		if(!list.isEmpty())
		return list.get(0);
		else return null;
	}

	@Override
	public Long getCount(Long companyId, LtMastEmployees input) throws ServiceException
	{
		String query = env.getProperty("getCountLtMastEmployees");
		 
		   String empCode=null;
		   if(input.getEmployeeNumber()!=null)
		   {empCode="%"+input.getEmployeeNumber().toUpperCase()+"%";}
		   
		   String empName=null;
		   if(input.getEmpName()!=null)
		   {empName="%"+input.getEmpName().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getOfficialEmail()!=null)
		   {email="%"+input.getOfficialEmail().toUpperCase()+"%";}
		   
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
			
			String position=null;
			if(input.getPositionValue()!=null) 
		    {position="%"+input.getPositionValue().toUpperCase()+"%";}
		
	
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId, empCode,empName,email,position,status,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	

	@Override
	public List<LtMastEmployees> getDatatableRecords(Long companyId, LtMastEmployees input) throws ServiceException {
		String query = env.getProperty("getLtMastEmployeesDatatableRecords");
		 
		   String empCode=null;
		   if(input.getEmployeeNumber()!=null)
		   {empCode="%"+input.getEmployeeNumber().toUpperCase()+"%";}
		   
		   String empName=null;
		   if(input.getEmpName()!=null)
		   {empName="%"+input.getEmpName().toUpperCase()+"%";}
		   
		   String email=null;
		   if(input.getOfficialEmail()!=null)
		   {email="%"+input.getOfficialEmail().toUpperCase()+"%";}
		   
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
			
			String position=null;
			if(input.getPositionValue()!=null) 
		    {position="%"+input.getPositionValue().toUpperCase()+"%";}
			
			
			
			List<LtMastEmployees> list = (List<LtMastEmployees>) 
					jdbcTemplate.query(query , new Object[]{companyId, empCode,empName,email,position,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class));
				return list;
	}

	@Override
	public List<LtMastEmployees> getLtMastEmployeesBySuperWID(long employeeId) throws ServiceException {
		String query = env.getProperty("getLtMastEmployeesBySWEmpId");
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ employeeId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	@Override
	public List<LtMastEmployees> getByEmpIdV1(Long employeeId) throws ServiceException {
		String query = env.getProperty("getEmployeeByEmpIdV1");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ employeeId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class));
	
		return list;
	}

	@Override
	public List<LtMastEmployees> getByEmpIdForEmail(Long empId) throws ServiceException {
		String query = env.getProperty("getByEmpIdForEmail");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ empId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	@Override
	public List<LtMastEmployees> getBuyerByDivId(String name, String divisionId) throws ServiceException {
		String query = env.getProperty("getBuyerByDivId");
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ divisionId,"%"+ name.toUpperCase() +"%",
				"%"+ name.toUpperCase() +"%"}, 
				 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		 
		return list;
	}

	@Override
	public List<LtMastEmployees> getAllBuyerByDivId(String divisionId) throws ServiceException {
		String query = env.getProperty("getAllBuyerByDivId");
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ divisionId}, 
				 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		 
		return list;
	}
	
	@Override
	public List<LtMastEmployees> companyWiseEmp(Long compId) throws ServiceException 
	{
		String query = env.getProperty("findCompanyWiseEmployee");
	    List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ compId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		
		return list;
	}

	@Override
	public List<LtMastEmployees> getLikeNameByComId(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getEmployeeLikeNameByComId");
		
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
	
		return list;
	}

	@Override
	public List<LtMastEmployees> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastEmployeesDataForReport");
		if(reportParameters.getStatus().equals(""))
			reportParameters.setStatus(null);
		List<LtMastEmployees> list=   jdbcTemplate.query(query, new Object[]{reportParameters.getStatus(),
				reportParameters.getStartDate(),reportParameters.getEndDate(),reportParameters.getCompanyId()  }, 
		 new BeanPropertyRowMapper<LtMastEmployees>(LtMastEmployees.class)); 
		return list;
	}

	@Override
	public Status getCompanyByBuyer(Long buyerId) throws ServiceException {
		Status status = new Status();
		String query = env.getProperty("getCompanyByBuyer");
		String companyId  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {buyerId}, String.class);
		status.setData(companyId);
		return status;
	}
	
}
