package com.lonar.vendor.vendorportal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "LT_MAST_USER_LOCATION")
@JsonInclude(Include.NON_NULL)
public class LtMastUserLocation 
{
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_location_seq")
	@SequenceGenerator(name = "user_location_seq", sequenceName = "LT_MAST_USER_LOCATION_S", allocationSize = 1)
	@Column(name = "USER_LOCATION_ID")
	private Long userLocationId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "LOCATION_ID")
	private Long locationId;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "SUB_INVENTORY")
	private String subInventory;
	
	@Column(name = "LOCATOR_ID")
	private String locatorId;

	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_UPDATE_LOGIN")
	private Long lastUpdateLogin;

	@Column(name = "LAST_UPDATED_BY")
	private Long lastUpdatedBy;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Transient
	private String userName;
	
	@Transient
	private String locationName;
	
	@Transient
	private String locationCode;
	
	@Transient
	private String defaultSubInv;
	
	@Transient
	private String locatorCode;
	
	@Transient
	private String locatorDesc;
	
	@Transient
	private Long draw;

	@Transient
	private Long start;

	@Transient
	private Long length;

	@Transient
	private String stDate;
	@Transient
	private String enDate;
	@Transient
	private int columnNo;
	@Transient
	private String sort;
	public Long getUserLocationId() {
		return userLocationId;
	}
	public void setUserLocationId(Long userLocationId) {
		this.userLocationId = userLocationId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSubInventory() {
		return subInventory;
	}
	public void setSubInventory(String subInventory) {
		this.subInventory = subInventory;
	}
	public String getLocatorId() {
		return locatorId;
	}
	public void setLocatorId(String locatorId) {
		this.locatorId = locatorId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}
	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getDefaultSubInv() {
		return defaultSubInv;
	}
	public void setDefaultSubInv(String defaultSubInv) {
		this.defaultSubInv = defaultSubInv;
	}
	public String getLocatorCode() {
		return locatorCode;
	}
	public void setLocatorCode(String locatorCode) {
		this.locatorCode = locatorCode;
	}
	public String getLocatorDesc() {
		return locatorDesc;
	}
	public void setLocatorDesc(String locatorDesc) {
		this.locatorDesc = locatorDesc;
	}
	public Long getDraw() {
		return draw;
	}
	public void setDraw(Long draw) {
		this.draw = draw;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public String getStDate() {
		return stDate;
	}
	public void setStDate(String stDate) {
		this.stDate = stDate;
	}
	public String getEnDate() {
		return enDate;
	}
	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}
	public int getColumnNo() {
		return columnNo;
	}
	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "LtMastUserLocation [userLocationId=" + userLocationId + ", userId=" + userId + ", locationId="
				+ locationId + ", userType=" + userType + ", subInventory=" + subInventory + ", locatorId=" + locatorId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", userName=" + userName + ", locationName=" + locationName
				+ ", locationCode=" + locationCode + ", defaultSubInv=" + defaultSubInv + ", locatorCode=" + locatorCode
				+ ", locatorDesc=" + locatorDesc + ", draw=" + draw + ", start=" + start + ", length=" + length
				+ ", stDate=" + stDate + ", enDate=" + enDate + ", columnNo=" + columnNo + ", sort=" + sort + "]";
	}
	
	
	

}
