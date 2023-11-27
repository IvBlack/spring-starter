package com.ivdev.spring.integration.service;

import com.ivdev.spring.ApplicationRunner;
import com.ivdev.spring.config.DBProperties;
import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.dto.CompanyReadDto;
import com.ivdev.spring.integration.customannotation.IT;
import com.ivdev.spring.listener.entity.EntityEvent;
import com.ivdev.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/*
SpringExtension знает, как интегрировать jUnit с
TestContext Framework И предоставить ApplicationContext, а какой именно контекст -
указывает @ContextConfiguration
*/
@IT
@RequiredArgsConstructor
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DBProperties dbProperties;

    @Test
    void findById() {
        var expectedResult = new CompanyReadDto(COMPANY_ID); //expected company object
        var actualResult = companyService.findById(1);
        assertTrue(actualResult.isPresent());

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
