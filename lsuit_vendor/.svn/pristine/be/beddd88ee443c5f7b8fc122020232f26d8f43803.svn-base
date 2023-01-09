package com.lonar.vendor.vendorportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.vendor.vendorportal.model.CustomeDataTable;
import com.lonar.vendor.vendorportal.model.LtPoShipment;
import com.lonar.vendor.vendorportal.service.LtPoShipmentService;

@RestController
@RequestMapping("/API/poshipments")
public class LtMastPoShipmentsRestController {

	@Autowired
	LtPoShipmentService ltPoShipmentService;

	@RequestMapping(value = "/datatable/{headerId}/{branchId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getLtMastVendorsDataTable(@PathVariable("headerId") Long headerId,
			@PathVariable("branchId") Long branchId, LtPoShipment input, @PathVariable("logTime") String logTime) {
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try {
			Long count = ltPoShipmentService.getLtPoShipmentCount(headerId, branchId, input);
			customeDataTable.setRecordsTotal(count);
			customeDataTable.setRecordsFiltered(count);
			List<LtPoShipment> ltPoLinesList = ltPoShipmentService.getLtPoShipmentDataTable(headerId, branchId, input);
			customeDataTable.setData(ltPoLinesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customeDataTable;
	}

}
