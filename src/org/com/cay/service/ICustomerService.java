package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.Customer;
import org.com.cay.entity.PageBean;

public interface ICustomerService {

	public void save(Customer customer);

	public PageBean<Customer> findByPage(Customer customer, Integer pageNum, Integer pageSize);

	public String delete(Customer customer);

	public Customer findById(Long custId);

	public void update(Customer model);

	public List<Customer> listAll();

}
