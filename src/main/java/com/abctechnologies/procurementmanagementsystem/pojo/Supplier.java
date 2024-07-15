package com.abctechnologies.procurementmanagementsystem.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class Supplier {
    private Integer id;
    private String supplierName;
    private String address;
    private String contactPerson;
    private String email;
    private String comment;
    private LocalDateTime createTime;
}