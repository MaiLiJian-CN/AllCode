package com.yichen.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class DataAdvice {

    @Pointcut("execution(boolean com.yichen.service.*Service.*(..))")
    private void servicePt(){}


    @Around("servicePt()")
    public Object trimStr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[1].getClass().equals(String.class)){
                args[1] = args[1].toString().trim();
            }
        }

        Object ret = proceedingJoinPoint.proceed(args);
        return ret;

    }
}
