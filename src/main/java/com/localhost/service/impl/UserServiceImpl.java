package com.localhost.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.localhost.dao.IUserInfoDAO;
import com.localhost.model.UserInfo;
import com.localhost.service.IUserService;


@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserInfoDAO userInfoDAO;

	@Override
	public UserInfo findUserByLoginId(String loginId) {
		UserInfo userInfo = userInfoDAO.findUserByLoginId(loginId);
		return userInfo;
	}

	@Override
	public Object[] findUserAllInfoByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

}
