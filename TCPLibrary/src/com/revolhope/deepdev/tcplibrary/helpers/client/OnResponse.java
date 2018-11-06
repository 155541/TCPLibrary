package com.revolhope.deepdev.tcplibrary.helpers.client;

import com.revolhope.deepdev.tcplibrary.model.Packet;

public interface OnResponse 
{
	void responseReceived(Packet packet);
}
