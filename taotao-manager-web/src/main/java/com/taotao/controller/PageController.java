package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weihu
 * @date 2018/7/15/015 18:26
 * @desc
 */
@Controller
public class PageController {
    /**
     * 返回index.jsp页面
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }



}
