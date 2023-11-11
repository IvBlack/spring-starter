package com.ivdev.spring;

import com.ivdev.spring.config.ApplicationConfiguration;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.service.CompanyService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

@SpringBootApplication
@ConfigurationPropertiesScan
//класс д.б. в главной дирректории проекта
public class ApplicationRunner {

    public static void main(String[] args) {
        //под капотом метода run происходит инициализация контекста
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
    }
}
