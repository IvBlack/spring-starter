package com.ivdev.spring;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CompanyRepository;
import com.ivdev.spring.ioc.Container;
import com.ivdev.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.ConnectionPoolDataSource;
import java.awt.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("app.xml");

        //use alias "pool2" to recognize required bean
        var connectionPool = context.getBean("pool2", ConnectionPool.class);
        System.out.println(connectionPool);
    }
}
