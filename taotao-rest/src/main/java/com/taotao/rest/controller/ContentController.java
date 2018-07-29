package com.taotao.rest.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weihu
 * @date 2018/7/29/029 19:36
 * @desc
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/category/{categoryId}")
    @ResponseBody
    public TaotaoResult categoryList(@PathVariable Long categoryId) {
        TaotaoResult result = contentService.getContentList(categoryId);
        return result;
    }
}
