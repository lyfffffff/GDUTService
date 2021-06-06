package com.test.demo.mapper;
import com.test.demo.entity.Information;

import java.util.List;
import java.util.Map;

public interface InsertInformationMapper {
    public List<Map> findDepts(Map param);
    public void create(Information information);
}
