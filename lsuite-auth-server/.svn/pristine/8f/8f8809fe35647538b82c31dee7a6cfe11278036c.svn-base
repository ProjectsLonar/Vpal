package com.lonar.UserManagement.web.service;

import java.util.List;

import com.lonar.UserManagement.web.model.LtMastEmailtoken;

public interface LtMastEmailtokenService {

	public List<LtMastEmailtoken> findByEmailtokenid(Long emailtokenid) throws Exception;

	public List<LtMastEmailtoken> findByTokenid(String tokenid) throws Exception;

	public List<LtMastEmailtoken> findAllActive() throws Exception;

	//public void makeEntryInEmailToken(List<ExpenseApproval> expenseApproval,String emailTemplate,LtExpExpenseHeaders ltExpExpenseHeaders,String type) throws Exception;

	public void updateStatus(Long tokenId, String status, Integer count) throws Exception;

	public List<LtMastEmailtoken> getDataTable(LtMastEmailtoken input) throws Exception;

	public Long getCount(LtMastEmailtoken input) throws Exception;

	public LtMastEmailtoken getLtMastEmailtokenById(String emailtokenid);

	
}
