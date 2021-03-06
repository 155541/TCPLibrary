package com.revolhope.deepdev.tcplibrary.helpers.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.revolhope.deepdev.tcplibrary.model.Packet;

public class TcpServer
{
	
	private static ServerSocket serv;
	
	private TcpServer() {}
	
	/**
	 * 
	 * @param port
	 * @throws IOException
	 */
	public static void bind(int port) throws IOException
	{
		serv = new ServerSocket(port);
	}
	
	/***
	 * Method to listen communications between the server and clients. 
	 * @param callback OnReceive callback to implement.
	 * @throws IOException 
	 * @throws ClassNotFoundException
	 */
	public static void listen(OnReceive callback) throws IOException, ClassNotFoundException
	{
		Socket socket = serv.accept();
		InetAddress clientAddr = socket.getInetAddress();
		ObjectInputStream input;
		ObjectOutputStream output;
		
		input = new ObjectInputStream(socket.getInputStream());
		Object o = input.readObject();
		
		Packet responsePacket = callback.process((Packet) o, clientAddr);
		
		output = new ObjectOutputStream(socket.getOutputStream());
		callback.response(responsePacket, clientAddr, socket.getPort(), output);
		
		input.close();
		output.close();
		socket.close();
	}
	
	/***
	 * Method to send a packet.
	 * @param packet Object to send
	 * @param addr InetAddress of the client.
	 * @param port Port of the communications.
	 * @param outputStream OutputStream from current socket
	 * @throws IOException
	 */
	public static void send(Packet packet, InetAddress addr, int port, ObjectOutputStream output) throws IOException
	{
		output.writeObject(packet);
		output.flush();
	}

	/**
	 * Method to transmit packet, it create it's own threat.
	 * @param packet Object to send
	 * @param addr InetAddress of the Client
	 * @param port Port of the communications
	 * @throws IOException
	 */
	public static void transmit(Packet packet, InetAddress addr, int port)
	{
		new Thread(new Runnable() {
			@Override
			public void run() {
				try 
				{
					Socket socket = new Socket(addr, port);
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					output.writeObject(packet);
					output.flush();
					output.close();
					socket.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
}
