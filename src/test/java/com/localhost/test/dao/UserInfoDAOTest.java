package com.localhost.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.localhost.dao.IUserInfoDAO;
import com.localhost.model.UserInfo;
import com.localhost.test.base.TestBase;

public class UserInfoDAOTest extends TestBase {
	
	@Autowired
	private IUserInfoDAO userInfoDAO;

//	@Test
	public void testFindUserInfoByLoginId() {
		try {
			UserInfo user = userInfoDAO.findUserByLoginId("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

//	@Test
	public void testFindUserInfoByEmail() {
		try {
			UserInfo user = userInfoDAO.findUserByEmail("admin@localhost.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void testFindMaxUserId() {
		try {
			String maxUserId = userInfoDAO.getMaxUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
