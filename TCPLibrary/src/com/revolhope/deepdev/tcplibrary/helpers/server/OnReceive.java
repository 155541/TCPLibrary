package com.revolhope.deepdev.tcplibrary.helpers.server;

import java.io.ObjectOutputStream;
import java.net.InetAddress;

import com.revolhope.deepdev.tcplibrary.model.Packet;

/***
 * Callback to handle when packet is received. Provide two methods, to process incoming packets and to response to this client.
 * @author storm 
 */
public interface OnReceive {
	/***
	 * Method to process incoming packet. To implement at call method "listen()".
	 * @param obj Packet received.
	 * @param addr InetAddress of the client.
	 * @return Packet object generated once is processed the original packet.
	 */
	Packet process(Packet obj, InetAddress addr);
	
	/***
	 * Method to response to the client who send the packet.
	 * @param obj Packet to send to client.
	 * @param addr InetAddress of the client.
	 * @param port Port of the socket.
	 * @param outputStream OutputStream from current socket.
	 */
	void response(Packet obj, InetAddress addr, int port, ObjectOutputStream output);
}
