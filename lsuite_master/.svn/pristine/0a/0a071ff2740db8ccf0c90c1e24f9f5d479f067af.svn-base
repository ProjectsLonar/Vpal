package com.lonar.vendor.vendorportal.additionalfields;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.BaseClass;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBillingAddresses;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Repository
@PropertySource(value = "classpath:queries/additionalFieldQueries.properties", ignoreResourceNotFound = true)
public class LtMastAdditionalFieldsDaoImpl implements LtMastAdditionalFieldsDao, CodeMaster {

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
    
	@Autowired
	LtMastAdditionalFieldsRepository additionalFieldsRepository;

	@Autowired
	LtMastAddFieldsColUsesRepository addFieldsColUsesRepository;

	@Override
	public LtMastAdditionalFields saveAdditionalFieldsDef(LtMastAdditionalFields additionalFields)
			throws ServiceException {
		return additionalFieldsRepository.save(additionalFields);
	}

	@Override
	public Long checkFieldDefinationNameAlreadyExits(LtMastAdditionalFields additionalFields) throws ServiceException {
		String query = env.getProperty("checkFieldDefinationNameAlreadyExits");

		String count = (String) getJdbcTemplate().queryForObject(query, new Object[] {
				additionalFields.getFieldDefinitionName().toUpperCase(), additionalFields.getColumnNo() },
				String.class);

		return Long.parseLong(count);
	}

