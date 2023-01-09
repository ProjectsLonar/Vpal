package com.lonar.vendor.vendorportal.dashboard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/API/dashboard")
public class LtMastDashboardController {

	@Autowired
	LtMastDashboardService ltMastDashboardService;

	@RequestMapping(value = "/dashboardyearsummarybybuyer/{buyerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastDashboardYearSummaryByBuyer(
			@PathVariable("buyerId") Long buyerId, @PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardYearBybuyerList = null;

		try {
			dashboardYearBybuyerList = ltMastDashboardService.getDashboardYearSummaryByBuyer(buyerId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardYearBybuyerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/dashboardyearsummarybyvendor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastDashboardYearSummaryByVendor(
			@PathVariable("vendorId") Long vendorId, @PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardYearByVendorList = null;

		try {
			dashboardYearByVendorList = ltMastDashboardService.getDashboardYearSummaryByVender(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardYearByVendorList, HttpStatus.OK);
	}

	@RequestMapping(value = "/dashboardmonthsummarybybuyer/{buyerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastDashboardMonthlySummaryByBuyer(
			@PathVariable("buyerId") Long buyerId, @PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardMonthByBuyerList = null;

		try {
			dashboardMonthByBuyerList = ltMastDashboardService.getDashboardMonthlySummaryByBubyer(buyerId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardMonthByBuyerList, HttpStatus.OK);

	}

	@RequestMapping(value = "/dashboardmonthsummarybyvendor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastDashboardMonthlySummaryByVendor(
			@PathVariable("vendorId") Long vendorId, @PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardMonthByVendorList = null;

		try {
			dashboardMonthByVendorList = ltMastDashboardService.getDashboardMonthlySummaryByVender(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardMonthByVendorList, HttpStatus.OK);

	}

	@RequestMapping(value = "/dashboardpoyearbyvendor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastPOYearByVendor(@PathVariable("vendorId") Long vendorId,
			@PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardPOYearVendorList = null;

		try {
			dashboardPOYearVendorList = ltMastDashboardService.getPurachaseOrderYearVendor(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardPOYearVendorList, HttpStatus.OK);

	}

	@RequestMapping(value = "/dashboardpoyearbybuyer/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastPOYearByBuyer(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) {

		List<LtMastDashboardModel> dashboardPOYearBuyerList = null;

		try {
			dashboardPOYearBuyerList = ltMastDashboardService.getPurachaseOrderYearBuyer(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardPOYearBuyerList, HttpStatus.OK);

	}

	@RequestMapping(value = "/dashboardpomonthbyvendor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<DashboardModel> getLtMastPoMonthByVendor(@PathVariable("vendorId") Long vendorId,
			@PathVariable("logTime") String logTime) {
		DashboardModel dm=new DashboardModel();
		List<LtMastDashboardModel> dashboardPOMonthVendorList = null;
		try {
			dashboardPOMonthVendorList = ltMastDashboardService.getPurachaseOrderMonthVendor(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dm.setCurrency("Lack");
		dm.setDataList(dashboardPOMonthVendorList);
		return new ResponseEntity<DashboardModel>(dm, HttpStatus.OK);
	}

	@RequestMapping(value = "/dashboardpomonthbybuyer/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getLtMastPoMonthByBuyer(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> dashboardPOMonthBuyerList = null;
		try {
			dashboardPOMonthBuyerList = ltMastDashboardService.getPurachaseOrderMonthBuyer(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(dashboardPOMonthBuyerList, HttpStatus.OK);
	}

	@RequestMapping(value = "/dashboardtotalincome/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getTotalIncome(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> totalIncomeList = null;
		try {
			totalIncomeList = ltMastDashboardService.getTotalIncome(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(totalIncomeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/dashboardtotalexpense/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getTotalExpense(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> totalExpenseList = null;
		try {
			totalExpenseList = ltMastDashboardService.getTotalExpense(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(totalExpenseList, HttpStatus.OK);
	}

	@RequestMapping(value = "/poinvoiceyearvedor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getPOInvoiceYearVendor(@PathVariable("vendorId") Long vendorId,
			@PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> pototalIncomeList = null;
		try {
			pototalIncomeList = ltMastDashboardService.getPOInvoiveYearVendor(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(pototalIncomeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/poinvoiceyearbuyer/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getPOInvoiceYearBuyer(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> pototalExpenseList = null;
		try {
			pototalExpenseList = ltMastDashboardService.getPOInvoiveYearBuyer(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<LtMastDashboardModel>>(pototalExpenseList, HttpStatus.OK);
	}

	@RequestMapping(value = "/totalincomeexpensesbuyer/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getTotalIncomeExpensesBuyer(
			@PathVariable("companyId") Long companyId, @PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> totalIncomeList = null;
		try {
			totalIncomeList = ltMastDashboardService.getTotalIncomeExpenseBuyer(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(totalIncomeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/totalincomeexpensesvendor/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LtMastDashboardModel>> getTotalIncomeExpenseVendor(
			@PathVariable("vendorId") Long vendorId, @PathVariable("logTime") String logTime) {
		List<LtMastDashboardModel> totalExpenseList = null;
		try {
			totalExpenseList = ltMastDashboardService.getTotalIncomeExpenseVendor(vendorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<LtMastDashboardModel>>(totalExpenseList, HttpStatus.OK);
	}
}
