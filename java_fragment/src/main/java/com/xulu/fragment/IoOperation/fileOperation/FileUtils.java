package com.xulu.fragment.IoOperation.fileOperation;

import java.io.File;
import java.io.IOException;

public class FileUtils 
{

	public static void create(String fileName) throws IOException
	{
		File file = new File(fileName);
		if(file.exists())
		{
			file.delete();
		}else 
		{
			file.createNewFile();
		}
	}
}
