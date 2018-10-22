package com.revolhope.deepdev.tcplibrary.helpers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.revolhope.deepdev.tcplibrary.model.Packet;

public class TcpClient 
{
	
	public interface OnResponse
	{
		void responseReceived(Packet packet);
	}
	
	private TcpClient() {}
	
	public static void send(Packet packet, InetAddress addr, int port, OnResponse callback) throws IOException, ClassNotFoundException
	{
		Socket socket = new Socket(addr, port);
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(packet);
		out.flush();
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Packet response = (Packet) in.readObject();
		in.close();
		
		callback.responseReceived(response);
		socket.close();
	}
}
