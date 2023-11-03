package com.ivdev.spring;

import com.ivdev.spring.config.ApplicationConfiguration;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.service.CompanyService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
