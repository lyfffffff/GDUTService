package com.test.demo.controller;

import com.test.demo.entity.NavigationUrl;
import com.test.demo.mapper.NavigationUrlMapper;
import com.test.demo.service.NavigationUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/navigation")
public class NavigationController {
    @Autowired
    //引入service实体类
    private NavigationUrlService navigationUrlService;
    @RequestMapping("/url")
    public List<NavigationUrl> getNavigetionUrl(){
        return  navigationUrlService.findAll();
    }

}
