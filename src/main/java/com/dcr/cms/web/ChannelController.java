package com.dcr.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcr.cms.entity.Channel;
import com.dcr.cms.service.ChannelService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@RequestMapping(value = "/channel/list.html", method = RequestMethod.GET)
	public String getChannelList(ModelMap modelMap, Long parentId) {
		List<Channel> channelList = channelService.getAll();
		modelMap.addAttribute("channelList", channelList);
		return "channel/list";
	}

	public ChannelService getChannelService() {
		return channelService;
	}

	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}
}
