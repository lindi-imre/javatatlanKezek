package server;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
<<<<<<< HEAD
=======
import java.io.ObjectOutputStream;
>>>>>>> origin/master
//File Name GreetingServer.java
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Server
{
	private ServerSocket serverSocket;

	public Server(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		// serverSocket.setSoTimeout(90000); for timeout remove comment
	}

	@SuppressWarnings("unchecked")
<<<<<<< HEAD
	public void run() throws ClassNotFoundException
=======
	public void run() throws Exception
>>>>>>> origin/master
	{
		while (true)

		{
			try
			{
				// Create server and waiting for a client
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				// When client connected print this text
				System.out.println("Client connected to " + server.getRemoteSocketAddress());

<<<<<<< HEAD
				ObjectInputStream streamFromServer = new ObjectInputStream(server.getInputStream());
				HashMap<File, byte[]> testMap = new HashMap<>();
				testMap = (HashMap<File, byte[]>) streamFromServer.readObject();
				for (Entry<File, byte[]> entry : testMap.entrySet())
				{
					File key = entry.getKey();
					byte[] value = entry.getValue();
					System.out.println(key + " " + value);
				}
				streamFromServer.close();
=======
				// Getting object from client
				ObjectInputStream streamFromClient = new ObjectInputStream(server.getInputStream());
				ObjectOutputStream steamToClient = new ObjectOutputStream(server.getOutputStream());

				HashMap<File, byte[]> unsortedList = new HashMap<File, byte[]>();
				unsortedList = (HashMap<File, byte[]>) streamFromClient.readObject();

				for (Entry<File, byte[]> entry : unsortedList.entrySet())
				{
					File key = entry.getKey();
					byte[] value = entry.getValue();

					System.out.println(entry.toString());
				}
>>>>>>> origin/master

				server.close();

			} catch (SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		int port = 6666;
		try
		{
			System.out.println("start server");

			// Create server and run
			Server test = new Server(port);
			test.run();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}