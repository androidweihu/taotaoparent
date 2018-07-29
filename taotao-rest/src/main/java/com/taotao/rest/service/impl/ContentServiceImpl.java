package com.taotao.rest.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weihu
 * @date 2018/7/29/029 17:42
 * @desc 内容服务管理
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_CONTENT_KEY}")
    private String REDIS_CONTENT_KEY;

    @Override
    public TaotaoResult getContentList(Long categoryId) {
        //添加缓存的逻辑
        //缓存不能影响正常逻辑
        try {
            String result=jedisClient.hget(REDIS_CONTENT_KEY,categoryId+"");
            if(!StringUtils.isBlank(result)){//缓存不为空，把缓存的数据给前端展示
                List<TbContent> list = JsonUtils.jsonToList(result, TbContent.class);
                return TaotaoResult.ok(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //缓存逻辑结束
        List<TbContent> list = null;
        try {
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            // 设置查询条件
            criteria.andCategoryIdEqualTo(categoryId);

            // 执行查询
            list = contentMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,"error");
        }
        //把内容添加到缓存中
        jedisClient.hset(REDIS_CONTENT_KEY, categoryId + "",
                JsonUtils.objectToJson(list));

        return TaotaoResult.ok(list);
    }

    /**
     * 删除缓存
     * @return
     */
    @Override
    public TaotaoResult syncContent(Long cid) {
        jedisClient.hdel(REDIS_CONTENT_KEY,cid+"");
        return TaotaoResult.ok();
    }
}
