package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.OrderMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.Order;
import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public PageBean page(String materialName, String supplierName, Integer page, Integer pageSize) {
        // Use PageHelper only if pagination parameters are provided
        if (page != null && pageSize != null) {
            PageHelper.startPage(page, pageSize);
        }

        List<Order> orderList = orderMapper.list(materialName, supplierName);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);

        return new PageBean(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void add(Order order) {
        order.setCreateTime(LocalDateTime.now());
        orderMapper.insert(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void delete(Integer id) {
        orderMapper.deleteById(id);

    }

}
