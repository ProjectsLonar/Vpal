package com.lonar.vendor.vendorportal.csvupload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LtMastCsvFileUploadDaoImpl  implements LtMastCsvFileUploadDao
{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LtMastFileTableMapping> getMappingTableDetails(String requestName) throws Exception {
		 String sqlQuery = " select * from LT_MAST_FILE_TAB_COL_MAP  "
		 		+ " where trim(UPLOAD_NAME) = ? "
		 		+ " order by CSV_COLUMN_ORDER asc ";
			
		 List<LtMastFileTableMapping> fileTableMappings =  jdbcTemplate.query(sqlQuery, new Object[]{ requestName.trim() }, 
				 new RowMapper<LtMastFileTableMapping>() {
					
			 			public LtMastFileTableMapping mapRow(ResultSet rs, int row) throws SQLException {
			 				LtMastFileTableMapping fileTableMapping = new LtMastFileTableMapping();
							
							fileTableMapping.setMapId(rs.getInt("MAPPING_ID"));
							fileTableMapping.setCvsFileName(rs.getString("UPLOAD_NAME"));
							fileTableMapping.setTableName(rs.getString("STG_TABLE_NAME"));
							fileTableMapping.setCsvColumnName(rs.getString("CSV_COLUMN_NAME"));
							fileTableMapping.setTableColumnName(rs.getString("STG_COLUMN_NAME"));
							fileTableMapping.setColumnOrder(rs.getInt("CSV_COLUMN_ORDER"));
							fileTableMapping.setSequenceName(rs.getString("SEQUENCE_NAME"));
							
							return fileTableMapping;
						}
					} );
		
		return fileTableMappings; 
	}

	@Override
	public int saveStatusTable(String tableName, String requestName, int requestorId, String fileName)
			throws Exception 
	{
		int statusTableId = 0;
	  	 
	  	String sqlCount="select LT_MAST_SYS_REQUESTS_S.nextval from dual";
	  	statusTableId = jdbcTemplate.queryForObject(sqlCount, Integer.class);
		String str="select to_char(sysdate, 'DDMMRRRRHH24MISS') from dual ";
		String time = jdbcTemplate.queryForObject(str, String.class);
		String[] arr = fileName.split("\\.");
		
		if(arr.length>0) {
			fileName=arr[0]+ time.toString()+"."+ arr[1];
		}
	
		//TODO change query
		String getRequestorName = "select user_name from lt_mast_users where user_id="+requestorId+" ";
		
		String name = jdbcTemplate.queryForObject(getRequestorName, String.class);

		String inserStatusQuery = "insert into lt_mast_sys_requests (request_id, request_name, requestor_name, status, requestor_id, stg_tab_name, actual_start_date,"
				+ " actual_end_date, file_name, LAST_UPDATE_DATE, LAST_UPDATED_BY, CREATION_DATE, CREATED_BY, LAST_UPDATE_LOGIN ) "  
			+ "values (? , ?, ?, 'Start', ?, ? , SYSDATE , SYSDATE , ?, SYSDATE, ?, SYSDATE, ?, ?  )";
	
		jdbcTemplate.update(inserStatusQuery, statusTableId, requestName, name, requestorId, tableName, fileName, requestorId, requestorId, requestorId );
	 
	 
	return statusTableId;
	}

	@Override
	public int saveCSVFileData(String query, List<List<String>> batchValueList, int statusTableId)
			throws Exception {
		int retValue = 0;
		try {
			    int rowCount = batchValueList.size();
				
				BatchPreparedStatementSetter statementSetter =  new BatchPreparedStatementSetter(){
					@Override
					public int getBatchSize() {
						return batchValueList.size();
					}
		
					@Override
					public void setValues(PreparedStatement ps, int index) throws SQLException {
						List<String> row = batchValueList.get(index);
						int colNo = 1;
						for(String data : row){
							ps.setString(colNo, data);
							++colNo;
						}
					}
				};
		
			int[] arr = jdbcTemplate.batchUpdate(query, statementSetter);
			
			String insertQuery = "";
			if ((arr.length ) == rowCount)  {
				insertQuery = " update lt_mast_sys_requests "
						+ " set phase='Running',status='File Uploaded',actual_end_date = sysdate "
						+ " where request_id = ?";
			     
				retValue = 1;	
			} 
			else {
				insertQuery =  " update lt_mast_sys_requests set phase='Completed',status='Error',actual_end_date=sysdate "
						+ " where request_id = ? ";
				 
				retValue = 0;
			}
			
			jdbcTemplate.update(insertQuery, statusTableId );
			
		} catch (Exception e) {
			String insertQuery =  "update lt_mast_sys_requests set phase='Completed',status='Error',actual_end_date=sysdate where request_id = ? ";
			jdbcTemplate.update(insertQuery, statusTableId );
			retValue = 0;
			throw new Exception(e);
			//e.printStackTrace();
		}
		return retValue;
	}

	@Override
	public List<LtMastFileTableMapping> getDownloadFilePath(String requestName) throws Exception {
		 String sqlQuery = " select * from LT_MAST_FILE_TAB_COL_MAP  "
			 		+ " where trim(UPLOAD_NAME) = ? ";
				
			 List<LtMastFileTableMapping> fileTableMappings =  jdbcTemplate.query(sqlQuery, new Object[]{ requestName }, 
					 new RowMapper<LtMastFileTableMapping>() {
						
				 			public LtMastFileTableMapping mapRow(ResultSet rs, int row) throws SQLException {
				 				LtMastFileTableMapping fileTableMapping = new LtMastFileTableMapping();
							
								fileTableMapping.setCsvFileFormat(rs.getString("CSV_FILE_FORMAT"));
								
								return fileTableMapping;
							}
						} );
			
		
			return fileTableMappings; 
	}
	

}
