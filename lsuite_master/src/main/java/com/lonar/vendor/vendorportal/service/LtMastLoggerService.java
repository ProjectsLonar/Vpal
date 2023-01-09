package com.lonar.vendor.vendorportal.service;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastLogger;

public interface LtMastLoggerService
{

	Long getCount(LtMastLogger input) throws Exception;

	List<LtMastLogger> getLoggerRecords(LtMastLogger input) throws Exception;

	LtMastLogger getByID(Long id) throws Exception;

}
