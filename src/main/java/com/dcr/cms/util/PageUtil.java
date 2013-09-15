package com.dcr.cms.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletRequest;

import com.dcr.cms.dao.BaseDao;
import com.dcr.cms.dao.query.PageQuery;

public class PageUtil {

	public static final String DEFAULT_QUERY_PARAM_PREFIX = "_";

	public static Map<String, Object> getQueryParams(ServletRequest request) {
		return getParametersStartingWith(request, DEFAULT_QUERY_PARAM_PREFIX);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
		Enumeration<String> paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}

	public static <T> Page<T> getPage(BaseDao<T> dao, Map<String, Object> queryParams) {
		Page<T> page = new Page<T>();
		if (queryParams.get("pageNum") == null || queryParams.get("pageSize") == null) {
			throw new IllegalArgumentException("pageNum:" + queryParams.get("pageNum") + ",pageSize:"
					+ queryParams.get("pageSize"));
		}
		page.setPageNum((Integer) queryParams.get("pageNum"));
		page.setPageSize((Integer) queryParams.get("pageSize"));
		long count = dao.queryCount(queryParams);
		if (count > 0) {
			page.setResultList(dao.query(queryParams));
		}

		return page;
	}

	public static <T> Page<T> getPage(BaseDao<T> dao, PageQuery query) {
		Page<T> page = new Page<T>();
		page.setPageNum(query.getPageNum());
		page.setPageSize(query.getPageSize());
		long count = dao.queryCount(query);
		page.setTotalCount(count);
		if (count > 0) {
			page.setResultList(dao.query(query));
		}

		return page;
	}
}
