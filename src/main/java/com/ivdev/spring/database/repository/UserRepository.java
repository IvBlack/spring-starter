package com.ivdev.spring.database.repository;

import com.ivdev.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.ConnectionPoolDataSource;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier("pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
