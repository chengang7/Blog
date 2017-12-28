package com.cg.blog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cg.blog.entity.Blog;

/**
 * 博客dao接口
 * 
 * @author root1
 * @date 2017年12月25日
 */
@Repository
public interface BlogDao {

	/**
	 * 分页查询博客
	 * @param map
	 * @return
	 */
	public List<Blog> listBlog(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
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
	 * 删除博客
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
