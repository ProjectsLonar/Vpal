package com.lonar.vendor.vendorportal.controller;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.lonar.vendor.vendorportal.common.WatermarkPageEvent;
import com.lonar.vendor.vendorportal.model.LtPoLineReport;
import com.lonar.vendor.vendorportal.model.LtPoReport;

public class POReportService extends PdfPageEventHelper {

	public static void main(String[] args) throws MalformedURLException, IOException {
		POReportService service = new POReportService();
		LtPoReport poReport = new LtPoReport();
		service.createPOPDFReport(poReport);
	}

	public LtPoReport createPOPDFReport(LtPoReport poReport) throws MalformedURLException, IOException {

		Document document = new Document(PageSize.A4);
		document.setMargins(20, 20, 20, 45);
		try {
			
			String fileName= "POInvoice" + System.currentTimeMillis() + ".pdf";
			String filePath = poReport.getReportGeneratedPath() + fileName;
			
			poReport.setFileName(fileName);
			poReport.setPdfPath(filePath);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
			writer.setPageEvent(new WatermarkPageEvent("Purchase Order"));
			document.open();

			POReportService poReportService = new POReportService();
			writer.setPageEvent(poReportService);

//================================================================================================
			PdfPTable outerTable = new PdfPTable(20);
			outerTable.setWidthPercentage(100);
			outerTable.setSplitLate(false);

			outerTable.setWidths(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });

			Font outerTableFont = FontFactory.getFont(FontFactory.defaultEncoding, 7, Font.NORMAL);
			Font outerTableColHeadFont = FontFactory.getFont(FontFactory.defaultEncoding, 7, Font.BOLD);

			PdfPCell outerTableCell = new PdfPCell();

			Path path = Paths.get(poReport.getReportCompanyLogoPath());
			outerTableCell = new PdfPCell(getImageLogo(path.getParent().toString(), path.getFileName().toString()),
					false);
			outerTableCell.setColspan(6);
			outerTableCell.setPaddingTop(5);
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setVerticalAlignment(Element.ALIGN_CENTER);
			outerTable.addCell(outerTableCell);

			PdfPTable companyNameTable = getCompanyNameTable(outerTableFont, outerTableColHeadFont, poReport);

			outerTableCell = new PdfPCell(companyNameTable);
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(10);
			outerTable.addCell(outerTableCell);

			PdfPTable gstInTable = getGSTINTable(outerTableFont, outerTableColHeadFont,poReport);

			outerTableCell = new PdfPCell(gstInTable);
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTable.addCell(outerTableCell);
			// -----------------------------------------------------------

//			outerTableCell = new PdfPCell(new Phrase("Supplier Address", outerTableColHeadFont));
//			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//			outerTableCell.setColspan(4);
//
//			outerTable.addCell(outerTableCell);
//
//			outerTableCell = new PdfPCell(new Phrase(poReport.getVendorAddress(), outerTableFont));
//			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			outerTableCell.setColspan(6);
			PdfPTable nameAddTable=getNameAddTable(outerTableFont, outerTableColHeadFont, poReport);
			outerTableCell = new PdfPCell(nameAddTable);
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(10);
			outerTable.addCell(outerTableCell);
			 

			PdfPTable addressTable = getAddressTable(outerTableFont, outerTableColHeadFont, poReport);

			outerTableCell = new PdfPCell(addressTable);
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(10);
			outerTable.addCell(outerTableCell);

//			outerTableCell = new PdfPCell(new Phrase("Order Number", outerTableColHeadFont));
//			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			outerTableCell.setColspan(6);
//			outerTable.addCell(outerTableCell);

			// ------------------------------------------------------------
			outerTableCell = new PdfPCell(new Phrase("Ship To:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getShipTo(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(6);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Bill To:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(5);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getBillTo(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(5);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("GSTIN", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getGstinShip(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(6);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("GSTIN", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(5);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getGstinBill(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(6);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Payment Terms:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Payment Method:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Currency:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getPaymentTerms(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getPaymentMethod(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getCurrencyCode(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Freight Terms:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Incoterms / FOB:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("Carrier:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getFreightTerms(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getIncotermsFOB(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(8);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(poReport.getCarrier(), outerTableFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			outerTableCell.setColspan(4);
			outerTable.addCell(outerTableCell);
			// --terms and
			// condition--------------------------------------------------------------
			outerTableCell = new PdfPCell(new Phrase("Terms and Conditions:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			// --line details
			// start---------------------------------------------------------------
			outerTableCell = new PdfPCell(new Phrase("Line", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Shipment", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Item/ Description", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(4);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Delivery Date:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Quantity", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("UOM", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Unit Price", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("SubAmount", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase("Amount:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(2);
			outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			outerTable.addCell(outerTableCell);

			// --line details VALUE
			// start---------------------------------------------------------------
			List<LtPoLineReport> lineReportList = poReport.getLineReportList();
			for (LtPoLineReport poLineReport : lineReportList) {

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getLineNum(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getShipmentNum(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getItem(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(4);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(
						new Phrase(getStringDate(poLineReport.getDeliveryDate()), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getQuantity(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getUOM(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getUnitPrice(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getSubAmount(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				// ---oracle Apps star----------------------
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(
						new Phrase(poLineReport.getItemDescription(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(12);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				// line # header start
				// --------------------------------------------------------------------------

				outerTableCell = new PdfPCell(new Phrase("", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("LINE#", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("TAX NAME& DESCRIPTION", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(6);
				outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("RATE", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("TAX AMOUNT", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTableCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				// line # header DATA start
				// --------------------------------------------------------------------------
				// 1st LINE
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getLineNoOne(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				
				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTaxNameAndDescriptionCGST(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(6);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTaxAmountCGST(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getRateCGST(),outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				// 2nd line
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getLineNoTwo(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTaxNameAndDescriptionSGST(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(6);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTaxAmountSGST(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getRateSGST(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				// new row start.....................
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("Total Tax Amount:", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				outerTableCell.setColspan(12);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTotalTaxAmount(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
				// end.....................
				// new row start.....................
				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("Total Line Plus Tax:", outerTableColHeadFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				outerTableCell.setColspan(12);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase("", outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);

				outerTableCell = new PdfPCell(new Phrase(poLineReport.getTotalLineTax(), outerTableFont));
				outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				outerTableCell.setColspan(2);
				outerTable.addCell(outerTableCell);
			} // loopend
				// end.....................
				// total amount row start.................
			outerTableCell = new PdfPCell(new Phrase("TOTAL AMOUNT(INR):", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			outerTableCell.setColspan(16);
			outerTable.addCell(outerTableCell);
			outerTableCell = new PdfPCell(new Phrase(poReport.getTotalAmount(), outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			outerTableCell.setColspan(4);
			outerTable.addCell(outerTableCell);
			// total amount row start.................
			outerTableCell = new PdfPCell(new Phrase(
					"STANDARD TERMS AND CONDITIONS ARE APPLICABLE WHICH ARE AGREED MUTUALLY ALONG WITH THIS PURCHASE ORDER TERMS AND CONDITIONS",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase("PO Terms:", outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(
					"1. The prices accepted by supplier/service provider and confirmed in the Purchase Order are fixed for the duration of the Purchase Order and may not be modified without the written agreement of both the parties. Any price increase shall not be binding on us unless evidenced by a purchase order change notice or revision issued and confirmed. In such a case, appropriate debit note/credit note may be issued under GST.",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(
					"2. GST will be applicable on the total amount of goods / services and that Michelin shall be only liable to pay taxes which have been charged on the face of tax invoice.",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(
					"3. Supplier/Service Provider will undertake satisfactory measures to ensure timely payment of taxes to the appropriate government and timely filing of return of outward supplies/services. In case of non-compliance of such measure, any liability accruing to us would be recovered from supplier/service provider.",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(
					"4. Supplier/Service Provider will issue a valid tax invoice with all the required particulars as defined under GST.",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			outerTableCell = new PdfPCell(new Phrase(
					"5. In case of any disagreement relating to the content written in this PO, kindly communicate us within seven days from the date of receipt of PO, failing which PO shall be deemed confirmed and accepted by the Supplier.",
					outerTableColHeadFont));
			outerTableCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			outerTableCell.setColspan(20);
			outerTable.addCell(outerTableCell);

			document.add(outerTable);

//===============================================================================================
			document.close();
			writer.close();
			
			
			
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return poReport;

	}
	private static PdfPTable getNameAddTable(Font outerTableFont, Font outerTableColHeadFont, LtPoReport poReport)
			throws DocumentException {
	 
		PdfPTable nameTable = new PdfPTable(10);
		
		nameTable.setWidthPercentage(100);
		nameTable.setSplitLate(false);

		nameTable.setWidths(new int[] { 1, 1, 1, 1, 1, 1,1,1,1,1 });
		
		 

		PdfPCell nameCell = new PdfPCell();

		nameCell = new PdfPCell(new Phrase("Supplier Name:", outerTableColHeadFont));
		nameCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		nameCell.setColspan(4);
		nameTable.addCell(nameCell);
		
		
		nameCell = new PdfPCell(new Phrase(poReport.getVendorName(), outerTableFont));
		nameCell.setColspan(6);
		nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		nameTable.addCell(nameCell);
		
		nameCell = new PdfPCell(new Phrase("Supplier Address:", outerTableColHeadFont));
		nameCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		nameCell.setColspan(4);
		nameTable.addCell(nameCell);
		
		nameCell = new PdfPCell(new Phrase(poReport.getVendorAddress(), outerTableFont));
		nameCell.setColspan(6);
		nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		nameTable.addCell(nameCell);
		
		return nameTable;
		
 
	}
	private PdfPTable getAddressTable(Font outerTableFont, Font outerTableColHeadFont, LtPoReport poReport)
			throws DocumentException {
		PdfPTable addressTable = new PdfPTable(2);
		addressTable.setWidthPercentage(100);
		addressTable.setSplitLate(false);
		addressTable.setWidths(new int[] { 2, 2 });

		PdfPCell addressCell = new PdfPCell();

		addressCell = new PdfPCell(new Phrase("Purchasing Contact", outerTableColHeadFont));
		addressCell.setColspan(1);
		addressCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase(poReport.getPurchasingContact(), outerTableFont));
		addressCell.setColspan(1);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase("Email:", outerTableColHeadFont));
		addressCell.setColspan(1);
		addressCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase(poReport.getEmail(), outerTableFont));
		addressCell.setColspan(1);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase("Telephone:", outerTableColHeadFont));
		addressCell.setColspan(1);
		addressCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase(poReport.getTelephone(), outerTableFont));
		addressCell.setColspan(1);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase("Fax:", outerTableColHeadFont));
		addressCell.setColspan(1);
		addressCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase(poReport.getFax(), outerTableFont));
		addressCell.setColspan(1);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase("Authorized by:", outerTableColHeadFont));
		addressCell.setColspan(1);
		addressCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		addressCell = new PdfPCell(new Phrase(poReport.getAuthorizedBy(), outerTableFont));
		addressCell.setColspan(1);
		addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		addressTable.addCell(addressCell);

		return addressTable;
	}

	private PdfPTable getCompanyNameTable(Font outerTableFont, Font outerTableColHeadFont, LtPoReport poReport)
			throws DocumentException {
		PdfPTable companyNameTable = new PdfPTable(7);
		companyNameTable.setWidthPercentage(100);
		companyNameTable.setSplitLate(false);

		companyNameTable.setWidths(new int[] { 1, 1, 1, 1, 1, 1, 1 });

		PdfPCell companyNameCell = new PdfPCell();

		companyNameCell = new PdfPCell(
				new Phrase("Standard Purchase Order \n "+poReport.getCompanyName(), outerTableColHeadFont));
		companyNameCell.setColspan(7);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase(""
				/*"THIS NUMBER MUST APEAR ON ALL CORRESPONDENCE\r\n" + "PACKAGES, SHIPPING DOCUMENT AND INVOICE."*/,
				outerTableColHeadFont));
		companyNameCell.setColspan(7);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("Order Number", outerTableColHeadFont));
		companyNameCell.setColspan(3);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("Rivision", outerTableColHeadFont));
		companyNameCell.setColspan(2);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("Page Number", outerTableColHeadFont));
		companyNameCell.setColspan(2);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase(poReport.getPoNumber(), outerTableFont));
		companyNameCell.setColspan(3);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase(poReport.getRevisionNum(), outerTableFont));
		companyNameCell.setColspan(2);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("1", outerTableFont));// PageNumber12 //static *****
		companyNameCell.setColspan(2);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("PO Date", outerTableColHeadFont));
		companyNameCell.setColspan(4);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase("Revision Date", outerTableColHeadFont));
		companyNameCell.setColspan(3);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase(getStringDate(poReport.getPoDate()), outerTableFont));
		companyNameCell.setColspan(4);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);

		companyNameCell = new PdfPCell(new Phrase(getStringDate(poReport.getRevisionDate()), outerTableFont));
		companyNameCell.setColspan(3);
		companyNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		companyNameTable.addCell(companyNameCell);
		return companyNameTable;
	}

	private PdfPTable getGSTINTable(Font outerTableFont, Font outerTableColHeadFont,LtPoReport poReport) throws DocumentException {
		PdfPTable gstInTable = new PdfPTable(4);
		gstInTable.setWidthPercentage(100);
		gstInTable.setSplitLate(false);
		gstInTable.setWidths(new int[] { 1, 1, 1, 1 });

		PdfPCell gstInTableCell = new PdfPCell();

		gstInTableCell = new PdfPCell(new Phrase("GSTIN:", outerTableColHeadFont));
		gstInTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setVerticalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setColspan(2);
		gstInTableCell.setPaddingTop(15);
		gstInTableCell.setPaddingBottom(15);
		gstInTable.addCell(gstInTableCell);

		gstInTableCell = new PdfPCell(new Phrase("--", outerTableFont));
		gstInTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setVerticalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setColspan(2);
		gstInTableCell.setPaddingTop(15);
		gstInTableCell.setPaddingBottom(15);
		gstInTable.addCell(gstInTableCell);

		gstInTableCell = new PdfPCell(new Phrase("Company's GST:", outerTableColHeadFont));
		gstInTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setVerticalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setColspan(2);
		gstInTableCell.setPaddingTop(15);

		gstInTable.addCell(gstInTableCell);

		gstInTableCell = new PdfPCell(new Phrase("--", outerTableFont));
		gstInTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setVerticalAlignment(Element.ALIGN_CENTER);
		gstInTableCell.setColspan(2);
		gstInTableCell.setPaddingTop(15);
		gstInTable.addCell(gstInTableCell);

		return gstInTable;
	}

	private void outerTable(Document document) throws DocumentException {
		PdfPTable outerTable = new PdfPTable(20);
		outerTable.setWidthPercentage(100);
		outerTable.setSplitLate(false);

		outerTable.setWidths(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });

		Font outerTableFont = FontFactory.getFont(FontFactory.defaultEncoding, 7, Font.NORMAL);
		Font outerTableColHeadFont = FontFactory.getFont(FontFactory.defaultEncoding, 7, Font.BOLD);

		PdfPCell outerTableCell = new PdfPCell();
		outerTableCell = new PdfPCell(new Phrase("Sr. No", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Description", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("HSN/SAC Code", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Quantity", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Unit", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Rate", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Value", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("SGST", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("CGST", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("IGST", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("UTGST", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("Amount", outerTableColHeadFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("1", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("ACTIVA-Honda Activa 2013", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("4.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("No", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("40.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("160.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("19.20", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("16.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("12.80", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTableCell.setColspan(2);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("8.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("216.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		outerTableCell = new PdfPCell(new Phrase("216.00", outerTableFont));
		outerTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		outerTable.addCell(outerTableCell);

		// outerTable.setHeaderRows(1);
		document.add(outerTable);
	}

	private void poHeader(Document document, LtPoReport poReport) throws DocumentException, MalformedURLException, IOException {
		Font poHeaderFont = FontFactory.getFont(FontFactory.defaultEncoding, 22, Font.BOLD);

		String poHeadrerStr = "Purchase / Work Order";
		Paragraph poHeader = new Paragraph(poHeadrerStr, poHeaderFont);

		PdfPTable headerTable = new PdfPTable(2);
		headerTable.getDefaultCell().setBorderWidth(0f); // Remove table border
		headerTable.setWidthPercentage(100);
		headerTable.setWidths(new int[] { 3, 1 }); // set column width

		headerTable.addCell(poHeader);
		Path path = Paths.get(poReport.getReportCompanyLogoPath());
		headerTable.addCell(getImageLogo(path.getParent().toString(), path.getFileName().toString()));

		document.add(headerTable);

		// add horizontal line
		Chunk linebreak = new Chunk(new LineSeparator());
		document.add(linebreak);

		// add blank line between two table
		Paragraph para = new Paragraph();
		para.add(new Chunk("\n"));
		document.add(para);
	}

	private void addFooter(PdfWriter writer, Document document, LtPoReport poReport) {

		PdfPTable footer = new PdfPTable(1);
		footer.setHorizontalAlignment(Element.ALIGN_RIGHT);
		try {

			Chunk linebreak = new Chunk(new LineSeparator());
			// Chunk linebreak = new Chunk(new DottedLineSeparator());
			// document.add(linebreak);

			Font footerFont = FontFactory.getFont(FontFactory.defaultEncoding, 7, Font.NORMAL); // new
																								// Font(Font.FontFamily.TIMES_ROMAN,
																								// 8, Font.NORMAL);

			// set defaults
			// footer.getDefaultCell().setBorderWidth(0f);
			footer.setWidthPercentage(100);
			footer.setWidths(new int[] { 1 });
			footer.setTotalWidth(560);
			footer.setLockedWidth(true);

			PdfPCell footerTableCells = new PdfPCell();
			// footerTableCells.setColspan(2);
			footerTableCells.addElement(linebreak);
			footerTableCells.setBorder(PdfPCell.NO_BORDER);
			footerTableCells.setHorizontalAlignment(Element.ALIGN_CENTER);
			footer.addCell(footerTableCells);

			footerTableCells = new PdfPCell(new Phrase(poReport.getPoNumber(), footerFont));
			// footerTableCells.setColspan(2);
			footerTableCells.setBorder(PdfPCell.NO_BORDER);
			footerTableCells.setHorizontalAlignment(Element.ALIGN_CENTER);
			footer.addCell(footerTableCells);

			footerTableCells = new PdfPCell(new Phrase("footer organization address", footerFont));
			// footerTableCells.setColspan(2);
			footerTableCells.setHorizontalAlignment(Element.ALIGN_CENTER);
			footerTableCells.setBorder(PdfPCell.NO_BORDER);
			footer.addCell(footerTableCells);

			footerTableCells = new PdfPCell(new Phrase("Page No : " + writer.getPageNumber(), footerFont));
			// footerTableCells.setColspan(2);
			footerTableCells.setHorizontalAlignment(Element.ALIGN_CENTER);
			footerTableCells.setBorder(PdfPCell.NO_BORDER);
			footer.addCell(footerTableCells);

			// write page
			PdfContentByte canvas = writer.getDirectContent();
			canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
			footer.writeSelectedRows(0, -1, 10, 65, canvas);
			// Rectangle page = document.getPageSize();
			// footer.setTotalWidth(page.getWidth() - document.leftMargin() -
			// document.rightMargin());
			canvas.endMarkedContentSequence();
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	public Image getImageLogo(String path, String fileName) throws BadElementException, MalformedURLException, IOException {
		Image logoImg = getFile(path, fileName);
		if (logoImg == null) {

			ClassLoader classLoader = this.getClass().getClassLoader();
			logoImg = Image.getInstance(classLoader.getResource("Logo.jpg").getFile());

		} 
		logoImg.scaleAbsolute(130f, 80f);
		logoImg.setAlignment(Image.RIGHT);
		return logoImg;
	}

	private Image getFile(String path, String fileName) {

		Image image = null;
		try {
			/*
			 * ClassLoader classLoader = getClass().getClassLoader(); image =
			 * Image.getInstance(classLoader.getResource(fileName)); return image;
			 */
			String finalFilePath = path + "/" + fileName;
			image = Image.getInstance(finalFilePath);
			// image = Image.getInstance("D:\\test\\image\\Logo.png");
			return image;

		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;

	}
	public String getStringDate(Date date) {
		String strDate="";
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			strDate = dateFormat.format(date);
			return strDate;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return strDate;
	}
}
