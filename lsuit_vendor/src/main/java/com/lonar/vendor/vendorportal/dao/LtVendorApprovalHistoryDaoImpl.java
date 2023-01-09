package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
public class LtVendorApprovalHistoryDaoImpl implements LtVendorApprovalHistoryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(LtVendorApprovalHistory ltExpenseApprovalHistory) throws ServiceException {
		
		int res = jdbcTemplate
		.update(" INSERT INTO lt_vendor_approval_history "
				+ " (VENDOR_APPROVAL_HISTORY_ID,VENDOR_APPROVAL_ID,EMPLOYEE_ID, "
				+ " STATUS,NOTE,LAST_UPDATE_DATE,VENDOR_ID,REMARK,USER_TYPE ) "
				+ " VALUES(LT_VENDOR_APPROVAL_HISTORY_S.NEXTVAL,?,?,?,?,?,?,?,?)  ",

				//ltExpenseApprovalHistory.getVendorApprovalHistoryId(),
				ltExpenseApprovalHistory.getVendorApprovalId(),
				ltExpenseApprovalHistory.getEmployeeId(),
				ltExpenseApprovalHistory.getStatus(),
				ltExpenseApprovalHistory.getNote(),
				new Date(),
				ltExpenseApprovalHistory.getVendorId(),
				ltExpenseApprovalHistory.getRemark(),
				ltExpenseApprovalHistory.getUserType());
				
if (res != 0)
	return true;
else
	return false;
	}

	@Override
	public List<LtVendorApprovalHistory> getVendorApprovalHistoryByVendorId(Long vendorId) throws ServiceException
	{
		String query = " SELECT v.VENDOR_APPROVAL_HISTORY_ID, v.VENDOR_APPROVAL_ID,v.NOTE,v.LAST_UPDATE_DATE,v.VENDOR_ID,v.EMPLOYEE_ID,  \r\n" + 
				"      v.REMARK,cmvs.value_name as status, " + 
				"  (CASE WHEN v.user_type = 'VENDOR' then ven.VENDOR_NAME " + 
				"   ELSE  ( cmv.value_name||' ' || em.first_name || ' '|| em.LAST_NAME||' ' || '(' ||em.EMPLOYEE_NUMBER||')' )  " + 
				"   END ) AS approval_Name,  " + 
				"  v.USER_TYPE, v.VENDOR_ID " + 
				"   FROM lt_vendor_approval_history v,LT_MAST_EMPLOYEES em,LT_MAST_COMN_MASTER_VALUES cmv ,  " + 
				" LT_MAST_COMN_MASTER_VALUES cmvs  , LT_MAST_VENDORS ven  ,LT_MAST_COMN_MASTER cm   " + 
				" WHERE v.VENDOR_ID = ? " + 
				"    AND ven.VENDOR_ID(+) = v.VENDOR_ID      " + 
				" and em.employee_id(+) = v.employee_id   " + 
				" and em.title = cmv.value_code(+)  " + 
				" and  v.status = cmvs.value_code(+) AND cmvs.master_Id(+) = cm.MASTER_ID AND cm.MASTER_NAME = 'VENDOR_STATUS'  " + 
				" order by v.VENDOR_APPROVAL_HISTORY_ID desc  ";
		
		List<LtVendorApprovalHistory> list=   jdbcTemplate.query(query, new Object[]{ vendorId }, 
				 new BeanPropertyRowMapper<LtVendorApprovalHistory>(LtVendorApprovalHistory.class)); 
		 
		return list;
	}

}
