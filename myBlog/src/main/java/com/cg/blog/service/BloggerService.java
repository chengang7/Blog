package com.cg.blog.service;

import com.cg.blog.entity.Blogger;

/**
 * 博主服务层类
 * @author root1
 * @date 2017年12月22日
 */
public interface BloggerService {
	/**
	 * 查询博主信息
	 * @return
	 */
	Blogger getBloggerData();
	
	/**
	 * 通过用户名查询博主信息
	 * @param userName
	 * @return
	 */
	Blogger getByUserName(String userName);
	
	/**
	 * 更新博主信息
	 * @param blogger
	 * @return
	 */
	Integer update(Blogger blogger);
	
	/**
	 * 检查是否登录
	 * @param blogger
	 * @return
	 */
	Boolean checkOut(Blogger blogger);
}
