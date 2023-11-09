package com.ivdev.spring.service;

import com.ivdev.spring.database.entity.Company;
import com.ivdev.spring.database.repository.CrudRepository;
import com.ivdev.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
