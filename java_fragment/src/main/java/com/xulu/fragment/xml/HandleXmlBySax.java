package com.xulu.fragment.xml;

import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandleXmlBySax {

	
	
	void read() throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		InputStream in = HandleXmlBySax.class.getClassLoader().getResourceAsStream("basicXml.xml");
		parser.parse(in, new MyHandler());
	}
	
	class MyHandler extends DefaultHandler
	{
		//��д���Լ�����Ȥ�¼��Ĵ�����
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			System.out.println("��ʼ�����ĵ�");
		}
		
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
			System.out.println("�����ĵ�����");
		}
	}
	
	void write()
	{
		System.out.println("��Sax��дXML����Ϊ��");
	}
	
}
