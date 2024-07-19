package com.abctechnologies.procurementmanagementsystem.service.impl;
import com.abctechnologies.procurementmanagementsystem.mapper.UserMapper;
import com.abctechnologies.procurementmanagementsystem.pojo.Result;
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
    public Result login(User user) {
        // Retrieve the user by username
        User existingUser = userMapper.getByUsername(user.getUsername());
        if (existingUser == null) {
            // Return result indicating user not found
            return Result.error("User not found");
        }

        // Manually verify the password
        if (!user.getPassword().equals(existingUser.getPassword())) {
            // Return result indicating incorrect password
            return Result.error("Incorrect password");
        }

        // Authentication successful, return user details or a success message
        return Result.success(existingUser);
    }
}