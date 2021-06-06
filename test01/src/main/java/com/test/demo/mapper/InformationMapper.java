package com.test.demo.mapper;
import com.test.demo.entity.Information;
import com.test.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface InformationMapper {
//    1，根据信息类别渲染信息
    @Select(value = "select i.* from information_table i where i.cates_name=#{cates_name}")
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
    List<Information> findInformationByPid(@Param("cates_name") String cates_name);
    //    2.根据用户名渲染信息
    @Select(value = "select i.* from information_table i where i.username=#{username}")
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
    List<Information> findInformationByUsername(@Param("username") String username);
    //    2.根据用户输入信息渲染信息
    @Select(value = "select i.* from information_table i where" +
            " i.cates_name like concat('%',#{cates_name},'%') or i.info_title like concat('%',#{info_title},'%') or i.info_content like concat('%',#{info_content},'%')")
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
    List<Information> findInformationBySearch(@Param("cates_name") String cates_name,@Param("info_title") String info_title,@Param("info_content") String info_content);



//    发布时插入信息
    @Insert("insert into information_table values(" +
            "#{info_id},#{cates_name},#{username},#{info_title},#{info_content},#{info_phone},#{info_price},#{info_datestart},#{info_dateend}" +
            ")")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "info_id",keyColumn = "info_id")
    void insert(Information information);
//删除信息
@Delete("delete from information_table i where i.info_id=#{info_id}")
void delete(@Param("info_id") long info_id);
//     修改信息
    @Update("update information_table set " +
            "info_title=#{info_title},info_content=#{info_content},info_phone=#{info_phone},info_price=#{info_price},info_datestart=#{info_datestart},info_dateend=#{info_dateend},cates_name=#{cates_name} " +
            "where info_id=#{info_id}")
    void update(Information information);
    //    void update(@Param("info_id") long info_id,@Param("info_title") String info_title,@Param("info_content") String info_content,@Param("info_price") String info_price,@Param("info_phone") String info_phone,@Param("info_datestart") String info_datestart,@Param("info_dateend") String info_dateend,@Param("cates_name") String cates_name);

    //    按照信息id搜索信息
@Select(value = "select i.* from information_table i where i.info_id=#{info_id}")
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
  Information selectbyinfoid(@Param("info_id") long info_id);
}

