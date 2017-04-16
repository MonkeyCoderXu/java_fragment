package com.xulu.fragment.internet.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient
{
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	public SimpleClient(String serverIp, int serverPort) throws UnknownHostException, IOException
	{
		this.socket = new Socket(serverIp, serverPort);
	}
	
	public void  writToServer(String contentToSend)
	{
		try {
			os = socket.getOutputStream();
			while(true)
			{
				os.write(contentToSend.getBytes(), 0, contentToSend.getBytes().length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String readFromServer()
	{
		String contentToRead = "";
		try {
			is = socket.getInputStream();
			while(true)
			{
				byte[] b = new byte[1024];
				int n = is.read(b);
				contentToRead = new String(b, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentToRead;
	}
	
	public void close()
	{
		if (socket != null)
		{
			try 
			{
				socket.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		if(is != null)
		{
			try 
			{
				is.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		if(os != null)
		{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}