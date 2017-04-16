package com.xulu.fragment.internet.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class UDPServer
{
	private DatagramSocket socket;
	private String contentToSend;
	 
	public void setContentToSend(String contentToSend) 
	{
		this.contentToSend = contentToSend;
	}
	
	private DatagramPacket createDatagramPacket()
	{
		DatagramPacket packet = new DatagramPacket(contentToSend.getBytes(), contentToSend.getBytes().length);
		return packet;
	}
	
	public UDPServer(String destIp, int destPort) throws SocketException
	{
		InetSocketAddress destAddress = new InetSocketAddress(destIp, destPort);
		this.socket = new DatagramSocket(destAddress);
	}
	
	public void writeToAnotherAddress() throws IOException
	{
		socket.send(createDatagramPacket());
	}
	
	public String readFromAnotherAddress() throws IOException
	{
		byte[] bytes = new byte[1024];
		DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
		socket.receive(packet);
		return new String(bytes, 0, packet.getLength());
	}
	
	
	public void close()
	{
		if (socket != null)
		{
			socket.close();
		}
	}
}