package com.abctechnologies.procurementmanagementsystem.service;

import com.abctechnologies.procurementmanagementsystem.pojo.Order;
import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;

public interface OrderService {
    /**
     *
     * @param materialName
     * @param supplierName
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(String materialName, String supplierName, Integer page, Integer pageSize);

    /**
     * add an order
     * @param order
     */
    void add(Order order);

    /**
     * edit an order
     * @param order
     */
    void update(Order order);

    /**
     * delete an order
     * @param id
     */
    void delete(Integer id);
}