package com.abctechnologies.procurementmanagementsystem.controller;

import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import com.abctechnologies.procurementmanagementsystem.pojo.Supplier;
import com.abctechnologies.procurementmanagementsystem.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/suppliers")
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public Result page(@RequestParam(required = false) String supplierName,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("read suppliers, parameters: {}, {}, {}", supplierName, page, pageSize);

        PageBean pageBean = supplierService.page(supplierName, page, pageSize);

        return Result.success(pageBean);
    }

    /**
     *add a supplier
     * @param supplier
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Supplier supplier) {
        log.info("adding a supplier: {}", supplier);
        supplierService.add(supplier);
        return Result.success();
    }

    /**
     * update a supplier
     * @param supplier
     * @return
     */

    @PutMapping
    public Result update(@RequestBody Supplier supplier) {
        log.info("updating a supplier:{}", supplier);
        supplierService.update(supplier);
        return Result.success();
    }

    /**
     *Delete a supplier
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("deleting a supplier by id:{}",id);
        supplierService.delete(id);
        return Result.success();
    };


}


