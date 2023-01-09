package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAttachment;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorAttachmentService extends CodeMaster
{
	
	public List<LtMastVendorAttachment> getAllFilesByVendorId(Long vendorId) throws ServiceException;

	Status delete(String expenceHeaderId) throws ServiceException;

	public Status deleteLtMastVendorAttachment(Long expenseFileUploadId)throws ServiceException;

	public ResponseEntity<Status> saveAttachments(String apiUrl, String[] names, String ltMastVendorAttachment,MultipartFile[] files);

	public Status deleteLtMastVendorAttachmentFile(Long vendorAttachmentId);

	public LtMastVendorAttachment getAttachmentByVendorIdAndType(Long vendorId) throws ServiceException;

	public Status checkRecord(Long venId) throws ServiceException;

	

}
