package com.lonar.vendor.vendorportal.dashboard;

import java.util.List;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource(value = "classpath:queries/dashboardQuery.properties", ignoreResourceNotFound = true)
public class LtMastDashboardDaoImpl implements LtMastDashboardDao {

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LtMastDashboardModel> getDashboardYearSummaryByBuyer(Long comapnyId) throws SerialException {

		String query = env.getProperty("dashboardYearSummaryByBuyer");

		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getDashboardYearSummaryByVender(Long comapnyId) throws SerialException {
		String query = env.getProperty("dashboardYearSummaryByVendor");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getDashboardMonthlySummaryByBuyer(Long comapnyId) throws SerialException {
		String query = env.getProperty("dashboardMonthSummaryByBuyer");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getDashboardMonthlySummaryByVender(Long comapnyId) throws SerialException {
		String query = env.getProperty("dashboardMonthSummaryByVendor");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderYearVendor(Long comapnyId) throws SerialException {
		String query = env.getProperty("");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderYearBuyer(Long comapnyId) throws SerialException {
		String query = env.getProperty("dasboardPOMonthByBuyer");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderMonthVendor(Long comapnyId) throws SerialException {
		String query = env.getProperty("dasboardPOMonthByVendor");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPurachaseOrderMonthBuyer(Long comapnyId) throws SerialException {
		String query = env.getProperty("dasboardPOMonthByBuyer");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));

		return list;
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncome(Long comapnyId) throws SerialException {
		String query = env.getProperty("dashboardTotalIncome");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

	@Override
	public List<LtMastDashboardModel> getTotalExpense(Long comapnyId) throws SerialException {
		String query = env.getProperty("dashboardTotalExpenses");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPOInvoiveYearBuyer(Long comapnyId) throws SerialException {
		String query = env.getProperty("poInvoiveYearBuyer");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { comapnyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

	@Override
	public List<LtMastDashboardModel> getPOInvoiveYearVendor(Long companyId) throws SerialException {
		String query = env.getProperty("poInvoiveYearVendor");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { companyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncomeExpenseBuyer(Long companyId) throws SerialException {
		String query = env.getProperty("totalIncomeExpenseBuyer");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { companyId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

	@Override
	public List<LtMastDashboardModel> getTotalIncomeExpenseVendor(Long vendorId) throws SerialException {
		String query = env.getProperty("totalIncomeExpenseVendor");
		List<LtMastDashboardModel> list = jdbcTemplate.query(query, new Object[] { vendorId },
				new BeanPropertyRowMapper<LtMastDashboardModel>(LtMastDashboardModel.class));
		return list;
	}

}
