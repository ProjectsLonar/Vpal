package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastVendorMiscQuestionsService
{

	Status save(List<LtMastVendorMiscQuestions> ltMastVendorMiscQuestions) throws ServiceException;

	Status update(List<LtMastVendorMiscQuestions> ltMastVendorMiscQuestions) throws ServiceException;

	List<LtMastVendorMiscQuestions> getVendorMiscQuestionByVenId(Long vendorId) throws ServiceException;

	LtMastVendorMiscQuestions getVendorMiscQuesById(Long vendorMiscQuesId) throws ServiceException;

	Status checkRecord(Long venId) throws ServiceException;

}
