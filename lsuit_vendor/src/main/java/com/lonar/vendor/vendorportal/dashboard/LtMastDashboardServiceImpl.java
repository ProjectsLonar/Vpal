package com.lonar.vendor.vendorportal.dashboard;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LtMastDashboardServiceImpl implements LtMastDashboardService {

	@Autowired
	LtMastDashboardDao ltMastDashboardDao;

	@Override
	public List<LtMastDashboardModel> getDashboardYearSummaryByBuyer(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getDashboardYearSummaryByBuyer(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getDashboardMonthlySummaryByBubyer(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getDashboardMonthlySummaryByBuyer(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getDashboardYearSummaryByVender(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getDashboardYearSummaryByVender(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getDashboardMonthlySummaryByVender(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getDashboardMonthlySummaryByVender(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncome(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getTotalIncome(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getTotalExpense(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getTotalExpense(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderYearVendor(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getPurachaseOrderYearVendor(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderYearBuyer(Long comapnyId) throws SerialException {
		return ltMastDashboardDao.getPurachaseOrderYearBuyer(comapnyId);
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderMonthVendor(Long comapnyId) throws SerialException {
		List<LtMastDashboardModel> listPoMonthList = ltMastDashboardDao.getPurachaseOrderMonthVendor(comapnyId);
		List<LtMastDashboardModel> newlistPoMonthList = new ArrayList<LtMastDashboardModel>();
		for (LtMastDashboardModel pomonth : listPoMonthList) {
		//	pomonth.setCurrency("Lakh");
			newlistPoMonthList.add(pomonth);
		}
		return newlistPoMonthList;
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderMonthBuyer(Long comapnyId) throws SerialException {
		List<LtMastDashboardModel> listPoMonthList = ltMastDashboardDao.getPurachaseOrderYearBuyer(comapnyId);
		List<LtMastDashboardModel> newlistPoMonthList = new ArrayList<LtMastDashboardModel>();
		for (LtMastDashboardModel pomonth : listPoMonthList) {
			pomonth.setCurrency("Lakh");
			newlistPoMonthList.add(pomonth);
		}
		return newlistPoMonthList;
	}

	@Override
	public List<LtMastDashboardModel> getPOInvoiveYearBuyer(Long companyId) throws SerialException {
		return ltMastDashboardDao.getPOInvoiveYearBuyer(companyId);
	}

	@Override
	public List<LtMastDashboardModel> getPOInvoiveYearVendor(Long vendorId) throws SerialException {
		return ltMastDashboardDao.getPOInvoiveYearVendor(vendorId);
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncomeExpenseBuyer(Long companyId) throws SerialException {
		return ltMastDashboardDao.getTotalIncomeExpenseBuyer(companyId);
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncomeExpenseVendor(Long vendorId) throws SerialException {
		return ltMastDashboardDao.getTotalIncomeExpenseVendor(vendorId);
	}

}
