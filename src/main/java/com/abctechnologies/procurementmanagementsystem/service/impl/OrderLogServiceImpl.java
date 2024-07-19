package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.OrderLogMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.OrderLog;
import com.abctechnologies.procurementmanagementsystem.service.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Autowired
    private OrderLogMapper orderLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(OrderLog orderLog) {
        orderLogMapper.insert(orderLog);}

}
