package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * search user by username and password
     * @param user
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User getByUsernameAndPassword(User user);
}
