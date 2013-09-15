package com.dcr.cms.service;

import com.dcr.cms.dao.query.UserQuery;
import com.dcr.cms.entity.User;
import com.dcr.cms.util.Page;
import com.dcr.cms.util.Result;

public interface UserService {

	Result add(User user);

	Result delete(Long id);

	Result modify(User user);

	User getById(Long id);

	Page<User> query(UserQuery query);
}
