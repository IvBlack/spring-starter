package com.ivdev.spring.service;

import com.ivdev.spring.database.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    //UserService не управляет созданием userRepository
    //он внедрен через конструктор, создание и управление происходит извне
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
