package com.xulu.fragment.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class HandleXmlByJDom {

	void read() throws Exception
	{
		boolean validate = false;
		SAXBuilder builder = new SAXBuilder(validate);
		InputStream in = HandleXmlByJDom.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document document = builder.build(in);
		
		Element root = document.getRootElement();
		readNode(root, "");
	}
	
	void readNode(Element e, String prefix)
	{
		if(e == null) return;
		List<Attribute> attrs = e.getAttributes();
		if(attrs != null && attrs.size() > 0)
		{
			for(Attribute attr: attrs)
			{
				System.out.println(attr.getValue() + " ");
			}
		}
		List<Element> childrenNodes = e.getChildren();
		prefix += "\t";
		for(Element node: childrenNodes)
		{
			readNode(node, prefix);
		}
	}
	
	void write() throws Exception
	{
		boolean validate = false;
		SAXBuilder builder = new SAXBuilder(validate);
		InputStream in = HandleXmlByJDom.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document document = builder.build(in);
		
		Element root = document.getRootElement();
		root.setAttribute("name", "John");
		boolean isRemoved = root.removeChildren("book");
		Element element = new Element("favorateBook");
		element.setAttribute("name", "Java");
		root.addContent(element);
		XMLOutputter out = new XMLOutputter();
		File file = new File("resource/xml/basicXml-modify.xml");
		if(file.exists())
		{
			file.delete();
		}
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		out.output(document, fos);
	}
}
