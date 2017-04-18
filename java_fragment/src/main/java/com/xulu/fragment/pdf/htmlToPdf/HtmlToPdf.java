package com.xulu.fragment.pdf.htmlToPdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPdf 
{
	public static void castHtmlToPdf(String destPdfPath, String htmlPath) throws DocumentException, IOException
	{
		Document document = new Document();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destPdfPath));
		document.open();
		XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, new FileInputStream(htmlPath));
		document.close();
	}
}
