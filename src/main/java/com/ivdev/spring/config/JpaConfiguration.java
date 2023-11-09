package com.ivdev.spring.config;

import com.ivdev.spring.config.condition.JpaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/*
@Conditional автоматически конфигурирует модули на основании условий.
Ниже - яркий пример работы @Conditional по условию наличия класса в classpath.
Если из JpaCondition.class вернется false - конфиг не будет подключен.
*/
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init() {
        System.out.println("Jpa config is enabled!");
    }
}