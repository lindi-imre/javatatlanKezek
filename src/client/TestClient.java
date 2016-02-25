package client;

import java.io.File;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class TestClient
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Client started");
			Socket client = new Socket("localhost", 6666);
			System.out.println("Client connected");
			ObjectOutputStream streamToClient = new ObjectOutputStream(client.getOutputStream());

			HashMap<File, byte[]> testMap = new HashMap<>();
			testMap.put(new File("D:\\test\\test1.mp3"), new byte[128]);
			testMap.put(new File("D:\\test\\test2.mp3"), new byte[128]);
			testMap.put(new File("D:\\test\\test3.mp3"), new byte[128]);

			streamToClient.writeObject(testMap);
			client.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
