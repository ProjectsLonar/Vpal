package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastLogger;

public interface LtMastLoggerDao {

	Long getCount(LtMastLogger input) throws Exception;

	List<LtMastLogger> getLoggerRecords(LtMastLogger input) throws Exception;

	LtMastLogger getByID(Long id) throws Exception;

}
