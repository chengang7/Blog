package com.cg.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 博主控制器类
 * @author root1
 * @date 2017年12月22日
 */

import com.cg.blog.entity.Blogger;
import com.cg.blog.service.BloggerService;

import com.cg.blog.util.MD5Util;
/**
 * 博主控制层前台,不需要shrio认证
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="blogger")
public class BloggerController {
	@Autowired
	private BloggerService bloggerService;
	
	/**
	 * 登录方法
	 * @param blogger
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,Blogger blogger) {
//		ModelAndView mv = new ModelAndView();
//		String pwd =MD5Util.md5(bloger.getPassword(), "xp");
//		Blogger blogger = new Blogger();
//		blogger.setUserName(bloger.getUserName());
//		blogger.setPassword(pwd);
//		
//		if (bloggerService.checkOut(blogger)) {
//			session.setAttribute("blogger", bloger.getUserName());
//			mv.setViewName("admin/main");
//		}else {
//			request.setAttribute("errorInfo", "用户名或密码错误！");
//			mv.setViewName("login");
//		}
//		return mv;
		Subject subject = SecurityUtils.getSubject();
		/**
		 * 获取加密后密码
		 */
//        String password = MD5Util.md5(blogger.getPassword(), "admin");
		String password = blogger.getPassword();
        System.out.println(password);
        /**
         * 获取用户密码登录token
         */
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), password);
        try {
        	/**
        	 * 根据token登录 会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
        	 */
            subject.login(token);
            return "redirect:/admin/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("blogger", blogger);
            /**
             * 提示信息
             */
            request.setAttribute("errorInfo", "用户名或密码错误");
            return "login";
        }
    }
	/**
	 * 关于我的方法
	 * @return
	 */
    @RequestMapping("/aboutme")
    public ModelAndView abouotMe() {
        ModelAndView mv = new ModelAndView();
        Blogger blogger = bloggerService.getBloggerData();
        mv.addObject("blogger", blogger);
        mv.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
        mv.addObject("title", "关于博主 - 我的个人博客");
        mv.setViewName("mainTemp");
        return mv;
    }
    /**
     * 相册模块未完成
     * @return
     */
    @RequestMapping(value = "/myalbum")
    public ModelAndView myAlbum() {
        ModelAndView mv = new ModelAndView();
        //要写一个相册的service获取相册
        //要建一个相册表
        //....
        mv.addObject("commonPage", "foreground/blogger/myAlbum.jsp");
        mv.setViewName("mainTemp");
        return mv;
    }
    /**
     * 未完成
     * @return
     */
    @RequestMapping("/resource")
    public ModelAndView resource() {
        ModelAndView mv = new ModelAndView();
        //
        //....
        mv.addObject("commonPage", "foreground/blogger/resource.jsp");
        mv.setViewName("mainTemp");
        return mv;
    }
		 
}

