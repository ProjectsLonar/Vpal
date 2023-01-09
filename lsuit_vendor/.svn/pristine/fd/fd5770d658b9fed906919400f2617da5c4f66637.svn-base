package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastVendorClients;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value = "classpath:queries/vendorClients.properties", ignoreResourceNotFound = true)
public class LtMastVendorClientsDaoImpl implements LtMastVendorClientsDao {

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LtMastVendorClients> getAllVendorClients() throws ServiceException {

		String query = env.getProperty("getAllVendorClients");

		// String query = " SELECT * FROM LT_MAST_VENDOR_CLIENTS v ";

		List<LtMastVendorClients> ltMastVendorClientsList = jdbcTemplate.query(query, new Object[] {},

				new RowMapper<LtMastVendorClients>() {
					public LtMastVendorClients mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorClients ltMastVendorClients = new LtMastVendorClients();

						ltMastVendorClients.setVendorClientsId(rs.getLong("VENDOR_CLIENTS_ID"));
						ltMastVendorClients.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorClients.setClientName(rs.getString("CLIENT_NAME"));

						ltMastVendorClients.setClientAddress(rs.getString("CLIENT_ADDRESS"));
						ltMastVendorClients.setClientContactPerson(rs.getString("CLIENT_CONTACT_PERSON"));
						ltMastVendorClients.setClientContactDesg(rs.getString("CLIENT_CONTACT_DESG"));
						ltMastVendorClients.setClientContactNo(rs.getString("CLIENT_CONTACT_NO"));
						ltMastVendorClients.setContactEmail(rs.getString("CONTACT_EMAIL"));
						ltMastVendorClients.setProductSupplied(rs.getString("PRODUCT_SUPPLIED"));
						ltMastVendorClients.setValueSupplies(rs.getString("VALUE_SUPPLIES"));

						ltMastVendorClients.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorClients.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorClients.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorClients.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorClients.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorClients;
					}
				});

