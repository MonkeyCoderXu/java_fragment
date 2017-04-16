package com.xulu.fragment.internet.server;
/**
 * 接收从服务器传过来的客户端socket
 * 
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread
{
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String contentToSend;
	private String contentToRecieve;
	
	public ServerThread(Socket client)
	{
		this.socket = client;
	}
	
	public void read()
	{
		
	}
	
	public void write()
	{
		
	}
	
	public void run() 
	{
		try 
		{
			is = socket.getInputStream();
			os = socket .getOutputStream();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
