package com.isvaso.aop.aspectclass.aspects;

import com.isvaso.aop.aspectclass.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Aspect
public class LoggingAspect {

    private static Logger logger;

    @Pointcut("execution(* *(..))")
    public void allMethodsPointcut(){}

    @Before("allMethodsPointcut()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {
        logger = LogManager.getLogger(
                joinPoint.getTarget().getClass().getName());
        logger.debug(joinPoint.getStaticPart().getSignature().getName()
                + "(" + Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining()) + ")");
    }
}
