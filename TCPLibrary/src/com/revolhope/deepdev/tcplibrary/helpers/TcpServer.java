package com.revolhope.deepdev.tcplibrary.helpers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.revolhope.deepdev.tcplibrary.model.Packet;

public class TcpServer
{
	/***
	 * Callback to handle when packet is received. Provide two methods, to process incoming packets and to response to this client.
	 * @author storm
	 */
	public interface OnReceive
	{
		/***
		 * Method to process incoming packet. To implement at call method "listen()".
		 * @param obj Packet received.
		 * @return Packet object generated once is processed the original packet.
		 */
		Packet process(Packet obj);
		
		/***
		 * Method to response to the client who send the packet.
		 * @param obj Packet to send to client.
		 * @param addr InetAddress of the client.
		 * @param port Port of the socket.
		 */
		void response(Packet obj, InetAddress addr, int port);
	}

	private TcpServer() {}
	
	/***
	 * Infinite-loop method to listen communications between the server and clients. 
	 * @param port Integer representing the port of the communications
	 * @param callback OnReceive callback to implement.
	 * @throws IOException 
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("resource")
	public static void listen(int port, OnReceive callback) throws IOException, ClassNotFoundException
	{
		ServerSocket serv = new ServerSocket(port);
		Socket socket = serv.accept();
		
		ObjectInputStream input;
		while(true)
		{
			input = new ObjectInputStream(socket.getInputStream());
			Object o = input.readObject();
			Packet responsePacket = callback.process((Packet) o);
			callback.response(responsePacket, socket.getInetAddress(), port);
			//input.close();
			//socket.close();
		}
		// serv.close();
	}
	
	/***
	 * Method to send a packet.
	 * @param packet Object to send
	 * @param addr InetAddress of the client.
	 * @param port Port of the communications.
	 * @throws IOException
	 */
	public static void send(Packet packet, InetAddress addr, int port) throws IOException
	{
		Socket socket = new Socket(addr, port);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		
		out.writeObject(packet);
		out.flush();
		out.close();
		socket.close();
	}
}
