package com.test.demo.mapper;

import com.test.demo.entity.Collect;
import com.test.demo.entity.Feedback;
import com.test.demo.entity.Information;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    //    插入信息
    @Insert("insert into feedback_table values(" +
            "#{feedback_id},#{username},#{feedback_content}"+
            ")")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "feedback_id",keyColumn = "feedback_id")
    void insert(Feedback feedback);
    //搜索信息
    @Select(value = "select f.* from feedback_table f where f.username=#{username}")
    @Results
            ({
                    @Result(property = "feedback_id",column = "feedback_id"),
                    @Result(property = "username",column = "username"),
                    @Result(property = "feedback_content",column = "feedback_content"),
            })
    List<Feedback> select(@Param("username") String username);
}
