package com.abctechnologies.procurementmanagementsystem.controller;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import com.abctechnologies.procurementmanagementsystem.pojo.User;
import com.abctechnologies.procurementmanagementsystem.service.UserService;
import com.abctechnologies.procurementmanagementsystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result login(@RequestBody User user) {
        log.info("login: {}", user);
        User u = userService.login(user);

        //login successful, generate GWT
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("name", u.getName());
            claims.put("username", u.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        //login failed
        return Result.error("username or password error");
    }
}
