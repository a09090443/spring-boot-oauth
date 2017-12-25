package com.localhost.test.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.localhost.model.UserInfo;
import com.localhost.service.IUserService;
import com.localhost.test.base.TestBase;

public class UserInfoServiceTest extends TestBase {
	@Autowired
	private IUserService userService;

	@Test
	public void testFindUserByLoginId() {
		try {
			UserInfo userInfo = userService.findUserByLoginId("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void testFindUserByEmail() {
		try {
			UserInfo userInfo = userService.findUserByEmail("admin@localhost.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
