package com.localhost.service;

import com.localhost.model.UserInfo;

public interface IUserService {
	public UserInfo findUserByLoginId(String loginId);

	public Object[] findUserAllInfoByLoginId(String loginId);

}
