package org.com.cay.dao.impl;

import org.com.cay.dao.IUserDao;
import org.com.cay.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

}
