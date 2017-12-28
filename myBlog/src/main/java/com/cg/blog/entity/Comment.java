package com.cg.blog.entity;

import java.util.Date;

import com.cg.blog.entity.Blog;

import lombok.Getter;
import lombok.Setter;
/**
 * 评论内容类实体
 * @author root1
 * @date 2017年12月25日
 */
@Getter@Setter
public class Comment {

	  private Integer id;
	  /**
	   * 评论者ip
	   */
	  private String userIp;
	  /**
	   * 评论内容
	   */
	  private String content;
	  /**
	   * 评论日期
	   */
	  private Date commentDate; 
	  /**
	   * 审核状态  0待审核 1通过 2未通过
	   */
	  private Integer state;
	  /**
	   * 所评论博客
	   */
	  private Blog blog;
	  
	  public Comment() {
	  }

	public Comment(Integer id, String userIp, String content, Date commentDate, Integer state,
			com.cg.blog.entity.Blog blog) {
		this.id = id;
		this.userIp = userIp;
		this.content = content;
		this.commentDate = commentDate;
		this.state = state;
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userIp=" + userIp + ", content=" + content + ", commentDate=" + commentDate
				+ ", state=" + state + ", blog=" + blog + "]";
	}
	  
	  
}
