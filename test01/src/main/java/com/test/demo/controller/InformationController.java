package com.test.demo.controller;
import com.test.demo.entity.Cate;
import com.test.demo.entity.Information;
import com.test.demo.entity.InsertResult;
import com.test.demo.entity.User;
import com.test.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;
//    插入
    @PostMapping(value = "/insert")
    public InsertResult insert(Information information){
        return informationService.insert(information);
    }
//    按照信息类别查询
    @PostMapping(value = "/getbycate")
    public List<Information> getbycate(Cate cate){
        return informationService.getbycate(cate);
    }
//    按照用户查询
    @PostMapping(value = "/getbyusername")
    public List<Information> getbyusername(User user){
        return informationService.getbyusername(user);
    }
//  修改用户发布的信息
@PostMapping(value = "/update")
public InsertResult update(Information information){
    return informationService.update(information);
}
//删除用户发布的信息
@PostMapping(value = "/delete")
public InsertResult delete(Information information){
    return informationService.delete(information);
}
    //    按照用户查询
    @PostMapping(value = "/getbysearch")
    public List<Information> getbysearch(Information information){
        return informationService.getbysearch(information);
    }

}
