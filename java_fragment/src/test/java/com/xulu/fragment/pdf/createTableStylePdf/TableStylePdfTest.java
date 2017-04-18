package com.xulu.fragment.pdf.createTableStylePdf;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.itextpdf.text.DocumentException;

public class TableStylePdfTest {

	@Test
	public void testCreateTableStylePdf() 
	{
		try {
			TableStylePdf.createTableStylePdf("src/main/resources/pdf/TableStylePDF.pdf");
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
