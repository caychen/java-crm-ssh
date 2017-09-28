package org.com.cay.service.impl;

import org.com.cay.dao.IUserDao;
import org.com.cay.entity.User;
import org.com.cay.service.IUserService;
import org.com.cay.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User checkCode(String userCode) {
		// TODO Auto-generated method stub
		String hql = "from User where userCode = ?";
		return userDao.findObject(hql, userCode);
	}

	@Override
	public void save(User model) {
		// TODO Auto-generated method stub
		// 获取密码
		String pwd = model.getUserPassword();
		// md5加密
		model.setUserPassword(MD5Utils.md5(pwd));
		// 用户状态
		model.setUserState("1");
		userDao.saveObject(model);
	}

	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		// 获取密码
		String pwd = model.getUserPassword();
		// md5加密
		model.setUserPassword(MD5Utils.md5(pwd));

		String hql = "from User where userCode = ? and userPassword = ? and userState = ?";
		// 查询
		return userDao.findObject(hql, model.getUserCode(), model.getUserPassword(), "1");
	}
}
