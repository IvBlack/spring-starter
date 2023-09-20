package com.ivdev.spring.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

//кастомный condition; если драйвер будет загружен в память из classpath - вернем true.
//но, здесь вернется false, т.к. нет такого класса, и conditional-условие не отработает.
public class JpaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
