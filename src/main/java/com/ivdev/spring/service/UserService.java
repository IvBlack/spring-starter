package com.ivdev.spring.service;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.repository.CompanyRepository;

public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    //UserService does not manage the creation of a UserRepository
    //UserRepository is implemented through the constructor, creation and management takes place from the outside
    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
