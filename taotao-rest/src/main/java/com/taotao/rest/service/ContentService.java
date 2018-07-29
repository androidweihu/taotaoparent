package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * @author weihu
 * @date 2018/7/29/029 17:41
 * @desc
 */
public interface ContentService {
    TaotaoResult getContentList(Long categoryId);
    TaotaoResult syncContent(Long cid);
}
