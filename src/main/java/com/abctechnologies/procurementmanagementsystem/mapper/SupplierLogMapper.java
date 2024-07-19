package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.SupplierLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierLogMapper {

    @Insert("insert into supplier_log(create_time,description) values(#{createTime},#{description})")
    void insert(SupplierLog supplierLog);
}
