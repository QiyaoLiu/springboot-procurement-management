package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user where BINARY username = #{username}")
    User getByUsername(String username);
}
