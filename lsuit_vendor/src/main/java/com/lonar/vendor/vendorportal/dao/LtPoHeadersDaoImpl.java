package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtPoHeaders;
import com.lonar.vendor.vendorportal.model.LtPoLineReport;
import com.lonar.vendor.vendorportal.model.LtPoReport;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/poHeaderQueries.properties", ignoreResourceNotFound = true)
public class LtPoHeadersDaoImpl implements LtPoHeadersDao {

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
	public Long getLtPoHeaderCount(LtPoHeaders input,Long companyId) throws ServiceException {
		String query = env.getProperty("getLtPoHeaderCount");

		String typeLookupCode = null;
		if (input.getPoType() != null && !input.getPoType().equals("")) {
			typeLookupCode = "%" + input.getPoType().trim().toUpperCase() + "%";
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String revNumber = null;
		if (input.getRevisionNum() != null) {
			revNumber = "%" + input.getRevisionNum() + "%";
		}

		if (input.getpDate() == null || input.getpDate().trim().equals("")) {
			input.setpDate(null);
		}
		/*
		 * if(input.getRevDate() == null || input.getRevDate().trim().equals("")) {
		 * input.setRevDate(null); }
		 */

		String stat = null;
		if (input.getStatus() != null && !input.getStatus().equals("")) {
			stat = "%" + input.getStatus().trim().trim().toUpperCase() + "%";
		}

		String pAmount = null;
		if (input.getPoAmount() != null) {
			pAmount = "%" + Double.valueOf(input.getPoAmount()).intValue() + "%";
		}

		String code = null;
		if (input.getCurrencyCode() != null && !input.getCurrencyCode().equals("")) {
			code = "%" + input.getCurrencyCode().trim().toUpperCase() + "%";
		}

		String agnt = null;
		if (input.getAgent() != null && !input.getAgent().equals("")) {
			agnt = "%" + input.getAgent().trim().toUpperCase() + "%";
		}
		
		String aFlag = null;
		if (input.getAckFlag() != null && !input.getAckFlag().equals("")) {
			aFlag = "%" + input.getAckFlag().trim().toUpperCase() + "%";
		}

		String count = (String) getJdbcTemplate().queryForObject(query,
				new Object[] {companyId, typeLookupCode, poNumber, revNumber, input.getpDate(), stat, pAmount, agnt, code,aFlag },
				String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtPoHeaders> getLtPoHeaderDataTable(LtPoHeaders input,Long companyId) throws ServiceException {
		String query = env.getProperty("getLtPoHeaderDataTable");

		String typeLookupCode = null;
		if (input.getPoType() != null && !input.getPoType().equals("")) {
			typeLookupCode = "%" + input.getPoType().trim().toUpperCase() + "%";
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String revNumber = null;
		if (input.getRevisionNum() != null) {
			revNumber = "%" + input.getRevisionNum() + "%";
		}

		if (input.getpDate() == null || input.getpDate().trim().equals("")) {
			input.setpDate(null);
		}

		/*
		 * if(input.getRevDate() == null || input.getRevDate().trim().equals("")) {
		 * input.setRevDate(null); }
		 */

		String stat = null;
		if (input.getStatus() != null && !input.getStatus().equals("")) {
			stat = "%" + input.getStatus().trim().trim().toUpperCase() + "%";
		}

		String pAmount = null;
		if (input.getPoAmount() != null) {
			pAmount = "%" + Double.valueOf(input.getPoAmount()).intValue() + "%";
		}

		String code = null;
		if (input.getCurrencyCode() != null && !input.getCurrencyCode().equals("")) {
			code = "%" + input.getCurrencyCode().trim().toUpperCase() + "%";
		}

		String agnt = null;
		if (input.getAgent() != null && !input.getAgent().equals("")) {
			agnt = "%" + input.getAgent().trim().toUpperCase() + "%";
		}

		String aFlag = null;
		if (input.getAckFlag() != null && !input.getAckFlag().equals("")) {
			aFlag = "%" + input.getAckFlag().trim().toUpperCase() + "%";
		}

		if (input.getColumnNo() == 0) {
			input.setColumnNo(9);
		}

		List<LtPoHeaders> list = (List<LtPoHeaders>) jdbcTemplate.query(query,
				new Object[] {companyId, typeLookupCode, poNumber, revNumber, input.getpDate(), stat, pAmount, agnt, code, aFlag,

						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),

						input.getStart() + input.getLength(), input.getStart()+1 },
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));
		return list;
	}

	@Override
	public List<LtPoHeaders> getAllPoHeaders() throws ServiceException {
		String query = env.getProperty("getAllPoHeaders");
		List<LtPoHeaders> list = jdbcTemplate.query(query, new Object[] {},
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));

		return list;
	}

	@Override
	public List<LtPoHeaders> getAllActivePoHeaders() throws ServiceException {
		String query = env.getProperty("getAllActivePoHeaders");
		List<LtPoHeaders> list = jdbcTemplate.query(query, new Object[] {},
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));
		return list;
	}