		return ltMastVendorClientsList;
	}

	@Override
	public List<LtMastVendorClients> getVendorClientsByVendorId(Long vendorId) throws ServiceException {

		String query = env.getProperty("getVendorClientsByVendorId");

		List<LtMastVendorClients> ltMastVendorClientsList = jdbcTemplate.query(query, new Object[] { vendorId },
				new RowMapper<LtMastVendorClients>() {
					public LtMastVendorClients mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorClients ltMastVendorClients = new LtMastVendorClients();

						ltMastVendorClients.setVendorClientsId(rs.getLong("VENDOR_CLIENTS_ID"));
						ltMastVendorClients.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorClients.setClientName(rs.getString("CLIENT_NAME"));

						ltMastVendorClients.setClientAddress(rs.getString("CLIENT_ADDRESS"));
						ltMastVendorClients.setClientContactPerson(rs.getString("CLIENT_CONTACT_PERSON"));
						ltMastVendorClients.setClientContactDesg(rs.getString("CLIENT_CONTACT_DESG"));
						ltMastVendorClients.setClientContactNo(rs.getString("CLIENT_CONTACT_NO"));
						ltMastVendorClients.setContactEmail(rs.getString("CONTACT_EMAIL"));
						ltMastVendorClients.setProductSupplied(rs.getString("PRODUCT_SUPPLIED"));
						ltMastVendorClients.setValueSupplies(rs.getString("VALUE_SUPPLIES"));

						ltMastVendorClients.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorClients.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorClients.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorClients.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorClients.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorClients;

					}
				});
		return ltMastVendorClientsList;

	}

	@Override
	public LtMastVendorClients getVendorClientsById(Long vendorClientsId) throws ServiceException {

		String query = env.getProperty("getByIdVendorClients");

		List<LtMastVendorClients> ltMastVendorClientsList = jdbcTemplate.query(query, new Object[] { vendorClientsId },
				new RowMapper<LtMastVendorClients>() {
					public LtMastVendorClients mapRow(ResultSet rs, int arg1) throws SQLException {

						LtMastVendorClients ltMastVendorClients = new LtMastVendorClients();

						ltMastVendorClients.setVendorClientsId(rs.getLong("VENDOR_CLIENTS_ID"));
						ltMastVendorClients.setVendorId(rs.getLong("VENDOR_ID"));
						ltMastVendorClients.setClientName(rs.getString("CLIENT_NAME"));

						ltMastVendorClients.setClientAddress(rs.getString("CLIENT_ADDRESS"));
						ltMastVendorClients.setClientContactPerson(rs.getString("CLIENT_CONTACT_PERSON"));
						ltMastVendorClients.setClientContactDesg(rs.getString("CLIENT_CONTACT_DESG"));
						ltMastVendorClients.setClientContactNo(rs.getString("CLIENT_CONTACT_NO"));
						ltMastVendorClients.setContactEmail(rs.getString("CONTACT_EMAIL"));
						ltMastVendorClients.setProductSupplied(rs.getString("PRODUCT_SUPPLIED"));
						ltMastVendorClients.setValueSupplies(rs.getString("VALUE_SUPPLIES"));

						ltMastVendorClients.setCreatedBy(rs.getInt("CREATED_BY"));
						ltMastVendorClients.setCreationDate(rs.getDate("CREATION_DATE"));
						ltMastVendorClients.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
						ltMastVendorClients.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
						ltMastVendorClients.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));

						return ltMastVendorClients;

					}
				});
		return ltMastVendorClientsList.get(0);

	}

	@Override
	public boolean save(LtMastVendorClients ltMastVendorClients) throws ServiceException {
		String query = env.getProperty("saveVendorClients");

		int res = jdbcTemplate.update(query, ltMastVendorClients.getVendorId(), ltMastVendorClients.getClientName(),
				ltMastVendorClients.getClientAddress(), ltMastVendorClients.getClientContactPerson(),
				ltMastVendorClients.getClientContactDesg(), ltMastVendorClients.getClientContactNo(),
				ltMastVendorClients.getContactEmail(), ltMastVendorClients.getProductSupplied(),
				ltMastVendorClients.getValueSupplies(),

				ltMastVendorClients.getCreatedBy(), ltMastVendorClients.getCreationDate(),
				ltMastVendorClients.getLastUpdateLogin(), ltMastVendorClients.getLastUpdatedBy(),
				ltMastVendorClients.getLastUpdateDate());

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(LtMastVendorClients ltMastVendorClients) throws ServiceException {
		String query = env.getProperty("updateVendorClients");
		int res = jdbcTemplate.update(query, ltMastVendorClients.getVendorId(), ltMastVendorClients.getClientName(),
				ltMastVendorClients.getClientAddress(), ltMastVendorClients.getClientContactPerson(),
				ltMastVendorClients.getClientContactDesg(), ltMastVendorClients.getClientContactNo(),
				ltMastVendorClients.getContactEmail(), ltMastVendorClients.getProductSupplied(),
				ltMastVendorClients.getValueSupplies(),

				ltMastVendorClients.getCreatedBy(), ltMastVendorClients.getCreationDate(),
				ltMastVendorClients.getLastUpdateLogin(), ltMastVendorClients.getLastUpdatedBy(),
				ltMastVendorClients.getLastUpdateDate(),

				ltMastVendorClients.getVendorClientsId());

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Long vendorClientsId) throws ServiceException {
		String query = env.getProperty("deleteVendorClients");

		int res = jdbcTemplate.update(query, vendorClientsId);

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteByVendorId(Long vendorId) throws ServiceException {

		String query = env.getProperty("deleteByVendorIdVendorClients");

		int res = jdbcTemplate.update(/* " DELETE FROM LT_MAST_VENDOR_CLIENTS WHERE VENDOR_ID = ? " */
				query, vendorId);

		if (res == 1)
			return true;
		else
			return false;
	}

	@Override
	public Long getVendorClientsByVendorIdDataTableCount(Long vendorId, LtMastVendorClients input)
			throws ServiceException {
		String query = env.getProperty("getVendorClientsByVendorIdDataTableCount");

		String clientName = null;
		if (input.getClientName() != null && !input.getClientName().equals("")) {
			clientName = "%" + input.getClientName().trim().toUpperCase() + "%";
		}

		String addr = null;
		if (input.getClientAddress() != null && !input.getClientAddress().equals("")) {
			addr = "%" + input.getClientAddress().trim().toUpperCase() + "%";
		}

		String contactPerson = null;
		if (input.getClientContactPerson() != null && !input.getClientContactPerson().equals("")) {
			contactPerson = "%" + input.getClientContactPerson().trim().toUpperCase() + "%";
		}

		String designationStr = null;
		if (input.getClientContactDesg() != null && !input.getClientContactDesg().equals("")) {
			designationStr = "%" + input.getClientContactDesg().trim().trim().toUpperCase() + "%";
		}

		String contactNumStr = null;
		if (input.getClientContactNo() != null && !input.getClientContactNo().equals("")) {
			contactNumStr = "%" + input.getClientContactNo().trim().trim().toUpperCase() + "%";
		}

		String emailStr = null;
		if (input.getContactEmail() != null && !input.getContactEmail().equals("")) {
			emailStr = "%" + input.getContactEmail().trim().trim().toUpperCase() + "%";
		}

		String productSuppliedStr = null;
		if (input.getProductSupplied() != null && !input.getProductSupplied().equals("")) {
			productSuppliedStr = "%" + input.getProductSupplied().trim().trim().toUpperCase() + "%";
		}

		String valueOfSuppliedStr = null;
		if (input.getValueSupplies() != null && !input.getValueSupplies().equals("")) {
			valueOfSuppliedStr = "%" + input.getValueSupplies().trim().trim().toUpperCase() + "%";
		}

		/*System.out.println("clientName :: " + clientName + " addr :: " + addr + " contactPerson :: " + contactPerson
				+ "\n" + " designationStr :: " + designationStr + " contactNumStr :: " + contactNumStr + " emailStr :: "
				+ emailStr + "\n" + " productSuppliedStr :: " + productSuppliedStr + " valueOfSuppliedStr :: "
				+ valueOfSuppliedStr);*/

		String count = jdbcTemplate.queryForObject(query, new Object[] { vendorId, clientName, addr, contactPerson,
				designationStr, contactNumStr, emailStr, productSuppliedStr, valueOfSuppliedStr }, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtMastVendorClients> getVendorClientsByVendorIdDataTable(Long vendorId, LtMastVendorClients input)
			throws ServiceException {
		String query = env.getProperty("getVendorClientsByVendorIdDataTable");

		String clientName = null;
		if (input.getClientName() != null && !input.getClientName().equals("")) {
			clientName = "%" + input.getClientName().trim().toUpperCase() + "%";
		}

		String addr = null;
		if (input.getClientAddress() != null && !input.getClientAddress().equals("")) {
			addr = "%" + input.getClientAddress().trim().toUpperCase() + "%";
		}

		String contactPerson = null;
		if (input.getClientContactPerson() != null && !input.getClientContactPerson().equals("")) {
			contactPerson = "%" + input.getClientContactPerson().trim().toUpperCase() + "%";
		}

		String designationStr = null;
		if (input.getClientContactDesg() != null && !input.getClientContactDesg().equals("")) {
			designationStr = "%" + input.getClientContactDesg().trim().trim().toUpperCase() + "%";
		}

		String contactNumStr = null;
		if (input.getClientContactNo() != null && !input.getClientContactNo().equals("")) {
			contactNumStr = "%" + input.getClientContactNo().trim().trim().toUpperCase() + "%";
		}

		String emailStr = null;
		if (input.getContactEmail() != null && !input.getContactEmail().equals("")) {
			emailStr = "%" + input.getContactEmail().trim().trim().toUpperCase() + "%";
		}

		String productSuppliedStr = null;
		if (input.getProductSupplied() != null && !input.getProductSupplied().equals("")) {
			productSuppliedStr = "%" + input.getProductSupplied().trim().trim().toUpperCase() + "%";
		}

		String valueOfSuppliedStr = null;
		if (input.getValueSupplies() != null && !input.getValueSupplies().equals("")) {
			valueOfSuppliedStr = "%" + input.getValueSupplies().trim().trim().toUpperCase() + "%";
		}

		List<LtMastVendorClients> list = (List<LtMastVendorClients>) jdbcTemplate.query(query, new Object[] { vendorId,
				clientName, addr, contactPerson, designationStr, contactNumStr, emailStr, productSuppliedStr,
				valueOfSuppliedStr, input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
				input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
				input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
				input.getColumnNo(), input.getColumnNo(), input.getStart() + input.getLength(), input.getStart() + 1 },
				new BeanPropertyRowMapper<LtMastVendorClients>(LtMastVendorClients.class));
		return list;
	}

}
