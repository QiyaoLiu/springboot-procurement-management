package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.CountMapper;
import com.abctechnologies.procurementmanagementsystem.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private CountMapper countMapper;

@Override
    public int countSupplierMonth() {

    return countMapper.countSupplierMonth();
    }

    @Override
    public int countSupplierTotal() {
        return countMapper.countSupplierTotal();
    }

    @Override
    public int countOrderMonth() {
        return countMapper.countOrderMonth();
    }

    @Override
    public int countAmountMonth() {
        return countMapper.countAmountMonth();
    }

    ;
}
