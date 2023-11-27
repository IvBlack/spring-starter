package com.ivdev.spring.integration.service;

import com.ivdev.spring.integration.customannotation.IT;
import com.ivdev.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@IT
@RequiredArgsConstructor
class UserServiceIT {
    private final UserService userService;
    @Test
    void test() {

    }
}
