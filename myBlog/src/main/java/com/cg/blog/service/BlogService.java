package com.cg.blog.service;

import java.util.List;
import java.util.Map;

import com.cg.blog.entity.Blog;
import com.cg.blog.entity.PageBean;

public interface BlogService {
	
	 
	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
    public List<Blog> listBlog(Map<String,Object> map);
    /**
     * 分页查询博客
     * @param title
     * @param pageBean
     * @return
     */
    public PageBean<Blog> listBlog(String title,PageBean<Blog> pageBean);
    /**
     * 根据博客类型的id查询该类型下的博客数量
     * @param typeId
     * @return
     */
    public Integer getBlogByTypeId(Integer typeId);
    /**
     * 添加博客
     * @param blog
     * @return
     */
    public Integer saveBlog(Blog blog);
    /**
     * 更新博客
     * @param blog
     * @return
     */
    public Integer updateBlog(Blog blog);
    /**
     * 通过id删除博客
     * @param id
     * @return
     */
    public Integer deleteBlog(Integer id);
    /**
     * 通过id获取博客
     * @param id
     * @return
     */
    public Blog getById(Integer id);
    
    /**
     * 获取博客标题
     * @param map
     * @return
     */
    long getTotal(Map<String, Object> map);

    /**
     * 获取上一篇博客
     * @param id
     * @return
     */
    Blog getPrevBlog(Integer id);
    /**
     * 获取下一篇博客
     * @param id
     * @return
     */
    Blog getNextBlog(Integer id);
}
