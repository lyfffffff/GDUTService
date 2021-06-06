package com.test.demo.mapper;

import com.test.demo.entity.NavigationUrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//接口：引入方法
@Mapper
public interface NavigationUrlMapper {
    List<NavigationUrl> findAll();
}
