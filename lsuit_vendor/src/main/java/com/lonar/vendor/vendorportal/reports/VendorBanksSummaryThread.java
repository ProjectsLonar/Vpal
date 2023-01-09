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

import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class VendorBanksSummaryThread extends Thread{

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<LtMastVendorBanks> ltMastVendorBanksData = null;
	String saveDirectory;
	
	public VendorBanksSummaryThread(Long requestId, String saveDirectory, List<LtMastVendorBanks> ltMastVendorBanksData,
			LtMastReportRequestRepository ltMastReportRequestRepository) {
		this.requestId = requestId;
		this.ltMastVendorBanksData = ltMastVendorBanksData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	public void run() 
    { 
		 String filepath = null;
        try
        { 
            if(ltMastVendorBanksData!=null) {
             filepath = createExcel("VendorBankReport",saveDirectory);
            }
            makeEntryForReport(requestId,filepath,"Completed",saveDirectory);
        } 
        catch (Exception e) 
        { 
        	makeEntryForReport(requestId,filepath,"Failed",saveDirectory);
        	e.printStackTrace();
        } 
    }

	private void makeEntryForReport(Long requestId2, String filepath, String status, String saveDirectory2) {
		LtMastReportRequest ltMastReportRequest = ltMastReportRequestRepository.findOne(requestId2);
		ltMastReportRequest.setCompletedDate(new Date());
		ltMastReportRequest.setFilePath(saveDirectory+filepath);
		ltMastReportRequest.setStatus(status);
		ltMastReportRequest.setFileName(filepath);
		ltMastReportRequest.setEndDate(new Date());
		ltMastReportRequestRepository.save(ltMastReportRequest);
	}

	private String createExcel(String reportName, String saveDirectory2) throws IOException {
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
			
			
			if(reportName.equals("VendorBankReport")) {
			if (ltMastVendorBanksData != null && ltMastVendorBanksData.size() > 0) {
				int rowIndex = 0;
				for (LtMastVendorBanks ltMastVendorBanks : ltMastVendorBanksData) {
					++rowIndex;
					insertDetailsInfoForVendorBankReport(sheet, rowIndex, ltMastVendorBanks, workbook);
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

	
	private void insertDetailsInfoForVendorBankReport(Sheet sheet, int rowIndex, LtMastVendorBanks ltMastVendorBanks,
			Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastVendorBanks.getVendorCode() != null){ c.setCellValue(ltMastVendorBanks.getVendorCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastVendorBanks.getVendorName() != null){ c.setCellValue(ltMastVendorBanks.getVendorName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastVendorBanks.getVendorStatus()!= null){ c.setCellValue(ltMastVendorBanks.getVendorStatus()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltMastVendorBanks.getAddressCode() != null){ c.setCellValue(ltMastVendorBanks.getAddressCode()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltMastVendorBanks.getAddress() != null){ c.setCellValue(ltMastVendorBanks.getAddress()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltMastVendorBanks.getCity() != null){ c.setCellValue(ltMastVendorBanks.getCity()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style);if (ltMastVendorBanks.getState()!= null){ c.setCellValue(ltMastVendorBanks.getState()); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltMastVendorBanks.getBankName()!= null){ c.setCellValue(ltMastVendorBanks.getBankName()); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style);if (ltMastVendorBanks.getBankBranch()!= null){ c.setCellValue(ltMastVendorBanks.getBankBranch()); }
        c = row.createCell(9);  row.getCell(9).setCellStyle(style);if (ltMastVendorBanks.getIfscCode()!= null){ c.setCellValue(ltMastVendorBanks.getIfscCode()); }
        c = row.createCell(10);  row.getCell(10).setCellStyle(style);if (ltMastVendorBanks.getBranchAddress() != null){ c.setCellValue(ltMastVendorBanks.getBranchAddress()); }
        c = row.createCell(11);  row.getCell(11).setCellStyle(style); if (ltMastVendorBanks.getBankAccountNo() != null) { c.setCellValue(ltMastVendorBanks.getBankAccountNo());  }
        c = row.createCell(12);  row.getCell(12).setCellStyle(style); if (ltMastVendorBanks.getMicrNo()!= null) {c.setCellValue(ltMastVendorBanks.getMicrNo()); }
        c = row.createCell(13);  row.getCell(13).setCellStyle(style); if (ltMastVendorBanks.getAccountType()!= null) { c.setCellValue(ltMastVendorBanks.getAccountType()); }
        c = row.createCell(14);  row.getCell(14).setCellStyle(style); if (ltMastVendorBanks.getStartDate()!= null) {  c.setCellValue(simpleDateFormat.format(ltMastVendorBanks.getStartDate()));  }
        c = row.createCell(15);  row.getCell(15).setCellStyle(style); if (ltMastVendorBanks.getEndDate()!= null) {  c.setCellValue(simpleDateFormat.format(ltMastVendorBanks.getEndDate()));  }
       
	}


	

	private void insertHeaderInfoForExcelReport(Sheet sheet, int rowIndex, Workbook workbook) {
		Row row = null;
        Cell c = null;
		 row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForHeader(workbook);
       
        c = row.createCell(0); row.getCell(0).setCellStyle(style); c.setCellValue("Vendor Code");
        c = row.createCell(1); row.getCell(1).setCellStyle(style); c.setCellValue("Vendor Name");
        c = row.createCell(2); row.getCell(2).setCellStyle(style); c.setCellValue("Vendor Status");
        c = row.createCell(3); row.getCell(3).setCellStyle(style); c.setCellValue("Address Code");
        c = row.createCell(4); row.getCell(4).setCellStyle(style); c.setCellValue("Address");
        c = row.createCell(5); row.getCell(5).setCellStyle(style); c.setCellValue("City");
        c = row.createCell(6); row.getCell(6).setCellStyle(style); c.setCellValue("State");
        c = row.createCell(7); row.getCell(7).setCellStyle(style); c.setCellValue("Bank Name");
        c = row.createCell(8); row.getCell(8).setCellStyle(style); c.setCellValue("Bank Branch");
        c = row.createCell(9); row.getCell(9).setCellStyle(style); c.setCellValue("IFSC Code");
        c = row.createCell(10); row.getCell(10).setCellStyle(style); c.setCellValue("Bank Address");
        c = row.createCell(11); row.getCell(11).setCellStyle(style); c.setCellValue("Account Number");
        c = row.createCell(12); row.getCell(12).setCellStyle(style); c.setCellValue("MICR No");
        c = row.createCell(13); row.getCell(13).setCellStyle(style); c.setCellValue("Account Type");
        c = row.createCell(14); row.getCell(14).setCellStyle(style); c.setCellValue("Start Date");
        c = row.createCell(15); row.getCell(15).setCellStyle(style); c.setCellValue("End Date");
    
		
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
