package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author weihu
 * @date 2018/7/18/018 23:13
 * @desc
 */
public interface ItemCatService {

    public List<EasyUITreeNode> getItemCatList(long parentId);
}
