package com.lonar.vendor.vendorportal.excelupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastCommonMessageService;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;
import com.opencsv.CSVReader;


@Service
public class LtMastFileUploadServiceImpl implements LtMastFileUploadService,CodeMaster{

	public static final char FILE_DELIMITER = ',';
	public static final String FILE_EXTN = ".xlsx";
	public static final String FILE_NAME = "EXCEL_DATA";
	
	
	@Autowired
	LtMastFileUploadDao ltMastFileUploadDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastUsersDao ltMastUsersDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	
	@Override
	public Status uploadFile(MultipartFile files, String requestName, Long requestorId)
			throws ServiceException {
		Status status = new Status();
		status = saveFile(files,requestName,requestorId);
		if(status.getCode()==SUCCESS) {
			status = insertExcelDataToTable(status,requestName,requestorId);
			System.out.println("status = == "+status);
			if(status.getCode()==SUCCESS) {
				return status;
			}else if(status.getCode()==EXCEPTION){
				return status;
			}else {
				status.setCode(EXCEPTION);
				status.setMessage("Please upload a File with valid format");
				status.setData(null);
			}
			
		}else {
			status.setCode(EXCEPTION);
			status.setMessage("Error in finding message! The action was unsuccessful");
			
		}
		return status;
		
	}

	private Status insertExcelDataToTable(Status status, String requestName, Long requestorId) {
		LtMastUsers ltMastUsers = ltMastUsersDao.getLtMastUsersByID(requestorId);
		try
        {
            FileInputStream file = new FileInputStream(new File(status.getData().toString()));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int rowCount = 0;
            
            Long requestId = ltMastFileUploadDao.getRequestId();
            List<LtInvoiceHeadersStg> ltInvoiceHeadersStgList = new ArrayList<LtInvoiceHeadersStg>();
            while (rowIterator.hasNext())
            {
            	LtInvoiceHeadersStg ltInvoiceHeadersStg = new LtInvoiceHeadersStg();
            	ltInvoiceHeadersStg.setRequestId(requestId);
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
              
                if(rowCount!=0) {
                int colCount = 0;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    System.out.println("cell.getColumnIndex() "+cell.getColumnIndex()+" colCount "+colCount);
                    if(cell.getColumnIndex()!=colCount) {
                    	System.out.println("hree");
                    	if(colCount == 1) {
                    		System.out.println("in");
                    		status.setCode(EXCEPTION);
                			status.setMessage("Please insert Invoice number");
                			System.out.println(status);
                			return status;
                    	}else if(colCount == 15) {
                    		System.out.println("in 2 ");
                    		status.setCode(EXCEPTION);
                    		status.setMessage("Please insert Invoice line number");
                			System.out.println(status);
                			return status;
                    	}else if(colCount == 26) {
                    		status.setCode(EXCEPTION);
                			status.setMessage("Please insert Tax name");
                			return status;
                    	}
                    	else {
                    		colCount++;
                    	}
                    }
                    	
                    	
                    
                    	if(cell.getColumnIndex()==0) {
                    			ltInvoiceHeadersStg.setInvoiceType(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==1) {
                    		ltInvoiceHeadersStg.setInvoiceNumber(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==2) {
                    			ltInvoiceHeadersStg.setInvoiceDate(new Date(getCellDateValue(cell)));
                    	}
                    	if(cell.getColumnIndex()==3) {
                    			ltInvoiceHeadersStg.setInvoiceReceivedDate(new Date(getCellDateValue(cell)));
                    	}
                    	if(cell.getColumnIndex()==4) {
                    			ltInvoiceHeadersStg.setPoNumber(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==5) {
                    		ltInvoiceHeadersStg.setBuyer(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==6) {
                    			ltInvoiceHeadersStg.setVendorCode(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==7) {
                    			ltInvoiceHeadersStg.setVendorAddressCode(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==8) {
                    		ltInvoiceHeadersStg.setBillingAddress(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==9) {
                    			ltInvoiceHeadersStg.setShippingAddress(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==10) {
                    			ltInvoiceHeadersStg.setInvoiceCurrencyCode(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==11) {
                    			ltInvoiceHeadersStg.setExchangeRate(Double.parseDouble(getCellValue(cell)));
                    	}
                    	if(cell.getColumnIndex()==12) {
                    			ltInvoiceHeadersStg.setPayterms(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==13) {
                    			ltInvoiceHeadersStg.setStatus(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==14) {
                    			ltInvoiceHeadersStg.setDescription(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==15) {
                    		ltInvoiceHeadersStg.setInvoiceLineNumber((long) cell.getNumericCellValue());
                    	}
                    	if(cell.getColumnIndex()==16) {
                    		ltInvoiceHeadersStg.setPoLineNo((long) cell.getNumericCellValue());
                    	}
                    	if(cell.getColumnIndex()==17) {
                    		ltInvoiceHeadersStg.setShipmentLineNo((long) cell.getNumericCellValue());
                    	}
                    	if(cell.getColumnIndex()==18) {
                    		ltInvoiceHeadersStg.setLineType(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==19) {
                    		ltInvoiceHeadersStg.setProductCategoryCode(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==20) {
                    		ltInvoiceHeadersStg.setSubCategoryCode(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==21) {
                    		ltInvoiceHeadersStg.setProduct(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==22) {
                    		ltInvoiceHeadersStg.setLineDescription(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==23){
                    		ltInvoiceHeadersStg.setUom(getCellValue(cell));
                    	}
                    	if(cell.getColumnIndex()==24) {
                    		ltInvoiceHeadersStg.setInvoiceQuantity(new Double(getCellValue(cell)));
                    	}
                    	if(cell.getColumnIndex()==25) {
                    		ltInvoiceHeadersStg.setInvoiceRate(Double.parseDouble(getCellValue(cell)));
                    	}
                    	if(cell.getColumnIndex()==26) {
                    		ltInvoiceHeadersStg.setTaxName(getCellValue(cell));
                    	}
                    	colCount++;
                   
                }
                ltInvoiceHeadersStg.setCreatedBy(requestorId);
                ltInvoiceHeadersStg.setCreationDate(new Date());
                ltInvoiceHeadersStg.setLastUpdateDate(new Date());
                ltInvoiceHeadersStg.setLastUpdatedBy(requestorId);
                ltInvoiceHeadersStg.setLastUpdateLogin(requestorId);
                ltInvoiceHeadersStg.setRecordStatus("NEW");
                ltInvoiceHeadersStg.setSourceDate(new Date());
                ltInvoiceHeadersStg.setSourceSystem("FILE UPLOAD");
                ltInvoiceHeadersStg.setCompanyId(ltMastUsers.getCompanyId());
                
                ltInvoiceHeadersStgList.add(ltInvoiceHeadersStg);
               /* if(ltMastFileUploadDao.save(ltInvoiceHeadersStg)){
                	status.setData(requestId);
                }*/
                }
                
               
                rowCount++;
            }
            file.close();
            for(LtInvoiceHeadersStg invoiceHeadersStg : ltInvoiceHeadersStgList) {
            	if(ltMastFileUploadDao.save(invoiceHeadersStg)){
                	status.setData(requestId);
            }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            status.setCode(EXCEPTION);
        }
		return status;
	}

	private String getCellDateValue(Cell cell) throws ParseException {
		if(cell.getCellType() ==cell.CELL_TYPE_STRING) {
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(cell);
			return val;
		}
		if (HSSFDateUtil.isCellDateFormatted(cell)) {
	        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        return df.format(cell.getDateCellValue());
	    }
		return null;
	}

	private String getCellValue(Cell cell) {
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
		   return null;
		 }
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
		{
			String value = cell.getNumericCellValue()+"";
			if(value.contains(".0")) {
				value = value.replace(".0", "");
			}
			return value;
		}
		case Cell.CELL_TYPE_STRING:{
			String value = cell.getStringCellValue()+"";
			if(value.contains(".0")) {
				value = value.replace(".0", "");
			}
			return value;
		}
		}
		return null;
		
	}

	private Status saveFile(MultipartFile files, String requestName, Long requestorId) {
		Status status = new Status();
		String fileName = null;
		String msg = "";	
		String saveDirectory = null;
		try {
			LtMastUsers ltMastUsers = ltMastUsersDao.getLtMastUsersByID(requestorId);
			if (files != null && files.getSize()> 0) {
				SysVariableWithValues sysVariableWithValues = ltMastSysVariablesService
						.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",ltMastUsers.getCompanyId());

				if (sysVariableWithValues != null) {
					if (sysVariableWithValues.getLtMastSysVariableValues().get(0) != null) {
						saveDirectory = sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
					} else {
						saveDirectory = sysVariableWithValues.getLtMastSysVariables().getSystemValue();
					}
				}
				
				File dir = new File(saveDirectory);
				if (!dir.exists()) {
					dir.mkdirs();
					if (!dir.isDirectory()) {
						status = ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
						if (status.getMessage() == null) {
							status.setCode(EXCEPTION);
							status.setMessage("Error in finding message! The action was unsuccessful");
						}

						return status;
					}
				}
				fileName = files.getOriginalFilename();
				
				try {
					byte[] bytes = files.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(
								new FileOutputStream(new File(saveDirectory + fileName)));
						buffStream.write(bytes);

						buffStream.close();
						msg += "You have successfully uploaded " + fileName ;
						
						String fileExtention = fileName.substring(fileName.lastIndexOf('.'));
						if (fileExtention.toUpperCase().equals(".CSV"))
						{
							
							String fileLoc = convertCsvToXls(saveDirectory, saveDirectory + fileName);
							status.setCode(200);
							status.setData(fileLoc);
							if (status.getMessage() == null) {
								status.setCode(SUCCESS);
								status.setMessage("You have successfully uploaded " + fileName );
							}
							return status;
						}else {
							status.setMessage(msg);
							status.setCode(200);
							status.setData(saveDirectory + fileName);
							if (status.getMessage() == null) {
								status.setCode(SUCCESS);
								status.setMessage("You have successfully uploaded " + fileName );
							}
							return status;
						}
				} catch (Exception e) {
					e.printStackTrace();
					status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
				}
			} else {
				status = ltMastCommonMessageService.getCodeAndMessage(INPUT_IS_EMPTY);
			}
			return status;
		}
		catch (Exception e) {
			e.printStackTrace();
			status = ltMastCommonMessageService.getCodeAndMessage(INTERNAL_SERVER_ERROR);
		}
		return status;
	}

	private String convertCsvToXls(String saveDirectory, String csvFilePath) {
		
			SXSSFSheet sheet = null;
			CSVReader reader = null;
			Workbook workBook = null;
			String generatedXlsFilePath = "";
			FileOutputStream fileOutputStream = null;

			try {

				/**** Get the CSVReader Instance & Specify The Delimiter To Be Used ****/
				String[] nextLine;
				reader = new CSVReader(new FileReader(csvFilePath), FILE_DELIMITER);

				workBook = new SXSSFWorkbook();
				sheet = (SXSSFSheet) workBook.createSheet("Sheet");

				int rowNum = 0;
				//logger.info("Creating New .Xls File From The Already Generated .Csv File");
				while ((nextLine = reader.readNext()) != null) {
					Row currentRow = sheet.createRow(rowNum++);
					for (int i = 0; i < nextLine.length; i++) {
						if (NumberUtils.isDigits(nextLine[i])) {
							if(nextLine[i].contains("/")){
								currentRow.createCell(i).setCellValue(nextLine[i]);
								}else {
									currentRow.createCell(i).setCellValue(Integer.parseInt(nextLine[i]));
								}
						} else if (NumberUtils.isNumber(nextLine[i])) {
							if(nextLine[i].contains("/")){
								currentRow.createCell(i).setCellValue(nextLine[i]);
								}else {
									currentRow.createCell(i).setCellValue(Double.parseDouble(nextLine[i]));
								}
						} else {
							currentRow.createCell(i).setCellValue(nextLine[i]);
						}
					}
				}

				generatedXlsFilePath = saveDirectory + FILE_NAME + FILE_EXTN;
				//logger.info("The File Is Generated At The Following Location?= " + generatedXlsFilePath);

				fileOutputStream = new FileOutputStream(generatedXlsFilePath.trim());
				workBook.write(fileOutputStream);
			} catch (Exception exObj) {
				//logger.error("Exception In convertCsvToXls() Method?=  " + exObj);
			} finally {
				try {

					/**** Closing The Excel Workbook Object ****/
					// ((FileOutputStream) workBook).close();
					// workBook.close();
					/**** Closing The File-Writer Object ****/
					// fileOutputStream.close();

					/**** Closing The CSV File-ReaderObject ****/
					reader.close();
				} catch (IOException ioExObj) {
					//logger.error("Exception While Closing I/O Objects In convertCsvToXls() Method?=  " + ioExObj);
				}
			}

			return generatedXlsFilePath;
		}

	@Override
	public List<LtInvoiceHeadersStg> getByRequestId(Long requestId) throws ServiceException {
		return ltMastFileUploadDao.getByRequestId(requestId);
	}

	@Override
	public Status createInvoice(Long requestId) throws ServiceException {
		Status status = new Status();
		status = ltMastFileUploadDao.createInvoiceProcedure(requestId);
		/*if(status.getCode().equals(SUCCESS)) {
			status=ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
		}else {
			
		}*/
		return status;
	}

	@Override
	public Long getLtInvoiceHeadersStgCount(Long requestId, LtInvoiceHeadersStg input) throws ServiceException {
		return ltMastFileUploadDao.getLtInvoiceHeadersStgCount(requestId,input);
	}

	@Override
	public List<LtInvoiceHeadersStg> getLtInvoiceHeadersStgData(Long requestId, LtInvoiceHeadersStg input)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		
		if(input.getColumnNo()==0)
		{
			input.setColumnNo(11);
		}
		return ltMastFileUploadDao.getLtInvoiceHeadersStgData(requestId,input);
	}

}
