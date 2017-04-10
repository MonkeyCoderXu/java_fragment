public class UDPServer
{
	private DatagramSocket dsSocket;
	
	public void startServer(int port) 
	{
		dsSocket = new DatagramSocket(port);
		System.out.println("server starting..." + port);
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		while(true)
			{
				dsSocket.receive(packet);
				String message = new String(buffer, 0, packet.getLength());
				System.out.println(packet.getAddress().getHostName() + ":" + message);
				if(message.equals("end")) break;
				packet.setLength(buffer.lenth);
			}
			dsSocket.close();	
	}
	
}