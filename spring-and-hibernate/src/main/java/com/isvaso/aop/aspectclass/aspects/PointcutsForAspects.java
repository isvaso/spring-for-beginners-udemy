package com.isvaso.aop.aspectclass.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutsForAspects {

    @Pointcut("execution(* *(..))")
    public void allMethodsPointcut() {}

    @Pointcut("execution(* com.isvaso.aop.aspectclass.Person.setJob("
            + "com.isvaso.aop.aspectclass.Job))")
    public void personSetJobPointcut() {}

    @Pointcut("execution(* com.isvaso.aop.aspectclass.Person.work())")
    public void personWorkPointcut() {}
}
