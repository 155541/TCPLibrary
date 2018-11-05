package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;

public class DataFile implements Serializable {

	private static final long serialVersionUID = 8299125296030896675L;
	private long id;
	private String filename;
	private String extension;
	private byte[] source;
	private long targetId;
	private long originId;
	private long requestTimestamp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getOriginId() {
		return originId;
	}
	public void setOriginId(long ownerId) {
		this.originId = ownerId;
	}
	public long getTimestamp() {
		return requestTimestamp;
	}
	public void setTimestamp(long timestamp) {
		this.requestTimestamp = timestamp;
	}
}
