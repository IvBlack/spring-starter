package com.ivdev.spring.database.repository;

import com.ivdev.spring.bpp.InjectBean;
import com.ivdev.spring.database.pool.ConnectionPool;

import javax.sql.ConnectionPoolDataSource;

public class CompanyRepository {

    //custom annotation over field for inject bean
    @InjectBean
    private ConnectionPool connectionPool;
}
