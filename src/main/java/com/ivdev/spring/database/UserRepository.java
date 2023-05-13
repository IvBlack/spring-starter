package com.ivdev.spring.database;

import javax.sql.ConnectionPoolDataSource;

public class UserRepository {
    private final ConnectionPoolDataSource connectionPoolDataSource;

    public UserRepository(ConnectionPoolDataSource connectionPoolDataSource) {
        this.connectionPoolDataSource = connectionPoolDataSource;
    }
}
