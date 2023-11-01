package com.ivdev.spring.service;

import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.dto.CompanyReadDto;
import com.ivdev.spring.listener.entity.AccessType;
import com.ivdev.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;

    //расширяется от Aware-интерфейса, инжектируется в первую очередь
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository,
                          UserService userService,
                          ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    //реализуем метод findById
    //как только из БД будет прочитана сущность - eventListener должен подхватить это событие
    public Optional<CompanyReadDto> findById(Integer id) {
        return  companyRepository.findById(id)
                .map(entity -> {
                    //публикуем кастомный event
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());

                });
    }
}
