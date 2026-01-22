package com.abhay.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Before("execution(* com.abhay.service.*.*(..))")
public void logBefore(){
    System.out.println("[LOG] Method execution started");
}


    @After("execution(* com.abhay.service.*.*(..))")
    public void logAfter() {
        System.out.println("[LOG] Method execution finished");
    }
}
