package com.isvaso.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.isvaso.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAspect(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String methodName = proceedingJoinPoint.getSignature().getName();

        System.out.format("[%s %s] - starts\n", formatter.format(date), methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.format("[%s %s] - ends\n", formatter.format(date), methodName);

        return targetMethodResult;
    }
}
