package org.com.cay.service;

import org.com.cay.entity.User;

public interface IUserService {

	User checkCode(String userCode);

	void save(User model);

	User login(User model);

}
