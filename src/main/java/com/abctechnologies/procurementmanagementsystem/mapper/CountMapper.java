package com.abctechnologies.procurementmanagementsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountMapper {

    @Select("SELECT COUNT(*) FROM db01.tb_supplier WHERE YEAR(create_time) = YEAR(CURDATE()) AND MONTH(create_time) = MONTH(CURDATE())")
    int countSupplierMonth();

    @Select("SELECT COUNT(*) FROM db01.tb_supplier")
    int countSupplierTotal();

    @Select("SELECT COUNT(*) FROM db01.tb_order WHERE YEAR(create_time) = YEAR(CURDATE()) AND MONTH(create_time) = MONTH(CURDATE())")
    int countOrderMonth();

    @Select("SELECT SUM(tb_order.total_price) FROM db01.tb_order WHERE YEAR(create_time) = YEAR(CURDATE()) AND MONTH(create_time) = MONTH(CURDATE())")
    int countAmountMonth();
}

