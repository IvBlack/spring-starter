package com.ivdev.spring.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public class ConnectionPool {
    private String username;
    private Integer poolSize;
    private List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool() {}

    public ConnectionPool(String username,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    //calls after constructor & setters
    @PostConstruct
    private void init() {
        System.out.println("Init connection pool.");
    }

    //calls after closing ApplicationContext
    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool.");
    }
}
