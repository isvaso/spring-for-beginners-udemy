package com.isvaso.aop.aspectclass.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
@Order(20)
public class LoggingAspect {

    private static Logger logger;

    @Before("com.isvaso" +
            ".aop.aspectclass.aspects.PointcutsForAspects.allMethodsPointcut()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {
        logger = LogManager.getLogger(
                joinPoint.getTarget().getClass().getName());
        logger.debug(joinPoint.getStaticPart().getSignature().getName()
                + "(" + Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining()) + ")");
    }
}
