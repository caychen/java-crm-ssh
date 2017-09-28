package org.com.cay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.cay.dao.ICustomerDao;
import org.com.cay.entity.Customer;
import org.com.cay.entity.Dict;
import org.com.cay.entity.PageBean;
import org.com.cay.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户的业务层
 * 
 * @author Administrator
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		customerDao.saveObject(customer);
	}

	/**
	 * 分页查询
	 */
	public PageBean<Customer> findByPage(Customer customer, Integer pageCode, Integer pageSize) {
		// 拼接hql
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sb.append("from Customer where 1 = 1");
		String custName = customer.getCustName();
		if (custName != null && !custName.trim().isEmpty()) {
			sb.append(" and custName like ? ");
			params.add("%" + custName.trim() + "%");
		}
		Dict level = customer.getLevel();
		if (level != null && !level.getId().trim().isEmpty()) {
			sb.append(" and level.id = ? ");
			params.add(level.getId().trim());
		}
		Dict source = customer.getSource();
		if (source != null && !source.getId().trim().isEmpty()) {
			sb.append(" and source.id = ? ");
			params.add(source.getId().trim());
		}
		if (params.size() > 0) {
			Object[] objs = new Object[params.size()];
			return customerDao.findPageList(sb.toString(), pageCode, pageSize, params.toArray(objs));
		} else {
			return customerDao.findPageList(sb.toString(), pageCode, pageSize);
		}

	}

	@Override
	public String delete(Customer customer) {
		// TODO Auto-generated method stub
		return (String) customerDao.deleteObject(customer);
	}

	@Override
	public Customer findById(Long custId) {
		// TODO Auto-generated method stub
		return customerDao.findObject(Customer.class, custId);
	}

	@Override
	public void update(Customer model) {
		// TODO Auto-generated method stub
		customerDao.updateObject(model);
	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return customerDao.findList(Customer.class);
	}
}
