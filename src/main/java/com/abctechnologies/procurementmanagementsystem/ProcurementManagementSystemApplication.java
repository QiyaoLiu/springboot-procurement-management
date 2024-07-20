package com.abctechnologies.procurementmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@SpringBootApplication
public class ProcurementManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcurementManagementSystemApplication.class, args);
    }

}
