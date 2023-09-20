package com.ivdev.spring.listener;


import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//listener д.б. компонентом, чтобы участвовать в системе слушателей spring
@Component
public class EntityListener {

    //в методе может быть реализована разная бизнес-логика, от денормализации БД до логирования.
    @EventListener(condition = "#p0.accessType.name() == 'READ'")
    @Order(10)
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println("Entity: " + entityEvent);
    }
}