	@Override
	public LtPoHeaders getPoHeaderById(Long poHeaderId) throws ServiceException {
		String query = env.getProperty("getPoHeaderById");
		List<LtPoHeaders> list = jdbcTemplate.query(query, new Object[] { poHeaderId },
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));

		if (!list.isEmpty())
			return list.get(0);
		else
			return null;
	}

	@Override
	public Long getLtPoHeaderCountByVendorId(LtPoHeaders input, Long venId) throws ServiceException {
		String query = env.getProperty("getLtPoHeaderCountByVendorId");

		String typeLookupCode = null;
		if (input.getPoType() != null && !input.getPoType().equals("")) {
			typeLookupCode = "%" + input.getPoType().trim().toUpperCase() + "%";
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String revNumber = null;
		if (input.getRevisionNum() != null) {
			revNumber = "%" + input.getRevisionNum() + "%";
		}

		if (input.getpDate() == null || input.getpDate().trim().equals("")) {
			input.setpDate(null);
		}
		/*
		 * if(input.getRevDate() == null || input.getRevDate().trim().equals("")) {
		 * input.setRevDate(null); }
		 */

		String stat = null;
		if (input.getStatus() != null && !input.getStatus().equals("")) {
			stat = "%" + input.getStatus().trim().trim().toUpperCase() + "%";
		}

		String pAmount = null;
		if (input.getPoAmount() != null) {
			pAmount = "%" + Double.valueOf(input.getPoAmount()).intValue() + "%";
		}

		String code = null;
		if (input.getCurrencyCode() != null && !input.getCurrencyCode().equals("")) {
			code = "%" + input.getCurrencyCode().trim().toUpperCase() + "%";
		}

		String agnt = null;
		if (input.getAgent() != null && !input.getAgent().equals("")) {
			agnt = "%" + input.getAgent().trim().toUpperCase() + "%";
		}

		String count = (String) getJdbcTemplate().queryForObject(query, new Object[] { venId, typeLookupCode, poNumber,
				revNumber, input.getpDate(), stat, pAmount, agnt, code }, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtPoHeaders> getLtPoHeadersDataTableByVendorId(LtPoHeaders input, Long venId) throws ServiceException {
		String query = env.getProperty("getLtPoHeadersDataTableByVendorId");

		String typeLookupCode = null;
		if (input.getPoType() != null && !input.getPoType().equals("")) {
			typeLookupCode = "%" + input.getPoType().trim().toUpperCase() + "%";
		}

		String poNumber = null;
		if (input.getPoNumber() != null && !input.getPoNumber().equals("")) {
			poNumber = "%" + input.getPoNumber().trim().toUpperCase() + "%";
		}

		String revNumber = null;
		if (input.getRevisionNum() != null) {
			revNumber = "%" + input.getRevisionNum() + "%";
		}

		if (input.getpDate() == null || input.getpDate().trim().equals("")) {
			input.setpDate(null);
		}
		/*
		 * if(input.getRevDate() == null || input.getRevDate().trim().equals("")) {
		 * input.setRevDate(null); }
		 */

		String stat = null;
		if (input.getStatus() != null && !input.getStatus().equals("")) {
			stat = "%" + input.getStatus().trim().trim().toUpperCase() + "%";
		}

		String pAmount = null;
		if (input.getPoAmount() != null) {
			pAmount = "%" + Double.valueOf(input.getPoAmount()).intValue() + "%";
		}

		String code = null;
		if (input.getCurrencyCode() != null && !input.getCurrencyCode().equals("")) {
			code = "%" + input.getCurrencyCode().trim().toUpperCase() + "%";
		}

		String agnt = null;
		if (input.getAgent() != null && !input.getAgent().equals("")) {
			agnt = "%" + input.getAgent().trim().toUpperCase() + "%";
		}

		if (input.getColumnNo() == 0) {
			input.setColumnNo(1);
		}

		List<LtPoHeaders> list = (List<LtPoHeaders>) jdbcTemplate.query(query,
				new Object[] { venId, typeLookupCode, poNumber, revNumber, input.getpDate(), stat, pAmount, agnt, code,

						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(), input.getColumnNo(), input.getColumnNo(),
						input.getColumnNo(), input.getColumnNo(),input.getColumnNo(), input.getColumnNo(),

						input.getStart() + input.getLength(), input.getStart()+1 },
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));
		return list;
	}

	@Override
	public DashboardDetails getAmountByVendorId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getAmountByVendorId");
		List<DashboardDetails> list = jdbcTemplate.query(query, new Object[] { vendorId },
				new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		if (!list.isEmpty())
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getCountAndStatusByVendorId");
		List<DashboardDetails> list = jdbcTemplate.query(query, new Object[] { vendorId },
				new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));

		return list;

	}

	@Override
	public List<LtPoHeaders> getTopFivePoById(Long vendorId) throws ServiceException {
		String query = env.getProperty("getTopFivePoById");
		List<LtPoHeaders> list = jdbcTemplate.query(query, new Object[] { vendorId },
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));

		return list;
	}

	@Override
	public List<DashboardDetails> getStatusCountByBuyerId(Long buyerId, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountAndStatusByBuyerId");
		if (buyerId == 0) {
			buyerId = null;
		}
		List<DashboardDetails> list = jdbcTemplate.query(query, new Object[] { buyerId, companyId },
				new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));

		return list;
	}

	@Override
	public List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException {
		String query = env.getProperty("getVendorMesaageByBuyerId");

		List<VendorBuyerDetails> list = jdbcTemplate.query(query, new Object[] { buyerId },
				new BeanPropertyRowMapper<VendorBuyerDetails>(VendorBuyerDetails.class));
		return list;

	}

	@Override
	public List<DashboardDetails> getQtrStatusCountByBuyerId(Long buyerId, Long year) throws ServiceException {
		String query = env.getProperty("getQtrCountAndStatusByBuyerIdANdYearWise");
		List<DashboardDetails> list = jdbcTemplate.query(query, new Object[] { buyerId, year },
				new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		return list;
	}

	@Override
	public boolean acknowldge(LtPoHeaders ltPoHeaders) throws ServiceException {
		String query = env.getProperty("acknowldgeLtPoHeaders");
		int res = jdbcTemplate.update(query,
				new Object[] { ltPoHeaders.getAckFlag(), ltPoHeaders.getAckMsg(), ltPoHeaders.getPoHeaderId() });
		if (res != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtPoHeaders> getActivePoHeadersByPoNumber(Long companyId, Long userId, String poNumber)
			throws ServiceException {
		String query = env.getProperty("getActivePoHeadersByPoNumber");
		List<LtPoHeaders> list = jdbcTemplate.query(query, new Object[] { "%" + poNumber + "%", companyId, userId },
				new BeanPropertyRowMapper<LtPoHeaders>(LtPoHeaders.class));

		return list;
	}

	@Override
	public List<LtPoReport> createPOPDFReport(Long poHeaderId,Long companyId) {
		String query = env.getProperty("ltPOReportQueryByPONumberAndCompanyId");
		 
		//List<LtPoReport> poReportList = jdbcTemplate.query(query, new Object[] { poHeaderId}, 
		//		new BeanPropertyRowMapper<LtPoReport>(LtPoReport.class));
		//========================================================================
		List<LtPoReport> poReportList = (ArrayList<LtPoReport>)jdbcTemplate.query(
				query, new Object[] { poHeaderId }, new LtPoReportRowMapper());
		
		//========================================================================
		return poReportList;
	}

	 
	 
}
class LtPoReportRowMapper implements RowMapper<LtPoReport>
{
	List<LtPoLineReport> lineReportList=new ArrayList<>();
	LtPoReport poReport = new LtPoReport();
	public LtPoReport mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		poReport.setPoNumber(rs.getString("order_number"));
		poReport.setRevisionNum(rs.getString("revision"));
		poReport.setPoDate(rs.getTimestamp("po_date"));
		poReport.setRevisionDate(rs.getTimestamp("rev_date")); 
		poReport.setVendorName(rs.getString("v_name"));
		poReport.setVendorAddress(rs.getString("ven_add"));
		poReport.setPurchasingContact(rs.getString("buyer"));
		
		poReport.setEmail(rs.getString("email"));
		poReport.setTelephone(rs.getString("telephone"));
		poReport.setFax(rs.getString("fax"));
		poReport.setAuthorizedBy(rs.getString("auth_by"));
		poReport.setShipTo(rs.getString("ship_to"));
		poReport.setBillTo(rs.getString("bill_to"));
		poReport.setGstinShip(rs.getString("gstinst"));
		poReport.setGstinBill(rs.getString("gstinbt"));
		poReport.setPaymentTerms(rs.getString("payment_terms"));
		poReport.setPaymentMethod(rs.getString("payment_method"));
		poReport.setCurrencyCode(rs.getString("currency"));
		poReport.setFreightTerms(rs.getString("freight_terms"));
		poReport.setIncotermsFOB(rs.getString("fob"));
		poReport.setCarrier(rs.getString("carriers"));
		
		
	 
		poReport.setPdfPath("");
		poReport.setReportCompanyLogoPath("");
		poReport.setReportGeneratedPath("");
		//poReport.setTotalTaxAmount(rs.getString("total_taxes"));
		//poReport.setTotalLineTax(rs.getString("amount"));
		poReport.setTotalAmount(rs.getString("total_amount"));
		//poReport.setTotal(rs.getInt("count"));
		poReport.setCompanyName(rs.getString("company_name"));
		
		LtPoLineReport poLineReport=new LtPoLineReport();
		poLineReport.setLineNum(rs.getString("line_no"));
		poLineReport.setShipmentNum(rs.getString("ship_num"));
		poLineReport.setItem(rs.getString("item"));
		poLineReport.setItemDescription(rs.getString("item_desc"));
		poLineReport.setDeliveryDate(rs.getTimestamp("delivery"));
		poLineReport.setQuantity(rs.getString("quantity"));
		poLineReport.setUOM(rs.getString("uom"));
		poLineReport.setUnitPrice(rs.getString("unit_price"));
		poLineReport.setSubAmount(rs.getString("sub_amount"));
		poLineReport.setLineNoOne(rs.getString("linec"));
		poLineReport.setTaxNameAndDescriptionCGST(rs.getString("tax_name_and_descc"));
		poLineReport.setTaxAmountCGST(rs.getString("ratec"));
		poLineReport.setLineNoTwo(rs.getString("LINES"));
		poLineReport.setTaxNameAndDescriptionSGST(rs.getString("tax_name_and_descs"));
		poLineReport.setTaxAmountSGST(rs.getString("rates"));
		poLineReport.setRateCGST(rs.getString("taxc"));
		poLineReport.setRateSGST(rs.getString("taxs"));
		poLineReport.setTotalTaxAmount(rs.getString("total_taxes"));
		poLineReport.setTotalLineTax(rs.getString("amount"));
		
		lineReportList.add(poLineReport);
		
		
		
		poReport.setLineReportList(lineReportList);
		
		return poReport;
	}
}
