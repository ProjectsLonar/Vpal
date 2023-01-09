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

import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class VendorSummaryThread extends Thread{

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<LtMastVendors> ltMastVendorsData = null;
	String saveDirectory;
	
	public VendorSummaryThread(Long requestId,  String saveDirectory,
			List<LtMastVendors> ltMastVendorsData,
			 LtMastReportRequestRepository ltMastReportRequestRepository
			) {
		this.requestId = requestId;
		this.ltMastVendorsData = ltMastVendorsData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	

	public void run() 
    { 
		 String filepath = null;
        try
        { 
            if(ltMastVendorsData!=null) {
             filepath = createExcel("VendorSummaryReport",saveDirectory);
             
            }
  
            makeEntryForReport(requestId,filepath,"Completed",saveDirectory);
        } 
        catch (Exception e) 
        { 
        	makeEntryForReport(requestId,filepath,"Failed",saveDirectory);
        	e.printStackTrace();
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



	private String createExcel( String reportName, String saveDirectory) throws ServiceException, IOException {
	
		Workbook workbook = new SXSSFWorkbook();
		String fileName = null;
		Date cdate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String dateReportCreatedBy = formatter.format(cdate);
		
			Sheet sheet = workbook.createSheet(reportName);
			File files = new File(saveDirectory);
			if (!files.exists()) {
				files.mkdirs();
			}
			
			insertHeaderInfoForExcelReport(sheet, 0, workbook);
			
			
			if(reportName.equals("VendorSummaryReport")) {
			if (ltMastVendorsData != null && ltMastVendorsData.size() > 0) {
				int rowIndex = 0;
				for (LtMastVendors ltMastVendors : ltMastVendorsData) {
					++rowIndex;
					insertDetailsInfoForVendorSummaryReport(sheet, rowIndex, ltMastVendors, workbook);
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



	private void insertDetailsInfoForVendorSummaryReport(Sheet sheet, int rowIndex, LtMastVendors ltMastVendors,
			Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastVendors.getVendorCode() != null){ c.setCellValue(ltMastVendors.getVendorCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastVendors.getVendorName() != null){ c.setCellValue(ltMastVendors.getVendorName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastVendors.getPrimaryEmail()!= null){ c.setCellValue(ltMastVendors.getPrimaryEmail()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltMastVendors.getVendorType() != null){ c.setCellValue(ltMastVendors.getVendorType()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltMastVendors.getStatus() != null){ c.setCellValue(ltMastVendors.getStatus()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltMastVendors.getPanNo() != null){ c.setCellValue(ltMastVendors.getPanNo()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style);if (ltMastVendors.getInitiatorName() != null){ c.setCellValue(ltMastVendors.getInitiatorName()); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltMastVendors.getMsmRegisterationNo()!= null){ c.setCellValue(ltMastVendors.getMsmRegisterationNo()); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style);if (ltMastVendors.getDivisionName() != null){ c.setCellValue(ltMastVendors.getDivisionName()); }
        c = row.createCell(9);  row.getCell(9).setCellStyle(style);if (ltMastVendors.getCompanyCategory()!= null){ c.setCellValue(ltMastVendors.getCompanyCategory()); }
        c = row.createCell(10);  row.getCell(10).setCellStyle(style);if (ltMastVendors.getBusinessNature() != null){ c.setCellValue(ltMastVendors.getBusinessNature()); }
        c = row.createCell(11);  row.getCell(11).setCellStyle(style); if (ltMastVendors.getStartDate() != null) { c.setCellValue(simpleDateFormat.format(ltMastVendors.getStartDate())); }
        c = row.createCell(12);  row.getCell(12).setCellStyle(style); if (ltMastVendors.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastVendors.getEndDate())); }
       
		
	}



	private void insertHeaderInfoForExcelReport(Sheet sheet, int rowIndex, Workbook workbook) {
		 Row row = null;
         Cell c = null;
		 row = sheet.createRow(rowIndex);
         CellStyle style  = setCellStylesForHeader(workbook);
        
         c = row.createCell(0); row.getCell(0).setCellStyle(style); c.setCellValue("Vendor Code");
         c = row.createCell(1); row.getCell(1).setCellStyle(style); c.setCellValue("Vendor Name");
         c = row.createCell(2); row.getCell(2).setCellStyle(style); c.setCellValue("Primary Email");
         c = row.createCell(3); row.getCell(3).setCellStyle(style); c.setCellValue("Vendor Type");
         c = row.createCell(4); row.getCell(4).setCellStyle(style); c.setCellValue("Status");
         c = row.createCell(5); row.getCell(5).setCellStyle(style); c.setCellValue("PAN No");
         c = row.createCell(6); row.getCell(6).setCellStyle(style); c.setCellValue("Initiator");
         c = row.createCell(7); row.getCell(7).setCellStyle(style); c.setCellValue("MSME Reg No.");
         c = row.createCell(8); row.getCell(8).setCellStyle(style); c.setCellValue("Division");
         c = row.createCell(9); row.getCell(9).setCellStyle(style); c.setCellValue("Company Category");
         c = row.createCell(10); row.getCell(10).setCellStyle(style); c.setCellValue("Business Nature");
         c = row.createCell(11); row.getCell(11).setCellStyle(style); c.setCellValue("Start Date");
         c = row.createCell(12); row.getCell(12).setCellStyle(style); c.setCellValue("End Date");
         
        
		
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
