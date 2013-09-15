package com.dcr.cms.service;

import java.util.List;

import com.dcr.cms.dao.query.UserGroupQuery;
import com.dcr.cms.entity.UserGroup;
import com.dcr.cms.util.Page;
import com.dcr.cms.util.Result;

public interface UserGroupService {

	Result add(UserGroup userGroup);

	Result delete(Long id);

	Result modify(UserGroup userGroup);

	UserGroup getById(Long id);
	
	List<UserGroup> getAll();

	Page<UserGroup> query(UserGroupQuery query);
}
