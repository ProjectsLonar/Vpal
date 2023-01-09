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

import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class CostCenterThread extends Thread{

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<String> colName = null;
	List<LtMastCostCenters> costCenterData = null;
	
	
	String saveDirectory;
	
	public CostCenterThread(Long requestId, List<String> colName, String saveDirectory,
			List<LtMastCostCenters> costCenterData,
			 LtMastReportRequestRepository ltMastReportRequestRepository
			) {
		this.requestId = requestId;
		this.colName=colName;
		this.costCenterData = costCenterData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	

	public void run() 
    { 
		 String filepath = null;
        try
        { 
            if(costCenterData!=null) {
             filepath = createExcel(colName,"CostCenterSummary",saveDirectory);
             
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
			
			if(reportName.equals("CostCenterSummary")) {
			if (costCenterData != null && costCenterData.size() > 0) {
				int rowIndex = 0;
				for (LtMastCostCenters ltMastCostCenters : costCenterData) {
					++rowIndex;
					insertDetailsInfoForCostCenterReport(sheet, rowIndex, ltMastCostCenters, workbook);
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
