package com.dcr.cms.dao;

import java.util.List;

import com.dcr.cms.entity.UserGroup;

@MyBatisDao
public interface UserGroupDao extends BaseDao<UserGroup> {

	UserGroup getByGroupName(String groupName);

	List<UserGroup> getAll();
}
