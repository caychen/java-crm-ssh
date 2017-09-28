package org.com.cay.dao.impl;

import org.com.cay.dao.ICustomerDao;
import org.com.cay.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 * 
 * @author Administrator
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao {

	@Override
	public Object deleteObject(Customer t) {
		// TODO Auto-generated method stub
		String filePath = t.getFilePath();
		super.deleteObject(t);
		return filePath;
	}

}
