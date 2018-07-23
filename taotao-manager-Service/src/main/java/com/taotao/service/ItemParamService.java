package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * @author weihu
 * @date 2018/7/22/022 23:37
 * @desc
 */
public interface ItemParamService {
    TaotaoResult getItemParamByCid(Long cid);
    TaotaoResult insertItemParam(Long cid,String paramData);
}
