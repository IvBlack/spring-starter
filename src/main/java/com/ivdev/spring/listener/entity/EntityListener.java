package com.ivdev.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    /*
    EntityListener слушает объект EntityEvent, тут может быть любая логика: от денормализации БД до аудита сущности
    Order гибко настраивает приоритет для одной и той же сущности.
    condition смотрит в наш ENUM, неявно вызывая getter по имени, если != READ - данный acceptEntityRead не отработает
    */
    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    @Order(10)
    public void acceptEntityRead(EntityEvent entityEvent) {

        System.out.println("Entity: " + entityEvent);
    }
}
