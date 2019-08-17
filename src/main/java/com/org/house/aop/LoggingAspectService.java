package com.org.house.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LoggingAspectService {

    @Pointcut("execution(* com.org.house.service..*(..))")
    private void logging() {
    }

    @After(value = "logging()", argNames = "joinPoint")
    private void logAfter(JoinPoint joinPoint) throws Throwable {
        log.info("Class: " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Method {} finished | args=> {}"
                , joinPoint.getSignature().toShortString(), Arrays.asList(joinPoint.getArgs()));

    }

}
