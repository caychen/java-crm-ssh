package org.com.cay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.cay.dao.ILinkmanDao;
import org.com.cay.entity.Customer;
import org.com.cay.entity.Linkman;
import org.com.cay.entity.PageBean;
import org.com.cay.service.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkmanServiceImpl implements ILinkmanService {

	@Autowired
	private ILinkmanDao linkmanDao;

	@Override
	public PageBean<Linkman> findByPage(Linkman model, Integer pageCode, Integer pageSize) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("from Linkman where 1 = 1");
		
		List<Object> params = new ArrayList<Object>();
		
		String linkmanName = model.getLkmName();
		if(linkmanName != null && !linkmanName.trim().isEmpty()){
			sb.append(" and lkmName like ?");
			params.add("%" + linkmanName.trim() + "%");
		}
		
		Customer customer = model.getCustomer();
		if(customer != null && customer.getCustId() != null){
			sb.append(" and customer.custId = ?");
			params.add(customer.getCustId());
		}
		
		if(params.size() > 0){
			Object[] objs = new Object[params.size()];
			return linkmanDao.findPageList(sb.toString(), pageCode, pageSize, params.toArray(objs));
		} else {
			return linkmanDao.findPageList(sb.toString(), pageCode, pageSize);
		}
	}

	@Override
	public Linkman findById(Long lkmId) {
		// TODO Auto-generated method stub
		return linkmanDao.findObject(Linkman.class, lkmId);
	}

	@Override
	public void update(Linkman model) {
		// TODO Auto-generated method stub
		linkmanDao.updateObject(model);
	}

	@Override
	public void delete(Linkman model) {
		// TODO Auto-generated method stub
		linkmanDao.deleteObject(model);
	}
}
