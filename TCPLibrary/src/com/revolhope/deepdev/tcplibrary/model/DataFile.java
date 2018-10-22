package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;

public class DataFile implements Serializable {

	private static final long serialVersionUID = 8299125296030896675L;
	private int id;
	private String filename;
	private String extension;
	private byte[] source;
	private long targetId;
	private long ownerId;
	private long timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public byte[] getSource() {
		return source;
	}
	public void setSource(byte[] source) {
		this.source = source;
	}
	public long getTargetId() {
		return targetId;
	}
	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
