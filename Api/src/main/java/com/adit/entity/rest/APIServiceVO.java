package com.adit.entity.rest;

import java.io.Serializable;
import java.util.ArrayList;

import com.adit.util.AppConstatnt;

public class APIServiceVO implements Serializable {

	private static final long serialVersionUID = -3608660223448269470L;

	private int appStatusCode = AppConstatnt.APP_STATUS_CODE_SUCCESS;
	private String payload = null;

	private ArrayList<String> messages = new ArrayList<>();
	private String apiCall = "";

	public APIServiceVO() {
		super();
	}

	public APIServiceVO(String apiCall) {
		super();
		this.apiCall = apiCall;
	}

	public String getApiCall() {
		return apiCall;

	}

	public int getAppStatusCode() {
		return appStatusCode;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public String getPayload() {
		return payload;
	}

	public void setApiCall(String apiCall) {
		this.apiCall = apiCall;
	}

	public void setAppStatusCode(int appStatusCode) {
		this.appStatusCode = appStatusCode;
	}

	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
