package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weihu
 * @date 2018/7/22/022 23:48
 * @desc
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemCatByCid(@PathVariable Long cid){
        TaotaoResult result=itemParamService.getItemParamByCid(cid);
        /**
         * 返回的数据为 status = status;
         *         this.msg = msg;
         *         this.data = data;
         *         {"status":status,"msg":msg,"data":data}
         *         Controller类中return的时候自动将键值对类型的或者对象转换成json数据类型
         */

        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
        return result;
    }
}
