public class SimpleClient
{
	private void client()
	{
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		String serverIP = "127.0.0.1";
		int serverPort = 10000;
		
		String contentToSent = "";
		
		try
		{
			socket = new Socket(serverIP, serverPort);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			while(true)
			{
				os.write(contentToSent.getBytes(), 0, data.getBytes().length);
				
				byte[] b = new byte[1024];
				int n = is.read(b);
				String contentToRead = new String(b, 0, n);
				Thread.sleep(3000);
			}
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
				os.close();
				socket.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}