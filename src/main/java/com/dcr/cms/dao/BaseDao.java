package com.dcr.cms.dao;

import java.util.List;
import java.util.Map;

import com.dcr.cms.dao.query.PageQuery;

public interface BaseDao<T> {

	List<T> query(Map<String, Object> queryParams);

	Long queryCount(Map<String, Object> queryParams);

	List<T> query(PageQuery query);

	Long queryCount(PageQuery query);

	T getById(Long id);

	Long add(T entity);

	void delete(Long id);

	void update(T entity);
}
