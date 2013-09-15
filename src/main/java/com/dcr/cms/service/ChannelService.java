package com.dcr.cms.service;

import java.util.List;

import com.dcr.cms.entity.Channel;
import com.dcr.cms.util.Result;

public interface ChannelService {

	Result add(Channel channel);

	Result delete(Long id);

	Result modify(Channel channel);

	Channel getById(Long id);
	
	List<Channel> getByParentId(Long parentId);

	List<Channel> getAll();
}
