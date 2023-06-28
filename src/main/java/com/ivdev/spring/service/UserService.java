package com.ivdev.spring.service;

import com.ivdev.spring.database.repository.UserRepository;
import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    //UserService does not manage the creation of a UserRepository
    //UserRepository is implemented through the constructor, creation and management takes place from the outside
    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
