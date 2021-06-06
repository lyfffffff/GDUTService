package com.test.demo.controller;

import com.test.demo.entity.SwiperUrl;
import com.test.demo.service.SwiperUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//使用注解的方式传出参数，自动传入jiso
@RestController
@RequestMapping("/swiper")
public class SwiperController {
    @Autowired
    private SwiperUrlService swiperUrlService;
    //设置调用接口的地址
    @RequestMapping("/url")
    public List<SwiperUrl> getSwiperUrl(){
        return  swiperUrlService.findAll();
    }

}
