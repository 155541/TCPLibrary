package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

public class Token implements Serializable {

	
	private static final long serialVersionUID = -558800336019028763L;
	private long deviceId;
	private String token;
	private long expirationDate;
	
	/**
	 * 
	 * @param deviceId
	 * @param token
	 * @param expirationDate
	 */
	public Token(long deviceId, String token, long expirationDate)
	{
		this.deviceId = deviceId;
		this.token = token;
		this.expirationDate = expirationDate;
	}
	
	/**
	 * 
	 * @param deviceId
	 */
	public Token(long deviceId)
	{
		this.deviceId = deviceId;
		this.token = UUID.randomUUID().toString().replace("-", "");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 2);
		this.expirationDate = cal.getTimeInMillis();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isValid()
	{
		Calendar now = Calendar.getInstance();
		Calendar expiration = Calendar.getInstance();
		expiration.setTimeInMillis(expirationDate);
		return now.before(expiration);
	}
	
	/**
	 * 
	 */
	public void refresh()
	{
		this.token = UUID.randomUUID().toString().replace("-", "");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 2);
		this.expirationDate = cal.getTimeInMillis();
	}
	
	
	@Override
	public String toString() 
	{
		return this.token;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public long getDeviceId()
	{
		return this.deviceId;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getExpirationDate()
	{
		return this.expirationDate;
	}
}
