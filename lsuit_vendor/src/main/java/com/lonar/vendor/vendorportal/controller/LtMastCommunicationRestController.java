package com.lonar.vendor.vendorportal.controller;

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

import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.service.LtMastCommunicationTabService;

@RestController
@RequestMapping("/API/communication")
public class LtMastCommunicationRestController {

	@Autowired
	LtMastCommunicationTabService ltMastCommunicationTabService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Status savecommunication(@RequestBody LtMastCommunicationTab ltMastCommunicationTab) throws Exception {
		return ltMastCommunicationTabService.save(ltMastCommunicationTab);
	}

	@RequestMapping(value = "/getallvendors/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastCommunicationTab> getAllCommunicationByComId(@PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getAllCommunicationByComId(companyId);
	}

	@RequestMapping(value = "/getallvendorcommunication/{commId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastCommunicationTab> getallvendorcommunication(@PathVariable("commId") Long commId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getallvendorcommunication(commId);
	}

	@RequestMapping(value = "/getallbuyercommunication/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastCommunicationTab> getAllBuyerCommunication(@PathVariable("vendorId") Long vendorId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getAllBuyerCommunication(vendorId);
	}

	@RequestMapping(value = "/getCommunicationId/{vendorId}/{companyId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status getCommunicationId(@PathVariable("vendorId") Long vendorId, @PathVariable("companyId") Long companyId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getCommunicationId(vendorId, companyId);
	}

	@RequestMapping(value = "/getvendornotificationcount/{buyerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status getVendorNotificationCount(@PathVariable("buyerId") Long buyerId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getVendorNotificationCount(buyerId);
	}

	@RequestMapping(value = "/getbuyernotificationcount/{buyerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status getBuuyerNotificationCount(@PathVariable("buyerId") Long buyerId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getBuuyerNotificationCount(buyerId);
	}

	@RequestMapping(value = "/getvendormsgbybuyerid/{buyerId}/{logTime}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<VendorBuyerDetails>> getVendorMsgByBuyerId(@PathVariable("buyerId") Long buyerId,
			@PathVariable("logTime") String logTime) throws ServiceException {
		List<VendorBuyerDetails> vendorBuyerDetails = ltMastCommunicationTabService.getVendorMsgByBuyerId(buyerId);
		return new ResponseEntity<List<VendorBuyerDetails>>(vendorBuyerDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/updatevendornotification/{buyerId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status updateVendorNotification(@PathVariable("buyerId") Long buyerId,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.updateVendorNotification(buyerId);
	}

	@RequestMapping(value = "/updatebuyernotification/{buyerId}/{vendorId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status updateBuuyerNotification(@PathVariable("buyerId") Long buyerId,
			@PathVariable("vendorId") Long vendorId, @PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.updateBuuyerNotification(buyerId, vendorId);
	}

	@RequestMapping(value = "/getLikeNameBybuyerid/{buyerId}/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastVendors> getLikeNameByBuyerId(@PathVariable("name") String name,
			@PathVariable("buyerId") Long buyerId, @PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getLikeNameByBuyerId(name, buyerId);
	}

	@RequestMapping(value = "/getLikeNameBybuyername/{name}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LtMastVendors> getLikeNameByBuyerName(@PathVariable("name") String name,
			@PathVariable("logTime") String logTime) throws Exception {
		return ltMastCommunicationTabService.getLikeNameByBuyerName(name);
	}
}
