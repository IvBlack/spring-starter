package com.ivdev.spring;

import com.ivdev.spring.config.ApplicationConfiguration;
import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CrudRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {
    public static void main(String[] args) {
        //for demonstration
        //with help of reflectionAPI, we can find out whether the given bean is a type of BeanFactoryPostProcessor or not
        String value = "Ave, Spring";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));



        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class))
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
