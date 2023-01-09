package com.lonar.vendor.vendorportal.dashboard;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

public interface LtMastDashboardDao {

	List<LtMastDashboardModel> getDashboardYearSummaryByBuyer(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getDashboardYearSummaryByVender(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getDashboardMonthlySummaryByBuyer(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getDashboardMonthlySummaryByVender(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getTotalIncome(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getTotalExpense(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getPOInvoiveYearBuyer(Long comapnyId) throws SerialException;

	/*-------Start---------*/
	List<LtMastDashboardModel> getTotalIncomeExpenseBuyer(Long companyId) throws SerialException;

	List<LtMastDashboardModel> getTotalIncomeExpenseVendor(Long vendorId) throws SerialException;
	/*-------end---------*/

	List<LtMastDashboardModel> getPOInvoiveYearVendor(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getPurachaseOrderYearVendor(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getPurachaseOrderYearBuyer(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getPurachaseOrderMonthVendor(Long comapnyId) throws SerialException;

	List<LtMastDashboardModel> getPurachaseOrderMonthBuyer(Long comapnyId) throws SerialException;

}
