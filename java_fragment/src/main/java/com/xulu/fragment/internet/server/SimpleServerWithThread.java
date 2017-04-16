package com.xulu.fragment.internet.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Administrator
 *
 */
public class SimpleServerWithThread extends Thread
{
	private ServerSocket server;
	private Socket client;
	
	public SimpleServerWithThread(int serverPort)
	{
		try {
			server = new ServerSocket(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			try {
				client = server.accept();
				ServerThread st = new ServerThread(client);
				st.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
