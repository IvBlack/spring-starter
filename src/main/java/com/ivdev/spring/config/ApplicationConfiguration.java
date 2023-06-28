package com.ivdev.spring.config;

import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.database.repository.UserRepository;
import com.ivdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.properties")
@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.ivdev.spring",
                useDefaultFilters = false,
                includeFilters = {
                    @Filter(type = FilterType.ANNOTATION, value = Component.class),
                    @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                    @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
                })

public class ApplicationConfiguration {

    //default bean name - the method name
    //or specify explicitly
    //we can use @Value for injecting into parameters like for field/constructor
    @Bean
    ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    //first bean injected into second
    //@Qualifier or id based on parameter 'pool2'
    @Bean
    public UserRepository userRepository(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }
}
