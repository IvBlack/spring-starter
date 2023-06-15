package com.ivdev.spring.bpp;

/*
task is: to write processor which will find all classes
annotated by @Transaction and open transactions
before and after all his methods.
*/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/*
1. check if bean contains Transaction annotation
2. create proxy for end-to-end functionality (like JUnit, using mocks; Hibernate with lazy init)
3. using dynamic proxy through inner java Proxy-class
4. adding new functionality, row 29
*/
public class TransactionBeanPostProcessor implements BeanPostProcessor {

    //прокси может не хранить метаинфо о нашем бине
    //поэтому обернем бины в мапу
    private final Map<String, Class<?>> transactionBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            transactionBeans.put(beanName, bean.getClass());
        }
        return bean;
    }

    /*
    Не смотря на то, что в newProxyInstance передается экземляр именно бина,
    а не прокси, т.к. нас интересуют интерфейсы бина (а не его прокси) -
    метод invoke() принимает именно bean - даже если это прокси, -  позволяя тем самым накидывать
    мощный функционал на один бин: профилирование, открытие транзакций и пр.
    */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.get(beanName);

        //если бин есть в мапе - можем оборачивать его в прокси и накидывать доп.функционал
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(),
                    beanClass.getInterfaces(), (proxy, method, args) -> {
                        //emulating transaction
                        System.out.println("Open transaction...");
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            System.out.println("Close transaction..");
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
