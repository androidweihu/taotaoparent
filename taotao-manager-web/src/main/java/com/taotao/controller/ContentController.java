package com.taotao.controller;

import com.alibaba.druid.util.HttpClientUtils;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weihu
 * @date 2018/7/29/029 20:01
 * @desc:内容管理
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/save")
    @ResponseBody
    private TaotaoResult saveContent(TbContent content){
        TaotaoResult result=contentService.insertContent(content);
        //调用taotao-rest发布的服务，同步缓存
        HttpClientUtil.doGet("url"+content.getCategoryId());
        return result;
    }
}
