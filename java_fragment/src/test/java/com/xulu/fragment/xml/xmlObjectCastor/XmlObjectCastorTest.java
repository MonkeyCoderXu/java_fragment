package com.xulu.fragment.xml.xmlObjectCastor;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.junit.Test;

import com.xulu.fragment.bean.xmlObjectCastor.Article;

public class XmlObjectCastorTest {

	@Test
	public void testCastObjectToXml() 
	{
		Article article = new Article();
		article.setTitle("Castor - Java Object to XML & XML to Object Mapping");
    	article.setUrl("http://hmkcode.com/castor-java-object-xml");
    	article.addCategory("Java");
    	article.addTag("Java");
    	article.addTag("Castor");
    	article.addTag("XML");
    	article.addTag("Marshalling");
    	article.addTag("Unmarshalling");
    	
    	try {
			XmlObjectCastor.castObjectToXml(article, "src/main/resources/xml/xmlOjbectCastor/ArticleToWrite.xml");
		} catch (MarshalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCastXmlToObject(){
		Article article = new Article();
		try {
			XmlObjectCastor.castXmlToObject(article, "src/main/resources/xml/xmlOjbectCastor/ArticleToRead.xml");
			System.out.println(article);
		} catch (MarshalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
