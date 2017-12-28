package com.cg.blog.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.blog.entity.Blog;
import com.cg.blog.entity.Comment;
import com.cg.blog.lucene.BlogIndex;
import com.cg.blog.service.BlogService;
import com.cg.blog.service.CommentService;
import com.cg.blog.util.PageUtil;
import com.cg.blog.util.StringUtil;

/**
 * 博客前台访问控制层
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private BlogIndex blogIndex;
	
	public ModelAndView detatils(@PathVariable("id") Integer id,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		/**
		 * 根据id来获取博客
		 */
		Blog blog = blogService.getById(id);
		/**
		 * 获取关键字
		 */
		String keyWords = blog.getKeyWord();
		if (StringUtil.isNotEmpty(keyWords)) {
			String[] strArray = keyWords.split("");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays.asList(strArray));
			mv.addObject("keyWords",keyWordsList);
		}else {
			mv.addObject("keyWords",null);
		}
		mv.addObject("blog",blog);
		//将博客访问量加1
		blog.setClickHit(blog.getClickHit()+1);
		//更新博客
		blogService.updateBlog(blog);
		
		//查看评论信息
		Map<String , Object> map =  new HashMap<String,Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		List<Comment> commentList= commentService.getCommentData(map);
		
		mv.addObject("commentList",commentList);
		mv.addObject("commonPage","foreground/blog/blogDetail.jsp");
		mv.addObject("title",blog.getTitle()+" - 我的个人博客");
		
		//存入上一篇和下一篇的显示代码
		mv.addObject("pageCode",PageUtil.getPrevAndNextPageCode(blogService.getPrevBlog(id), blogService.getNextBlog(id),request.getServletContext().getContextPath()));
		
		mv.setViewName("mainTemp");
		
		return mv;
	}
	
	public ModelAndView search(
			@RequestParam(value="q",required=false)String q,
			@RequestParam(value="page",required=false)String page,
			HttpServletRequest request) throws Exception{
		/**
		 * 定义每页显示的文章数
		 */
		int pageSize = 10;
		ModelAndView mv = new ModelAndView();
		List<Blog> blogIndexList = blogIndex.searchBlog(q);
		if (page==null) {
			page = "1";
		}
		//开始索引
		int fromIndex = (Integer.parseInt(page)-1)*pageSize;
		int toIndex = blogIndexList.size()>= Integer.parseInt(page)*pageSize ? Integer.parseInt(page)*pageSize : blogIndexList.size();
		
		mv.addObject("blogIndexList",blogIndexList.subList(fromIndex, toIndex));
		mv.addObject("pageCode",PageUtil.getUpAndDownPageCode(Integer.parseInt(page), blogIndexList.size(), q, pageSize, request.getServletContext().getContextPath()));
		//用于数据的回显
		mv.addObject("q",q);
		//查询到的总记录数
		mv.addObject("resultTotal",blogIndexList.size());
		mv.addObject("commonPage","foreground/blog/searchResult.jsp");
		mv.addObject("title","搜索'" + q + "'的结果 - 我的个人博客");
		mv.setViewName("mainTemp");
		return mv;
	}
}
