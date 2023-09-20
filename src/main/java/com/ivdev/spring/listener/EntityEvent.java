package com.ivdev.spring.listener;

import java.util.EventObject;

//Event - первый основной элемент паттерна Listener
//главным объектом event-а будет сущность entity, добавим ее в конструктор родительского класса
public class EntityEvent extends EventObject {
    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }
}
