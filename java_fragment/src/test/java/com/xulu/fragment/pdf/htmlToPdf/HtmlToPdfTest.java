package com.xulu.fragment.pdf.htmlToPdf;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.DocumentException;

public class HtmlToPdfTest {

	@Test
	public void testCastHtmlToPdf() 
	{
		try {
			HtmlToPdf.castHtmlToPdf("src/main/resources/pdf/HtmlToPdf.pdf", "src/main/resources/html/castHtmlToPdf/index.html");
		} catch (DocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
