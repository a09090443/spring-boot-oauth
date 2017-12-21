package com.localhost.dao;

import com.localhost.base.dao.BaseHibernateDAO;
import com.localhost.model.UserInfo;

public interface IUserInfoDAO extends BaseHibernateDAO<UserInfo> {
	
	public UserInfo findUserByUsername(String username);
	
	public UserInfo findUserByLoginId(String loginId);
	
}
