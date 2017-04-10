package com.xulu.fragment.internet.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastServer
{
	private MulticastSocket socket;
	private String contentToCast;
	//多点广播地址
	//IP协议为多点广播提供了这批特殊的IP地址，这些IP地址的范围是224.0.0.0至239.255.255.255
	private InetAddress multicastAddress;
	
	public void setContentToCast(String contentToCast)
	{
		this.contentToCast = contentToCast;
	}
	
	public void setMulticastAddress(String multicastIp) throws UnknownHostException
	{
		this.multicastAddress = InetAddress.getByName(multicastIp);
	}
	
	private DatagramPacket createDatagramPacket()
	{
		DatagramPacket packet = new DatagramPacket(contentToCast.getBytes(), contentToCast.getBytes().length);
		return packet;
	}
	
	public MulticastServer(int port) throws IOException
	{
		socket = new MulticastSocket(port);
		socket.joinGroup(multicastAddress);
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
}