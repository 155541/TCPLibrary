package com.revolhope.deepdev.tcplibrary.model;

import java.io.Serializable;

public enum Code implements Serializable
{
	REQ_INIT,
	REQ_GET_DEV_CONN,
	REQ_OPEN_SESSION,
	REQ_TRANSMISSION,
	REQ_PENDING_FILES,
	REQ_DELETE_FILES,
	REQ_CLOSE_SESSION,
	
	RES_OK,
	RES_ERROR_IO,
	RES_ERROR_SQL,
	RES_ERROR_NAME_IN_USE,
}
