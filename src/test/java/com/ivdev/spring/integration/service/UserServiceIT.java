package com.ivdev.spring.integration.service;

import com.ivdev.spring.database.pool.ConnectionPool;
import com.ivdev.spring.integration.customannotation.IT;
import com.ivdev.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

/*
DirtiesContext c используется для поднятия нескольких контекстов с
различными параметрами, если это необходимо.
TestConfiguration в кастомной аннотации @IT позволяет выносить
мок-зависимости из класса в отдельный класс.
*/
@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceIT {
    private final UserService userService;
    private  final ConnectionPool pool1;

    @Test
    void test() {
        System.out.println();
    }

    @Test
    void test2() {
        System.out.println();
    }

    @Test
    void test3() {
        System.out.println();
    }
}
