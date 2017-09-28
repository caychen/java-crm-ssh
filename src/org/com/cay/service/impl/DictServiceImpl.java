package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.IDictDao;
import org.com.cay.entity.Dict;
import org.com.cay.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements IDictService {

	@Autowired
	private IDictDao dictDao;

	@Override
	public List<Dict> findAll(String hql, Object... params) {
		// TODO Auto-generated method stub
		return dictDao.findList(hql, params);
	}
}
