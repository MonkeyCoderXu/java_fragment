//UDP连接
public class UDPClient
{
	private String name;
	
	public UDPClient(String name)
	{
		this.name = name;
	}
	
	public void connect
	public static void main(String[] args)
	{
		try
		{
			InetAddress host = InetAddress.getLocalHost();
			int port = 5678;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				String line = br.readLine();
				byte[] message = line.getBytes();
				DatagramPacket packet = new DatagramPacket(message, message.length, host, port);
				DatagramSocket socket = new DatagramSocket();
				socket.send(packet);
				socket.close();
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