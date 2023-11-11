package com.ivdev.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/*
Маппинг .properties на java-класс
Имена полей должны точно соответствовать при переносе
Работает практически с любыми типами данных
@ConfigurationProperties ищется главным классом приложения через @ConfigurationPropertiesScan
*/
@ConfigurationProperties(prefix = "db")
public record DBProperties(String username, String password, String driver,
                            String url, String hosts, PoolProperties pool,
                            List<PoolProperties> pools, Map<String, Object> properties
) {

    public  static record  PoolProperties(Integer size,
            Integer timeout
    ) {
    }
}
