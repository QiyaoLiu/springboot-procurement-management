package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.SupplierLogMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.SupplierLog;
import com.abctechnologies.procurementmanagementsystem.service.SupplierLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierLogServiceImpl implements SupplierLogService {

    @Autowired
    private SupplierLogMapper supplierLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(SupplierLog supplierLog) {
        supplierLogMapper.insert(supplierLog);}
}
