package com.cg.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blog.dao.BloggerDao;
import com.cg.blog.entity.Blogger;
import com.cg.blog.service.BloggerService;

/**
 * 博主服务层映射类
 * @author root1
 * @date 2017年12月22日
 */
@Service
public class BloggerServiceImpl implements BloggerService{
	
	@Autowired
	private BloggerDao bloggerDao;
	
	@Override
	public Blogger getBloggerData() {
		
		return bloggerDao.getBloggerData();
	}
	@Override
	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}
	@Override
	public Integer update(Blogger blogger) {
		
		return bloggerDao.update(blogger) ;
	}
	
	@Override
	public Boolean checkOut(Blogger blogger) {
		Boolean flag =false;
		List<Blogger> list = bloggerDao.findByUsernameAndPasswod(blogger.getUserName(), blogger.getPassword());
		if (list.size()>0) {
			flag=true;
		}
		return flag;
	}
}
