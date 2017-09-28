package org.com.cay.service;

import org.com.cay.entity.PageBean;
import org.com.cay.entity.Visitor;

public interface IVisitorService {

	PageBean<Visitor> findByPage(Visitor model, Integer pageCode, Integer pageSize);

}
