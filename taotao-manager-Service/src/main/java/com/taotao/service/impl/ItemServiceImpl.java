package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import com.taotao.mapper.TbItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //分页处理,接受前端请求的页码和每页显示的行数
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemExample example=new TbItemExample();
        List<TbItem> list=itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        //返回处理结果
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);
        return result;
    }



    public List<EasyUITreeNode> getItemCatList(long parentId) {
        // 根据parentId查询分类列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //转换成EasyUITreeNode列表
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            //创建一个节点对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent() ? "closed" : "open");
            //添加到列表中
            resultList.add(node);
        }
        return resultList;


    }

    @Override
    public TaotaoResult createItem(TbItem item, String desc) {
        // 生成商品id
        long itemId = IDUtils.genItemId();
        // 补全TbItem属性
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除'
        item.setStatus((byte) 1);
        // 创建时间和更新时间
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 插入商品表,插入item对象就可以
        itemMapper.insert(item);
        // 商品描述
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 插入商品描述数据
        itemDescMapper.insert(itemDesc);

        /**
         * 插入成功返回TaotaoResult对象，TaotaoResult对象中包含数据
         *  status = 200;
         *  msg = "OK";
         *  data = data;
         */
        return TaotaoResult.ok();
    }

}
