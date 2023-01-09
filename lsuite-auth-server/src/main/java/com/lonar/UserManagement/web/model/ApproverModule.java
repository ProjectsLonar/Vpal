package com.lonar.UserManagement.web.model;

import java.util.List;

public class ApproverModule 
{

	private LtModuleApprovals ltExpModuleApprovals;
	private List<LtMastModuleAppEmployees> appEmployeeList;
	
	
	
	public LtModuleApprovals getLtExpModuleApprovals() {
		return ltExpModuleApprovals;
	}
	public void setLtExpModuleApprovals(LtModuleApprovals ltExpModuleApprovals) {
		this.ltExpModuleApprovals = ltExpModuleApprovals;
	}
	public List<LtMastModuleAppEmployees> getAppEmployeeList() {
		return appEmployeeList;
	}
	public void setAppEmployeeList(List<LtMastModuleAppEmployees> appEmployeeList) {
		this.appEmployeeList = appEmployeeList;
	}
	@Override
	public String toString() {
		return "ApproverModule [ltExpModuleApprovals=" + ltExpModuleApprovals + "]";
	}
	
	
}
