package com.xulu.fragment.internet.server;

public class SimpleServer 
{
  private ServerSocket server;
  private Socket socket;
  private InputStream is;
  private OutputStream os;
  
  public SimpleServer(int serverPort)
  {
    this.server = new ServerSocket(serverPort);
    socket = this.server.accept();
  }
  
  public void readFromClient()
  {
    is = socket.getInputStream();
  }
  
  public void writeToClient()
  {
    os = socket.getOutputStream();
  }
}
