package com.ivdev.spring.bpp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//annotation for class for all his methods
//opening transaction -> execute methods -> closing transaction
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transaction {
}
