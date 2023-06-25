package com.ivdev.spring.database.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@Component("pool1")
public class ConnectionPool {
    private final String username;
    private final Integer poolSize;

    //we don't add Autowired if constructor is single
    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
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
