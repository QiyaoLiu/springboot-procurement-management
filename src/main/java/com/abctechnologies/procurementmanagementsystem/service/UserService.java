package com.abctechnologies.procurementmanagementsystem.service;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import com.abctechnologies.procurementmanagementsystem.pojo.User;


public interface UserService {

    /**
     * user login
     * @param user
     * @return
     */
    Result login(User user);
}
