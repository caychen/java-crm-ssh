package org.com.cay.service;

import org.com.cay.entity.Linkman;
import org.com.cay.entity.PageBean;

public interface ILinkmanService {

	PageBean<Linkman> findByPage(Linkman model, Integer pageCode, Integer pageSize);

	Linkman findById(Long lkmId);

	void update(Linkman model);

	void delete(Linkman model);

}
