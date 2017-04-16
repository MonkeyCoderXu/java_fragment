package com.xulu.fragment.internet.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * java nio的非阻塞式socket编程
 * @author Administrator
 *
 */
public class ServerThreadWithMultiAccess
{
	
	public static void run() throws IOException 
	{  
	     Selector selector=Selector.open();  
	     ServerSocketChannel ssc=ServerSocketChannel.open();  
	     ssc.configureBlocking(false); //设置为非阻塞  
	     ServerSocket ss = ssc.socket(); //用来监听连接的ServerSocket  
	     ss.bind(new InetSocketAddress(26666)); //绑定端口  
	     ssc.register(selector,SelectionKey.OP_ACCEPT); //注册有新连接  
	    
	     Set<SelectionKey> selectionKeys = selector.selectedKeys();
	     
	     Iterator<SelectionKey> iter=selectionKeys.iterator();  

	         while(iter.hasNext())
	         {  
	        	 SelectionKey key=iter.next();  
	        	 if((key.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT)  
	        	 { 
	        		 //如果有新的连接请求，则新建一个SocketChannel  
	                 ServerSocketChannel nssc=(ServerSocketChannel)key.channel();  
	                 SocketChannel sc=nssc.accept();  

	                 sc.configureBlocking(false); //非阻塞  

	                 sc.register(selector, SelectionKey.OP_READ); //监听READ操作  

	             }
	        	 else if((key.readyOps()&SelectionKey.OP_READ)==SelectionKey.OP_READ) 
	        	 {  

	        		 //此socket上有数据可以读入   
	                 SocketChannel sc=(SocketChannel)key.channel();  

	                 ByteBuffer echoBuffer=ByteBuffer.allocate(20);   

	                 echoBuffer.clear();  

	                 int a=sc.read(echoBuffer); //读入数据  

	                 echoBuffer.flip();  

	                 //处理数据  

	             }  

	         }  
	 } 
}

