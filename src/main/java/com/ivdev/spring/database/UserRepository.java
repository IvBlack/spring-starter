package com.ivdev.spring.database;

import org.springframework.stereotype.Repository;

import javax.sql.ConnectionPoolDataSource;

@Repository
public class UserRepository {
    private final ConnectionPoolDataSource connectionPoolDataSource;

    public UserRepository(ConnectionPoolDataSource connectionPoolDataSource) {
        this.connectionPoolDataSource = connectionPoolDataSource;
    }
}
