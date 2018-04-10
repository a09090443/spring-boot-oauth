package com.localhost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.model.UserInfo;
import com.localhost.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/getAllUsers")
	public List<UserInfo> getAllUsers() throws Exception {
		List<UserInfo> userInfoList = userService.findAllUsers();
		return userInfoList;
	}

	@PostMapping("/addUser")
	public void addUser(@ModelAttribute("userInfo") UserInfo userInfo) throws Exception {
		userService.addUser(userInfo);
	}
}
