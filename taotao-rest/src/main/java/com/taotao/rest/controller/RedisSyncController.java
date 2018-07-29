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
 * @date 2018/7/29/029 19:38
 * @desc 同步缓存服务
 */
@Controller
@RequestMapping("/sync/content/{cid}")
public class RedisSyncController {
    @Autowired
    private ContentService contentService;

    @ResponseBody
    public TaotaoResult sysnContent(@PathVariable Long cid){
        try {
            TaotaoResult result=contentService.syncContent(cid);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "exception!");
        }
    }


}
