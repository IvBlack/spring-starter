package com.ivdev.spring.service;

import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.dto.CompanyReadDTO;
import com.ivdev.spring.listener.AccessType;
import com.ivdev.spring.listener.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository,
                          UserService userService,
                          ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    /*
    Когда сработает поиск по findById и сущность будет найдена,
    должен сработать EntityListener и среагировать должным образом.
    Можно работать с event любых типов, не только с сущностями.
    */
    public Optional<CompanyReadDTO> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    //на этом шаге нужно запаблишить event, для этого нужен publisher-объект ApplicationEventPublisher
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDTO(entity.id());
                });
    }
}
