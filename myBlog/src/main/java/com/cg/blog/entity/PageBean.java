package com.cg.blog.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
/**
 * 分页显示类实体
 * @author root1
 * @date 2017年12月25日
 * @param <T>
 */
@Getter@Setter
public class PageBean<T> {
	/**
	 * 当前页数
	 */
	private int currPage;
	/**
	 * 每页显示的个数
	 */
	private int pageSize;
	/**
	 * 总记录数
	 */
	private long total;
	private int start;
	private int end;
	/**
	 * 分页查询的结果
	 */
	private List<T> result;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	 PageBean(){

	    }
	 
	 public PageBean(int currPage, int pageSize) {
	        this.currPage = currPage;
	        this.pageSize = pageSize;
	        this.start = (currPage-1)*pageSize;
	        this.end = currPage*pageSize;
	    }

	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", total=" + total + ", start=" + start
				+ ", end=" + end + ", result=" + result + ", map=" + map + "]";
	}
	 
}
