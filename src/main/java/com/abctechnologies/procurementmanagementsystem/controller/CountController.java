package com.abctechnologies.procurementmanagementsystem.controller;

import com.abctechnologies.procurementmanagementsystem.service.CountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    private CountService countService;

    @GetMapping("/supplier-month")
    public int countSupplierMonth() {
        log.info("counting suppliers of current month");
        return countService.countSupplierMonth();
    }

        @GetMapping("/supplier-total")
        public int countSupplierTotal() {
            log.info("counting total suppliers");
            return countService.countSupplierTotal();
        }

        @GetMapping("/order-month")
        public int countOrderMonth() {
            log.info("counting order of current month");
            return countService.countOrderMonth();
        }

    @GetMapping("/amount-month")
    public int countAmountMonth() {
        log.info("counting month amount");
        return countService.countAmountMonth();
    }

    }

