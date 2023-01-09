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

import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

public class VendorAddressSummaryThread extends Thread{

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	Long requestId = null;
	LtMastReportRequestRepository ltMastReportRequestRepository;
	LtMastSysVariablesService ltMastSysVariablesService;
	List<LtMastVendorAddress> ltMastVendorAddressData = null;
	String saveDirectory;
	
	public VendorAddressSummaryThread(Long requestId, String saveDirectory, List<LtMastVendorAddress> ltMastVendorAddressData,
			LtMastReportRequestRepository ltMastReportRequestRepository) {
		this.requestId = requestId;
		this.ltMastVendorAddressData = ltMastVendorAddressData;
		this.saveDirectory = saveDirectory;
		this.ltMastReportRequestRepository = ltMastReportRequestRepository;
	}
	
	public void run() 
    { 
		String filepath = null;
        try
        { 
            if(ltMastVendorAddressData!=null) {
             filepath = createExcel("VendorAddressReport",saveDirectory);
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
			
			
			if(reportName.equals("VendorAddressReport")) {
			if (ltMastVendorAddressData != null && ltMastVendorAddressData.size() > 0) {
				int rowIndex = 0;
				for (LtMastVendorAddress  ltMastVendorAddress : ltMastVendorAddressData) {
					++rowIndex;
					insertDetailsInfoForVendorAddrSummaryReport(sheet, rowIndex, ltMastVendorAddress, workbook);
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

	private void insertDetailsInfoForVendorAddrSummaryReport(Sheet sheet, int rowIndex,
			LtMastVendorAddress ltMastVendorAddress, Workbook workbook) {
		Row row = null;
        Cell c = null;
        row = sheet.createRow(rowIndex);
        CellStyle style  = setCellStylesForData(workbook);
         
        c = row.createCell(0);  row.getCell(0).setCellStyle(style);if (ltMastVendorAddress.getVendorCode() != null){ c.setCellValue(ltMastVendorAddress.getVendorCode()); }
        c = row.createCell(1);  row.getCell(1).setCellStyle(style);if (ltMastVendorAddress.getVendorName() != null){ c.setCellValue(ltMastVendorAddress.getVendorName()); }
        c = row.createCell(2);  row.getCell(2).setCellStyle(style);if (ltMastVendorAddress.getVendorStatus()!= null){ c.setCellValue(ltMastVendorAddress.getVendorStatus()); }
        c = row.createCell(3);  row.getCell(3).setCellStyle(style);if (ltMastVendorAddress.getAddressCode() != null){ c.setCellValue(ltMastVendorAddress.getAddressCode()); }
        c = row.createCell(4);  row.getCell(4).setCellStyle(style);if (ltMastVendorAddress.getAddress1() != null){ c.setCellValue(ltMastVendorAddress.getAddress1()); }
        c = row.createCell(5);  row.getCell(5).setCellStyle(style);if (ltMastVendorAddress.getCity() != null){ c.setCellValue(ltMastVendorAddress.getCity()); }
        c = row.createCell(6);  row.getCell(6).setCellStyle(style);if (ltMastVendorAddress.getStateName() != null){ c.setCellValue(ltMastVendorAddress.getStateName()); }
        c = row.createCell(7);  row.getCell(7).setCellStyle(style);if (ltMastVendorAddress.getCountry()!= null){ c.setCellValue(ltMastVendorAddress.getCountry()); }
        c = row.createCell(8);  row.getCell(8).setCellStyle(style);if (ltMastVendorAddress.getPinCode() != null){ c.setCellValue(ltMastVendorAddress.getPinCode()); }
        c = row.createCell(9);  row.getCell(9).setCellStyle(style);if (ltMastVendorAddress.getPrimaryAddress()!= null){ c.setCellValue(ltMastVendorAddress.getPrimaryAddress()); }
        c = row.createCell(10);  row.getCell(10).setCellStyle(style);if (ltMastVendorAddress.getBilling() != null){ c.setCellValue(ltMastVendorAddress.getBilling()); }
        c = row.createCell(11);  row.getCell(11).setCellStyle(style); if (ltMastVendorAddress.getShipping() != null) { c.setCellValue(ltMastVendorAddress.getShipping());  }
        c = row.createCell(12);  row.getCell(12).setCellStyle(style); if (ltMastVendorAddress.getStartDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastVendorAddress.getStartDate())); }
        c = row.createCell(13);  row.getCell(13).setCellStyle(style); if (ltMastVendorAddress.getEndDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastVendorAddress.getEndDate())); }
        c = row.createCell(14);  row.getCell(14).setCellStyle(style); if (ltMastVendorAddress.getGstRegistered()!= null) { c.setCellValue(ltMastVendorAddress.getGstRegistered());  }
        c = row.createCell(15);  row.getCell(15).setCellStyle(style); if (ltMastVendorAddress.getStateCode()!= null) { c.setCellValue(ltMastVendorAddress.getStateCode());  }
        c = row.createCell(16);  row.getCell(16).setCellStyle(style); if (ltMastVendorAddress.getGstRegNo()!= null) { c.setCellValue(ltMastVendorAddress.getGstRegNo());  }
        c = row.createCell(17);  row.getCell(17).setCellStyle(style); if (ltMastVendorAddress.getGstVendorType()!= null) { c.setCellValue(ltMastVendorAddress.getGstVendorType());  }
        c = row.createCell(18);  row.getCell(18).setCellStyle(style); if (ltMastVendorAddress.getVendorRegStatus()!= null) { c.setCellValue(ltMastVendorAddress.getVendorRegStatus());  }
        c = row.createCell(19);  row.getCell(19).setCellStyle(style); if (ltMastVendorAddress.getGstStartDate()!= null) { c.setCellValue(simpleDateFormat.format(ltMastVendorAddress.getGstStartDate()));  }
        c = row.createCell(20);  row.getCell(20).setCellStyle(style); if (ltMastVendorAddress.getGstEndDate()!= null) {  c.setCellValue(simpleDateFormat.format(ltMastVendorAddress.getGstEndDate())); }
        
		
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
         c = row.createCell(7); row.getCell(7).setCellStyle(style); c.setCellValue("Country");
         c = row.createCell(8); row.getCell(8).setCellStyle(style); c.setCellValue("PIN Code");
         c = row.createCell(9); row.getCell(9).setCellStyle(style); c.setCellValue("Primary Address");
         c = row.createCell(10); row.getCell(10).setCellStyle(style); c.setCellValue("Billing");
         c = row.createCell(11); row.getCell(11).setCellStyle(style); c.setCellValue("Shipping");
         c = row.createCell(12); row.getCell(12).setCellStyle(style); c.setCellValue("Start Date");
         c = row.createCell(13); row.getCell(13).setCellStyle(style); c.setCellValue("End Date");
         c = row.createCell(14); row.getCell(14).setCellStyle(style); c.setCellValue("GST Registered");
         c = row.createCell(15); row.getCell(15).setCellStyle(style); c.setCellValue("GST State Code");
         c = row.createCell(16); row.getCell(16).setCellStyle(style); c.setCellValue("GST Registration No");
         c = row.createCell(17); row.getCell(17).setCellStyle(style); c.setCellValue("GST Vendor Type");
         c = row.createCell(18); row.getCell(18).setCellStyle(style); c.setCellValue("GST Registration Status");
         c = row.createCell(19); row.getCell(19).setCellStyle(style); c.setCellValue("GST Start Date");
         c = row.createCell(20); row.getCell(20).setCellStyle(style); c.setCellValue("GST End Date");
       
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
