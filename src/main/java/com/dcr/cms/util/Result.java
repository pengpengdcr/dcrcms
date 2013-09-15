package com.dcr.cms.util;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private boolean success = false;

	private String message;

	private Map<String, Object> resultPayLoad = new HashMap<String, Object>();

	public void addPayLoad(String key, Object value) {
		resultPayLoad.put(key, value);
	}

	public Object getPayLoad(String key) {
		return resultPayLoad.get(key);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getResultPayLoad() {
		return resultPayLoad;
	}

	public void setResultPayLoad(Map<String, Object> resultPayLoad) {
		this.resultPayLoad = resultPayLoad;
	}
}
