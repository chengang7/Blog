package com.cg.blog.service;

import java.util.List;

import com.cg.blog.entity.BlogType;
import com.cg.blog.entity.PageBean;
/**
 * 分页查询Service层
 * @author cg
 * @date 2017年12月25日
 */
public interface BlogTypeService {
	/**
	 * 分页查询
	 * 
	 * @param pageBean
	 * @return
	 */
	PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public Long getTotal();

	/**
	 * 添加博客类别
	 * 
	 * @param blogType
	 * @return
	 */
	public Integer addBlogType(BlogType blogType);

	/**
	 * 更新博客类别
	 * 
	 * @param blogType
	 * @return
	 */
	public Integer updateBlogType(BlogType blogType);

	/**
	 * 删除博客类别
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteBlogType(Integer id);

	/**
	 * 获取博客类型数据
	 * @return
	 */
	public List<BlogType> getBlogTypeData();
}
