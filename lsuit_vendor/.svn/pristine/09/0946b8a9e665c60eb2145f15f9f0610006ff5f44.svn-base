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

import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class VendorApprovalSummaryThread extends Thread {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<LtVendorApprovalSummary> ltVendorApprovalData = null;
	String saveDirectory;
	
	public VendorApprovalSummaryThread(Long requestId, String saveDirectory, List<LtVendorApprovalSummary> ltVendorApprovalData,
			LtMastReportRequestRepository ltMastReportRequestRepository) {
		this.requestId = requestId;
		this.ltVendorApprovalData = ltVendorApprovalData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	public void run() 
    { 
		 String filepath = null;
        try
        { 
            if(ltVendorApprovalData!=null) {
             filepath = createExcel("VendorApprovalSummary",saveDirectory);
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
			if(reportName.equals("VendorApprovalSummary")) {
			if (ltVendorApprovalData != null && ltVendorApprovalData.size() > 0) {
				int rowIndex = 0;
				for (LtVendorApprovalSummary ltVendorApprovalSummary : ltVendorApprovalData) {
					++rowIndex;
					insertDetailsInfoForVendorApprovalReport(sheet, rowIndex, ltVendorApprovalSummary, workbook);
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

	private void insertDetailsInfoForVendorApprovalReport(Sheet sheet, int rowIndex,
			LtVendorApprovalSummary ltVendorApprovalSummary, Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltVendorApprovalSummary.getVendorCode() != null){ c.setCellValue(ltVendorApprovalSummary.getVendorCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltVendorApprovalSummary.getVendorName() != null){ c.setCellValue(ltVendorApprovalSummary.getVendorName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltVendorApprovalSummary.getStatus()!= null){ c.setCellValue(ltVendorApprovalSummary.getStatus()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltVendorApprovalSummary.getInitiatorName() != null){ c.setCellValue(ltVendorApprovalSummary.getInitiatorName()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltVendorApprovalSummary.getApproverName() != null){ c.setCellValue(ltVendorApprovalSummary.getApproverName()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltVendorApprovalSummary.getApprovalStatus() != null){ c.setCellValue(ltVendorApprovalSummary.getApprovalStatus()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style);if (ltVendorApprovalSummary.getApprovedDate()!= null){ c.setCellValue(simpleDateFormat.format(ltVendorApprovalSummary.getApprovedDate())); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltVendorApprovalSummary.getRemark()!= null){ c.setCellValue(ltVendorApprovalSummary.getRemark()); }
	}

	private void insertHeaderInfoForExcelReport(Sheet sheet, int rowIndex, Workbook workbook) {
		Row row = null;
        Cell c = null;
		 row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForHeader(workbook);
       
        c = row.createCell(0); row.getCell(0).setCellStyle(style); c.setCellValue("Vendor Code");
        c = row.createCell(1); row.getCell(1).setCellStyle(style); c.setCellValue("Vendor Name");
        c = row.createCell(2); row.getCell(2).setCellStyle(style); c.setCellValue("Status");
        c = row.createCell(3); row.getCell(3).setCellStyle(style); c.setCellValue("Initiator");
        c = row.createCell(4); row.getCell(4).setCellStyle(style); c.setCellValue("Approver Name");
        c = row.createCell(5); row.getCell(5).setCellStyle(style); c.setCellValue("Approval Status");
        c = row.createCell(6); row.getCell(6).setCellStyle(style); c.setCellValue("Dated");
        c = row.createCell(7); row.getCell(7).setCellStyle(style); c.setCellValue("Remark");
       
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
