package org.com.cay.dao;

import java.io.Serializable;
import java.util.List;

import org.com.cay.entity.PageBean;

public interface IBaseDao<T> {

	public T findObject(String hql);

	public T findObject(String hql, Object... params);

	public T findObject(Class<T> cls, Serializable id);

	public T findObjectBySql(String sql);

	public T findObjectBySql(String sql, Object... params);

	public List<T> findList(String hql);

	public List<T> findList(String hql, Object... params);

	public List<T> findList(Class<T> cls);

	public List<T> findListBySql(String sql);

	public List<T> findListBySql(String sql, Object... params);

	public void saveObject(T t);

	public Object deleteObject(T t);

	public void updateObject(T t);

	public void saveOrUpdateObject(T t);

	public int executeSql(String sql);

	public int executeSql(String sql, Object... params);

	public int countObject(String hql);

	public int countObject(String hql, Object... params);

	public PageBean<T> findPageList(String hql, Integer pageCode, Integer pageSize);

	public PageBean<T> findPageList(String hql, Integer pageCode, Integer pageSize, Object... params);

}
