package com.test.demo.controller;

import com.test.demo.entity.Collect;
import com.test.demo.entity.CollectResult;
import com.test.demo.entity.Information;
import com.test.demo.entity.User;
import com.test.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
//    将商品收藏信息插入
    @PostMapping(value = "/insert")
    public CollectResult insert(Collect collect){
        return collectService.insert(collect);
    }
////    将商品收藏信息删除
    @PostMapping(value = "/delete")
    public CollectResult delete(Collect collect){
        return collectService.delete(collect);
    }
    //按用户名查询
    @PostMapping(value = "/getbyusername")
    public List<Information> getbyusername(User user){
        return collectService.getbyusername(user);
    }

    //按用户名和信息查询是否收藏
    @PostMapping(value = "/iscollect")
    public CollectResult iscollect(Collect collect){
        return collectService.iscollect(collect);
    }

}
