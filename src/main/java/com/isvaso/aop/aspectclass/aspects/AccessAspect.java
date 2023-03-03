package com.isvaso.aop.aspectclass.aspects;

import com.isvaso.aop.aspectclass.Job;
import com.isvaso.aop.aspectclass.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
@Order(10)
public class AccessAspect {

    private static Logger logger;

    @Around("com.isvaso" +
            ".aop.aspectclass.aspects.PointcutsForAspects.personSetJobPointcut()")
    public void checkEducationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        logger = LogManager.getLogger(
                proceedingJoinPoint.getTarget().getClass().getName());

        logger.debug(proceedingJoinPoint.getStaticPart().getSignature().getName()
                + "(" + Arrays.stream(proceedingJoinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining()) + ")");

        logger.debug("Education checking status: started");

        String education = ((Person) proceedingJoinPoint.getThis())
                .getEducation().getJobName();
        String job = ((Job) proceedingJoinPoint.getArgs()[0])
                .getJobName();

        if (job.equals(education)) {
            try {
                proceedingJoinPoint.proceed();

                logger.debug("Education is: " + education);
                logger.debug("Education checking status: verified");

            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        } else {
            logger.debug("Education is: " + education);
            logger.debug("Education checking status: denied");

            System.out.println("Job denied! " +
                    "Person education doesn't match the job! ");
        }
    }

    @Before("com.isvaso" +
            ".aop.aspectclass.aspects.PointcutsForAspects.personWorkPointcut()")
    public void checkWorkAdvice(JoinPoint joinPoint) {
        logger = LogManager.getLogger(
                joinPoint.getTarget().getClass().getName());

        logger.debug("Job access checking status: started");

        Object object = joinPoint.getThis();

        if (((Person) object).getJob() == null) {
            logger.debug("Job access checking status: job is not set");

            throw new NullPointerException();
        } else {
            logger.debug("Job access checking status: job is set");
        }
    }
}
