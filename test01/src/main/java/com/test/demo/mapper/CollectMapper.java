package com.test.demo.mapper;

import com.test.demo.entity.Collect;
import com.test.demo.entity.Information;
import com.test.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectMapper {
//    插入信息
    @Insert("insert into collect_table values(" +
            "#{username},#{info_id},#{collect_id}"+
            ")")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "collect_id",keyColumn = "collect_id")
    void insert(Collect collect);
//删除
    @Delete("delete from collect_table c where c.username=#{username} and c.info_id=#{info_id}")
    void delete(@Param("username") String username,@Param("info_id") long info_id);
//查询
    @Select(value = "select i.* from information_table i where i.info_id in" +
            " (select info_id from collect_table where username=#{username})")
    @Results
            ({
                    @Result(property = "info_id",column = "info_id"),
                    @Result(property = "cates_name",column = "cates_name"),
                    @Result(property = "username",column = "username"),
                    @Result(property = "info_title",column = "info_title"),
                    @Result(property = "info_content",column = "info_content"),
                    @Result(property = "info_phone",column = "info_phone"),
                    @Result(property = "info_price",column = "info_price"),
                    @Result(property = "info_datestrat",column = "info_datestrat"),
                    @Result(property = "info_dateend",column = "info_dateend"),
            })
    List<Information> getbyusername(@Param("username") String username);

    //查看是否收藏
    @Select("select c.collect_id from collect_table c where c.username = #{username} and info_id = #{info_id}")
    Long iscollect(Collect collect);

}
