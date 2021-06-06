package com.test.demo.service;
import com.test.demo.entity.SwiperUrl;
import com.test.demo.mapper.SwiperUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SwiperUrlService {
    @Autowired
    private SwiperUrlMapper swiperUrlMapper;
    public List<SwiperUrl> findAll(){
        return swiperUrlMapper.findAll();
    }
}
