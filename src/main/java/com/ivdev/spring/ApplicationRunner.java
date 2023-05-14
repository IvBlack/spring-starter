package com.ivdev.spring;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CompanyRepository;
import com.ivdev.spring.ioc.Container;
import com.ivdev.spring.service.UserService;

import javax.sql.ConnectionPoolDataSource;
import java.awt.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        var container = new Container();

//        var connectionPool = new ConnectionPool();
//        var userRepository = new UserRepository((ConnectionPoolDataSource) connectionPool);
//        var companyRepository = new CompanyRepository((ConnectionPoolDataSource) connectionPool);
//        var userService = new UserService(userRepository, companyRepository);

//        var connectionPool = container.get(ConnectionPool.class);
//        var userRepository = container.get(UserRepository.class);
//        var companyRepository = container.get(CompanyRepository.class);

        //тут происходит внедрение зависимостей, нам не нужно знать какие есть зависимости
        //мы не управляем созданием UserService, это делает сторонний объект
        var userService = container.get(UserService.class);
    }
}
