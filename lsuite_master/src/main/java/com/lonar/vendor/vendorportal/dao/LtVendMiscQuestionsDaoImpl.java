package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMisc;
import com.lonar.vendor.vendorportal.model.LtCompanyVenMgmtMiscQues;
import com.lonar.vendor.vendorportal.model.LtVendMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendMiscQuestionsMasterQueries.properties", ignoreResourceNotFound = true)
public class LtVendMiscQuestionsDaoImpl implements LtVendMiscQuestionsDao{


	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}
	
	@Override
	public List<LtVendMiscQuestions> getBycompanyMiscId(Long companyMiscId) throws ServiceException {
		String query = env.getProperty("getVendMiscQuestionsBycompanyMiscId");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{companyMiscId },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getAll() throws ServiceException {
		String query = env.getProperty("getAllVendMiscQuestions");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getAllActive() throws ServiceException {
		String query = env.getProperty("getAllActiveVendMiscQuestions");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getById(Long id) throws ServiceException {
		String query = env.getProperty("getLtVendMiscQuestionsById");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{id },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		if(list.isEmpty())
			return null;
		else
		return list;
	}

	@Override
	public List<LtVendMiscQuestions> getMiscQueBycompanyId(Long companyId) throws ServiceException {
		String query = env.getProperty("getVendMiscQuestionsBycompanyId");
		
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{companyId },
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtMiscQues> getLtCompanyVenMgmtMiscQuesByQueId(Long compMiscellaneousId)
			throws ServiceException {
		String query = env.getProperty("getLtCompanyVenMgmtMiscQuesByQueId");
		List<LtCompanyVenMgmtMiscQues> list = (List<LtCompanyVenMgmtMiscQues>) 
				jdbcTemplate.query(query , new Object[]{ compMiscellaneousId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtMiscQues>(LtCompanyVenMgmtMiscQues.class));
		return list;
	}

	@Override
	public List<LtCompanyVenMgmtMisc> getLtCompanyVenMgmtMiscQuesBy(Long compVenMgmtMiscId) throws ServiceException {
		String query = env.getProperty("getLtCompanyVenMgmtMiscQuesBycompVenMgmtMiscId");
		List<LtCompanyVenMgmtMisc> list = (List<LtCompanyVenMgmtMisc>) 
				jdbcTemplate.query(query , new Object[]{ compVenMgmtMiscId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtMisc>(LtCompanyVenMgmtMisc.class));
		return list;
	}

	@Override
	public boolean deletecompanyVenMgmtMiscQue(Long compVenMgmtMiscId) throws ServiceException {
		String query1 = " DELETE FROM LT_MAST_VENDOR_MISC_QUESTIONS vmq " + 
				" WHERE vmq.MISC_QUESTION_ID IN ( SELECT cmmq.MISC_QUESTION_ID  " + 
				"                            FROM LT_COMPANY_VEN_MGMT_MISC_QUES cmmq " + 
				"                            WHERE cmmq.COMP_VEN_MGMT_MISC_ID = ? ) "
				+ " AND vmq.VENDOR_ID = ( SELECT VENDOR_ID FROM LT_COMPANY_VEN_MGMT_MISC WHERE COMP_VEN_MGMT_MISC_ID = ? )";
		
		int res=0;
		res=jdbcTemplate.update(query1 ,compVenMgmtMiscId,compVenMgmtMiscId);
		 
		//if(res!=0) {
			String query = " DELETE FROM LT_COMPANY_VEN_MGMT_MISC_QUES WHERE COMP_VEN_MGMT_MISC_ID = ? ";
			int res1=0;
			res1=jdbcTemplate.update(query ,compVenMgmtMiscId);
	 
			if(res1!=0)
				return true;
			else
				return false;
		//}
		//return false;
	}

	@Override
	public List<LtVendMiscQuestions> getMiscQueBycompanyVendorId(Long companyId, Long vendorId)
			throws ServiceException {
		String query = env.getProperty("getcompanyMiscQueBycompanyVendorId");
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ companyId,vendorId},
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public boolean deleteCompanyQueByCompanyId(Long companyId,Long miscQueId) throws ServiceException {
		/*String query = " DELETE FROM LT_COMPANY_VEN_MGMT_MISC_QUES " + 
				" WHERE COMP_VEN_MGMT_MISC_ID IN ( SELECT COMP_VEN_MGMT_MISC_ID FROM LT_COMPANY_VEN_MGMT_MISC " + 
				" WHERE COMPANY_ID = ? " + 
				" AND VENDOR_ID IN ( SELECT VENDOR_ID  "
				+ "FROM LT_MAST_VENDORS WHERE ( STATUS = 'INVITED' OR STATUS = 'VENDOR_DRAFT')  AND COMPANY_ID = ? ) ) ";*/
		
		/*String query = " DELETE FROM LT_COMPANY_VEN_MGMT_MISC_QUES  " + 
				"   WHERE COMP_VEN_MGMT_MISC_ID IN ( SELECT COMP_VEN_MGMT_MISC_ID FROM LT_COMPANY_VEN_MGMT_MISC  " + 
				" WHERE COMPANY_ID = ?  ) AND MISC_QUESTION_ID = ?";*/
		
		String query = "   DELETE FROM LT_COMPANY_VEN_MGMT_MISC_QUES  " + 
				"				   WHERE COMP_VEN_MGMT_MISC_ID IN ( SELECT mm.COMP_VEN_MGMT_MISC_ID " + 
				"                 FROM LT_COMPANY_VEN_MGMT_MISC mm , LT_MAST_VENDORS mv " + 
				"				 WHERE mm.COMPANY_ID = ? AND mm.VENDOR_ID = mv.VENDOR_ID  "
				+ " AND ( mv.STATUS = 'INVITED' OR mv.STATUS = 'VENDOR_DRAFT' OR mv.STATUS = 'REJECTED' OR mv.STATUS = 'WITHDRAW' ) ) " + 
				"                 AND MISC_QUESTION_ID = ? ";
		int res=0;
		 res=jdbcTemplate.update(query ,companyId,miscQueId);
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtCompanyVenMgmtMiscQues> getCompVenMgmtMiscQuesByParent(Long compVenMgmtMiscId)
			throws ServiceException {
		String query = env.getProperty("getCompVenMgmtMiscQuesByParent");
		List<LtCompanyVenMgmtMiscQues> list = (List<LtCompanyVenMgmtMiscQues>) 
				jdbcTemplate.query(query , new Object[]{ compVenMgmtMiscId},
		new  BeanPropertyRowMapper<LtCompanyVenMgmtMiscQues>(LtCompanyVenMgmtMiscQues.class));
		return list;
	}

	@Override
	public boolean deleteVendorQueByCompanyId(Long comId,Long miscQueId) throws ServiceException {
		
		/*String query = " DELETE FROM LT_MAST_VENDOR_MISC_QUESTIONS " + 
				"	WHERE  VENDOR_ID IN ( SELECT VENDOR_ID "
				+ "  FROM LT_MAST_VENDORS WHERE  STATUS IN ( 'INVITED' ,'VENDOR_DRAFT','WITHDRAW','REJECTED' ) " + 
				"    AND COMPANY_ID = ? ) AND MISC_QUESTION_ID = ? ";
		int res=0;
		 res=jdbcTemplate.update(query ,comId,miscQueId);*///11-7-2019
		
		String query = " DELETE FROM LT_MAST_VENDOR_MISC_QUESTIONS " + 
				" WHERE  VENDOR_ID IN ( SELECT vcm.VENDOR_ID  " + 
				"                      FROM LT_COMPANY_VEN_MGMT_MISC  vcm,LT_MAST_VENDORS vm " + 
				"                      WHERE  vcm.COMPANY_ID = ?  " + 
				"                      AND vm.VENDOR_ID = vcm.VENDOR_ID  " + 
				"                      AND  vm.STATUS IN ('INVITED' ,'VENDOR_DRAFT','WITHDRAW','REJECTED') )  ";
		int res=0;
		 res=jdbcTemplate.update(query ,comId);
		 
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtVendMiscQuestions> getConfigDifference(Long companyId, Long vendorId) throws ServiceException {
		String query = env.getProperty("getConfigDifferentQuestion");
		List<LtVendMiscQuestions> list = (List<LtVendMiscQuestions>) 
				jdbcTemplate.query(query , new Object[]{ companyId,vendorId},
		new  BeanPropertyRowMapper<LtVendMiscQuestions>(LtVendMiscQuestions.class));
		return list;
	}

	@Override
	public boolean deleteCompanyQueByCompanyIdVendorId(Long companyId, Long vendorId) throws ServiceException {
		String query = " DELETE FROM LT_COMPANY_VEN_MGMT_MISC_QUES " + 
				"	WHERE  COMP_VEN_MGMT_MISC_ID = ( SELECT COMP_VEN_MGMT_MISC_ID "
				+ "  FROM LT_COMPANY_VEN_MGMT_MISC WHERE COMPANY_ID = ? AND VENDOR_ID = ? )  ";
		int res=0;
		 res=jdbcTemplate.update(query ,companyId,vendorId);
		if(res!=0)
			return true;
		else
			return false;
		
	}

	

}
