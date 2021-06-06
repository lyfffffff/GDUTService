package com.test.demo.mapper;

import com.test.demo.entity.SwiperUrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SwiperUrlMapper {
    List<SwiperUrl> findAll();
}
