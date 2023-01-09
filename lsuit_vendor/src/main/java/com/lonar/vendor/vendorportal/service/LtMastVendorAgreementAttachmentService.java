package com.lonar.vendor.vendorportal.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorAgreementAttachmentService 
{

	String multipleSave(MultipartFile[] files, Long vendorId,Long venAgreementId) throws ServiceException , FileNotFoundException, IOException  ;

}
