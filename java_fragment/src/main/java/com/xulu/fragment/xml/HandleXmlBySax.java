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
		//重写对自己感兴趣事件的处理方法
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			System.out.println("开始解析文档");
		}
		
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
			System.out.println("解析文档结束");
		}
	}
	
	void write()
	{
		System.out.println("纯Sax对写XML无能为力");
	}
	
}
