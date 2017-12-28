package com.cg.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 跳转后台管理页面测试类
 * @author cg
 * @date 2017年12月26日
 */
@Controller
@RequestMapping(value="/admin")
public class MainAdminController {

	@RequestMapping(value = "/menu")
    public String toMenuPage(){
        return "admin/main";
    }

    @RequestMapping(value = "/menu1")
    public String toMenuPage1(){
        return "admin/main1";
    }
}
