/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lonar.UserManagement.web.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LT_MAST_EMPLOYEES")
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class LtMastEmployees extends BaseClass {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId_seq")
	@SequenceGenerator(name = "employeeId_seq", sequenceName = "LT_MAST_EMPLOYEES_S", allocationSize = 1)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "EMPLOYEE_NUMBER")
	private String employeeNumber;

	@Size(max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "TITLE")
	private String title;

	@Size(max = 150)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(max = 150)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Size(max = 150)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "LAST_NAME")
	private String lastName;

	@Size(max = 150)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "OFFICIAL_EMAIL")
	private String officialEmail;

	@Size(max = 150)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "PERSONAL_EMAIL")
	private String personalEmail;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "GENDER")
	private String gender;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "PERSON_TYPE")
	private String personType;

	@Basic(optional = false)
	@NotNull
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "DOB")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Basic(optional = false)
	@Size(min = 1, max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "POSITION")
	private String position;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "GRADE")
	private String grade;

	@Size(max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "DEPT_ID")
	private String deptId;

	@Size(max = 20)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "PAN_NO")
	private String panNo;

	@Size(max = 30)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "PASSPORT_NO")
	private String passportNo;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "BRANCH_ID")
	private Long branchId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "SUPERVISOR_EMP_ID")
	private Long supervisorEmpId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COST_CENTER_ID")
	private Long costCenterId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "DIVISION_ID")
	private Long divisionId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "SUB_DIVISION_ID")
	private Long subDivisionId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "COMPANY_ID")
	private Long companyId;

	@JsonView(DataTablesOutput.View.class)
	@Column(name = "IMAGE_PATH")
	private String imagePath;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@JsonView(DataTablesOutput.View.class)
	@SafeHtml
	@Column(name = "STATUS")
	private String status;

	@Transient
	private String deptName;
	
	@Transient
	private String supervisorEmpName;

	@Transient
	private String locationCode;

	@Transient
	private String divisionName;

	@Transient
	private String costCenterName;

	@Transient
	private String locationName;

	@Transient
	private String empName;

	@Transient
	private String companyName;

	@Transient
	private String imageName;

	@Transient
	private String stDate;
	@Transient
	private String enDate;
 

	public LtMastEmployees() {
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public Date getDob() {
		return dob;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getSupervisorEmpId() {
		return supervisorEmpId;
	}

	public void setSupervisorEmpId(Long supervisorEmpId) {
		this.supervisorEmpId = supervisorEmpId;
	}

	public Long getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(Long costCenterId) {
		this.costCenterId = costCenterId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getSubDivisionId() {
		return subDivisionId;
	}

	public void setSubDivisionId(Long subDivisionId) {
		this.subDivisionId = subDivisionId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getStatus() {
		return status;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupervisorEmpName() {
		return supervisorEmpName;
	}

	public void setSupervisorEmpName(String supervisorEmpName) {
		this.supervisorEmpName = supervisorEmpName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

 
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
