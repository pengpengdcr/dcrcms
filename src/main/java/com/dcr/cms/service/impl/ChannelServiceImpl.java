package com.dcr.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dcr.cms.dao.ChannelDao;
import com.dcr.cms.entity.Channel;
import com.dcr.cms.service.ChannelService;
import com.dcr.cms.util.Result;

@Transactional
@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelDao channelDao;

	@Override
	public Result add(Channel channel) {
		Result result = new Result();
		Channel temp = channelDao.getByParentIdAndName(channel.getParent().getId(), channel.getName());
		if (temp != null) {
			result.setMessage("栏目名已被使用！");
			return result;
		}
		temp = channelDao.getByParentIdAndPath(channel.getParent().getId(), channel.getPath());
		if (temp != null) {
			result.setMessage("栏目路径已被使用！");
			return result;
		}
		channelDao.add(channel);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result delete(Long id) {
		Result result = new Result();
		List<Channel> list = channelDao.getByParentId(id);
		if (CollectionUtils.isEmpty(list)) {
			result.setMessage("该栏目下存在子栏目，不允许删除！");
			return result;
		}
		channelDao.delete(id);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Result modify(Channel channel) {
		Result result = new Result();
		Channel temp = channelDao.getByParentIdAndName(channel.getParent().getId(), channel.getName());
		if (temp != null && !temp.equals(channel)) {
			result.setMessage("栏目名已被使用！");
			return result;
		}
		temp = channelDao.getByParentIdAndPath(channel.getParent().getId(), channel.getPath());
		if (temp != null && !temp.equals(channel)) {
			result.setMessage("栏目路径已被使用！");
			return result;
		}
		channelDao.update(channel);
		result.setSuccess(true);
		return result;
	}

	@Override
	public Channel getById(Long id) {
		return channelDao.getById(id);
	}

	@Override
	public List<Channel> getByParentId(Long parentId) {
		return channelDao.getByParentId(parentId);
	}

	@Override
	public List<Channel> getAll() {
		return channelDao.getAll();
	}

	public ChannelDao getChannelDao() {
		return channelDao;
	}

	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
}
