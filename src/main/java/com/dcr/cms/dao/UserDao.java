package com.dcr.cms.dao;

import com.dcr.cms.entity.User;

@MyBatisDao
public interface UserDao extends BaseDao<User>{
	
	User getByUserName(String userName);
}
