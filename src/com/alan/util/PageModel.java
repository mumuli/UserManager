package com.alan.util;

public class PageModel {
	private int page = 1;
	private int pageSize = 20;
	private long totalCount;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page < 0) {			
			this.page = page;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public long getTotalCount() {
		return totalCount;
	}
	public int getPageCount() {
		int pageCount = (int)totalCount / pageSize;
		if (totalCount % pageSize != 0) {
			pageCount += 1;
		}
		return pageCount;
	}
}
