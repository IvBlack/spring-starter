package com.ivdev.spring;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.service.UserService;

import javax.sql.ConnectionPoolDataSource;

public class ApplicationRunner {
    public static void main(String[] args) {
        var connectionPool = new ConnectionPool();
        var userRepository = new UserRepository((ConnectionPoolDataSource) connectionPool);
        var userService = new UserService(userRepository);

    }
}
