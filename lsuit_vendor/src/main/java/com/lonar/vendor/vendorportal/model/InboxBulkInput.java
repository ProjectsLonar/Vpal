package com.lonar.vendor.vendorportal.model;

import java.util.List;

public class InboxBulkInput {
	private Long approvalId;
	private String note;
	private String type;
	private String action;
	private List<BulkIdWithName> expenseList;
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<BulkIdWithName> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(List<BulkIdWithName> expenseList) {
		this.expenseList = expenseList;
	}
	public Long getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}
	@Override
	public String toString() {
		return "InboxBulkInput [approvalId=" + approvalId + ", note=" + note + ", type=" + type + ", action=" + action
				+ ", expenseList=" + expenseList + "]";
	}
	
	
	

}
