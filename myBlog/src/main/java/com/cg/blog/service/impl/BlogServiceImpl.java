package com.cg.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blog.dao.BlogDao;
import com.cg.blog.service.BlogService;

import com.cg.blog.entity.Blog;
import com.cg.blog.entity.PageBean;
/**
 * BlogService鏄犲皠绫� 
 * @author cg
 * @date 2017骞�12鏈�25鏃�
 */
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean) {
		Map<String,Object> map = new HashMap<String,Object>();
		//璁剧疆鏌ヨ鏉′欢
		map.put("title",title);
		//鎬昏褰曟斁鍏ageBean
		pageBean.setTotal(blogDao.getTotal(map));
		map.put("start",pageBean.getStart());
		map.put("end",pageBean.getEnd());
		//鎶婂垎椤电粨鏋滄斁鍏ageBean
		pageBean.setResult(blogDao.listBlog(map));
		return pageBean;
	}


	public List<Blog> listBlog(Map<String,Object> map) {
		return blogDao.listBlog(map);
	}

	public Integer getBlogByTypeId(Integer typeId) {
		return blogDao.getBlogByTypeId(typeId);
	}

	public Integer saveBlog(Blog blog) {
		return blogDao.saveBlog(blog);
	}

	public Integer updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	public Integer deleteBlog(Integer id) {
		return blogDao.deleteBlog(id);
	}

	public Blog getById(Integer id) {
		return blogDao.getById(id);
	}

	public long getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}

	public Blog getPrevBlog(Integer id) {
		return blogDao.getPrevBlog(id);
	}


	public Blog getNextBlog(Integer id) {
		return blogDao.getNextBlog(id);
	}
}
