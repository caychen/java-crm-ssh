package org.com.cay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.cay.dao.IVisitorDao;
import org.com.cay.entity.PageBean;
import org.com.cay.entity.Visitor;
import org.com.cay.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements IVisitorService {

	@Autowired
	private IVisitorDao visitorDao;

	@Override
	public PageBean<Visitor> findByPage(Visitor model, Integer pageCode, Integer pageSize) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("from Visitor where 1 = 1");
		
		List<Object> params = new ArrayList<Object>();
		
		if(params.size() > 0){
			Object[] objs = new Object[params.size()];
			return visitorDao.findPageList(sb.toString(), pageCode, pageSize, params.toArray(objs));
		} else {
			return visitorDao.findPageList(sb.toString(), pageCode, pageSize);
		}
	}
}
