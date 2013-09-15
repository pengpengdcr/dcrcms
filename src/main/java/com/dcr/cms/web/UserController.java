package com.dcr.cms.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcr.cms.dao.query.UserQuery;
import com.dcr.cms.entity.User;
import com.dcr.cms.entity.UserGroup;
import com.dcr.cms.service.UserGroupService;
import com.dcr.cms.service.UserService;
import com.dcr.cms.util.Page;
import com.dcr.cms.util.Result;
import com.dcr.cms.web.form.UserForm;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserGroupService userGroupService;

	@RequestMapping(value = "/user/list.html", method = RequestMethod.GET)
	public String list(UserQuery query, Model model) {
		model.addAttribute("query", query);
		Page<User> userList = userService.query(query);
		model.addAttribute("page", userList);

		List<UserGroup> userGroupList = userGroupService.getAll();
		model.addAttribute("userGroupList", userGroupList);

		return "user/list";
	}

	@RequestMapping(value = "/user/view.html", method = RequestMethod.GET)
	public String view(Model model, Long id) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		return "user/view";
	}

	@RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
	public String goAdd(Model model) {
		List<UserGroup> userGroupList = userGroupService.getAll();
		model.addAttribute("userGroupList", userGroupList);
		return "redirect:user/add";
	}

	@RequestMapping(value = "/user/add.json", method = RequestMethod.POST)
	public String add(Model model, UserForm form) {
		User user = convertToEntity(form);
		Result result = userService.add(user);
		model.addAttribute("result", result);
		return "redirect:user/list";
	}

	@RequestMapping(value = "/user/modify.html", method = RequestMethod.GET)
	public String modify(Model model, UserForm form) {
		User user = convertToEntity(form);
		Result result = userService.modify(user);
		model.addAttribute("result", result);
		return "redirect:user/list";
	}

	private User convertToEntity(UserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		UserGroup userGroup = new UserGroup();
		userGroup.setId(form.getUserGroupId());
		user.setUserGroup(userGroup);
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
