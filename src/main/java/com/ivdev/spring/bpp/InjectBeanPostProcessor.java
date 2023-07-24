package com.ivdev.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
/*
How BeanPostProcessor works behind the scene:
1. getting all fields through ReflectionAPI
2. filtering by our custom annotation
3. ReflectionUtils catch exceptions automatically behind the scene
*/

@Component
public class InjectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

/*
Using reflection API:
- we'll get all the bean fields
- filter out those marked with a custom annotation
-if there are any: for each field of units. and we will get the desired bin from the ApplicationContext
- ApplicationContext is injected through the setter from the corresponding aware interface
- from the context we get a bin by field type: field.GetType()
- get access to a private field
- set the value for the field in this bin
*/
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectBean.class))
                .forEach(field -> {
                    Object beanToInject = applicationContext.getBean(field.getType());
                    ReflectionUtils.makeAccessible(field);
                    ReflectionUtils.setField(field, bean, beanToInject);
                });
        return bean;
    }

    //инжект ApplicationContext через сеттер интерфейса
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
