package com.lonar.vendor.vendorportal.csvupload;

import java.util.List;

public interface LtMastCsvFileUploadDao 
{

	List<LtMastFileTableMapping> getMappingTableDetails(String requestName) throws Exception;

	int saveStatusTable(String tableName, String requestName, int requestorId, String fileName) throws Exception;

	int saveCSVFileData(String startQuery, List<List<String>> batchValueList, int statusTableId)  throws Exception;

	List<LtMastFileTableMapping> getDownloadFilePath(String requestName) throws Exception;

}
