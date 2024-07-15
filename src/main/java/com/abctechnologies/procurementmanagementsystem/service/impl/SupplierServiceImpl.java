package com.abctechnologies.procurementmanagementsystem.service.impl;

import com.abctechnologies.procurementmanagementsystem.mapper.SupplierMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.pojo.Supplier;
import com.abctechnologies.procurementmanagementsystem.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;


    public PageBean page(String supplierName, Integer page, Integer pageSize) {

        //Get count of all records
         PageHelper.startPage(page, pageSize);

        //Get table of records result
        List<Supplier> supplierList = supplierMapper.list(supplierName);

        //Get result of the reading
        Page<Supplier> p = (Page<Supplier>) supplierList;

        //Encapsulation of PageBean
       return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer id) {
        supplierMapper.deleteById(id);
    }

    @Override
    public void add(Supplier supplier) {
        supplier.setCreateTime(LocalDateTime.now());
        supplierMapper.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierMapper.update(supplier);
    }
}
