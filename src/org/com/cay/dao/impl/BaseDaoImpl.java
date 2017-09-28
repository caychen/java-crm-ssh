package org.com.cay.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.com.cay.dao.IBaseDao;
import org.com.cay.entity.PageBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {

	/*
	 * private Class<T> clazz;
	 * 
	 * @SuppressWarnings("unchecked") public BaseDaoImpl() { // TODO
	 * Auto-generated constructor stub // this表示的子类，c表示子类的Class对象 Class<?
	 * extends BaseDaoImpl> c = this.getClass();
	 * 
	 * // 第2步：获取到是BaseDaoImpl Type type = c.getGenericSuperclass();
	 * 
	 * // 目的：把type接口转换成子接口 if (type instanceof ParameterizedType) {
	 * ParameterizedType ptype = (ParameterizedType) type;
	 * 
	 * // 获取泛型的类型，也可能是数组 Type[] types = ptype.getActualTypeArguments();
	 * this.clazz = (Class<T>) types[0]; } }
	 */

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveObject(T t) {
		// TODO Auto-generated method stub
		this.getSession().save(t);
	}

	@Override
	public Object deleteObject(T t) {
		// TODO Auto-generated method stub
		this.getSession().delete(t);
		return null;
	}

	@Override
	public void updateObject(T t) {
		// TODO Auto-generated method stub
		this.getSession().update(t);
	}

	@Override
	public T findObject(Class<T> cls, Serializable id) {
		// TODO Auto-generated method stub
		return this.getSession().get(cls, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<T> findPageList(String hql, Integer pageCode, Integer pageSize) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createQuery(hql);
		return findPageList(query, pageCode, pageSize);
	}

	private PageBean<T> findPageList(Query<T> query, Integer pageCode, Integer pageSize) {
		// TODO Auto-generated method stub
		List<T> list = query.getResultList();
		if (list != null) {
			int totalCount = list.size();
			query.setFirstResult((pageCode - 1) * pageSize);
			query.setMaxResults(pageSize);
			return new PageBean<T>(pageCode, pageSize, totalCount, query.getResultList());
		} else {
			return null;
		}
	}

	@Override
	public T findObject(String hql) {
		// TODO Auto-generated method stub
		List<T> list = findList(hql);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public T findObject(String hql, Object... params) {
		// TODO Auto-generated method stub
		List<T> list = findList(hql, params);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public T findObjectBySql(String sql) {
		// TODO Auto-generated method stub
		List<T> list = findListBySql(sql);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public T findObjectBySql(String sql, Object... params) {
		// TODO Auto-generated method stub
		List<T> list = findListBySql(sql, params);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(String hql) {
		// TODO Auto-generated method stub
		return this.getSession().createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(String hql, Object... params) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createQuery(hql);
		setParameter(query, params);
		return query.getResultList();
	}

	private void setParameter(Query<T> query, Object[] params) {
		// TODO Auto-generated method stub
		for (int i = 0; i < params.length; ++i) {
			query.setParameter(i, params[i]);
		}
	}

	@Override
	public List<T> findList(Class<T> cls) {
		// TODO Auto-generated method stub
		return findList("from " + cls.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListBySql(String sql) {
		// TODO Auto-generated method stub
		return this.getSession().createNamedQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListBySql(String sql, Object... params) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createNamedQuery(sql);
		setParameter(query, params);
		return query.getResultList();
	}

	@Override
	public void saveOrUpdateObject(T t) {
		// TODO Auto-generated method stub
		this.getSession().saveOrUpdate(t);
	}

	@Override
	public int executeSql(String sql) {
		// TODO Auto-generated method stub
		return this.getSession().createNamedQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int executeSql(String sql, Object... params) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createNamedQuery(sql);
		setParameter(query, params);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countObject(String hql) {
		// TODO Auto-generated method stub
		List<T> list = this.getSession().createQuery(hql).getResultList();
		return list == null ? 0 : list.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countObject(String hql, Object... params) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createQuery(hql);
		setParameter(query, params);
		List<T> list = query.getResultList();
		return list == null ? 0 : list.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<T> findPageList(String hql, Integer pageCode, Integer pageSize, Object... params) {
		// TODO Auto-generated method stub
		Query<T> query = this.getSession().createQuery(hql);
		setParameter(query, params);
		return findPageList(query, pageCode, pageSize);
	}

}
