package com.dcr.cms.enums;

public enum UserStatus {

	ACTIVE("活动"),

	FREEZE("冻结"),

	;

	private String description;

	private UserStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
