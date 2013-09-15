package com.dcr.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcr.cms.dao.UserDao;
import com.dcr.cms.dao.query.UserQuery;
import com.dcr.cms.entity.User;
import com.dcr.cms.service.UserService;
import com.dcr.cms.util.Page;
import com.dcr.cms.util.PageUtil;
import com.dcr.cms.util.Result;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Result add(User user) {
		Result result = new Result();
		User temp = userDao.getByUserName(user.getUserName());
		if (temp != null) {
			result.setMessage("用户名已被使用！");
			return result;
		}
		userDao.add(user);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result delete(Long id) {
		Result result = new Result();
		userDao.delete(id);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result modify(User user) {
		Result result = new Result();
		User temp = userDao.getByUserName(user.getUserName());
		if (temp != null && !temp.equals(user)) {
			result.setMessage("用户名已被使用！");
			return result;
		}
		userDao.update(user);
		result.setSuccess(true);
		return result;
	}

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public Page<User> query(UserQuery query) {
		return PageUtil.getPage(userDao, query);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
