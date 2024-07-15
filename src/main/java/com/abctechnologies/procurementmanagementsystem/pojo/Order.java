package com.abctechnologies.procurementmanagementsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private String materialName;
    private Integer supplierId;
    private String supplierName;
    private Integer materialQuantity;
    private String unit;
    private Float singlePrice;
    private Float totalPrice;
    private String comment;
    private LocalDateTime createTime;
}
