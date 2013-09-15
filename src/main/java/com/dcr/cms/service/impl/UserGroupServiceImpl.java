package com.dcr.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcr.cms.dao.UserGroupDao;
import com.dcr.cms.dao.query.UserGroupQuery;
import com.dcr.cms.entity.UserGroup;
import com.dcr.cms.service.UserGroupService;
import com.dcr.cms.util.Page;
import com.dcr.cms.util.PageUtil;
import com.dcr.cms.util.Result;

@Transactional
@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {
	
	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public Result add(UserGroup userGroup) {
		Result result = new Result();
		UserGroup temp = userGroupDao.getByGroupName(userGroup.getGroupName());
		if (temp != null) {
			result.setMessage("用户组名已被使用！");
			return result;
		}
		userGroupDao.add(userGroup);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result delete(Long id) {
		Result result = new Result();
		userGroupDao.delete(id);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result modify(UserGroup userGroup) {
		Result result = new Result();
		UserGroup temp = userGroupDao.getByGroupName(userGroup.getGroupName());
		if (temp != null && !temp.equals(userGroup)) {
			result.setMessage("用户名已被使用！");
			return result;
		}
		userGroupDao.update(userGroup);
		result.setSuccess(true);
		return result;
	}

	@Override
	public UserGroup getById(Long id) {
		return userGroupDao.getById(id);
	}

	@Override
	public List<UserGroup> getAll() {
		return userGroupDao.getAll();
	}

	@Override
	public Page<UserGroup> query(UserGroupQuery query) {
		return PageUtil.getPage(userGroupDao, query);
	}

	public UserGroupDao getUserGroupDao() {
		return userGroupDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao) {
		this.userGroupDao = userGroupDao;
	}
}
