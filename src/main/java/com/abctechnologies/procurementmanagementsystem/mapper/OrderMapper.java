package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * list orders
     * @param materialName
     * @param supplierName
     * @return
     */
    List<Order> list(String materialName, String supplierName);

    /**
     * delete order
     * @param id
     */
    @Delete("delete from tb_order where id = #{id}")
    void deleteById(Integer id);

    /**
     * delete a supplier by supplier id
     * @param supplierId
     */
    @Delete("delete from tb_order where supplier_id = #{supplierId}")
    void deleteBySupplierId(Integer supplierId);

    /**
     * add a new order
     * @param order
     */
    @Insert("insert into tb_order(supplier_id, material_name, material_quantity, unit, single_price, total_price, comment, create_time) " +
            "values(#{supplierId}, #{materialName}, #{materialQuantity}, #{singlePrice}, #{totalPrice}, #{unit}, #{comment}, #{createTime})")
    void insert(Order order);

    /**
     * edit an order
     * @param order
     */
    void update(Order order);
}