package com.dcr.cms.dao;

import java.util.List;

import com.dcr.cms.entity.Channel;

@MyBatisDao
public interface ChannelDao extends BaseDao<Channel> {

	List<Channel> getByParentId(Long parentId);

	Channel getByParentIdAndName(Long parentId, String name);

	Channel getByParentIdAndPath(Long parentId, String path);

	List<Channel> getAll();
}
