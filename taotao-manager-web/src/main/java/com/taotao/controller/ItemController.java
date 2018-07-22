package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemService;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item")
    @ResponseBody
    private TbItem getItemById() {

        TbItem item = itemService.getItemById(1L);
        return item;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        EasyUIDataGridResult result=itemService.getItemList(page,rows);
        return result;//这个对象自动转换成json对象
    }

    //插入数据
    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item,String desc){
        TaotaoResult result=itemService.createItem(item,desc);

        /**
         * result是json数据{"status":200,"msg":"OK","data",null}
         */
        return result;
    }

}