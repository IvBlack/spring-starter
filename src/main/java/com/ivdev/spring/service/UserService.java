package com.ivdev.spring.service;

import com.ivdev.spring.database.UserRepository;
import com.ivdev.spring.database.repository.CompanyRepository;

public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    //UserService не управляет созданием userRepository
    //он внедрен через конструктор, создание и управление происходит извне
    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
