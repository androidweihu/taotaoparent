package com.taotao.controller;

import com.taotao.service.ItemService;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}