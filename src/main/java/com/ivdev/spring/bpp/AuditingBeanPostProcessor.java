package com.ivdev.spring.bpp;

/*
task is: to write processor which will find all classes
annotated by @Transaction and open transactions
before and after all his methods.
*/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/*
1. check if bean contains Auditing annotation
2. create proxy for end-to-end functionality (like JUnit, using mocks; Hibernate with lazy init)
3. using dynamic proxy through inner java Proxy-class
4. adding new functionality, row 46
*/
public class AuditingBeanPostProcessor implements BeanPostProcessor {

    //прокси может не хранить метаинфо о нашем бине
    //поэтому обернем бины в мапу
    private final Map<String, Class<?>> auditBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Auditing.class)) {
            auditBeans.put(beanName, bean.getClass());
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = auditBeans.get(beanName);

        //без проблем оборачиваем новый функционал поверх TransactionBeanPostProcessor
        //добавив нужный бин в app.xml
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(), (proxy, method, args) -> {
                        //emulating audit
                        System.out.println("Audit method " + method.getName());
                        var start = System.nanoTime();
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            System.out.println("Time execution: " + (System.nanoTime() - start));
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
