package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastVendorMiscQuestions;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastVendorMiscQuestionsDao 
{

	List<LtMastVendorMiscQuestions> getVendorMiscQuestionByVenId(Long vendorId) throws ServiceException;

	LtMastVendorMiscQuestions getVendorMiscQuesById(Long vendorMiscQuesId) throws ServiceException;

}
