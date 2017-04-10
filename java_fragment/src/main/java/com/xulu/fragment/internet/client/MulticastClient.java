//多播
//多播采用和UDP类似的方式，它会使用D类IP地址和标准的UDP端口号，D类IP地址是指224.0.0.0到239.255.255.255之间的地址，不包括224.0.0.0
public class MulticastClient
{
	
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			InetAddress address = InetAddress.getByName("230.0.0.1");
			int port = 5678;
			while(true)
			{
				String line = br.readLine();
				byte[] message = line.getBytes();
				DatagramPacket packet = new DatagramPacket(message, message.length, address, port);
				MulticastSocket multicastSocket = new MulticastSocket();
				multicastSocket.send(packet);
				if(line.equals("end")) break;
			}
			br.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}