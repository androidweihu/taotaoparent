package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author weihu
 * @date 2018/7/25/025 23:50
 * @desc
 */
public interface ContentCatgoryService {
    List<EasyUITreeNode> getContentCatList(Long parentId);
}
