package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;

public class Header implements Serializable 
{
	private static final long serialVersionUID = 7092998169043400874L;
	private Type type;
	private long deviceId;
	private Token token;
	private long timestamp;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