	@Override
	public Long getAddFieldsDefiSummaryDataTableCount(Long companyId, LtMastAdditionalFields input)
			throws ServiceException {
		String query = env.getProperty("getAddFieldsDefiSummaryDataTableCount");

		String definitionNameStr = null;
		if (input.getFieldDefinitionName() != null) {
			definitionNameStr = "%" + input.getFieldDefinitionName().toUpperCase() + "%";
		}

		String titleStr = null;
		if (input.getTitle() != null) {
			titleStr = "%" + input.getTitle().toUpperCase() + "%";
		}

		String applicatinNameStr = null;
		if (input.getApplicationTableName() != null) {
			applicatinNameStr = "%" + input.getApplicationTableName().toUpperCase() + "%";
		}

		String count = (String) getJdbcTemplate().queryForObject(query,
				new Object[] { companyId, definitionNameStr, titleStr, applicatinNameStr }, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtMastAdditionalFields> getAddFieldsDefiSummaryDataTableData(Long companyId,
			LtMastAdditionalFields input) throws ServiceException {
		String query = env.getProperty("getAddFieldsDefiSummaryDataTableData");

		String definitionNameStr = null;
		if (input.getFieldDefinitionName() != null) {
			definitionNameStr = "%" + input.getFieldDefinitionName().toUpperCase() + "%";
		}

		String titleStr = null;
		if (input.getTitle() != null) {
			titleStr = "%" + input.getTitle().toUpperCase() + "%";
		}

		String applicatinNameStr = null;
		if (input.getApplicationTableName() != null) {
			applicatinNameStr = "%" + input.getApplicationTableName().toUpperCase() + "%";
		}

		List<LtMastAdditionalFields> list = (List<LtMastAdditionalFields>) jdbcTemplate.query(query,
				new Object[] { companyId, definitionNameStr, titleStr, applicatinNameStr, input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getStart() + input.getLength(), input.getStart() + 1 },
				new BeanPropertyRowMapper<LtMastAdditionalFields>(LtMastAdditionalFields.class));
		return list;
	}

	@Override
	public Long getAddFieldsDataTableCount(Long fieldDefId, LtMastAddFieldsColUses input) throws ServiceException {
		String query = env.getProperty("getAddFieldsDataTableCount");

		String coloumnSeqStr = null;
		if (input.getAppColumnSeqNoStr() != null) {
			coloumnSeqStr = "%" + input.getAppColumnSeqNoStr() + "%";
		}

		String categoryNameStr = null;
		if (input.getAppCategoryName() != null) {
			categoryNameStr = "%" + input.getAppCategoryName().toUpperCase() + "%";
		}

		String columnNameStr = null;
		if (input.getAppColumnName() != null) {
			columnNameStr = "%" + input.getAppColumnName().toUpperCase() + "%";
		}
		
		String endUserColumnNameStr = null;
		if (input.getEndUserColumnName() != null) {
			endUserColumnNameStr = "%" + input.getEndUserColumnName().toUpperCase() + "%";
		}

		String enableStr = null;
		if (input.getEnabledFlag() != null) {
			enableStr = "%" + input.getEnabledFlag().toUpperCase() + "%";
		}
		String requiredStr = null;
		if (input.getRequiredFlag() != null) {
			requiredStr = "%" + input.getRequiredFlag().toUpperCase() + "%";
		}
		String displayStr = null;
		if (input.getDisplayFlag() != null) {
			displayStr = "%" + input.getDisplayFlag().toUpperCase() + "%";
		}
		
		String displaySize = null;
		if (input.getDisplaySizeStr() != null) {
			 displaySize = "%" + input.getDisplaySizeStr() + "%";
		}
		
		String count = (String) getJdbcTemplate().queryForObject(query,
				new Object[] { fieldDefId, coloumnSeqStr ,categoryNameStr,columnNameStr, endUserColumnNameStr, enableStr, requiredStr, displayStr, displaySize

		}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtMastAddFieldsColUses> getAddFieldsDataTableData(Long fieldDefId, LtMastAddFieldsColUses input)
			throws ServiceException {
		String query = env.getProperty("getAddFieldsDataTableData");

		String coloumnSeqStr = null;
		if (input.getAppColumnSeqNoStr() != null) {
			coloumnSeqStr = "%" + input.getAppColumnSeqNoStr() + "%";
		}

		String categoryNameStr = null;
		if (input.getAppCategoryName() != null) {
			categoryNameStr = "%" + input.getAppCategoryName().toUpperCase() + "%";
		}

		String columnNameStr = null;
		if (input.getAppColumnName() != null) {
			columnNameStr = "%" + input.getAppColumnName().toUpperCase() + "%";
		}
		
		String endUserColumnNameStr = null;
		if (input.getEndUserColumnName() != null) {
			endUserColumnNameStr = "%" + input.getEndUserColumnName().toUpperCase() + "%";
		}

		String enableStr = null;
		if (input.getEnabledFlag() != null) {
			enableStr = "%" + input.getEnabledFlag().toUpperCase() + "%";
		}
		String requiredStr = null;
		if (input.getRequiredFlag() != null) {
			requiredStr = "%" + input.getRequiredFlag().toUpperCase() + "%";
		}
		String displayStr = null;
		if (input.getDisplayFlag() != null) {
			displayStr = "%" + input.getDisplayFlag().toUpperCase() + "%";
		}
		
		String displaySize = null;
		if (input.getDisplaySizeStr() != null) {
			 displaySize = "%" + input.getDisplaySizeStr() + "%";
		}
		
		List<LtMastAddFieldsColUses> list = (List<LtMastAddFieldsColUses>) jdbcTemplate.query(query,
				new Object[] { fieldDefId, coloumnSeqStr ,categoryNameStr,columnNameStr, endUserColumnNameStr, enableStr, requiredStr, displayStr, displaySize,
						input.getColumnNo(),input.getColumnNo(), 
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),
						input.getStart() + input.getLength(), input.getStart() + 1 },
				new BeanPropertyRowMapper<LtMastAddFieldsColUses>(LtMastAddFieldsColUses.class));
		return list;
	}

	@Override
	public List<String> getTableName(String tablename) throws ServiceException {
		String query = env.getProperty("getTableName");
		String tablenameStr = null;
		if (tablename != null) {
			tablenameStr = "%" + tablename.toUpperCase() + "%";
		}
		
		List<String> list = jdbcTemplate.queryForList(query, String.class, tablenameStr);
		return list;
	}

	@Override
	public List<String> getColumnNameByTableName(String tablename) throws ServiceException {
		String query = env.getProperty("getColumnNameByTableName");
		String tablenameStr = null;
		if (tablename != null) {
			tablenameStr = "%" + tablename.toUpperCase() + "%";
		}
		List<String> list = jdbcTemplate.queryForList(query, String.class, tablenameStr);
		return list;
	}

	@Override
	public List<LtMastAddFieldsColUses> getAddFieldDetailsByTableName(String tableName,Long companyId) throws ServiceException {
		String query = env.getProperty("getAddFieldDetailsByTableName");
		
		String tablenameStr = null;
		if (tableName != null) {
			tablenameStr = "%" + tableName.toUpperCase() + "%";
		}
		
		List<LtMastAddFieldsColUses> list = (List<LtMastAddFieldsColUses>) jdbcTemplate.query(query,
				new Object[] { tablenameStr,companyId },
				new BeanPropertyRowMapper<LtMastAddFieldsColUses>(LtMastAddFieldsColUses.class));
		return list;
	}

	@Override
	public ResponseEntity<Status> saveAditionalfieldDataToDB(Long id,  BaseClass input)
			throws ServiceException {
System.out.println("input "+input);
		/*String tableAndRepoName = env.getProperty(tableName);
		
		String[] tableRepoList = tableAndRepoName.split(",");

		String repositoryName = tableRepoList [0];
		String tableNameStr = tableRepoList [1];
		
		try {
			Class<?> tableCls = Class.forName(tableNameStr);
			Class<?> repoCls = Class.forName(repositoryName);
			
			
			Object repoClassObj = (Object) repoCls.newInstance();
			//repoClassObj.save
			
			SimpleJpaRepository<tableCls, Serializable> jpaRepository;
			//jpaRepository = new SimpleJpaRepository<tableCls, Serializable>( tableCls.class, entityManager);
			
			
			
			jpaRepository.save(tableCls);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Object clsInstance = (Object) cls.newInstance();
*/		
		//String query = 	"delete from LT_INVOICE_ATTACHMENT where INVOICE_ATTACHMENT_ID = ?";
		
		String tableAndRepoName = env.getProperty(input.getMasterName());
		
		String[] tableRepoList = tableAndRepoName.split(",");

		String primaryKey = tableRepoList [0];
		System.out.println("primaryKey "+primaryKey);
		String tableNameStr = tableRepoList [1];
		String query = "update "+input.getMasterName()+" Set ADDITIONAL_FIELD_1 = ? ,ADDITIONAL_FIELD_2 = ?,ADDITIONAL_FIELD_3 = ?,"
				+ " ADDITIONAL_FIELD_4 = ? ,ADDITIONAL_FIELD_5 = ? ,ADDITIONAL_FIELD_6 = ?, ADDITIONAL_FIELD_7 = ?, ADDITIONAL_FIELD_8 = ?,"
				+ "ADDITIONAL_FIELD_9 = ? ,ADDITIONAL_FIELD_10 = ? ,ADDITIONAL_FIELD_11 = ?, ADDITIONAL_FIELD_12 = ?,ADDITIONAL_FIELD_13 = ?, "
				+ " ADDITIONAL_FIELD_14 = ? ,ADDITIONAL_FIELD_15 = ? WHERE "+primaryKey +" = ?";
		int res= 0;
		res= jdbcTemplate.update(query,input.getAdditionalField1(),input.getAdditionalField2(),input.getAdditionalField3(),input.getAdditionalField4(),
				input.getAdditionalField5(),input.getAdditionalField6(),input.getAdditionalField7(),input.getAdditionalField8(),
				input.getAdditionalField9(),input.getAdditionalField10(),input.getAdditionalField11(),input.getAdditionalField12(),
				input.getAdditionalField13(),input.getAdditionalField14(),input.getAdditionalField15(),id);
		System.out.println("rs "+res);
		if(res!=0) {
			Status status = new Status();
			status.setCode(SUCCESS);
			status.setMessage("inserted successfully");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		else {
			Status status = new Status();
			status.setCode(FAIL);
			status.setMessage("inserted fail");
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
			
	}

	@Override
	public BaseClass getAdditionalFieldById(Long id, String masterName) throws ServiceException {
		String tableAndRepoName = env.getProperty(masterName);
		
		String[] tableRepoList = tableAndRepoName.split(",");
		String primaryKey = tableRepoList [0];
		
		String query = "SELECT ADDITIONAL_FIELD_1,ADDITIONAL_FIELD_2,ADDITIONAL_FIELD_3,ADDITIONAL_FIELD_4,ADDITIONAL_FIELD_5,ADDITIONAL_FIELD_6,\r\n" + 
				"ADDITIONAL_FIELD_7,ADDITIONAL_FIELD_8,ADDITIONAL_FIELD_9,ADDITIONAL_FIELD_10,ADDITIONAL_FIELD_11,ADDITIONAL_FIELD_12,\r\n" + 
				"ADDITIONAL_FIELD_13,ADDITIONAL_FIELD_14,ADDITIONAL_FIELD_15 FROM "+masterName+" WHERE "+primaryKey +" = ? ";
		
		List<BaseClass> list =jdbcTemplate.query(query,  new Object[] {  id} , 
				new RowMapper<BaseClass>() {

					@Override
					public BaseClass mapRow(ResultSet rs, int arg1) throws SQLException {
						BaseClass baseClass = new BaseClass();
						baseClass.setAdditionalField1(rs.getString("ADDITIONAL_FIELD_1"));
						baseClass.setAdditionalField2(rs.getString("ADDITIONAL_FIELD_2"));
						baseClass.setAdditionalField3(rs.getString("ADDITIONAL_FIELD_3"));
						baseClass.setAdditionalField4(rs.getString("ADDITIONAL_FIELD_4"));
						baseClass.setAdditionalField5(rs.getString("ADDITIONAL_FIELD_5"));
						baseClass.setAdditionalField6(rs.getString("ADDITIONAL_FIELD_6"));
						baseClass.setAdditionalField7(rs.getString("ADDITIONAL_FIELD_7"));
						baseClass.setAdditionalField8(rs.getString("ADDITIONAL_FIELD_8"));
						baseClass.setAdditionalField9(rs.getString("ADDITIONAL_FIELD_9"));
						baseClass.setAdditionalField10(rs.getString("ADDITIONAL_FIELD_10"));
						baseClass.setAdditionalField11(rs.getString("ADDITIONAL_FIELD_10"));
						baseClass.setAdditionalField12(rs.getString("ADDITIONAL_FIELD_12"));
						baseClass.setAdditionalField13(rs.getString("ADDITIONAL_FIELD_13"));
						baseClass.setAdditionalField14(rs.getString("ADDITIONAL_FIELD_14"));
						baseClass.setAdditionalField15(rs.getString("ADDITIONAL_FIELD_15"));
						
						return baseClass;
					}
		});
		return list.get(0);
	}

	@Override
	public List<String> getColumnNameByFieldId(String fieldDefId) throws ServiceException {
		String query = env.getProperty("getColumnNameByFieldId");
		
		List<String> list = jdbcTemplate.queryForList(query, String.class, fieldDefId);
		return list;
	}
}

/*SimpleJpaRepository<User, Serializable> jpaRepository;
jpaRepository = new SimpleJpaRepository<User, Serializable>( User.class, entityManager);
	//With SimpleJpaRepository, I can use all repository methods.

jpaRepository.save(user);
*/
