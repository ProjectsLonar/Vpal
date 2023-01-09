package com.lonar.vendor.vendorportal.reports;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@RestController
@RequestMapping("/API/reports")
public class LtMastExcelReportsRestController implements CodeMaster{
	
	@Autowired
	LtMastExcelReportsService ltMastExcelReportsService;
	
	@RequestMapping(value = "/excelReport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> createExcelReport(@RequestBody ReportParameters reportParameters) throws ServiceException, IOException{
		Status status =  ltMastExcelReportsService.createExcelReport(reportParameters);
		return new ResponseEntity<Status>(status,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/dataTable/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable DataTable(@PathVariable("companyId") Long companyId, LtMastReportRequest input,@PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltMastExcelReportsService.getCount(input,companyId);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtMastReportRequest> ltMastReportRequestList = ltMastExcelReportsService.getReportRequestDataTableRecords(input,companyId);
			customeDataTable.setData(ltMastReportRequestList);

		} catch (Exception e) {
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, e);
		}
		return customeDataTable;

	}

}
