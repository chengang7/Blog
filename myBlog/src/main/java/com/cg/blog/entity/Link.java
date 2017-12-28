package com.cg.blog.entity;

import lombok.Getter;
import lombok.Setter;
/**
 * 友情链接实体类
 * @author root1
 * @date 2017年12月25日
 */
@Getter@Setter
public class Link {
	private Integer id;
	private String linkName;
	private String linkUrl;
	private Integer orderNum;
}
