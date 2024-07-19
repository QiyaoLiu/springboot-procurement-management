package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.OrderMapper;
import com.abctechnologies.procurementmanagementsystem.mapper.SupplierMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.pojo.Supplier;
import com.abctechnologies.procurementmanagementsystem.pojo.SupplierLog;
import com.abctechnologies.procurementmanagementsystem.service.SupplierLogService;
import com.abctechnologies.procurementmanagementsystem.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SupplierLogService supplierLogService;

@Transactional
    public PageBean page(String supplierName, Integer page, Integer pageSize) {

    // Initiate pagination
         PageHelper.startPage(page, pageSize);

    // Execute the select query with pagination applied
        List<Supplier> supplierList = supplierMapper.list(supplierName);

    // Cast the result to Page<Supplier>
        Page<Supplier> p = (Page<Supplier>) supplierList;

        //Encapsulation of PageBean
       return new PageBean(p.getTotal(), p.getResult());
    }


    @Override
    @Transactional
    public void delete(Integer id) throws Exception {
        try {
            orderMapper.deleteBySupplierId(id);
            supplierMapper.deleteById(id);
        } finally {
            SupplierLog supplierLog = new SupplierLog();
            supplierLog.setCreateTime(LocalDateTime.now());
            supplierLog.setDescription("attempted to delete supplier with id"+id);
            supplierLogService.insert(supplierLog);
        }

    }

@Transactional
    @Override
    public void add(Supplier supplier) {
        supplier.setCreateTime(LocalDateTime.now());
        supplierMapper.insert(supplier);
    }

    @Transactional
    @Override
    public void update(Supplier supplier) {
        supplierMapper.update(supplier);
    }
}
