package com.abctechnologies.procurementmanagementsystem.controller;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import com.abctechnologies.procurementmanagementsystem.pojo.User;
import com.abctechnologies.procurementmanagementsystem.service.UserService;
import com.abctechnologies.procurementmanagementsystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

   @Autowired
  private UserService userService;

@PostMapping("/login")
public ResponseEntity<Result> login(@RequestBody User user) {
    log.info("login: {}", user);
    Result result = userService.login(user);

    if (result.getCode() == 1) { // Login successful
        User u = (User) result.getData();
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", u.getId());
        claims.put("name", u.getName());
        claims.put("username", u.getUsername());

        String jwt = JwtUtils.generateJwt(claims);
        // Return 200 OK with JWT token
        return ResponseEntity.ok(Result.success(jwt));
    } else {
        // Return 401 Unauthorized with specific error message
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
}
