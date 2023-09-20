package com.ivdev.spring.config;

import com.ivdev.spring.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

//настройка бинов для работы с БД через JPA
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    //чтобы убедиться, что JpaConfiguration добавляется в контекст, для этого создадим кастомный Condition
    @PostConstruct
    void init() {
        System.out.println("JPAConfig is enabled.");
    }
}
