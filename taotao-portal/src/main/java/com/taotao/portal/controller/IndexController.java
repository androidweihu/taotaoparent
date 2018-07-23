package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weihu
 * @date 2018/7/23/023 23:41
 * @desc
 */
@Controller
public class IndexController {

    /**
     * 返回到首页
     * @return
     */
    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
}
