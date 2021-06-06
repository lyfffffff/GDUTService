package com.test.demo.service;

import com.test.demo.entity.Collect;
import com.test.demo.entity.CollectResult;
import com.test.demo.entity.Information;
import com.test.demo.entity.User;
import com.test.demo.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional(rollbackFor = RuntimeException.class)
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;
//    插入
    public CollectResult insert(Collect collect) {
        CollectResult collectResult = new CollectResult();
        collectResult.setSuccess(false);
        collectResult.setDetail(null);
        collectMapper.insert(collect);
        collectResult.setMsg("收藏成功~");
        collectResult.setSuccess(true);
        collectResult.setDetail(collect);
        return collectResult;
    }
//    删除
    public CollectResult delete(Collect collect) {
        CollectResult collectResult = new CollectResult();
        collectResult.setSuccess(false);
        collectResult.setDetail(null);
        collectMapper.delete(collect.getUsername(),collect.getInfo_id());
        collectResult.setMsg("取消收藏成功~");
        collectResult.setSuccess(true);
        collectResult.setDetail(collect);
        return collectResult;
    }
    //    获取
    public List<Information> getbyusername(User user) {
        return collectMapper.getbyusername(user.getUsername());
    }
    // 查询是否收藏
    public CollectResult iscollect(Collect collect) {
        CollectResult collectResult = new CollectResult();
        collectResult.setSuccess(false);
        collectResult.setDetail(null);
        try {
            Long existCollect = collectMapper.iscollect(collect);
            if(existCollect != null) {
                collectResult.setMsg("该用户已经收藏过这条信息~");
                collectResult.setSuccess(true);
                collectResult.setDetail(collect);
            }
            else{
                collectResult.setMsg("该用户没有收藏这条信息~");
                collectResult.setSuccess(false);
                collectResult.setDetail(null);
            }

        } catch (Exception e) {
            collectResult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return collectResult;
    }

}
