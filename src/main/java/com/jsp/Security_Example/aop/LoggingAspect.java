package com.jsp.Security_Example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(* com.jsp.emp_Management.*.*.*(..))")
//    public void loggingMethod1(JoinPoint joinPoint) {
////        System.out.println("Logging Before Method..");
//            log.info("Entering logging method 1"+joinPoint.getSignature().getName()+"and Arguments "+ Arrays.toString(joinPoint.getArgs()));
//    }

    //after is also same

    @Around("execution(* com.jsp.Security_Example.*.*.*(..))")
    public Object loggingMethod2(ProceedingJoinPoint joinPoint) {
        log.info("Entering logging method "+joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        log.info("Exiting logging method "+joinPoint.getSignature().getName()+" time consumed is ms:"+(end-start));

        return result;
    }

}
