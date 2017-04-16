package com.xulu.fragment.internet.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer 
{
  private ServerSocket server;
  private Socket socket;
  private InputStream is;
  private OutputStream os;
  
  public SimpleServer(int serverPort) throws IOException
  {
    this.server = new ServerSocket(serverPort);
    socket = this.server.accept();
  }
  
  public void readFromClient() throws IOException
  {
    is = socket.getInputStream();
  }
  
  public void writeToClient() throws IOException
  {
    os = socket.getOutputStream();
  }
}
