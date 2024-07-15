package com.abctechnologies.procurementmanagementsystem;

import com.abctechnologies.procurementmanagementsystem.mapper.SupplierMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.PageBean;
import com.abctechnologies.procurementmanagementsystem.service.SupplierService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ProcurementManagementSystemApplicationTests {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testListAllSuppliers() {
        String supplierName = null; // no keyword
        Integer page = 1;
        Integer pageSize = 10;

        PageBean pageBean = supplierService.page(supplierName, page, pageSize);
        pageBean.getRows().forEach(System.out::println);
    }

    @Test
    public void testListSuppliersByKeyword() {
        String supplierName = "virt"; // keyword
        Integer page = 1;
        Integer pageSize = 10;

        PageBean pageBean = supplierService.page(supplierName, page, pageSize);
        pageBean.getRows().forEach(System.out::println);
    }


    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "root");

        // Generate a key (you should use a securely generated key in a real application)
        Key key = Keys.hmacShaKeyFor("abctechnologiesabctechnologiesabctechnologies".getBytes());

        String jwt = Jwts.builder()
                .setClaims(claims) // Set JWT claims
                .signWith(key) // Sign with the key using HS256 algorithm
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // Set expiration time
                .compact();
        System.out.println(jwt);
    }


    @Test
    public void testParseJwt() {
        Key key = Keys.hmacShaKeyFor("abctechnologiesabctechnologiesabctechnologies".getBytes());

        String jwtToParse = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicm9vdCIsImlkIjoxLCJleHAiOjE3MjA0NDQ2NjZ9.FxgLZqt1E_SFp2KMoq2Bnmzci414eKBWpOLWPl-Poxc";
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToParse)
                    .getBody();
            System.out.println(claims);
        }
    }










