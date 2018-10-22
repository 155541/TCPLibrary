package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;
import java.net.InetAddress;

public class Device implements Serializable {
	
	private static final long serialVersionUID = 6816324346965185941L;
	private long id;
	private String macAddress;
	private String name;
	private InetAddress currentInetAddress;
	private long createdDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InetAddress getCurrentInetAddress() {
		return currentInetAddress;
	}
	public void setCurrentInetAddress(InetAddress currentInetAddress) {
		this.currentInetAddress = currentInetAddress;
	}
	public long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}
}
