package com.taotao.service;

import com.taotao.pojo.TbItem;

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

}
