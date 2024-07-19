package com.abctechnologies.procurementmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
