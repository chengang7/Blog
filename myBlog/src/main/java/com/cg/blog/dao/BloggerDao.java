package com.cg.blog.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.blog.entity.Blogger;
/**
 * 博主dao接口
 * @author root1
 * @date 2017年12月22日
 */
@Repository 
public interface BloggerDao {
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
	/**
	 * 查找账号和密码的方法
	 * @param userName
	 * @param password
	 * @return
	 */
	List<Blogger> findByUsernameAndPasswod(String userName,String password);
}
