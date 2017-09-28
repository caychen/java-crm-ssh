package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.Dict;

public interface IDictService {

	List<Dict> findAll(String hql, Object... params);

}
