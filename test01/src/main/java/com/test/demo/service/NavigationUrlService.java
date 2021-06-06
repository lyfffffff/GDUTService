package com.test.demo.service;

import com.test.demo.entity.NavigationUrl;

import com.test.demo.mapper.NavigationUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationUrlService {
    @Autowired
    private NavigationUrlMapper navigationUrlMapper;
    public List<NavigationUrl> findAll(){
        return navigationUrlMapper.findAll();
    }
}
