package com.xulu.fragment.xml.xmlObjectCastor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import com.xulu.fragment.bean.xmlObjectCastor.Article;

/**
 * 根据指定mapping.xml来的读写xml
 * @author Administrator
 *
 */
public class XmlObjectCastorByMapping 
{
	public static void castObjectToXml(Article article, String xmlPath, String mappingPath)
	{
		try 
		{
			//loading a mapping.xml
			Mapping mapping = new Mapping();
			mapping.loadMapping(mappingPath);
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			
			Writer writer = new FileWriter(xmlPath);
			Marshaller marshaller  = context.createMarshaller();
			marshaller.setWriter(writer);
			
			marshaller.marshal(article);
			
			writer.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} catch (MappingException e) 
		{
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	public static void castXmlToObject(Article article, String xmlPath, String mappingPath)
	{
		try 
		{
			//loading a mapping.xml
			Mapping mapping = new Mapping();
			mapping.loadMapping(mappingPath);
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			
			Reader reader = new FileReader(xmlPath);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass(article.getClass());
			
			article = (Article)unmarshaller.unmarshal(reader);
			
			reader.close();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MappingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MarshalException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
