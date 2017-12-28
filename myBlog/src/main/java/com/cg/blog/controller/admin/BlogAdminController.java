package com.cg.blog.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.blog.service.BlogService;
import com.cg.blog.service.CommentService;
import com.cg.blog.util.ResponseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cg.blog.entity.Blog;
import com.cg.blog.entity.PageBean;
import com.cg.blog.lucene.BlogIndex;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private BlogIndex blogIndex;
	/**
	 * 后台分页查询博客信息
	 * @return
	 */
	@RequestMapping("/listBlog")
	public String listBlog(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Blog s_blog,
            HttpServletResponse response)throws Exception {
		PageBean<Blog> pageBean = new PageBean<Blog>(Integer.parseInt(page), Integer.parseInt(rows));
		
		pageBean = blogService.listBlog(s_blog.getTitle(), pageBean);
		/**
		 * 创建json对象
		 */
		JSONObject result = new  JSONObject();
		/**
		 * 设置json序列化日期格式
		 */
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		
		String jsonStr = JSONObject.toJSONString(pageBean.getResult(),
				        SerializerFeature.DisableCircularReferenceDetect,
				        SerializerFeature.WriteDateUseDateFormat);
		/**
		 * 得到json数组
		 */
		JSONArray array = JSON.parseArray(jsonStr);
		/**
		 * 把结果放入json
		 */
		result.put("rows", array);
		result.put("total", pageBean.getTotal());
		//返回
		ResponseUtil.write(response, result);
		
		return null;
	}
	/**
	 * 更新或者新增博客
	 * @param blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public String saveBlog(Blog blog,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if (blog.getId()!=null) {
			//更新操作
			resultTotal = blogService.updateBlog(blog);
			//更新索引
			blogIndex.updateIndex(blog);
		}else {
			//新增操作
			resultTotal = blogService.saveBlog(blog);
			//添加索引
			blogIndex.addIndex(blog);
		}
		JSONObject result = new JSONObject();
		if (resultTotal>0) {
			result.put("success", true);
		}else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 删除博客
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String deleteBlog(@RequestParam("ids")String ids,HttpServletResponse response) throws Exception{
		String[] idsStr = ids.split(",");
		for (int i=0; i<idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			//先删除博客所关联的评论
			commentService.deleteCommentByBlogId(id);
			blogService.deleteBlog(id);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
