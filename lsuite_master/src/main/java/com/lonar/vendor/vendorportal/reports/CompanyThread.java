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

import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class CompanyThread extends Thread{

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<String> colName = null;
	List<LtVendCompany> companyData = null;
	
	
	String saveDirectory;
	
	public CompanyThread(Long requestId, List<String> colName, String saveDirectory, List<LtVendCompany> companyData,
			LtMastReportRequestRepository ltMastReportRequestRepository) {
		this.requestId = requestId;
		this.colName=colName;
		this.companyData = companyData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	

	public void run() 
    { 
		 String filepath = null;
        try
        { 
            if(companyData!=null) {
             filepath = createExcel(colName,"COMPANY",saveDirectory);
             
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
		Date cdate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String dateReportCreatedBy = formatter.format(cdate);
		
			Sheet sheet = workbook.createSheet(reportName);
			File files = new File(saveDirectory);
			if (!files.exists()) {
				files.mkdirs();
			}
			
			insertHeaderInfoForExcelReport(sheet, 0, workbook,colName);
			colName.removeAll(colName);
			
			
			if (companyData != null && companyData.size() > 0) {
				int rowIndex = 0;
				for (LtVendCompany ltVendCompany : companyData) {
					++rowIndex;
					insertDetailsInfoForCompanyReport(sheet, rowIndex, ltVendCompany, workbook);
				}
			}
			
				fileName = reportName + "_" + dateReportCreatedBy + ".xlsx";
				String filePath = saveDirectory + fileName;
				
				FileOutputStream fileOut = new FileOutputStream(filePath);
				workbook.write(fileOut);
				fileOut.close();
				return fileName;
			
			
		}
	
	

	private void insertDetailsInfoForCompanyReport(Sheet sheet, int rowIndex, LtVendCompany ltVendCompany,
			Workbook workbook) {
		
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltVendCompany.getCompanyName() != null){ c.setCellValue(ltVendCompany.getCompanyName()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltVendCompany.getRegdAddress() != null){ c.setCellValue(ltVendCompany.getRegdAddress()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltVendCompany.getCity() != null){ c.setCellValue(ltVendCompany.getCity()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltVendCompany.getStateValue() != null){ c.setCellValue(ltVendCompany.getStateValue()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltVendCompany.getPinCode() != null){ c.setCellValue(ltVendCompany.getPinCode()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltVendCompany.getOrgId() != null){ c.setCellValue(ltVendCompany.getOrgId()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style);if (ltVendCompany.getStatusValue() != null){ c.setCellValue(ltVendCompany.getStatusValue()); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style); if (ltVendCompany.getStartDate() != null) { c.setCellValue(simpleDateFormat.format(ltVendCompany.getStartDate())); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style); if (ltVendCompany.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltVendCompany.getEndDate())); }
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
