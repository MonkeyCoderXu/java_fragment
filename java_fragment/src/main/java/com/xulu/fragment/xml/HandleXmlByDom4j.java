package com.xulu.fragment.xml;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;
import org.jdom.Attribute;

public class HandleXmlByDom4j {

	
	void read1() throws Exception
	{
		SAXReader reader = new SAXReader();
		InputStream in = HandleXmlByDom4j.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document document = reader.read(in);
		
		Element root = document.getRootElement();
		readNode(root, "");
	}
	
	void readNode(Element e, String prefix)
	{
		if(e == null) return;
		List<Attribute> attrs = e.attributes();
		if(attrs != null && attrs.size() > 0)
		{
			for(Attribute attr: attrs)
			{
				System.out.println(attr.getValue() + " ");
			}
		}
		
		List<Element> childrenNodes = e.elements();
		prefix += "\t";
		for(Element node: childrenNodes)
		{
			readNode(node, prefix);
		}
	}
	
	void read2() throws Exception
	{
		SAXReader reader = new SAXReader();
		InputStream in = HandleXmlByDom4j.class.getClassLoader().getResourceAsStream("basicXml.xml");
		Document document = reader.read(in);
		
		document.accept(new MyVisitor());
	}
	
	class MyVisitor extends VisitorSupport
	{
		@Override
		public void visit(org.dom4j.Attribute node) 
		{
			// TODO Auto-generated method stub
			super.visit(node);
			System.out.println("Attribute:" + node.getName() + "=" + node.getValue());
		}
		
		@Override
		public void visit(Element node) 
		{
			// TODO Auto-generated method stub
			super.visit(node);
			if(node.isTextOnly())
			{
				System.out.println("Element:" + node.getName() + "=" + node.getText());
			}else 
			{
				System.out.println(node.getName());
			}
		}
		
		@Override
		public void visit(ProcessingInstruction node) 
		{
			// TODO Auto-generated method stub
			super.visit(node);
			System.out.println("PI:" + node.getTarget() + " " + node.getText());
		}
	}
}
