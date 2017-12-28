package com.cg.blog.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
/**
 * 博客类型实体
 * @author root1
 * @date 2017年12月25日
 */
@Getter@Setter
public class BlogType implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
		private Integer id;
	    private String typeName;
	    private Integer orderNum;
	    private Integer blogCount;
	    
	    public BlogType() {
	    }
	    
	    public BlogType(Integer id, String typeName, Integer orderNum, Integer blogCount) {
	        this.id = id;
	        this.typeName = typeName;
	        this.orderNum = orderNum;
	        this.blogCount = blogCount;
	    }

	    public BlogType(String typeName, Integer orderNum, Integer blogCount) {
	        this.typeName = typeName;
	        this.orderNum = orderNum;
	        this.blogCount = blogCount;
	    }

	    public BlogType(Integer id, String typeName, Integer orderNum) {
	        this.id = id;
	        this.typeName = typeName;
	        this.orderNum = orderNum;
	    }

	    public BlogType(String typeName, Integer orderNum) {
	        this.typeName = typeName;
	        this.orderNum = orderNum;
	    }

		@Override
		public String toString() {
			return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNum=" + orderNum + ", blogCount="
					+ blogCount + "]";
		}
	    
}
