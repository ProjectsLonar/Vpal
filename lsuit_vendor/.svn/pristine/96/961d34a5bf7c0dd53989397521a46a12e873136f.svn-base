package com.lonar.vendor.vendorportal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.service.LtMastVendorAgreementAttachmentService;

@RestController
@RequestMapping("/vendorattachment")
public class LtMastVendorAgreementAttachment 
{
	static final Logger logger = Logger.getLogger(LtMastVendorAgreementAttachment.class);
	@Autowired
	LtMastVendorAgreementAttachmentService vendorAgreementAttachmentService;
		
	@RequestMapping(value="/multipleUpload")
    public String multiUpload()
	{
    	return "multipleUpload";
    }
	
	
    @RequestMapping(value="/multipleSave", method=RequestMethod.POST )
    public @ResponseBody String multipleSave(@RequestParam("file") MultipartFile[] files,@RequestParam("vendorId") Long vendorId)
    {
    	String fileName = null;
    	String msg = "";
    	try
    	{
    		if (files != null && files.length >0) 
    		{
    			msg=vendorAgreementAttachmentService.multipleSave(files,vendorId,new Long(1));
    			
    		}	
    	}
    	catch(Exception e)
    	{
    		logger.error("ERROR "+ e );
			e.printStackTrace();
    		return "You failed to upload " + fileName + ": " + e.getMessage() +"<br/>";
    	}
    	return msg;
	
    }
    
    
	
	
}
