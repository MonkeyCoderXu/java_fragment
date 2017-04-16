package com.xulu.fragment.xml.xmlObjectCastor;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.xulu.fragment.bean.xmlObjectCastor.Article;

public class XmlObjectCastor
{

	public static void castObjectToXml(Article article, String xmlPath) throws IOException, MarshalException, ValidationException
	{
		FileWriter writer = new FileWriter(xmlPath);
		Marshaller.marshal(article, writer);
		writer.close();
	}
	
	public static void castXmlToObject(Article article, String xmlPath) throws MarshalException, ValidationException, FileNotFoundException
	{
		FileReader reader = new FileReader(xmlPath);
		article = (Article)Unmarshaller.unmarshal(article.getClass(), reader);
	}
}
