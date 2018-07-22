package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.List;

/**
 * @author weihu
 * @date 2018/7/14/014 17:02
 * @desc
 */
public interface ItemService {

    /**
     * 根据id查询商品信息,其实执行的还是TbItemMapper接口中的方法对应的sql语句
     * TbItem selectByPrimaryKey(Long id)
     * service相当于包装了一下
     * @param itemId
     * @return
     */
    TbItem getItemById(Long  itemId);
    EasyUIDataGridResult getItemList(int page, int rows);
    TaotaoResult createItem(TbItem item,String desc);



}
