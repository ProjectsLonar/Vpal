package com.lonar.vendor.vendorportal.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class EmployeeThread extends Thread{

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<String> colName = null;
	
	List<LtMastEmployees> employeeData = null;
	
	
	
	String saveDirectory;
	
	public EmployeeThread(Long requestId, List<String> colName, String saveDirectory,
			List<LtMastEmployees> employeeData,
		  LtMastReportRequestRepository ltMastReportRequestRepository
			) {
		this.requestId = requestId;
		this.colName=colName;
		this.employeeData = employeeData;
		
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	

	public void run() 
    { 
		 String filepath = null;
        try
        { 
            
            if(employeeData!=null) {
             filepath = createExcel(colName,"EmployeeSummary",saveDirectory);
             
            }
  
            makeEntryForReport(requestId,filepath,"Completed",saveDirectory);
        } 
        catch (Exception e) 
        { 
        	makeEntryForReport(requestId,filepath,"Failed",saveDirectory);
        	e.printStackTrace();
        } finally{
        	 
        	colName=null;
        }
    }
	
	
	private void makeEntryForReport(Long requestId2, String filepath, String status, String saveDirectory) 
	{
		LtMastReportRequest ltMastReportRequest = ltMastReportRequestRepository.findOne(requestId2);
		ltMastReportRequest.setCompletedDate(new Date());
		ltMastReportRequest.setFilePath(saveDirectory+filepath);
		ltMastReportRequest.setStatus(status);
		ltMastReportRequest.setFileName(filepath);
		ltMastReportRequest.setEndDate(new Date());
		ltMastReportRequestRepository.save(ltMastReportRequest);
	}



	private String createExcel(List<String> colName, String reportName, String saveDirectory) throws ServiceException, IOException {
	
		Workbook workbook = new SXSSFWorkbook();
		String fileName = null;
		//reportName=null;
		Date cdate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String dateReportCreatedBy = formatter.format(cdate);
		

		
			//reportName = "report";
			Sheet sheet = workbook.createSheet(reportName);
			
			File files = new File(saveDirectory);
			if (!files.exists()) {
				files.mkdirs();
			}
			
			insertHeaderInfoForExcelReport(sheet, 0, workbook,colName);
			colName.removeAll(colName);
			
			if(reportName.equals("EmployeeSummary")) {
			if (employeeData != null && employeeData.size() > 0) {
				int rowIndex = 0;
				for (LtMastEmployees ltMastEmployees : employeeData) {
					++rowIndex;
					insertDetailsInfoForEmployeeReport(sheet, rowIndex, ltMastEmployees, workbook);
				}
			}
			}
				fileName = reportName + "_" + dateReportCreatedBy + ".xlsx";
				String filePath = saveDirectory + fileName;
				
				FileOutputStream fileOut = new FileOutputStream(filePath);
				workbook.write(fileOut);
				fileOut.close();
				
				return fileName;
			
			
		}
	
	private void insertDetailsInfoForEmployeeReport(Sheet sheet, int rowIndex, LtMastEmployees ltMastEmployees,
			Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastEmployees.getTitleValue() != null){ c.setCellValue(ltMastEmployees.getTitleValue()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastEmployees.getFirstName() != null){ c.setCellValue(ltMastEmployees.getFirstName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastEmployees.getMiddleName() != null){ c.setCellValue(ltMastEmployees.getMiddleName()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltMastEmployees.getLastName() != null){ c.setCellValue(ltMastEmployees.getLastName()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltMastEmployees.getGenderValue() != null){ c.setCellValue(ltMastEmployees.getGenderValue()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltMastEmployees.getMaritalStatusValue() != null){ c.setCellValue(ltMastEmployees.getMaritalStatusValue()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style); if (ltMastEmployees.getDob() != null) { c.setCellValue(simpleDateFormat.format(ltMastEmployees.getDob())); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltMastEmployees.getPersonalEmail()!= null){ c.setCellValue(ltMastEmployees.getPersonalEmail()); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style);if (ltMastEmployees.getEmployeeNumber() != null){ c.setCellValue(ltMastEmployees.getEmployeeNumber()); }
        c = row.createCell(9);  row.getCell(9).setCellStyle(style);if (ltMastEmployees.getPersonTypeValue() != null){ c.setCellValue(ltMastEmployees.getPersonTypeValue()); }
        c = row.createCell(10);  row.getCell(10).setCellStyle(style);if (ltMastEmployees.getCompanyName() != null){ c.setCellValue(ltMastEmployees.getCompanyName()); }
      
        c = row.createCell(11);  row.getCell(11).setCellStyle(style);if (ltMastEmployees.getDeptName() != null){ c.setCellValue(ltMastEmployees.getDeptName()); }
        c = row.createCell(12);  row.getCell(12).setCellStyle(style);if (ltMastEmployees.getPositionValue() != null){ c.setCellValue(ltMastEmployees.getPositionValue()); }
        c = row.createCell(13);  row.getCell(13).setCellStyle(style);if (ltMastEmployees.getOfficialEmail() != null){ c.setCellValue(ltMastEmployees.getOfficialEmail()); }
      
        c = row.createCell(14);  row.getCell(14).setCellStyle(style);if (ltMastEmployees.getGradeTypeName() != null){ c.setCellValue(ltMastEmployees.getGradeTypeName()); }
        c = row.createCell(15);  row.getCell(15).setCellStyle(style);if (ltMastEmployees.getPanNo() != null){ c.setCellValue(ltMastEmployees.getPanNo()); }
        c = row.createCell(16);  row.getCell(16).setCellStyle(style);if (ltMastEmployees.getPassportNo() != null){ c.setCellValue(ltMastEmployees.getPassportNo()); }
      
        c = row.createCell(17);  row.getCell(17).setCellStyle(style);if (ltMastEmployees.getSupervisorEmpName()!= null){ c.setCellValue(ltMastEmployees.getSupervisorEmpName()); }
        c = row.createCell(18);  row.getCell(18).setCellStyle(style);if (ltMastEmployees.getLocationCode() != null){ c.setCellValue(ltMastEmployees.getLocationCode()); }
        c = row.createCell(19);  row.getCell(19).setCellStyle(style);if (ltMastEmployees.getCostCenterName() != null){ c.setCellValue(ltMastEmployees.getCostCenterName()); }
      
        c = row.createCell(20);  row.getCell(20).setCellStyle(style);if (ltMastEmployees.getDivisionName()!= null){ c.setCellValue(ltMastEmployees.getDivisionName()); }
        c = row.createCell(21);  row.getCell(21).setCellStyle(style);if (ltMastEmployees.getSubDivisionName() != null){ c.setCellValue(ltMastEmployees.getSubDivisionName()); }
        c = row.createCell(22);  row.getCell(22).setCellStyle(style);if (ltMastEmployees.getStatusValue()!= null){ c.setCellValue(ltMastEmployees.getStatusValue()); }
        
        c = row.createCell(23);  row.getCell(23).setCellStyle(style); if (ltMastEmployees.getStartDate() != null) { c.setCellValue(simpleDateFormat.format(ltMastEmployees.getStartDate())); }
        c = row.createCell(24);  row.getCell(24).setCellStyle(style); if (ltMastEmployees.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastEmployees.getEndDate())); }
      
        c = row.createCell(25);  row.getCell(25).setCellStyle(style);if (ltMastEmployees.getIsBuyer() != null){ c.setCellValue(ltMastEmployees.getIsBuyer()); }
       
	}

	

	private void insertHeaderInfoForExcelReport(Sheet sheet, int rowIndex, Workbook workbook, List<String> colName) {
		 Row row = null;
         Cell c = null;
         
         row = sheet.createRow(rowIndex);
         CellStyle style  = setCellStylesForHeader(workbook);
         for(int i = 0 ; i < colName.size() ; i++ ) {
         c = row.createCell(i); row.getCell(i).setCellStyle(style); c.setCellValue(colName.get(i));
         }
		
	}

	private CellStyle setCellStylesForData(Workbook wb) 
	{
		Font bold = wb.createFont();
		CellStyle style = wb.createCellStyle();

		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}
	
	private CellStyle setCellStylesForHeader(Workbook wb) 
	{
		Font bold = wb.createFont();
		bold.setBoldweight(Font.BOLDWEIGHT_BOLD);

		CellStyle style = wb.createCellStyle();

		style.setFont(bold);

		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return style;
	}

	
	
	
}
