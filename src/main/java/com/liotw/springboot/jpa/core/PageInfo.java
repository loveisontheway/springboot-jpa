package com.liotw.springboot.jpa.core;

import java.util.List;

public class PageInfo<T> {

	/**
	 * @Fields totalPage : 总页数
	 */
	private int totalPage;
	/**
	 * @Fields pageSize : 页面显示条数
	 */
	private int pageSize;
	/**
	 * @Fields currentPageNumber : 当前页数
	 */
	private int currentPageNumber;
	/**
	 * @Fields records : 返回数据集
	 */
	private List<T> records;
	
	/**
	 * 总条数
	 */
	private Long totalNum;
	

	public Long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * @Title:  getRecords <BR>
	 * @Description: please write your description <BR>
	 * @return: List <BR>
	 */
	public List<T> getRecords() {
		return records;
	}
	/**
	 * @Title:  setRecords <BR>
	 * @Description: please write your description <BR>
	 * @return: List <BR>
	 */
	public void setRecords(List<T> records) {
		this.records = records;
	}
	/**
	 * @Title:  getTotalPage <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @Title:  setTotalPage <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @Title:  getPageSize <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @Title:  setPageSize <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @Title:  getCurrentPageNumber <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	/**
	 * @Title:  setCurrentPageNumber <BR>
	 * @Description: please write your description <BR>
	 * @return: int <BR>
	 */
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
}
