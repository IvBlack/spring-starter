package com.ivdev.spring;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CompanyRepository;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.ioc.Container;
import com.ivdev.spring.service.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.ConnectionPoolDataSource;
import java.awt.*;
import java.io.Serializable;

public class ApplicationRunner {
    public static void main(String[] args) {
        //for demonstration
        //with help of reflectionAPI, we can find out whether the given bean is a type of BeanFactoryPostProcessor or not
        String value = "Ave, Spring";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));



        try (var context = new ClassPathXmlApplicationContext("app.xml"))
        {
            //use alias "p1" to recognize required bean
            //clazz -> String -> Map(String, Object)
            var connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
