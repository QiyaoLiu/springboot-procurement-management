package com.abctechnologies.procurementmanagementsystem.service.impl;
import com.abctechnologies.procurementmanagementsystem.mapper.UserMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.User;
import com.abctechnologies.procurementmanagementsystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }
}