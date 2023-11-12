package com.ivdev.spring.service;

import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.dto.CompanyReadDto;
import com.ivdev.spring.listener.entity.EntityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;
    @Mock
    private CrudRepository<Integer, Company> companyRepository;
    @Mock
    private UserService userService;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private  CompanyService companyService;

    @Test
    void findById() {
        //программируем companyRepository, чтобы вернул Entity по id
        when(companyRepository.findById(COMPANY_ID))
                .thenReturn(Optional.of(new Company(COMPANY_ID)));
//        doReturn(Optional.of(new Company(COMPANY_ID)))
//                .when(companyRepository).findById(COMPANY_ID);

        var expectedResult = new CompanyReadDto(COMPANY_ID); //expected company object
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        //check is excepted and actual company object`s equal
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        //проverifyить моки, удостовериться, что они вызваны
        verify(eventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(eventPublisher, userService);
    }
}