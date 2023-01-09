package com.lonar.vendor.vendorportal.csvupload;

import java.io.BufferedReader;
import java.util.List;

public interface LtMastCsvFileUploadService 
{

	List<LtMastFileTableMapping> getMappingTableDetails(String requestName) throws Exception;

	int saveFileDemo(BufferedReader bufferedReader, List<LtMastFileTableMapping> mappingList, String requestName,
			int reqId, String fileName) throws Exception;

	List<LtMastFileTableMapping> getDownloadFilePath(String requestName) throws Exception;

}
