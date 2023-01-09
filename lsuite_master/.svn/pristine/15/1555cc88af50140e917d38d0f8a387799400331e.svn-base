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

import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;


public class MultiThread extends Thread{

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<String> colName = null;
	List<LtMastBranches> branchData = null;
	
	
	String saveDirectory;
	
	public MultiThread(Long requestId, List<String> colName, String saveDirectory,
			List<LtMastBranches> branchData,  LtMastReportRequestRepository ltMastReportRequestRepository
			) {
		this.requestId = requestId;
		this.colName=colName;
		this.branchData = branchData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	

	public void run() 
    { 
		 String filepath = null;
        try
        { 
           if(branchData!=null) {
            	 filepath = createExcel(colName,"LocationSummary",saveDirectory);
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
			
			if(reportName.equals("LocationSummary")) {
				if (branchData != null && branchData.size() > 0) {
					int rowIndex = 0;
					for (LtMastBranches ltMastBranches : branchData) {
						++rowIndex;
						insertDetailsInfoForBranchReport(sheet, rowIndex, ltMastBranches, workbook);
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
	
	private void insertDetailsInfoForBranchReport(Sheet sheet, int rowIndex, LtMastBranches ltMastBranches,
			Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastBranches.getBranchCode() != null){ c.setCellValue(ltMastBranches.getBranchCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastBranches.getBranchName() != null){ c.setCellValue(ltMastBranches.getBranchName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastBranches.getCity() != null){ c.setCellValue(ltMastBranches.getCity()); }
        c = row.createCell(3);  row.getCell(2).setCellStyle(style);if (ltMastBranches.getRegion() != null){ c.setCellValue(ltMastBranches.getRegion()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltMastBranches.getStateName() != null){ c.setCellValue(ltMastBranches.getStateName()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltMastBranches.getCountryValue() != null){ c.setCellValue(ltMastBranches.getCountryValue()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style); if (ltMastBranches.getOpeningDate() != null) { c.setCellValue(simpleDateFormat.format(ltMastBranches.getOpeningDate())); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltMastBranches.getManagerName() != null){ c.setCellValue(ltMastBranches.getManagerName()); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style);if (ltMastBranches.getStateCode() != null){ c.setCellValue(ltMastBranches.getStateCode()); }
        c = row.createCell(9);  row.getCell(9).setCellStyle(style);if (ltMastBranches.getGstRegNo() != null){ c.setCellValue(ltMastBranches.getGstRegNo()); }
        c = row.createCell(10);  row.getCell(10).setCellStyle(style);if (ltMastBranches.getBranchTypeValue()!= null){ c.setCellValue(ltMastBranches.getBranchTypeValue()); }
        c = row.createCell(11);  row.getCell(11).setCellStyle(style); if (ltMastBranches.getStartDate() != null) { c.setCellValue(simpleDateFormat.format(ltMastBranches.getStartDate())); }
        c = row.createCell(12);  row.getCell(12).setCellStyle(style); if (ltMastBranches.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastBranches.getEndDate())); }
        c = row.createCell(13);  row.getCell(13).setCellStyle(style);if (ltMastBranches.getStatusValue() != null){ c.setCellValue(ltMastBranches.getStatusValue()); }
        c = row.createCell(14);  row.getCell(14).setCellStyle(style);if (ltMastBranches.getCompanyName() != null){ c.setCellValue(ltMastBranches.getCompanyName()); }
        c = row.createCell(15);  row.getCell(15).setCellStyle(style);if (ltMastBranches.getBillableLocation()!= null){ c.setCellValue(ltMastBranches.getBillableLocation()); }
        c = row.createCell(16);  row.getCell(16).setCellStyle(style);if (ltMastBranches.getShippingLocation()!= null){ c.setCellValue(ltMastBranches.getShippingLocation()); }
	}

	private void insertDetailsInfoForCostCenterReport(Sheet sheet, int rowIndex, LtMastCostCenters ltMastCostCenters,
			Workbook workbook) {
		
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastCostCenters.getCostCenterCode() != null){ c.setCellValue(ltMastCostCenters.getCostCenterCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastCostCenters.getCostCenterName() != null){ c.setCellValue(ltMastCostCenters.getCostCenterName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastCostCenters.getStatus() != null){ c.setCellValue(ltMastCostCenters.getStatus()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style); if (ltMastCostCenters.getStartDate() != null) { c.setCellValue(simpleDateFormat.format(ltMastCostCenters.getStartDate())); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style); if (ltMastCostCenters.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastCostCenters.getEndDate())); }
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

	public float sendData(List<Object> colName2, List<Object> excelData2) {
		return downcast(colName2,excelData2);
	}
	
	public  <newClass> float downcast(Object obj1,Object obj2) {
		
		newClass header = (newClass) obj1;
		
			
		newClass data = (newClass) obj2;
		
		return 0;
	
	}
	
}
