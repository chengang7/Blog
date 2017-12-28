package com.cg.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blog.dao.BlogTypeDao;

import com.cg.blog.entity.BlogType;
import com.cg.blog.entity.PageBean;
import com.cg.blog.service.BlogTypeService;
/**
 * BlogTypeService映射类
 * @author cg
 * @date 2017年12月25日
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService{
	@Autowired
	private BlogTypeDao blogTypeDao;
	
	  public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
	        //查询分页结果
	        pageBean.setResult(blogTypeDao.listByPage(pageBean.getStart(),pageBean.getEnd()));
	        //查询记录总数
	        pageBean.setTotal(blogTypeDao.getTotal());
	        return pageBean;
	    }

	    public Long getTotal() {
	        return blogTypeDao.getTotal();
	    }

	    public Integer addBlogType(BlogType blogType) {
	        return blogTypeDao.addBlogType(blogType);
	    }

	    public Integer updateBlogType(BlogType blogType) {
	        return blogTypeDao.updateBlogType(blogType);
	    }

	    public Integer deleteBlogType(Integer id) {
	        return blogTypeDao.deleteBlogType(id);
	    }

	    public List<BlogType> getBlogTypeData(){return  blogTypeDao.getBlogTypeData();}
}
