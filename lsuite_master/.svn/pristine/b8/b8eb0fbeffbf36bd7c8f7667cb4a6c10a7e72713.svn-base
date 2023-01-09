package com.lonar.vendor.vendorportal.csvupload;

import java.io.BufferedReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LtMastCsvFileUploadServiceImpl implements LtMastCsvFileUploadService
{
	@Autowired
	LtMastCsvFileUploadDao ltMastCsvFileUploadDao;

	@Override
	public List<LtMastFileTableMapping> getMappingTableDetails(String requestName) throws Exception
	{
		return ltMastCsvFileUploadDao.getMappingTableDetails(requestName);//fileName);
	}

	@Override
	public int saveFileDemo(BufferedReader bufferedReader, List<LtMastFileTableMapping> mappingList, String requestName,
			int requestorId, String fileName) throws Exception 
	{
		StringBuffer finalQuery = new StringBuffer();
		
		int statusTableId;
		int retValue = 0;// rowCount = 0;
		BufferedReader br = bufferedReader;
		String line = "";

		
		String header;
		
			header = br.readLine();

			String[] headerArray = header.split("\\|", header.length() - 1);
			StringBuffer columnQuery = new StringBuffer();
			StringBuffer valueQuery = new StringBuffer();
			 
			String startQuery = "";
			String tableName = "";
			String sequenceName = "";

			
			String prefix = "";
			Map<Integer, String> mapColumn = new LinkedHashMap<>();
			
			Map<Integer, String> valueColumn = new LinkedHashMap<>();
			
			// set first id
			 columnQuery.append("(ID,");
			 
			 sequenceName =  mappingList.get(0).getSequenceName();
			 valueQuery.append(sequenceName + ".NEXTVAL, ");
			
			for (LtMastFileTableMapping fileTableMapping : mappingList) 
			{
				columnQuery.append(prefix);
				prefix = ", ";
				columnQuery.append(fileTableMapping.getTableColumnName());
				tableName =  fileTableMapping.getTableName();
				
				valueQuery= valueQuery.append(":"+fileTableMapping.getTableColumnName()+",");
				
				sequenceName = fileTableMapping.getSequenceName();

				if (mapColumn.containsKey(fileTableMapping.getColumnOrder()))
				{
					return -4; 
				}

				mapColumn.put(fileTableMapping.getColumnOrder(), fileTableMapping.getCsvColumnName());
				valueColumn.put(fileTableMapping.getColumnOrder(), fileTableMapping.getTableColumnName());
			}

			
			for (Map.Entry<Integer, String> entry : mapColumn.entrySet())
			{
				if (entry.getKey() > headerArray.length)
					return -3;
			}
			
			if (mapColumn.size() != headerArray.length) 
			{
				return -2;
			}
			
			boolean columnOrderStatus = true;

			for (int i = 0; i < headerArray.length; i++)
			{
				if (mapColumn.containsKey(i + 1)){
				 
					if (!headerArray[i].trim().equals(mapColumn.get(i + 1).trim())) {
						columnOrderStatus = false;
						break;
					}
				}
			}
		 
			if (columnOrderStatus == false) 
			{
				return -1;
			}

			// set foreign key request id
			columnQuery.append(",REQUEST_ID ");
			columnQuery.append(",CREATED_BY ");
			columnQuery.append(",CREATION_DATE ");//08-01-2018
			columnQuery.append(",LAST_UPDATE_LOGIN ");
			columnQuery.append(",LAST_UPDATED_BY ");
			columnQuery.append(",LAST_UPDATE_DATE ");
			//----------17/5/17-------------
			columnQuery.append(",RECORD_STATUS ");
			 
			columnQuery.append(",SOURCE");
			columnQuery.append(")");
			//--------------------------------------------------
			valueQuery.append(":REQUEST_ID,");
			valueQuery.append(":CREATED_BY,");
			valueQuery.append("SYSDATE,");
			valueQuery.append(":LAST_UPDATE_LOGIN,");
			valueQuery.append(":LAST_UPDATED_BY,");
			valueQuery.append("SYSDATE,");
			valueQuery.append(":RECORD_STATUS,");
			valueQuery.append(":SOURCE");
			
			
			startQuery = "insert into " + tableName + "";
			//StringBuffer finalQuery = new StringBuffer();
			
			startQuery=startQuery+" "+columnQuery;
			
			startQuery=startQuery+" VALUES( "+valueQuery+" )";
			
			sequenceName = sequenceName + ".NEXTVAL";
			//valueQuery.append(" VALUES(" + sequenceName + ",");
			
			///----------------call to insert entry into status table when fetching of record from file start--------------
			
			statusTableId = ltMastCsvFileUploadDao.saveStatusTable(tableName, requestName,requestorId,fileName);
		 
			finalQuery.append("UPDATE LT_MAST_SYS_REQUESTS set phase='Running', status='Inserting',"
					+ " LAST_UPDATE_DATE=SYSDATE WHERE REQUEST_ID = " + statusTableId + ";");
		 
			List<List<String>> batchValueList = new ArrayList<List<String>>();
			 
			while ((line = br.readLine()) != null) 
			{
			
				line =   stripXSS(line);
				List<String> rowList = new ArrayList<String>();
				String[] userDetails = line.split("\\|", line.length() - 1);
				 
				if (line != null && !line.isEmpty() && !line.trim().equals("") && !line.trim().equals("\n") ) { //&& userDetails.length > headerArray.length
					 
					 for (Map.Entry<Integer, String> entry : mapColumn.entrySet()){
						    if (userDetails[entry.getKey() - 1].isEmpty()){
						    	rowList.add(null);
							} else {
							    rowList.add(userDetails[entry.getKey() - 1]);
							}						 
					 }
					
					rowList.add(""+statusTableId);
					rowList.add(""+requestorId);
					rowList.add(""+requestorId);
					rowList.add(""+requestorId);
					
					rowList.add("New");
					rowList.add("EXCEL UPLOAD");
					 
					batchValueList.add(rowList);
					 
				}
				
			}
		 
			retValue =  ltMastCsvFileUploadDao.saveCSVFileData(startQuery, batchValueList, statusTableId );
			
		 
		return retValue;
	}
	
	private String stripXSS(String value) {
		String cleanValue = null;
		if (value != null) {
			cleanValue = Normalizer.normalize(value, Normalizer.Form.NFD);

			// Avoid null characters
			cleanValue = cleanValue.replaceAll("\0", "");

			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid anything in a src='...' type of expression
			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid expression(...) expressions
			scriptPattern = Pattern.compile("expression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
		}
		return cleanValue;
	}

	@Override
	public List<LtMastFileTableMapping> getDownloadFilePath(String requestName) throws Exception 
	{
		// TODO Auto-generated method stub
		return ltMastCsvFileUploadDao.getDownloadFilePath(requestName);
	}

}
