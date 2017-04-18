package com.xulu.fragment.pdf.createTableStylePdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class TableStylePdf 
{
	public static void createTableStylePdf(String destPdfPath) throws FileNotFoundException, DocumentException
	{
		Document document = new Document();
		document.setPageSize(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destPdfPath));
		document.open();
		document.add(TableBuilder.createTable());
		document.close();
	}
}
