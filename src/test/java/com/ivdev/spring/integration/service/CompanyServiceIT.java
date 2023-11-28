package com.ivdev.spring.integration.service;

import com.ivdev.spring.config.DBProperties;
import com.ivdev.spring.dto.CompanyReadDto;
import com.ivdev.spring.integration.customannotation.IT;
import com.ivdev.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

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
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID); //expected company object
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
