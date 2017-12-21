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

	@Test
	public void testFindUserInfoByLoginId() {
		try {
			UserInfo user2 = userInfoDAO.findUserByUsername("admin");
			System.out.println(user2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
