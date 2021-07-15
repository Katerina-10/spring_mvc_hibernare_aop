package com.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint pJp) throws Throwable
    {
        MethodSignature ms = (MethodSignature) pJp.getSignature();
        String methodN = ms.getName();
        System.out.println("begin of "+ methodN);

        Object targetMethodRez = pJp.proceed();
        System.out.println("End of " + methodN);

        return targetMethodRez;

    }
}
