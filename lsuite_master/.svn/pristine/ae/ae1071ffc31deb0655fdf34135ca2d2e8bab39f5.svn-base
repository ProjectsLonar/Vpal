package com.lonar.vendor.vendorportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.model.LtMastDocumentList;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastDocumentListService {

	Long getCount(Long companyId, LtMastDocumentList input) throws ServiceException;

	List<LtMastDocumentList> getDataTableRecords(Long companyId, LtMastDocumentList input) throws ServiceException;

	ResponseEntity<Status> saveWithfile(Long lastUpdateLogin, MultipartFile[] files) throws ServiceException;

	ResponseEntity<Status> deleteById(Long id) throws ServiceException;


}
