package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;

public class Packet implements Serializable
{
	private static final long serialVersionUID = -3840210947728274569L;
	private Header header;
	private Serializable body;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Serializable getBody() {
		return body;
	}
	public void setBody(Serializable body) {
		this.body = body;
	}
}
