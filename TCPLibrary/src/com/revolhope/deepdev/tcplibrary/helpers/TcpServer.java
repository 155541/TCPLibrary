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
	
	private static ServerSocket serv;
	
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
		 * @param outputStream OutputStream from current socket.
		 */
		void response(Packet obj, InetAddress addr, int port, ObjectOutputStream output);
	}

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
		ObjectInputStream input;
		ObjectOutputStream output;
		
		input = new ObjectInputStream(socket.getInputStream());
		Object o = input.readObject();
		Packet responsePacket = callback.process((Packet) o);
		
		output = new ObjectOutputStream(socket.getOutputStream());
		callback.response(responsePacket, socket.getInetAddress(), socket.getPort(), output);
		
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
}
