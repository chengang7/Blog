package com.cg.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blog.dao.LinkDao;
import com.cg.blog.service.LinkService;

import com.cg.blog.entity.Link;
import com.cg.blog.entity.PageBean;
/**
 * LinkService映射类
 * @author cg
 * @date 2017年12月25日
 */
@Service
public class LinkServiceImpl implements LinkService {
	@Autowired
	private LinkDao linkDao;
	
	 @Override
	    public List<Link> getTotalData() {
	        return linkDao.getTotalData();
	    }

	    @Override
	    public PageBean<Link> listByPage(PageBean<Link> pageBean) {
	        pageBean.setResult(linkDao.listByPage(pageBean.getStart(),pageBean.getEnd()));
	        pageBean.setTotal(linkDao.getTotalCount());
	        return pageBean;
	    }

	    @Override
	    public Long getTotalCount() {
	        return linkDao.getTotalCount();
	    }

	    @Override
	    public Integer addLink(Link link) {
	        return linkDao.addLink(link);
	    }

	    @Override
	    public Integer deleteLink(Integer id) {
	        return linkDao.deleteLink(id);
	    }

	    @Override
	    public Integer updateLink(Link link) {
	        return linkDao.updateLink(link);
	    }
}
