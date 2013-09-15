package com.dcr.cms.dao.query;

public class UserGroupQuery extends PageQuery {

	private String groupName;

	private String description;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
