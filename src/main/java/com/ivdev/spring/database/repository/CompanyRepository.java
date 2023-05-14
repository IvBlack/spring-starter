package com.ivdev.spring.database.repository;

import javax.sql.ConnectionPoolDataSource;

public class CompanyRepository {
    private final ConnectionPoolDataSource connectionPoolDataSource;

    public CompanyRepository(ConnectionPoolDataSource connectionPoolDataSource) {
        this.connectionPoolDataSource = connectionPoolDataSource;
    }
}
