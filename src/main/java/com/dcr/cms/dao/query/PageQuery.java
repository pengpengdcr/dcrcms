package com.dcr.cms.dao.query;

public class PageQuery {

	public static final int DEFAULT_PAGE_SIZE = 20;

	private int pageNum = 1;

	private int pageSize = DEFAULT_PAGE_SIZE;

	public int getLimit() {
		return (pageNum - 1) * pageSize;
	}

	public int getOffset() {
		return pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
