package com.xulu.fragment.xml;
/**
 * π”√DOM∂¡–¥XML
 * 
 */

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class HandleXmlByDom {

	
	public void handle() throws Exception
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File("resources/xml/basicXml.xml"));
		
		NodeList list= document.getElementsByTagName("book");
		for(int i=0; i< list.getLength(); i++)
		{
			Element element= (Element)list.item(i);
//			String content0 = element.getElementsByTagName("title").item(0).getNodeValue();
			String content = element.getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
			String content1 = element.getElementsByTagName("author").item(0).getFirstChild().getNodeValue();
			String content2 = element.getElementsByTagName("year").item(0).getFirstChild().getNodeValue();
			String content3 = element.getElementsByTagName("price").item(0).getFirstChild().getNodeValue();
			
			System.out.println("title:" + content +" author:" + content1 + " year:" + content2 + " price:" + content3);
		}
	}
	
	public static void read() throws Exception
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream in = HandleXmlByDom.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document document = db.parse(in);
		
		Element root = document.getDocumentElement();
		if (root == null) return;
		
		NodeList list = root.getChildNodes();
	}
	
	public void write() throws Exception
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream in = HandleXmlByDom.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document  document = db.parse(in);
		
		Element root = document.getDocumentElement();
		if(root == null) return;
		root.setAttribute("name", "John");
		
		
	}
}
