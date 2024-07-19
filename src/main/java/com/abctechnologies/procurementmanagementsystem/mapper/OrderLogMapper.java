package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.OrderLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderLogMapper {


    @Insert("insert into order_log(create_time,description) values(#{createTime},#{description})")
    void insert(OrderLog orderLog);
}
