package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//File Name GreetingServer.java
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerTestTwo
{
	private ServerSocket serverSocket;

	public ServerTestTwo(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		// serverSocket.setSoTimeout(90000); for timeout remove comment
	}

	public void run()
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

				// Get stream from client and print out
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());

				// Send data to client and close the server
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
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
			ServerTestTwo test = new ServerTestTwo(port);
			test.run();
			// Thread t = new ServerTestTwo(port);
			// t.start();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}