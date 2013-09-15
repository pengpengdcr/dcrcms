package com.dcr.cms.util;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

	private static final int PAGE_SIZE = 20;

	private int pageNum = 1;

	private int pageSize = PAGE_SIZE;

	private long totalCount = 0;

	private List<T> resultList = new ArrayList<T>();

	public long getPageStart() {
		return (pageNum - 1) * pageSize + 1;
	}

	public long getPageEnd() {
		long pageEnd = pageNum * pageSize;
		if (pageEnd > totalCount) {
			pageEnd = totalCount;
		}
		return pageEnd;
	}

	public boolean forwardable() {
		if (pageNum <= 1) {
			return false;
		}
		return true;
	}

	public boolean backwardable() {
		if (pageNum >= getPageCount()) {
			return false;
		}
		return true;
	}

	public List<Integer> getSlider(int count) {
		List<Integer> slider = new ArrayList<Integer>();

		return slider;
	}

	public long getPageCount() {
		long totalPages = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			totalPages += 1;
		}
		return totalPages;
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

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
