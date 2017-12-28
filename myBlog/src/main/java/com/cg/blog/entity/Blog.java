package com.cg.blog.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
/**
 * 博客实体
 * @author root1
 * @date 2017年12月25日
 */
@Getter@Setter
public class Blog {
	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickHit;
	private Integer replyHit;
	private String content;
	/**
	 * 不带标签的博客内容，用于Lucene索引中
	 */
	private String contentNoTag;
	/**
	 * 关键字，用空格隔开
	 */
	private String keyWord;
	
	/**
	 * 博客类型
	 */
	private BlogType blogType;
	/**
	 * 博客数量，非博客实际属性，用于根据发布日期归档查询
	 */
	private Integer blogCount;
	/**
	 * 发布日期的字符串，只取年月
	 */
	private String releaseDateStr;
	/**
	 * 博客里存的图片，主要用于展示缩略图
	 */
	private List<String> imageList = new LinkedList<String>();
}
