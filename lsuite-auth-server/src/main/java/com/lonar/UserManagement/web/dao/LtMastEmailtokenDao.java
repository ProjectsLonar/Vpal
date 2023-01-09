package com.lonar.UserManagement.web.dao;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastEmailtoken;

public interface LtMastEmailtokenDao {

	public List<LtMastEmailtoken> findByEmailtokenid(Long emailtokenid) throws Exception;

	public List<LtMastEmailtoken> findByTokenid(String tokenid) throws Exception;

	public List<LtMastEmailtoken> findAllActive() throws Exception;

	public Long makeEntryInEmailToken(LtMastEmailtoken ltMastEmailtoken) throws Exception;
	
	public List<LtMastEmailtoken> getByStatus(String status) throws Exception;

	public void updateEmailToken(String sending) throws Exception;

	public void updateStatus(Long tokenId, String status, Integer count) throws Exception;

	//public void batchInsertLine(List<LtExpEmailTokenlLine> emailTokenLines)  throws Exception;

	public List<LtMastEmailtoken> getDataTable(LtMastEmailtoken input)throws Exception;

	public Long getCount(LtMastEmailtoken input)throws Exception;

	public LtMastEmailtoken getLtMastEmailtokenById(String emailtokenid);

}
