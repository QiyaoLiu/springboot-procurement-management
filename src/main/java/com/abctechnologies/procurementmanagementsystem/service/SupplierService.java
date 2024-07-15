package com.abctechnologies.procurementmanagementsystem.service;

import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.pojo.Supplier;

public interface SupplierService {


    /**
     *
     * @param supplierName
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(String supplierName, Integer page, Integer pageSize);


    /**
     * add a supplier
     *
     * @param supplier
     */
    void add(Supplier supplier);

    /**
     * update a supplier
     *
     * @param supplier
     */
    void update(Supplier supplier);

    /**
     * delete a supplier by id
     *
     * @param id
     */
    void delete(Integer id);

}
